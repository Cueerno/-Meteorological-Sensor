# Project Description

This project (REST API service) receives and processes data from a meteorological sensor. This sensor measures the ambient air temperature and can detect if it is raining.

## Service Functionality:

1. **Get all sensors**:  
   `GET /sensors`
2. **Get a specific sensor by ID**:  
   `GET /sensors/{id}`
3. **Register a new sensor in the system**:  
   `POST /sensors`
4. **Get all measurements**:  
   `GET /measurements`
5. **Get a specific measurement by ID**:  
   `GET /measurements/{id}`
6. **Register a new measurement in the system**:  
   `POST /measurements`

## Data Format

Data exchange is performed in JSON format.

## Configuration

To make this project work, you need to create a file `application.properties` (or rename the file `application.properties.origin`) and fill in the fields according to your DBMS and

## Testing the Service

To test the service, you can install the [Postman](https://www.postman.com/) application and send requests to the service, receiving responses.
