# betas-registration project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/betas-registration-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## /beta/developers endpoint

This rest endpoint implements full singular CRUD for a developer object:

### To register a developer:
POST /beta/developers
{
"firstName": "Bob",
"lastName": "Argon",
"developmentEnvironment": "TEXT_EDITOR",
"developmentLanguage": "JAVASCRIPT"
}

(For all possible development* options, issue GET /beta/options)

### To read one by id once persisted:
GET /beta/developers/byId/MQ==

Response:
{
"id": "MQ==",
"registeredAt": "2021-06-14T15:02:29.232115-04:00",
"firstName": "Bob",
"lastName": "Argon",
"developmentEnvironment": "TEXT_EDITOR",
"developmentLanguage": "JAVASCRIPT"
}

### To update an entity:
PUT /beta/developers/byId/MQ==
{
"firstName": "Bob",
"lastName": "Argon",
"developmentEnvironment": "TEXT_EDITOR",
"developmentLanguage": "JAVASCRIPT",
"instagramUsername": "realWebDev",
"twitterUsername": "@realWebDev",
"location": "Denver, CO"
}

Response:
{
"id": "MQ==",
"registeredAt": "2021-06-14T15:02:29.232115-04:00",
"firstName": "Bob",
"lastName": "Argon",
"developmentEnvironment": "TEXT_EDITOR",
"developmentLanguage": "JAVASCRIPT",
"instagramUsername": "realWebDev",
"twitterUsername": "@realWebDev",
"location": "Denver, CO"
}

All fields except id and registeredAt are mutable, those fields will be ignored if added to your payload.

### To delete an entity:
DELETE /beta/developers/byId/MQ==

Response will be a 200 with:
OK

## Unit tests
Unit tests are present and run during the maven build cycle. Both endpoints are fully tested for CRUD.