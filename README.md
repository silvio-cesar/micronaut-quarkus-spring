# Sample with micronaut/quarkus/spring

Project with examples using spring, micronaut and quarkus with kafka and mongodb running with native image.

## graalvm

Install GraalVM to run in native mode: https://www.graalvm.org/22.0/docs/getting-started/linux/
Version used: https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-22.1.0

## infra

Just run:
` cd infra `
` docker-compose up -d`

## sample-spring

Run sample-spring natively

Build project and image
` mvn clean package -Pnative  `

Run container
` docker run --network infra_sample -e SPRING.PROFILES.ACTIVE='prod' -p 8080:8080 sample-spring:0.0.1 `

Not working yet, only in normal build using mvn clean install and normal application run.

## sample-quarkus

Run sample-quarkus natively

Build project and image
` mvn clean package -Pnative -Dquarkus.native.container-build=true `

Run container
` docker run --network infra_sample -p 8080:8080 sample-quarkus:0.0.1 `

To run locally without native, just run `quarkus dev`
It's needed to install the quarkus cli tool: https://quarkus.io/guides/cli-tooling

## sample-micronaut

Run sample-micronaut natively

Not working yet, only in normal build using mvn clean install and normal application run.