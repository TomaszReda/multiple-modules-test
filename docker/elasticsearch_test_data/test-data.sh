curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/1 -d '{ "title" : "test", "tags" : ["test"], "authors" : [{"name" : "name"}] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/2 -d '{ "title" : "test2", "tags" : ["test2"], "authors" : [{"name" : "name2"}] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/3 -d '{ "title" : "test3", "tags" : ["test,test2,test3"], "authors" : [{"name" : "name3"}] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/4 -d '{ "title" : "test4", "tags" : ["test4,test2"], "authors" : [{"name" : "name23"}] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/5 -d '{ "title" : "test5", "tags" : ["test"], "authors" : [{"name" : "name4"}] }'

curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  http://elasticsearch:9200/blog/_doc/6 -d '{ "title" : "test6", "tags" : ["test2"], "authors" : [{"name" : "name5"}] }'