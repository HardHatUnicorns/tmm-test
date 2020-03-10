package pl.aogiri.tmm.test.rest;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.aogiri.tmm.test.rest.model.UserModel;

import static io.restassured.RestAssured.given;

public class UserRegister extends BaseTest{
    private String usersEndPoint = "/user/register";

    @Test
    public void shouldCreateUser(){
        UserModel userModel = UserModel.builder().login("mihaltomurzyn").email("mihu123@gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
        Assertions.assertNotNull(response.as(UserModel.class).getId());
        Assertions.assertFalse(response.as(UserModel.class).isEnabled());
    }

    @Test
    public void loginTooShort(){
        UserModel userModel = UserModel.builder().login("mihal").email("mihu1234@gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void loginTooLong(){
        UserModel userModel = UserModel.builder().login("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ").email("mihu1234@gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void passwordTooShort(){
        UserModel userModel = UserModel.builder().login("mihalaa").email("mihu1234@gmail.com").plainPassword("Dua123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void passwordTooLong(){
        UserModel userModel = UserModel.builder().login("mihal").email("mihu1234@gmail.com").plainPassword("Duzalitaaaaaaaaaaaaaaaaaaaaaaaaaaaaadwadawdwawdawdawaawawddwadwaadwdawawddawdawawawdwaddawdwaawdaddawadwdwwerka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void noUpperCharacterPassword(){
        UserModel userModel = UserModel.builder().login("mihal").email("mihu1234@gmail.com").plainPassword("duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void noNumbersPassword(){
        UserModel userModel = UserModel.builder().login("mihal").email("mihu1234@gmail.com").plainPassword("Duzaliterka").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void noAtSignEmail(){
        UserModel userModel = UserModel.builder().login("mihal").email("mihu123gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void createUserNoDomainEmail(){
        UserModel userModel = UserModel.builder().login("mihalaa").email("mihu1234@gmail").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    }
}
