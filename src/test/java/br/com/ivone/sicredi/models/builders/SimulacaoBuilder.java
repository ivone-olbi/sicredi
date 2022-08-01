package br.com.ivone.sicredi.models.builders;

import static br.com.ivone.sicredi.config.Propriedades.propriedade;
import static java.lang.Integer.parseInt;

import java.math.BigDecimal;

import br.com.ivone.sicredi.models.Simulacao;

/**
 * <p>Fabrica de simulacoes.</p>
 */
public class SimulacaoBuilder {

    public static br.com.ivone.sicredi.models.Simulacao.SimulacaoBuilder criarSimulacao() {
        return Simulacao.builder().nome(propriedade("nome"))
                                  .cpf(propriedade("cpf"))
                                  .email(propriedade("email"))
                                  .valor(new BigDecimal(propriedade("valor_maximo")))
                                  .parcelas(parseInt(propriedade("parcela_maxima")))
                                  .seguro(true);
    }

}