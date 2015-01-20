HowTo: Spring Security
======================

[![Build Status](https://travis-ci.org/pfac/howto-spring-security.svg?branch=master)](https://travis-ci.org/pfac/howto-spring-security)


Based on the [official Spring Security reference documentation][spring-security].

This project aims mainly to achieve a working configuration that includes username/password authentication (without any external service) and role-based authentication.


## Description

In this project we have a Messenger service, which is only accessible to regular users. Administrators are not authorized to access this service (I know, doesn't make sense, but it doesn't really matter).

There are two built-in users:

There are two users built into the app:
* regular user `pedro`/`costa`, which accesses the service successfully.
* admin `costa`/`pedro`, which is not authorized to access the service.


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