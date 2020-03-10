package pl.aogiri.tmm.test.rest.model;

import lombok.Data;

@Data
public class ErrorModel {

    private String object;
    private String field;
    private String rejectedValue;
    private String message;

}
