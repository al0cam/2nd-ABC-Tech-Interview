2nd Interview App
=================
Interview App is a simple app that allows you to create and manage accounts (racun).
It has basic CRUD functionality and it is written in Java Spring (https://spring.io/) with Thymeleaf (https://www.thymeleaf.org/) template engine as the front-end with the Bootstrap UI (https://getbootstrap.com/) library.

## SQL and Database
The database is placed inside a docker container which is created via docker-compose.yml. The database is PostgreSQL (https://www.postgresql.org/). 
The database is created via the schema.sql file which is located in the resources folder.
The database credentials would usually be inside an .env file but for the sake of simplicity they are hardcoded in the places where they are used.


## Installation
1. Clone the repository
2. Import the project into your IDE
3. Run the docker-compose.yml file via docker compose up command
4. Run the application

## Usage
Choosing the date of the displayed data is done via the datepicker. The datepicker is located on top of the page under the app title.

Adding a new account is done via the collapsed form which is behind the "Add new account" (Unesite novi račun) title. The form is collapsed by default and it is expanded by clicking on the title.

The account can be edited by clicking on any value in the table and is saved by clicking on the "Save" (Ažuriraj) button after the edit.

The account can be deleted by clicking on the "Delete" (Obriši) button.