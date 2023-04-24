package dev.ifrs;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.MediaType;

@QuarkusTest
public class Exercicio {

/*     @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy"));
    } */

    @Test
    public void testCupom() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=1150.23&cupom=CUPOM10")
            .when()
                .post("/cupom")
            .then()
                .statusCode(200)
                .body(is("103521"));
    }

    @Test
    public void testCupom15() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=1150.23&cupom=CUPOM15")
            .when()
                .post("/cupom")
            .then()
                .statusCode(200)
                .body(is("97770"));
    }

    @Test
    public void testValor0() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=0&cupom=CUPOM10")
            .when()
                .post("/cupom")
            .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    public void testValorLetras() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=AAA&cupom=CUPOM10")
            .when()
                .post("/cupom")
            .then()
                .statusCode(400);
    }

    @Test
    public void testCupomNums() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=0&cupom=123")
            .when()
                .post("/cupom")
            .then()
                .statusCode(200)
                .body(is("fail"));
    }

}