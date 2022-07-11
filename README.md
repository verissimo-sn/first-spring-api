# First Java project - Task CRUD

## Description
 - This repo is a first rest api with Java and Spring Boot. My goal was to know a little about java and test some native methods of the language.
 - This project doesn't have validation or treatment of data received in the endpoints, it's really just a simple crud to get to know a little of the language
 - used the following methods - GET, POST, PUT, PATH and DELETE

## How to show a project and run in local machine
 - Clone the repository
 - Install dependencies
 - The api runs on port `8080`

## End-points
 - Get all tasks
   - GET `/tasks`
 - Get task by id
   - GET `/tasks/:id`
 - Create task
   - POST `/tasks`
   - Body: 
   ```json 
   {
      "name": string,
      "description": string
   }
    ```
 - Update task
   - PUT `/tasks/id`
   - Query:
   ```json 
   {
     "name": string,
     "description": string
   }
 - Delete task
   - DELETE `/tasks/:id`
 - Update task status
   - PATH `/tasks/:id/status`
