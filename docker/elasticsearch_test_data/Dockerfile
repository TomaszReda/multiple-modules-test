FROM ubuntu

# Install packages
RUN apt-get update && \
apt-get install -y curl

COPY docker-entrypoint.sh /
COPY test-data.sh /

RUN chmod +x /docker-entrypoint.sh
RUN chmod +x /test-data.sh

ENTRYPOINT ["/docker-entrypoint.sh"]