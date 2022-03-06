# Project structures

The intention of this repository its show different type of architectures based on my professional experience, personal experience and knowledge.

Each architecture has its own pros and cons.


## Monolith 
  
Pros:
   * Consistency
   * Transactions + rollback
   * Shared code, no contract issues internally
   * Traceability
   * Robust deploys

Cons:
   * Code coupling
   * Hard to develop simultaneously
   * One bug can tear down the whole system
   * Scalability
   * Evolution, upgrade a big system its hard

### Architectures

- MVC
- DDD
- Hexagonal
- Module based

### Testing
Huge amount of tests.
Usually there is a UAT(User Acceptance Test) environment where the whole system is checked before going to production. It's a replication of production system
(in the better cases it's exactly the same system with production modified data), usually it's similar.

Sometimes there is a "testing project" where QAs work and develop a testing battery with cucumber for UAT and keep them updated

What I've found so far in my professional experience
* Tons of Unit Tests
* A little of integration tests(maybe with H2 or similar)
* Hardly E2E tests
* Nonexistent performance tests
* A lot of manual testing once you have finished your task in Development and Test environments, based on Excel files/postman calls

## Microservices

Pros:
* More reliable, one failure don't break the whole system
* Decoupling, tasks can be done in different projects without impact
* Scalability
* Evolution, you can change whatever part without impacting the rest
* Easy deploys

Cons:
* Code decoupling
* Huge complexity
* Communication issues
* Complex transactions
* Traceability
* Decentralized data, duplicated data, in consequence data reliability

### Architectures

* Event driven
* Decentralized monolith (nested REST/API calls)

#### Microservice architectures

Whatever fits in my opinion on the microservice pourpose.

* DDD
* CQRS
* MVC
* Hexagonal
* Integration patterns [Apache camel](https://camel.apache.org/components/3.15.x/eips/enterprise-integration-patterns.html)


### Testing
I've experience different approaches, although they were polluted because they transitioned from a monolith
in most cases had the same validations

Here we have CI/CD so the "requirement" of tests its far more important

There is more standardized as mentioned before because we have the CI/CD, so the required tests usually are:
* Unit Tests
* In some cases [Sonar](https://www.sonarqube.org/features/multi-languages/java/) checks i.e code coverage, linting, etc...
* Integration tests(there are several interpretations, functional, integration, component)
  * with tests containers they have become more trustworthy
* Performance tests (k6, Jmeter)
* E2E tests, they are very expensive to create and maintain
  * never seen them on a "whole" system perspective, E2E tests from an API point of view, yes they are the "integration tests")