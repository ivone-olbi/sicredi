package br.com.ivone.sicredi.features;

import static br.com.ivone.sicredi.config.Propriedades.propriedade;
import static br.com.ivone.sicredi.models.builders.SimulacaoBuilder.criarSimulacao;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.lang.Integer.parseInt;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

import br.com.ivone.sicredi.config.RestAssured;
import br.com.ivone.sicredi.models.Simulacao;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarSimulacaoFeature {

    // Injetado via PicoContainer.
    private final RestAssured restAssured;

    // Dados informados pelo usuario.
    protected Simulacao simulacao;

    @Given("CPF {string}")
    public void cpf(String cenario) {
        this.simulacao = criarSimulacao().cpf(propriedade(cenario)).build();
    }

    @Given("e-mail {string}")
    public void e_mail(String cenario) {
        this.simulacao = criarSimulacao().email(propriedade(cenario)).build();
    }

    @Given("parcela {string}")
    public void parcela(String cenario) {
        this.simulacao = criarSimulacao().parcelas(parseInt(propriedade(cenario))).build();
    }

    @When("crio a simulacao")
    public void crio_a_simulacao() {
        restAssured.response = given().contentType(JSON).body(simulacao).when().post("/api/v1/simulacoes");
    }

    @Then("retorna status de criacao {string}")
    public void retorna_status_de_criacao(String httpStatus) {
        restAssured.validatableResponse = restAssured.response.then().statusCode(parseInt(httpStatus));
    }

    @Then("a mensagem de criacao correta {string}")
    public void a_mensagem_de_criacao_correta(String mensagem) {
        restAssured.validatableResponse.body(containsStringIgnoringCase(mensagem));
    }

}