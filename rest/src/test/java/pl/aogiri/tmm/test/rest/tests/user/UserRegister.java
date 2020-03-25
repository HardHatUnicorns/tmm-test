package pl.aogiri.tmm.test.rest.tests.user;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.aogiri.tmm.test.rest.BaseTest;
import pl.aogiri.tmm.test.rest.model.ResponseModel;
import pl.aogiri.tmm.test.rest.model.UserModel;

import static io.restassured.RestAssured.given;

public class UserRegister extends BaseTest {
    private final static String USERS_END_POINT = "/user/register";

    @Test
    public void shouldCreateUser() {
        UserModel userModel = UserModel.builder().login("tmmUserRegister1").email("tmmuser@tmm.com").plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        Assertions.assertNotNull(response.as(UserModel.class).getId());
        Assertions.assertFalse(response.as(UserModel.class).isEnabled());
    }

    @Test
    public void ShouldCreateUserNoDomainEmail() {
        UserModel userModel = UserModel.builder().login("tmmUserRegisterNoDomain").email("tmmUserNoDomain@tmm").plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        Assertions.assertNotNull(response.as(UserModel.class).getId());
        Assertions.assertFalse(response.as(UserModel.class).isEnabled());
    }

    @ParameterizedTest(name = "Too short and too long login tests")
    @ValueSource(strings = {"userA", "userNameWhichShouldNotBeCreatedBe"})
    public void shouldNotCreateUserWrongLogin(String login) {
        UserModel userModel = UserModel.builder().login(login).email("tmmUserWrongLogin@tmm.com").plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("size must be between 6 and 32")));
    }

    @ParameterizedTest(name = "Too short and too long password tests")
    @ValueSource(strings = {"Passwo1", "userNameWhichShouldNotBeCreatedBecausePasswordIsTooLongPleaseMakeMeLonger"})
    public void shouldNotCreateUserWrongPassword(String password) {
        UserModel userModel = UserModel.builder().login("tmmUserWrongPassword").email("tmmUserWrongPassword@tmm.com").plainPassword(password).build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("size must be between 8 and 64")));
    }

    @ParameterizedTest
    @ValueSource(strings = {"password1", "Password"})
    public void shouldNotCreateUserIllegalPassword(String password) {
        UserModel userModel = UserModel.builder().login("tmmUserIllegalPassword").email("tmmUserIllegalPassword@tmm.com").plainPassword(password).build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("Password is not valid")));
    }

    @Test
    public void shouldNotCreateUserWhenEmailNoAtSign() {
        UserModel userModel = UserModel.builder().login("tmmUserNoAtSign").email("tmmUserNoAtSign.com").plainPassword("Password1").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("must be a well-formed email address")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void shouldNotCreateUserWithEmptyLogin(String login) {
        UserModel userModel = UserModel.builder().login(login).email("tmmUserEmptyLogin@tmm.com").plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("Login is required")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void shouldNotCreateUserWithEmptyEmail(String email) {
        UserModel userModel = UserModel.builder().login("tmmUserEmptyEmail").email(email).plainPassword("Password123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("Email is required")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    public void shouldNotCreateUserWithEmptyPassword(String password) {
        UserModel userModel = UserModel.builder().login("tmmUserEmptyPassword").email("tmmUserEmptyPassword@tmm.com").plainPassword(password).build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(USERS_END_POINT);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
        Assertions.assertTrue(response.as(ResponseModel.class).getErrors().parallelStream().anyMatch(error -> error.getMessage().equals("Password is required")));
    }
}
