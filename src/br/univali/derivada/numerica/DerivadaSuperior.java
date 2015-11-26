/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.derivada.numerica;

import br.univali.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public class DerivadaSuperior extends DerivadaNumerica{

    public DerivadaSuperior(Double x, Double h, Funcao funcao) {
        super(x, h, funcao);
    }

    @Override
    public Double calcular() {
        return (funcao.calcular(x-h)-funcao.calcular(x))/(h);
    }
    
}
