  dockerize -wait tcp://elasticsearch:9200 -timeout 120s
      bash put_index.sh
      bash put_template.sh