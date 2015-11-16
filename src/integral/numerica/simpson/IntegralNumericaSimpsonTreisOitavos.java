/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integral.numerica.simpson;

import funcoes.Funcao;
import integral.numerica.IntegralNumerica;
import java.util.Objects;

/**
 *
 * @author Alisson
 */
public class IntegralNumericaSimpsonTreisOitavos extends IntegralNumerica{

    public IntegralNumericaSimpsonTreisOitavos(Double h, Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(h, pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        for(Double i=pontoInicial;i<=pontoFinal;i+=h){
            if(Objects.equals(i, pontoInicial) || Objects.equals(i, pontoFinal)){
                resposta+=funcao.calcular(i);
            }
            else {
                resposta+=3*(funcao.calcular(i)+funcao.calcular(i+1));
                resposta+=2*funcao.calcular(i+2);
                i+=2;
            }
        }
        resposta= (resposta*h)/3;
        return resposta;
    }
    
}
