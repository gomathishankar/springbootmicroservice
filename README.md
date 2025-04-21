## Project
Eazy bank (Demo) application is a Springboot based microservices app. 
It offers three services, Accounts, Loans and Cards and has API gateway configuration to provide the entrypoint.
Also has set up for the service discovery.

## Table of Contents
- [Project Structure](#Project Structure)
- [Prerequisites](#prerequisites)
- [Usage](#Usage)

## Project Structure

springbootmicroservice/       
├── accounts          
├── loans             
├── cards            
├── configserver       
├── docker-compose      
├── eureka server          
└── gatewayserver        


### Accounts Service:

Deals with creation, retrieve, updates and deletion of accounts via API's.
Also exposes few endpoints to get the other details of the service
All the configuration for the application is handled in configserver.

### Loans Service:

Deals with creation, retrieve, updates and deletion of Loans via API's.
Also exposes few endpoints to get the other details of the service
All the configuration for the application is handled in configserver.

### Cards Service:

Deals with creation, retrieve, updates and deletion of Loans via API's.
Also exposes few endpoints to get the other details of the service
All the configuration for the application is handled in configserver.

### Config server
It is a separate repository that maintains the configuration for all the microservices,
gateway and service discovery configurations. The intention is to maintain the config outside of the main repo.

### eurekaserver
Contains the service and configurations for maintaining the service discovery of all the microservices

### gatewatserver:
Uses the API gateway setup for all the services in the project

## Prerequisites
- Java 21 or higher
- Maven (latest)
- Docker

## Usage

### Main Repo
`git clone https://github.com/gomathishankar/springbootmicroservice`

### Config Repo
`git clone https://github.com/gomathishankar/eazybank-config`

In the Main Repo > configserver > src > main > resources > application.yml update the config repo path according to your config if required.
Else same config can be used.

### How to Run
- Order of the service to start configserver > eurekaserver > (in any order) application, loans, cards > gatewayserver
- Build using : `mvn clean install`
- Run application : `mvn spring-boot:run`

