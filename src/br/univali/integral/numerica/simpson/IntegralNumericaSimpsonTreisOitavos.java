/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.integral.numerica.simpson;

import br.univali.funcoes.Funcao;
import br.univali.integral.numerica.IntegralNumerica;
import java.util.Objects;

/**
 *
 * @author Alisson
 */
public class IntegralNumericaSimpsonTreisOitavos extends IntegralNumerica{

    public IntegralNumericaSimpsonTreisOitavos(Integer pontos, Double pontoInicial, Double pontoFinal, Funcao funcao) {
        super(pontos, pontoInicial, pontoFinal, funcao);
    }

    @Override
    public Double calcular() {
        Double resposta=0.0;
        int j=0;
        for(Double i=pontoInicial;i<=pontoFinal;i+=h){
            if(Objects.equals(i, pontoInicial) || Objects.equals(i, pontoFinal)){
                resposta+=funcao.calcular(i);
            }else if(j%2==0){
                resposta+=2*funcao.calcular(i+2*h);
            }else{
                resposta+=3*(funcao.calcular(i)+funcao.calcular(i+h));
                i+=h;
            }
            j++;
        }
        resposta= 3*(resposta*h)/8;
        return resposta;
    }
    
}
