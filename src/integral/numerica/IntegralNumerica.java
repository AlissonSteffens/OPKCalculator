/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral.numerica;

import funcoes.Funcao;
import integral.Integral;

/**
 *
 * @author 5663296
 */
public abstract class IntegralNumerica extends Integral{
    protected Double h;
    protected Integer pontos;
    protected Double pontoInicial;
    protected Double pontoFinal;

    public IntegralNumerica(Double h, Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(funcao);
        this.h = h;
        this.pontos = pontos;
        this.pontoInicial = pontoInicial;
        this.pontoFinal = pontoFinal;
    }
    
}
