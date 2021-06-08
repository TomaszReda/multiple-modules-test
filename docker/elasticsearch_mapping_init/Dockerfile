FROM ubuntu

# Install packages
RUN apt-get update && \
apt-get install -y curl

COPY docker-entrypoint.sh /

RUN chmod +x docker-entrypoint.sh
#RUN chmod +x put_index.sh
#RUN chmod +x put_template.sh

ENTRYPOINT ["/docker-entrypoint.sh"]

#GET /_cat/indices
#GET /blog/_mapping
#
#GET /blog/_search
