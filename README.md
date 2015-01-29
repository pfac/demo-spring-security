HowTheHell: Spring Security
===========================

![HowTheHell: Spring Security][logo]

[![Build Status](https://travis-ci.org/pfac/howto-spring-security.svg?branch=master)](https://travis-ci.org/pfac/howto-spring-security)

*This is repository is under (yet another) major reorganization, which will include renaming the repository. Until such a time, this is to be considered work in progress and extremely unstable. Sorry for the inconvenience.*


Based on the [official Spring Security reference documentation][spring-security].

This project aims mainly to be an archive of working configurations for authentication and authorization using Spring Security.

In other words, it's meant to be the 42 for the question **How the hell do I configure Spring Security?**.


## Try it out

*Coming soon*


## Description

Consider an `Messenger` service. It only answers to users it knows (a.k.a, its methods require authentication), and it has three types of messages to deliver:

* a regular message for all users.
* a secret message, only for administrators.
* a top secret message, only meant for the highest pay grade.

Respectively, consider the following users:

| Username | Password     | Type          |
| `user`   | `secret`     | Regular user  |
| `admin`  | `53cr37`     | Administrator |
| `root`   | `70p_53cr3t` | Big Boss      |

Where an email should be used instead of an username, its value should be `<username>@example.com`.


## Configurations

### Authentication

- [ ] In-memory
- [ ] JDBC (with default schema)
- [ ] JDBC (with custom schema)
- [ ] LDAP

### Authorization

- [ ] In-memory
- [ ] JDBC (with default schema)
- [ ] JDBC (with custom schema)
- [ ] LDAP + JDBC (with custom schema)


## License

Project under the [MIT License][mit].

[logo]: https://github.com/pfac/howto-spring-security/raw/master/src/site/resources/images/howto-spring-security-logo.png
[spring-security]: http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#tech-intro-authentication
[maven]: http://maven.apache.org/
[mit]: http://opensource.org/licenses/MIT
