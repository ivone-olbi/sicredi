package br.com.ivone.sicredi.config;

import static br.com.ivone.sicredi.config.Propriedades.propriedade;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public final class RestAssured {

    static { 
        io.restassured.RestAssured.baseURI = propriedade("host");
        io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public Response response;
    public ValidatableResponse validatableResponse;

}