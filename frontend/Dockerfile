# base image
FROM node:9.6

ARG HTTP_PROXY
ARG HTTPS_PROXY

RUN npm config set proxy $HTTP_PROXY
RUN npm config set https-proxy $HTTPS_PROXY


# install chrome for protractor tests
RUN wget -e use_proxy=yes -e https_proxy=$HTTPS_PROXY -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN printf "deb http://archive.debian.org/debian/ jessie main\ndeb-src http://archive.debian.org/debian/ jessie main\ndeb http://security.debian.org jessie/updates main\ndeb-src http://security.debian.org jessie/updates main" > /etc/apt/sources.list
RUN http_proxy=$HTTP_PROXY apt-get update && http_proxy=$HTTP_PROXY apt-get install -yq google-chrome-stable

# set working directory
RUN mkdir /usr/src/app
WORKDIR /usr/src/app

# add `/usr/src/app/node_modules/.bin` to $PATH
ENV PATH /usr/src/app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY package.json /usr/src/app/package.json
RUN npm install
RUN npm i typescript@"<3.3.0"
RUN npm install -g @angular/cli@1.7.1
RUN npm install bootstrap --save
RUN npm install ngx-bootstrap --save

# add app
COPY . /usr/src/app

# start app
CMD ./launch.sh
