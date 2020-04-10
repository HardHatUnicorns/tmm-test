package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseModel {
    private Integer status;
    private String timestamp;
    private List<ErrorModel> errors;

}
