# Jumping On The Clouds API

Jumping On The Clouds Spring Boot Application

### Run the Application
`./gradlew bootRun`


### API Endpoint Details

* Jumping On The Clouds Results: **POST  /jotc/results**

`HTTP Response Code : 201 Created`

Sample Request Body:

       {
          "input": "0 0 0 1 0 1 0 0",
          "firstName": "test",
          "lastName": "user",
          "email": "test.user@gmail.com"
        }


Sample Response Body:

        {
          "jumps": 4
        }

Curl:

`curl --request POST \
--url http://localhost:8080/jotc/results \
--header 'Content-Type: application/json' \
--data '{
"input": "0 0 0 1 0 1 0 0",
"firstName": "test",
"lastName": "user",
"email": "test.user@gmail.com"
}'`


* Administrators can request information about the JOTC requests(How many requests were processed in total and how many per user) : 
  **GET  /jotc/admin/requests**

`HTTP Response Code : 200 OK`

Sample Response Body:

        {
          "totalRequests": 10,
          "users": [
            {
              "email": "test.user@gmail.com",
              "requests": 10
            }
          ]
        }

Curl:

`curl --request GET \
--url http://localhost:8080/jotc/admin/requests \`


* Administrators can remove all requests for a certain user : **DELETE  /jotc/admin/users/remove**
  
`Query Parameter : userEmail`

`HTTP Response Code : 204 No Content`

Curl:

`curl --request DELETE \
--url 'http://localhost:8080/jotc/admin/users/remove?userEmail=test.user@gmail.com' \`



### Frameworks
1. Java
2. SpringBoot
3. H2 Database
4. Lombok
