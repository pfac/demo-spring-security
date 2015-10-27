Demo: Spring Security
======================

[![Build Status](https://travis-ci.org/pfac/demo-spring-security.svg?branch=dev)](https://travis-ci.org/pfac/demo-spring-security)


Based on the [official Spring Security reference documentation][spring-security].

This project aims mainly to achieve a working configuration that includes username/password authentication (without any external service) and role-based authentication.


## Description

In this project we have a Messenger service, which is only accessible to regular users. Administrators are not authorized to access this service (I know, doesn't make sense, but it doesn't really matter).

Configured authentication providers:
* In memory, configured in `SecurityConfiguration`. Usernames start with `mem`.
* JDBC, through an embedded H2 database. Usernames start with `db`.
* Custom JDBC, through the same embedded H2 database but using completely distinct tables. Usernames are replaced with emails ending in `@example.org`.
* LDAP, through an embedded LDAP server. Usernames start with `ldap`.
* Custom LDAP + JDBC, where authentication is performed using an embedded LDAP server and authorization is loaded from the embedded database. Usernames start with `mix`.

Built-in users:

| Username | Password | Type | Result |
| -------- | -------- | ---- | ------ |
| `memdemo`  | `secret` | user | Success |
| `memadmin` | `53cr37` | admin | Access denied |
| `dbdemo`   | `secret` | user | Success |
| `dbadmin`  | `53cr37` | admin | Access denied |
| `demo@example.org`  | `secret` | user | Success |
| `admin@example.org`  | `53cr37` | admin | Access denied |
| `ldapdemo`   | `secret` | user | Success |
| `ldapadmin`  | `53cr37` | admin | Access denied |
| `mixdemo`   | `secret` | user | Success |
| `mixadmin`  | `53cr37` | admin | Access denied |


## Build it

Assuming you're using a shell already at the root of the project, run the following command with [Maven][maven] to build the project:

``` bash
mvn package
```

All dependencies and configurations should be automatically taken care of.


## Try it

Still at the root of the project (after building it) use the following command to run the application:

``` bash
java -jar target/spring-security-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```


## License

Project under the [MIT License][mit].


[spring-security]: http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#tech-intro-authentication
[maven]: http://maven.apache.org/
[mit]: http://opensource.org/licenses/MIT