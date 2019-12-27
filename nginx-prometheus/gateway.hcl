listen {
  port = 4040
}

consul {
  enable = false
}

namespace "gateway" {

  format = "$remote_addr - $remote_user [$time_local] \"$request\" $status $body_bytes_sent \"$http_referer\" \"$http_user_agent\" \"$http_x_forwarded_for\""

  source = {
    files = [
        "/var/log/nginx/gateway.log"
      ]
  }

  labels {
        app = "Bank Connector"
        env = "Proxy"
  }

  histogram_buckets = [.005, .01, .025, .05, .1, .25, .5, 1, 2.5, 5, 10]
}
