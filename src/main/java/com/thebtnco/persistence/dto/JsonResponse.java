package com.thebtnco.persistence.dto;

/**
 * Created by Ady on 2/19/17.
 */
@SuppressWarnings("DefaultFileTemplate")
public class JsonResponse {

    private Object data;

    public JsonResponse(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
