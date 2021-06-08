curl -XPUT -k --user elastic:changeme http://elasticsearch:9200/blog-test

curl -XPOST -H "Content-Type: application/json" -k --user elastic:changeme http://elasticsearch:9200/_aliases -d '
{
    "actions": [
        {
            "add": {
                "index": "blog",
                "alias": "blog-test"
            }
        }
    ]
}';