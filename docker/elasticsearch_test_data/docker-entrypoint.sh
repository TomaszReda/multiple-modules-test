dockerize -wait tcp://elasticsearch:9200 -timeout 120s

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  https://elasticsearch:9200/blog/_doc/1 -d '{ "title" : "test", "tags" : ["test"], "authors" : ["name" : "name"] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  https://elasticsearch:9200/blog/_doc/2 -d '{ "title" : "test2", "tags" : ["test2"], "authors" : ["name" : "name2"] }'
