package br.com.ivone.sicredi.features;

import static br.com.ivone.sicredi.config.Propriedades.propriedade;
import static br.com.ivone.sicredi.models.builders.SimulacaoBuilder.criarSimulacao;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import java.util.Map;

import br.com.ivone.sicredi.config.RestAssured;
import br.com.ivone.sicredi.models.Simulacao;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlterarSimulacaoFeature {

    // Injetado via PicoContainer.
    private final RestAssured restAssured;

    // Dados informados pelo usuario.
    protected Simulacao simulacao;

    @Given("um novo CPF {string}")
    public void um_novo_cpf(String cenario) {
        this.simulacao = criarSimulacao().cpf(propriedade(cenario)).build();
    }

    @When("atualizo uma simulacao existente")
    public void atualizo_uma_simulacao_existente() {
        restAssured.response = given().contentType(JSON).body(simulacao).when().put("/api/v1/simulacoes/{cpf}", Map.of("cpf", propriedade("cpf")));
    }

    @Then("retorna status de atualizacao {string}")
    public void retorna_status_de_atualizacao(String httpStatus) {
        restAssured.validatableResponse = restAssured.response.then().statusCode(parseInt(httpStatus));
    }

    @Then("a mensagem de atualizacao correta {string}")
    public void a_mensagem_de_atualizacao_correta(String mensagem) {
        restAssured.validatableResponse.body(containsStringIgnoringCase(mensagem));
    }

}