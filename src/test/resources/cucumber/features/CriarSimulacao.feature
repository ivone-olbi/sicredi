@Simulacoes @CriarSimulacao
Feature: Criar simulacao.
  POST /api/v1/simulacoes

  Background:
    Given uma massa de dados
      And um CPF "cpf_duplicado"

  Scenario: Simulacao duplicada.
    Given CPF "cpf_duplicado"
    When crio a simulacao
    Then retorna status de criacao "400"
     And a mensagem de criacao correta '{"mensagem":"CPF duplicado"}'

  Scenario: CPF invalido alphanumerico.
    Given CPF "cpf_invalido_alphanumerico"
    When crio a simulacao
    Then retorna status de criacao "400"
     And a mensagem de criacao correta ""

  Scenario: CPF invalido numerico.
    Given CPF "cpf_invalido_numero"
    When crio a simulacao
    Then retorna status de criacao "400"
     And a mensagem de criacao correta ""

  Scenario: E-mail invalido.
    Given e-mail "email_invalido"
    When crio a simulacao
    Then retorna status de criacao "400"
     And a mensagem de criacao correta '{"erros":{"email":"E-mail deve ser um e-mail válido"}}'

  Scenario: Parcela acima da maxima.
    Given parcela "parcela_maxima+1"
    When crio a simulacao
    Then retorna status de criacao "400"
     And a mensagem de criacao correta ""