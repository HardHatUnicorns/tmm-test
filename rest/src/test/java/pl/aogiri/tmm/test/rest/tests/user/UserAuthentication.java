package pl.aogiri.tmm.test.rest.tests.user;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.aogiri.tmm.test.rest.BaseTest;
import pl.aogiri.tmm.test.rest.model.UserModel;

import static io.restassured.RestAssured.given;

public class UserAuthentication extends BaseTest {
    private final String USERS_END_POINT = "/user/authentication";

    @Test
    public void shouldNotAuthenticateWithDisabledAccount() {
        UserModel userModel = UserModel.builder().login("tmmNoAuthUser").email("tmmNoAuthUser@tmm.com").plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post("user/register");
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        Assertions.assertFalse(response.as(UserModel.class).isEnabled());

        response = given()
                .auth()
                .basic("tmmNoAuthUser", "Password123")
                .contentType("application/json")
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
    }

}
