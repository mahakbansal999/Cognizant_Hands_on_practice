# Microservices with API Gateway — Solution

This folder contains three independent Maven/Spring Boot projects that implement the
exercise from the PDF: a `greet-service` microservice, a Eureka `eureka-server`
discovery server, and an `api-gateway` that routes to services via Eureka and logs
every request through a global filter.

```
solution/
├── greet-service/      -> Simple REST service, GET /greet -> "Hello World!!"
├── eureka-server/       -> Eureka discovery server on port 8761
└── api-gateway/          -> Spring Cloud Gateway on port 9090, with LogFilter
```

## Prerequisites
- JDK 11 (matches `java.version` in the poms — bump if you prefer JDK 17)
- Maven 3.6+
- Internet access to Maven Central (to download Spring Boot / Spring Cloud deps)

## Build order
Build each project independently — they have no compile-time dependency on
each other, only a runtime dependency via Eureka.

```bash
cd eureka-server && mvn clean package && cd ..
cd greet-service && mvn clean package && cd ..
cd api-gateway  && mvn clean package && cd ..
```

## Run order (this matters!)
1. **Start eureka-server first** and wait until it's fully up:
   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```
   Verify at http://localhost:8761 — the "Instances currently registered with Eureka"
   list should be empty.

2. **Start greet-service**:
   ```bash
   cd greet-service
   mvn spring-boot:run
   ```
   Verify at http://localhost:8080/greet → `Hello World!!`
   Refresh http://localhost:8761 — `GREET-SERVICE` should now be listed.

3. **Start api-gateway**:
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```
   Refresh http://localhost:8761 — `API-GATEWAY` should now also be listed.

## Test the gateway routing
With all three running, hit the greet-service *through* the gateway:

```
http://localhost:9090/greet-service/greet
```

You should see `Hello World!!` in the browser, and in the api-gateway console
you should see a log line similar to:

```
====>Request URL http://localhost:9090/greet-service/greet
```

This confirms the `LogFilter` (a `GlobalFilter`) is intercepting and logging
every request that passes through the gateway, and that the gateway is
resolving `greet-service` to the correct instance via Eureka
(`spring.cloud.gateway.discovery.locator.enabled=true`, with
`lower-case-service-id=true` so the lowercase path segment matches the
registered service ID `GREET-SERVICE`).

## Notes / version choices
The PDF screenshots use Spring Boot 2.5.5 with `spring-cloud.version=2020.0.4`
and `java.version=17`. Spring Boot 2.5.x does not officially support Java 17,
so this solution instead uses a slightly newer, mutually-compatible combo
(Spring Boot 2.7.18 / Spring Cloud 2021.0.9 / Java 11) so the projects build
and run cleanly out of the box. If you need Java 17, bump Spring Boot to
2.7.x (already Java 17-compatible) and just change `<java.version>` to `17`.

## Adapting the account/loan microservices section
The PDF also walks through creating `account` and `loan` microservices
registered with Eureka (GET /accounts/{number} and GET /loans/{number}
returning dummy JSON). Those follow the exact same pattern as
`greet-service` — same pom.xml shape, same `@EnableDiscoveryClient`,
just a different controller and `server.port` (e.g. 8080 for account,
8081 for loan). Let me know if you'd like those two scaffolded as well.
