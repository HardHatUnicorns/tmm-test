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
        UserModel userModel = UserModel.builder().login("tmmuser123").email("tmmuser123@gmail.com").plainPassword("Duzaliterka123").build();
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
    public void shouldNotCreateUserLoginTooShort(){
        UserModel userModel = UserModel.builder().login("tmmus").email("tmmuser321@gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserloginTooLong(){
        UserModel userModel = UserModel.builder().login("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ").email("tmmuser345@gmail.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserPasswordTooShort(){
        UserModel userModel = UserModel.builder().login("tmmuser098").email("tmmuser345@gmail.com").plainPassword("Dua123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserPasswordTooLong(){
        UserModel userModel = UserModel.builder().login("tmmuserdfg").email("tmmuserzxc@gmail.com").plainPassword("Duzalitaaaaaaaaaaaaaaaaaaaaaaaaaaaaadwadawdwawdawdawaawawddwadwaadwdawawddawdawawawdwaddawdwaawdaddawadwdwwerka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserNoUpperCharacterPassword(){
        UserModel userModel = UserModel.builder().login("tmmuser567").email("jkl@gmail.com").plainPassword("duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserNoNumbersPassword(){
        UserModel userModel = UserModel.builder().login("tmmgej").email("mihu1234@gmail.com").plainPassword("Duzaliterka").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserNoAtSignEmail(){
        UserModel userModel = UserModel.builder().login("tmmowina").email("tmmowinol.com").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void ShouldCreateUserNoDomainEmail(){
        UserModel userModel = UserModel.builder().login("tmmowina").email("tmmowina@gmail").plainPassword("Duzaliterka123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    }
    @Test
    public void shouldNotCreateUserNoPassword(){
        UserModel userModel = UserModel.builder().login("tmmeksdi").email("tmmeksdi@gmail.com").plainPassword("").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserNoLogin(){
        UserModel userModel = UserModel.builder().login("").email("tmmmasakra@gmail.com").plainPassword("Tmmuser123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }

    @Test
    public void shouldNotCreateUserNoEmail(){
        UserModel userModel = UserModel.builder().login("Tmmuser123").email("").plainPassword("Tmmuser123").build();
        Response response = given()
                .contentType("application/json")
                .body(userModel)

                .when()
                .post(usersEndPoint);
        Assertions.assertEquals(HttpStatus.SC_UNPROCESSABLE_ENTITY, response.statusCode());
    }
}
