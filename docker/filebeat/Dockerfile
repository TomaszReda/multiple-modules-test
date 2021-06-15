FROM elastic/filebeat:7.13.1
COPY --chown=root  ./filebeat.docker.yml /usr/share/filebeat/filebeat.yml
USER root
RUN chmod 600 /usr/share/filebeat/filebeat.yml