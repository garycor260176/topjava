**get**
``````
curl --location "http://localhost:8080/topjava/rest/meals/100004" 
``````
---
**delete**
``````
curl --location --request DELETE http://localhost:8080/topjava/rest/meals/100004
``````
---
**getAll**
``````
curl --location http://localhost:8080/topjava/rest/meals
``````
---
**createWithLocation** - создаем новую еду
``````
curl --location --request POST http://localhost:8080/topjava/rest/meals -H "Content-Type: application/json" -d "{""dateTime"": ""2020-02-01T10:00:00"", ""description"": ""1111"", ""calories"": 100}"
``````
**update** - апдейтим созданную еду (айди из БД берем.)
``````
curl --location --request PUT http://localhost:8080/topjava/rest/meals/100012 -H "Content-Type: application/json" -d "{""dateTime"": ""2020-02-01T10:00:00"", ""description"": ""333"", ""calories"": 200}"
``````
**getBetween**
``````

curl --location http://localhost:8080/topjava/rest/meals/between?startDate=2020-01-30&startTime=10:00:00&endDate=2020-01-30&endTime=21:00:00
``````
