package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorModel {
    private String object;
    private String field;
    private String rejectedValue;
    private String message;

}
