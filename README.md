```
curl -X POST \
  http://localhost:8080/person \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"id":1,
	"name":"john",
	"age":22
}'


curl -X GET \
http://localhost:8080/person \
-H 'cache-control: no-cache'
  
  
curl -X GET \
http://localhost:8080/person/1 \
-H 'cache-control: no-cache'


curl -X PUT \
  http://localhost:8080/person/1 \
  -H 'Content-Type: application/json' \
  -H 'cache-control: no-cache' \
  -d '{
	"name":"johnny",
	"age":44
}'

```