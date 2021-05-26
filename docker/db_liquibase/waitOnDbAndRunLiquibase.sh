sleep 20
dockerize -wait tcp://db-test:3306 -timeout 120s
/entrypoint update