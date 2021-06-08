curl -XPUT -H "Content-Type: application/json" -k --user elastic:changeme  https://elasticsearch:9200/_template/blog -d '
{
  "blog" : {
    "mappings" : {
      "properties" : {
        "_class" : {
          "type" : "keyword",
          "index" : false,
          "doc_values" : false
        },
        "authors" : {
          "type" : "nested",
          "include_in_parent" : true,
          "properties" : {
            "_class" : {
              "type" : "keyword",
              "index" : false,
              "doc_values" : false
            },
            "name" : {
              "type" : "text"
            }
          }
        },
        "tags" : {
          "type" : "keyword"
        },
        "title" : {
          "type" : "text",
          "fields" : {
            "verbatim" : {
              "type" : "keyword"
            }
          },
          "fielddata" : true
        }
      }
    }
  }
}
