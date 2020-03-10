package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class ResponseModel {
    private Integer status;
    private String timestamp;
    private ArrayList<ErrorModel> errors;

}
