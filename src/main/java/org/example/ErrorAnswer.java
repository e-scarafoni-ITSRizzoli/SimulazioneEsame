package org.example;

import com.google.gson.Gson;

public class ErrorAnswer {
    String errorText;
    Boolean result;

    public ErrorAnswer(String errorText, Boolean result) {
        this.errorText = errorText;
        this.result = result;
    }

    String asJSON() {
        Gson g = new Gson();
        String toJson = g.toJson(this);
        return toJson;
    }
}
