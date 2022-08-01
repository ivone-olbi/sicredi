@Simulacoes @AtualizarSimulacao
Feature: Ataulizar simulacao.
  PUT /api/v1/simulacoes/{cpf}

  Background:
    Given uma massa de dados
      And um CPF "cpf"
      And um CPF "cpf_duplicado"

  Scenario: Simulacao duplicada.
    Given um novo CPF "cpf_duplicado"
    When atualizo uma simulacao existente
    Then retorna status de atualizacao "400"
     And a mensagem de atualizacao correta '{"mensagem":"CPF duplicado"}'