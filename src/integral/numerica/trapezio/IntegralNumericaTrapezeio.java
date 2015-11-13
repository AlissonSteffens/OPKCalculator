/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral.numerica.trapezio;

import funcoes.Funcao;
import integral.numerica.IntegralNumerica;

/**
 *
 * @author 5663296
 */
public class IntegralNumericaTrapezeio extends IntegralNumerica{

    public IntegralNumericaTrapezeio(Double h, Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(h, pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        for(Double i=pontoInicial;i<=pontoFinal;i+=h){
            
        }
        return resposta;
    }
    
}
