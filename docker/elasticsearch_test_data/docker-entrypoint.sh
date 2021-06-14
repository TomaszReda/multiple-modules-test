#!/bin/bash
function elastic {
  if curl --user elastic:changeme elasticsearch:9200;
  then
    bash test-data.sh
  else
    sleep 20
    elastic
  fi
}

elastic

