@Restricoes @ConsultarRestricoes
Feature: Consultar restricao pelo CPF.
  GET /api/v1/restricoes/{cpf}

  Scenario Outline: 
    Given um <CPF>
    When consulto a restricao
    Then retorna o <status> correto

    Examples: 
      | CPF           | status |
      | "23650409003" | 204    |
      | "2365040900T" | 400    |
      | "23650409001" | 400    |
      | "97093236014" | 200    |