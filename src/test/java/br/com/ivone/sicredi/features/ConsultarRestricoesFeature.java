package br.com.ivone.sicredi.features;

import static io.restassured.RestAssured.given;

import java.util.Map;

import br.com.ivone.sicredi.config.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsultarRestricoesFeature {

    // Injetado via PicoContainer.
    private final RestAssured restAssured;

    // CPF informado pelo usuario.
    private String cpf;

    @Given("um {string}")
    public void um(String cpf) {
        this.cpf = cpf;
    }

    @When("consulto a restricao")
    public void consulto_as_restricoes() {
        // Chamada do servico REST de consulta da restricao.
    	restAssured.response = given().when().get("/api/v1/restricoes/{cpf}", Map.of("cpf", cpf));
    }

    @Then("retorna o {int} correto")
    public void retorna_o_correto(int httpStatus) {
        // Valida o HTTP Status retornado.
    	restAssured.response.then().statusCode(httpStatus);
    }

}