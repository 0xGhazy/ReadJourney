package com.project.ReadJourney.utils;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class Response {

    private String message;
    private HttpStatus status;
    private Object data;
    private ResponseMetadata responseMetadata;
    private HashMap<String, Object> jsonResponse = new HashMap<>();



    private Response(ResponseBuilder responseBuilder){
        this.message = responseBuilder._message;
        this.status = responseBuilder._status;
        this.data = responseBuilder._data;
        this.responseMetadata = responseBuilder._metadata;
    }

    public HashMap<String, Object> jsonfy(){
        jsonResponse.put("message", this.message);
        jsonResponse.put("status", this.status);
        jsonResponse.put("data", this.data);
        jsonResponse.put("metadata", this.responseMetadata);
        if(jsonResponse.get("metadata") == null){
            jsonResponse.remove("metadata");
        }
        return jsonResponse;
    }

    public HttpStatus getStatusCode(){
        return status;
    }


    @NoArgsConstructor
    public static class ResponseBuilder {

        private String _message;
        private HttpStatus _status;
        private Object _data;
        private ResponseMetadata _metadata;

        public ResponseBuilder message(String message) {
            this._message = message;
            return this;
        }

        public ResponseBuilder status(HttpStatus status) {
            this._status = status;
            return this;
        }

        public ResponseBuilder data(Object _data) {
            this._data = _data;
            return this;
        }

        public ResponseBuilder metadata(ResponseMetadata metadata) {
            this._metadata = metadata;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}
