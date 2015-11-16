/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral.numerica.trapezio;

import funcoes.Funcao;
import integral.numerica.IntegralNumerica;
import java.util.Objects;

/**
 *
 * @author 5663296
 */
public class IntegralNumericaTrapezeio extends IntegralNumerica{

    public IntegralNumericaTrapezeio(Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        for(Double i=pontoInicial;i<=pontoFinal;i+=h){
            if(Objects.equals(i, pontoInicial) || Objects.equals(i, pontoFinal)){
                resposta+=funcao.calcular(i);
            }
            else{
                resposta+=2*funcao.calcular(i);
            }
        }
        resposta= (resposta*h)/2;
        return resposta;
    }
    
}
