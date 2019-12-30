FROM nginx:stable-alpine
#ENV BUNDLER_VERSION 1.12.3

#RUN \
#    apk --update add ruby ruby-io-console ruby-irb ruby-json ruby-rake ruby-rdoc ruby-dev  && \
#    gem install bundler -v "$BUNDLER_VERSION" --no-document && \
#    bundle config --global silence_root_warning 1

#RUN apk --update add git build-base && \
RUN apk --update add ruby ruby-bundler ruby-dev git build-base ruby-rdoc ruby-irb ruby-webrick && \
    gem install fluentd --no-ri --no-rdoc && \
    fluent-gem install fluent-plugin-grep && fluent-gem install fluent-plugin-prometheus && \
    git clone git://github.com/fluent/fluent-plugin-prometheus && \
    cd fluent-plugin-prometheus && \
#    bundle install --path vendor/bundle && \
    wget https://github.com/prometheus/prometheus/releases/download/v1.5.2/prometheus-1.5.2.linux-amd64.tar.gz -O - | tar zxf -



WORKDIR fluent-plugin-prometheus

CMD  nginx -g "daemon on;" &&  ./prometheus-1.5.2.linux-amd64/prometheus -config.file=./misc/prometheus.yaml -storage.local.path=./prometheus/metrics & fluentd -c misc/fluentd_sample.conf -v




