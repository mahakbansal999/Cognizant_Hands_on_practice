# JWT Authentication with Spring Security — Hands-on Project

A runnable Spring Boot project that implements the "JWT Authentication for
RESTful Web Service using Spring Security" hands-on: HTTP Basic login against
an `/authenticate` endpoint that issues a JSON Web Token, and a servlet filter
that authorizes subsequent requests using that token's `Bearer` header.

## What it demonstrates

- Securing REST endpoints with Spring Security (`@EnableWebSecurity`)
- In-memory users/roles via `AuthenticationManagerBuilder`
- URL authorization rules with `antMatchers`
- Issuing a JWT (header / payload / signature) after Basic-auth login
- A custom `BasicAuthenticationFilter` (`JwtAuthorizationFilter`) that reads
  the `Authorization: Bearer <token>` header, validates the JWT, and marks
  the request as authenticated

## Project layout

```
src/main/java/com/cognizant/springlearn/
├── SpringLearnApplication.java        # Spring Boot entry point
├── controller/
│   ├── CountryController.java         # GET /countries (sample protected resource)
│   └── AuthenticationController.java  # GET /authenticate (issues the JWT)
├── security/
│   ├── SecurityConfig.java            # Users, roles, filter chain
│   └── JwtAuthorizationFilter.java    # Validates Bearer tokens per request
└── model/
    └── Country.java
src/main/resources/application.properties  # server.port=8090
```

## Prerequisites

- Java 11+
- Maven 3.6+

## Build & run

```bash
mvn clean package
mvn spring-boot:run
```

The app starts on **http://localhost:8090**.

## Try it out

**1. Call a protected endpoint with no credentials → 401**
```bash
curl -s http://localhost:8090/countries
```

**2. Get a JWT via HTTP Basic login**
```bash
curl -s -u user:pwd http://localhost:8090/authenticate
# {"token":"eyJhbGciOiJIUzI1NiJ9...."}
```

**3. Call the protected endpoint using the token**
```bash
TOKEN=$(curl -s -u user:pwd http://localhost:8090/authenticate | python3 -c "import sys,json;print(json.load(sys.stdin)['token'])")
curl -s -H "Authorization: Bearer $TOKEN" http://localhost:8090/countries
```

**4. Tamper with the token → request is rejected**
```bash
curl -s -H "Authorization: Bearer $TOKEN-tampered" http://localhost:8090/countries
```

In-memory users, both with password `pwd`:

| user  | roles        |
|-------|--------------|
| user  | USER         |
| admin | ADMIN        |

## Notes

- The signing key (`secretkey`) and in-memory users are hard-coded for
  learning purposes only, exactly as in the original hands-on. **Do not use
  hard-coded secrets or in-memory credentials in a real application** — load
  the signing key from configuration/a secrets manager and back users with a
  persistent store (e.g. Spring Data JPA).
- Tokens expire 20 minutes after issue (`setExpiration`), matching the
  original exercise.
- This project pins `spring-boot-starter-parent` to 2.7.x and `jjwt` 0.9.1 so
  that `WebSecurityConfigurerAdapter` and the exact API calls from the
  hands-on document work unmodified. A follow-up exercise is to migrate this
  to the newer `SecurityFilterChain` bean style and a current `jjwt` (0.12.x)
  API.
