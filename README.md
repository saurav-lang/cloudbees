# cloudbees
POST call :
http://localhost:8080/ticket/purchase
{
"from" : "London",
"to" : "France",
"date" : "23-05-2024",
"user": "cloudbees",
"firstName": "saurav",
"lastName": "kumar",
"email": "saurav@gmail.com"
}

GET call:
http://localhost:8080/ticket/details/cloudbees
http://localhost:8080/ticket/seat/cloudbees

PUT call :
http://localhost:8080/ticket/update/cloudbees/12

DELETE call:
http://localhost:8080/ticket/remove/cloudbees
