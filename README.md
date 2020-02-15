# Testing the microservices

## Working plan

Domain: I suspect examples should use banking domain so that the following apps are expected:

1. **Users management** - an app to manage user accounts. Basic DTO and CRUD operations. Actually, 
this module holds information about users - their logins and password, activation status, creation, 
update and last login date. All the information that is exposed by this module is described using Swagger. 

2. **Accounts management** - every user can have number of accounts so this module is responsible 
for management of user accounts. Every account has personal information about particular user
like its first name, last name, middle name, date of birth, account status like blocked or active.
At the same time, accounts store information about the currency that is used for this account
and amount of money left. Again, all the necessary information is exposed by this modules used Swagger.   

3. **Cards management** - a few cards could be associated with every account. Every card has the
following properties: card holder name, card number, validity date, secret code.  

## Tasks and statutes

| Task no    | Task description                               | Task status                |
| -----------|------------------------------------------------| ---------------------------|
| Feature 1  | Create a new multi-module Apache Maven project | Not started                |
|            | with the following modules:                    |                            |
|            | * banking-users                                |                            |
|            | * banking-accounts                             |                            |
|            | * banking-cards                                |                            |
|------------|------------------------------------------------|----------------------------|
| Feature 2  | Create a new Spring Boot project for every     | Not started                |
|            | module.                                        | DTO - not started          |
|            | Every Spring Project should have a collection  | REST - not started         |
|            | of DTOs to describe the domain entities,       | Swagger - not started      |
|            | REST endpoints to provide some data externally |                            |
|            | and Swagger to describe the external API       |                            |
|------------|------------------------------------------------|----------------------------|
| Feature 3  | Unit tests that test particular classes with   | Not started                |
|            | isolated dependencies.                         |                            |
|------------|------------------------------------------------|----------------------------|
| Feature 4  | Spring-based JPA integration test. Will mock   |                            |
|            | the downside dependency


Example Title | Example Description | Status
--------------|---------------------|-------
Maven repo    | Create a basic maven repository with three modules:
                1. Account
