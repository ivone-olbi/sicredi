package br.com.ivone.sicredi.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class Simulacao {

    private String id;

    private String nome, cpf, email;

    private BigDecimal valor;

    private int parcelas;

    private boolean seguro;

}