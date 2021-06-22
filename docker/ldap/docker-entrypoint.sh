#!/bin/bash
function elastic {
  if curl --user elastic:changeme elasticsearch:9200;
  then
    bash put_index.sh
    bash put_template.sh
  else
    sleep 20
    elastic
  fi
}

elastic