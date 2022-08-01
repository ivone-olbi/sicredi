![I Love You](https://img.shields.io/badge/Sicredi-I%20Love%20You-red?style=flat-square)
![Eclipse](https://img.shields.io/badge/Eclipse-IDE-blue?style=flat-square&logo=eclipseide)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=flat-square&logo=apachemaven)

**Sicredi = Ivone Feliz!! _Muito obrigada pela oportunidade!_** 💘

---

**BUGs** 🪲  
_Erros encontrados na API:_

> As linhas marcadas de vermelho são os BUGs, as verde são "possíveis" BUGs.

`GET <host>/api/v1/restricoes/{cpf}`
```diff
- NAO DEVE consultar restrições DADO CPF inválido alphanumérico.
- NAO DEVE consultar restrições DADO CPF inválido numérico.
```
![<host>/api/v1/restricoes/{cpf}](https://github.com/ivone-olbi/sicredi/blob/main/ferramentas/readme.md/imagens/GET%20restricoes%20-%20All%20Tests.png?raw=true)

`POST <host>/api/v1/simulacoes`
```diff
- NAO DEVE criar uma simulação QUANDO seguro vazio.
  Internal Server Error
- NAO DEVE criar uma simulação DADO CPF inválido alphanumérico.
- NAO DEVE criar uma simulação DADO CPF inválido numérico.
- NAO DEVE criar uma simulação DADO parcela acima da máxima.
- NAO DEVE criar uma simulação DADO valor abaixo do minímo.

+ NAO DEVE criar uma simulação QUANDO e-mail vazio.
  Cenário apresenta mensagem fora do padrão.
+ NAO DEVE criar uma simulação DADO e-mail inválido.
  Existem 2 mensagens "cadastradas" para o cenário acima.
```
![<host>/api/v1/simulacoes](https://github.com/ivone-olbi/sicredi/blob/main/ferramentas/readme.md/imagens/POST%20simulacoes%20-%20All%20Tests.png?raw=true)

`PUT <host>/api/v1/simulacoes/{cpf}`  

😫😫😫 _**A SIMULAÇÃO SÓ CONSEGUE SER ATUALIZADA COM O ATRIBUTO `seguro` PREENCHIDO. EX.:**_ 😫😫😫

```json
{ 
    "cpf": "16238900040"
}

Internal Server Error:
{
    "timestamp": "2022-08-01T05:39:32.483+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "ModelMapper mapping errors...",
    "path": "/api/v1/simulacoes/23650409003"
}
```

> Abaixo se encontram os erros apresentados mesmo com o atributo `seguro` preenchido.
  
```diff
- NAO DEVE atualizar a simulação DADO CPF inválido numérico.
- NAO DEVE atualizar a simulação DADO parcela acima da máxima.
- DEVE atualizar a simulação DADO valor.
 
+ NAO DEVE atualizar a simulação DADO valor acima do máximo.
  Cenário não permite atualizar, mas também não retorna mensagem de erro.
+ NAO DEVE atualizar a simulação DADO valor abaixo do minímo.
  Cenário não permite atualizar, mas também não retorna mensagem de erro.
```
![<host>/api/v1/simulacoes/{cpf}](https://github.com/ivone-olbi/sicredi/blob/main/ferramentas/readme.md/imagens/PUT%20simulacoes%20-%20All%20Tests.png?raw=true)

---

_Tecnologias usadas:
**JDK 11** - [Cucumber](https://cucumber.io), [Eclipse](https://www.eclipse.org), [JUnit](https://junit.org/junit4), [Maven](https://maven.apache.org), [PicoContainer](http://picocontainer.com), [Postman](https://www.postman.com), [Project Lombok](https://projectlombok.org) e [REST Assured](https://rest-assured.io)._

**Instalação**

1. _realize o `git clone` do projeto;_
2. _realize a instalação do plugin **[Project Lombok](https://projectlombok.org)** na sua IDE favorita **[clicando aqui](https://projectlombok.org)**;_
3. _realize a configuração do plugin do **[Cucumber](https://cucumber.io)** na sua IDE favorita **[clicando aqui](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin)**;_

**Postman**  
_O Postman foi adicionado como um **apêndice**, para mostrar a facilidade que o mesmo possuí em testes de API, com a mesma precisão de um projeto em Java._

[Link para Collection e Environment do Postman.](https://github.com/ivone-olbi/sicredi/tree/main/ferramentas/postman)
  
⚠️⚠️⚠️ _**REALIZEI APENAS ALGUNS CENARIOS NO PROJETO JAVA. O POSTMAN ESTA COM 100% DOS CENARIOS ABAIXO.**_ ⚠️⚠️⚠️  


Código lindo em Typescript no [Postman](https://www.postman.com). Ex.:
```javascript
// Limpa o(s) cenario(s):
pm.sendRequest({ method: "GET", url: `${host}/api/v1/simulacoes` }, (error, response) => {
    response.json().forEach((simulacao) => pm.sendRequest({ method: "DELETE", url: `${host}/api/v1/simulacoes/${simulacao.id}` }))
    carregarCenarios()
})
```  

_Cenários:_

`GET <host>/api/v1/restricoes/{cpf}`
1. _**NAO DEVE** consultar restrições **DADO** CPF inválido alphanumérico._
2. _**NAO DEVE** consultar restrições **DADO** CPF inválido numérico._
3. _**DEVE** consultar restrições **DADO** CPF sem restrição._
4. _**DEVE** consultar restrições **DADO** CPF com restrição._

`POST <host>/api/v1/simulacoes`
1. _**NAO DEVE** criar uma simulação **QUANDO** nome vazio._
2. _**NAO DEVE** criar uma simulação **QUANDO** CPF vazio._
3. _**NAO DEVE** criar uma simulação **QUANDO** e-mail vazio._
4. _**NAO DEVE** criar uma simulação **QUANDO** valor vazio._
5. _**NAO DEVE** criar uma simulação **QUANDO** parcelas vazio._  
6. _**NAO DEVE** criar uma simulação **QUANDO** seguro vazio._
7. _**NAO DEVE** criar uma simulação **DADO** CPF duplicado._
8. _**NAO DEVE** criar uma simulação **DADO** CPF inválido numérico._
9. _**NAO DEVE** criar uma simulação **DADO** CPF inválido alphanumérico._
10. _**NAO DEVE** criar uma simulação **DADO** e-mail inválido._
11. _**NAO DEVE** criar uma simulação **DADO** parcela acima da máxima._
12. _**NAO DEVE** criar uma simulação **DADO** parcela abaixo da miníma._
13. _**NAO DEVE** criar uma simulação **DADO** valor acima do máximo._
14. _**NAO DEVE** criar uma simulação **DADO** valor abaixo do minímo._
15. _**DEVE** criar uma simulação **DADO** informações corretas com valor máximo._
16. _**DEVE** criar uma simulação **DADO** informações corretas com valor minímo._
17. _**DEVE** criar uma simulação **DADO** informações corretas com parcela máxima._
18. _**DEVE** criar uma simulação **DADO** informações corretas com parcela miníma._
19. _**DEVE** criar uma simulação **DADO** informações sem seguro._

> Os cenáros 15 e 17/16 e 18 são testados simultâneamente.

`PUT <host>/api/v1/simulacoes/{cpf}`
1. _**NAO DEVE** atualizar a simulação **DADO** CPF duplicado._
2. _**NAO DEVE** atualizar a simulação **DADO** CPF inválido numérico._
3. _**NAO DEVE** atualizar a simulação **DADO** CPF não encontrado._
4. _**NAO DEVE** atualizar a simulação **DADO** parcela acima da máxima._
5. _**NAO DEVE** atualizar a simulação **DADO** parcela abaixo da miníma._
6. _**NAO DEVE** atualizar a simulação **DADO** valor acima do máximo._
7. _**NAO DEVE** atualizar a simulação **DADO** valor abaixo do minímo._
8. _**DEVE** atualizar a simulação **DADO** nome._
9. _**DEVE** atualizar a simulação **DADO** CPF._
10. _**DEVE** atualizar a simulação **DADO** e-mail._
11. _**DEVE** atualizar a simulação **DADO** valor._  
12. _**DEVE** atualizar a simulação **DADO** parcela._
13. _**DEVE** atualizar a simulação **DADO** seguro._  