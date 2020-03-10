package pl.aogiri.tmm.test.rest.model;

import java.util.Collection;

public class RoleModel {
    private Long id;
    private String name;
    private Collection<PrivilegeModel> privileges;
}
