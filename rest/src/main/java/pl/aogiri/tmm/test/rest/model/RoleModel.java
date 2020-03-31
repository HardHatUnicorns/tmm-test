package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class RoleModel {
    private Long id;
    private String name;
    private Collection<PrivilegeModel> privileges;
}
