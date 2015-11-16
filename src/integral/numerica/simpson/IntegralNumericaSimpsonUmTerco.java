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
public class IntegralNumericaSimpsonUmTerco extends IntegralNumerica{

    public IntegralNumericaSimpsonUmTerco(Double h, Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(h, pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        for(Double i=pontoInicial;i<=pontoFinal;i+=h){
            if(Objects.equals(i, pontoInicial) || Objects.equals(i, pontoFinal)){
                resposta+=funcao.calcular(i);
            }
            else if(i%2==0){
                resposta+=4*funcao.calcular(i);
            }
            else{
                resposta+=2*funcao.calcular(i);
            }
        }
        resposta= (resposta*h)/3;
        return resposta;
    }
    
}
