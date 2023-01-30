package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
     void shouldReturnSendData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Data 45") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Data"))
                .body(matchesJsonSchemaInClasspath("postmanecho.schema.json"));
    }
}
