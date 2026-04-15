# Project Restaurant 

A simple exercise focused on REST API Request/Response patterns using Spring, database MySql and Postman. 
Created to familiarize with I/O data handling, annotations, mappers and data Jpa/Hibernate.
(Work in progress).

### Tack Stack

* Java 21
* Spring Boot 4.x
* Postman
* Maven
* Lombok
* Jpa/Hibernate
* MySql


### Installation

1. Clone or download the repository to your machine.
2. Open the project with your favorite IDE.
3. Install dependencies using Maven.
4. Add mySql datasource/hibernate properties.
5. Run the application.


### Documentation

In this project there are 4 main entities: User, Restaurant, Reservation and Menu.

(work in progress)

User endpoints. Path: /app/v1/user
* GET /{id}: Return a user by ID.
* POST: Add a new barber.
* DELETE /{id}: Delete user by ID.

Restaurant endpoints. Path: /app/v1/restaurant

* GET /{city}: Return restaurants by city.
* POST: Add a new restaurant.
* DELETE /{id}: Delete restaurant by ID. If you remove a restaurant in db is introduced a cascade operation for remove Menu and Reservation for the removed restaurant. 

Reservation endpoints. Path: /app/v1/reservation

* GET /{id}: Return reservation by id.
* POST: Add a new reservation.
* PUT: /{id} Modify number of people reservation by id.
* DELETE /{id}: Delete reservation by ID.  

Menu endpoints. Path: /app/v1/menu 

* GET /{id_restaurant}: Return Menus by restaurant id.
* POST: Add a new Menu.
* PUT: /{id} Modify price of menu id.
* DELETE /{id}: Delete menu by ID.  

## Project Structure

* Entity: Contains the domain models.
* Repository: Interfaces of entities. 
* Service: Implements business logic and handles DTO mapping. 
* Controller: Are stored all the controllers of the application. 
* Exception: Contains exceptions handler.
* Configuration: Contains beans implementation and configuration.
* schema: Contains MySql schema tables. 


## Author
[@Bog653](https://github.com/Bog653)