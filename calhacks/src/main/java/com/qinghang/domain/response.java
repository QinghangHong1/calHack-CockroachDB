package com.qinghang.domain;

import java.util.HashMap;

public class Response extends HashMap<String, Object> {
    public Response message(String message){
        this.put("message", message);
        return this;
    }
    public Response data(Object data){
        this.put("data", data);
        return this;
    }
    public Response put(String key, Object value){
        super.put(key, value);
        return this;
    }

}
