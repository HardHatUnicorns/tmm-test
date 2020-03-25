package pl.aogiri.tmm.test.rest.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class UserModel {
    private Long id;
    private String login;
    private String email;
    private String plainPassword;
    private String password;
    private Collection<RoleModel> roles;
    private boolean enabled;

}
