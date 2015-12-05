/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.infinitesimal.derivada.numerica;

import br.univali.model.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public class DerivadaInferior extends DerivadaNumerica{

    public DerivadaInferior(Double x, Double h, Funcao funcao) {
        super(x, h, funcao);
    }

    @Override
    public Double calcular() {
        return (funcao.calcular(x)-funcao.calcular(x-h))/(h);
    }
    
}
