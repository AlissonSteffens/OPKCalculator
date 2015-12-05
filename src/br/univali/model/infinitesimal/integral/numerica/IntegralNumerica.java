/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.infinitesimal.integral.numerica;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.integral.Integral;

/**
 *
 * @author 5663296
 */
public abstract class IntegralNumerica extends Integral{
    protected Double h;
    protected Integer pontos;
    protected Double pontoInicial;
    protected Double pontoFinal;

    public IntegralNumerica(Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(funcao);
        this.pontos = pontos;
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
        this.h = (pontoFinal-pontoInicial)/(pontos-1);
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
        this.h = (pontoFinal-pontoInicial)/(pontos-1);
    }
    
    
}
