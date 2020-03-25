package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrivilegeModel {
    private Long id;
    private String name;
}
