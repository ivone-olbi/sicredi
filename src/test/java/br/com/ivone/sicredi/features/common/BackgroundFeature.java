package br.com.ivone.sicredi.features.common;

import static br.com.ivone.sicredi.config.Propriedades.propriedade;
import static br.com.ivone.sicredi.models.builders.SimulacaoBuilder.criarSimulacao;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static java.util.Arrays.stream;

import br.com.ivone.sicredi.models.Simulacao;
import io.cucumber.java.en.Given;

public class BackgroundFeature {

    @Given("uma massa de dados")
    public void uma_massa_de_dados() {
        stream(given().when().get("/api/v1/simulacoes").thenReturn().as(Simulacao[].class))
                             .forEach(simulacao -> given().when().delete("api/v1/simulacoes/" + simulacao.getId()).thenReturn());
    }

    @Given("um CPF {string}")
    public void um_cpf_duplicado(String cenario) {
    	given().contentType(JSON).body(criarSimulacao().cpf(propriedade(cenario)).build()).when().post("/api/v1/simulacoes").thenReturn();
    }

}