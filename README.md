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

4. **Transactions management** - it's possible to withdraw and add money using transactions. It's 
better having these transactions asynchronous, so, there will be a module that will use other
modules to process the data. 

## Tasks and statutes

This list of features is not completed, I assume it'll be updated during the development but
for now it could be considered as a starting point. 

Development is expected to be going in separated branches using the GitFlow strategy. 

### Feature 1 - in progress

Create a new multi-module Apache Maven project with the following modules:

* banking-users - done
* banking-accounts - done
* banking-cards - done
* banking-transactions - in progress

### Feature 2 - not started

Create a new Spring Boot project for every module. Every Spring Project should have a collection
of DTOs to describe the domain entities, REST endpoints to provide some data externally,
and Swagger to describe the external API.

* DTO - not started
* REST - not started
* Swagger - not started
                                      
### Feature 3 - not started

Unit tests that test particular classes with isolated dependencies.

### Feature 4 - not started

* Spring-based JPA integration test. In this context it's necessary to show that
every service has its own database and in order to test code without dependencty
to the particular database instance it's possible using the in-memory database or 
mock this layer completely.

* Specifying a contract between microservices using Spring Cloud Contract. This contract should
be separated to its own maven module and should be used as a separated dependency to test if
services that use this particular service could consume the contract. 

* Just an idea right now - generate something based on this contract, for example, REST API and 
test it. 

* Just an idea right now - generate something based on this contract that consumes this contract
in asynchronous way, for example, something that will use a message queue to process data.

### Feature 5 - not started

It will be an end-to-end test that is described using Gherkin language and ran using Cucumber. 
In this particular case the one single service will be checked using this test, all other services
will be mocked using described contracts. 

### Feature 6 - not started

* First part of this feature is to build all service and pack them into docker containers. More
likely it'll be necessary having some infrastructure to deal with it - Docker Registry to store
images and `docker-compose.yml` to deploy everything at once. 

* End-to-end test for the whole system. Looks quite simple but it's better running these tests
not only from the local environment but also from the CI. 
  
