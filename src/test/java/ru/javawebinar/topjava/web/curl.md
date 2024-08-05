**get meal by id**
``````
curl --location "http://localhost:8080/topjava/rest/meals/100004" 
``````
---
**delete meal by id**
``````
curl --location --request DELETE http://localhost:8080/topjava/rest/meals/100004
``````
---
**get all meals**
``````
curl --location http://localhost:8080/topjava/rest/meals
``````
---
**create new meal**
``````
curl --location --request POST http://localhost:8080/topjava/rest/meals -H "Content-Type: application/json" -d "{""dateTime"": ""2020-02-01T10:00:00"", ""description"": ""1111"", ""calories"": 100}"
``````

**update meal by id**
``````
curl --location --request PUT http://localhost:8080/topjava/rest/meals/100012 -H "Content-Type: application/json" -d "{""dateTime"": ""2020-02-01T10:00:00"", ""description"": ""333"", ""calories"": 200}"
``````

**get meals within a date_time range**
``````

curl --location http://localhost:8080/topjava/rest/meals/between?startDate=2020-01-30&startTime=10:00:00&endDate=2020-01-30&endTime=21:00:00
``````
