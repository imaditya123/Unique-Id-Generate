# Spring Boot Unique ID Generator

This Spring Boot application provides a simple and scalable Unique ID generator for use in your projects. It offers different strategies for generating unique identifiers, and you can choose the one that best fits your application's requirements.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)

## <a id="features">Features</a>

- **UUID Generation:** Utilizes the built-in Java `UUID` class for universally unique identifiers.
- **Timestamp + Random Number:** Generates IDs based on a combination of timestamp and a random number.
- **Snowflake Algorithm:** Implements the Twitter Snowflake algorithm for distributed systems.
- **Database Sequence:** Uses a database sequence to generate unique IDs.

## <a id="getting-started">Getting Started</a> 

### <a id="prerequisites">Prerequisites</a> 

Before you begin, ensure you have the following:

- Java Development Kit (JDK) installed (version X.X or higher)
- Maven or Gradle build tool installed (depending on your preference)

### <a id="installation">Installation</a>  

1. Clone the repository:

   ```bash
   git clone https://github.com/imaditya123/Unique-Id-Generate.git
   ```

2. cd spring-boot-unique-id-generator
   ./mvnw clean install
3. java -jar target/spring-boot-unique-id-generator.jar

#  <a id="usage">Usage</a>  

To incorporate the unique ID generator into your application, follow the steps outlined below. The generator provides various ID generation strategies, each accompanied by code examples and explanations.

## Example Usage

Here's how you can utilize the unique ID generator in your code:

````java
IdGeneratorService idGeneratorService = new IdGeneratorService();

## Generate ID using Timestamp + Random Number

### Endpoint: `/api/timestamp+random`

```http
GET http://localhost:8080/api/timestamp+random
"1638268537297"

```http
GET http://localhost:8080/api/builtIn-UUID
"657b539d-e854-4a91-aa19-e16d6b06eb5c"

```http
GET http://localhost:8080/api/snowflakeIdGenerator
"1375051334564215808"

```http
GET http://localhost:8080/api/databaseSequence
"1"

````