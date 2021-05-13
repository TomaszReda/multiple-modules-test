FROM nginx:alpine

ENV PORT=8081
EXPOSE 8081
COPY test-frontend/dist/test-frontend /usr/share/nginx/html/
COPY test-frontend/nginx/default.conf /etc/nginx/conf.d/default.conf.template

RUN chown -R nginx /etc/nginx

CMD ["/bin/sh","-c","envsubst '$PORT' < /etc/nginx/conf.d/default.conf.template > /etc/nginx/conf.d/default.conf && nginx -g 'daemon off;'"]