FROM nginx:stable-alpine
RUN  wget https://github.com/martin-helmich/prometheus-nginxlog-exporter/releases/download/v1.3.0/prometheus-nginxlog-exporter && \
     chmod +x prometheus-nginxlog-exporter && \
     mv prometheus-nginxlog-exporter /usr/local/bin
CMD  nginx -g "daemon off;" && prometheus-nginxlog-exporter -config-file /etc/prometheus-nginxlog-exporter.hcl


