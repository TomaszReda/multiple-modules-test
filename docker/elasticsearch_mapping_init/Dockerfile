FROM ubuntu

# Install packages
RUN apt-get update &&  apt-get install -y curl

COPY docker-entrypoint.sh /
COPY put_index.sh /
COPY put_template.sh /

RUN chmod +x /docker-entrypoint.sh
RUN chmod +x /put_index.sh
RUN chmod +x /put_template.sh

ENTRYPOINT ["/docker-entrypoint.sh"]

#GET /_cat/indices
#GET /logstash-blog/_mapping
#GET /logstash-blog/_search
