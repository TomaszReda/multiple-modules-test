FROM node:10 as builder



RUN cp ./test-frontend/package.json . && cp test-frontend/package-lock.json . && npm i && mv ./node_modules /test-frontend/

WORKDIR /test-frontend
## Build the angular app in production mode and store the artifacts in dist folder
RUN $(npm bin)/ng build --prod --output-path=dist

### STAGE 2: Setup ###
FROM nginx:stable-alpine

COPY ./nginx.conf /etc/nginx/conf.d/default.conf

## Remove default nginx website
RUN rm -rf /usr/share/nginx/html/*

## From ‘builder’ stage copy over the artifacts in dist folder to default nginx public folder
COPY --from=builder /test-frontend/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]