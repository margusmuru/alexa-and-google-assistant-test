package csgoInventory.gateway;

import java.util.HashMap;
import java.util.Map;

public class GatewayApiResponseWrapper {
    private Integer statusCode = 200;
    private Map<String, String> headers = new HashMap<>();
    private boolean isBase64Encoded = false;
    private String body;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public void setBase64Encoded(boolean base64Encoded) {
        isBase64Encoded = base64Encoded;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static class Builder {
        private Integer statusCode = 200;
        private Map<String, String> headers = new HashMap<>();
        private boolean isBase64Encoded = false;
        private String body;

        public Builder() {
        }

        public Builder statusCode(Integer statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder headers(Map<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder base64Encoded(boolean base64Encoded) {
            isBase64Encoded = base64Encoded;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public GatewayApiResponseWrapper build() {
            GatewayApiResponseWrapper wrapper = new GatewayApiResponseWrapper();
            wrapper.setStatusCode(this.statusCode);
            wrapper.setHeaders(this.headers);
            wrapper.setBase64Encoded(this.isBase64Encoded);
            wrapper.setBody(this.body);
            return wrapper;
        }
    }
}
