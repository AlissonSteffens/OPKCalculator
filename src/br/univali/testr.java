/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.integral.numerica.IntegralNumerica;
import br.univali.model.infinitesimal.integral.numerica.simpson.IntegralNumericaSimpsonUmTerco;
import br.univali.model.util.VerificadordeErro;
 
/**
 *
 * @author Alisson
 */
public class testr {
    public static void main(String[] args) {
        
        Double valorAnterior;
        Double temp;
        int pontos = 3;
        IntegralNumerica integralNumerica =  new IntegralNumericaSimpsonUmTerco(pontos, 0.0, 1.0, new Funcao() {
            @Override
            public Double calcular(Double x) {
                return x*Math.exp(x);
            }
        });
        valorAnterior = integralNumerica.calcular();
        temp = valorAnterior;
        do{
            valorAnterior=temp;
            pontos+=2;
            integralNumerica.setPontos(pontos);
            temp = integralNumerica.calcular();
        }while(!VerificadordeErro.verificarErro(valorAnterior, temp, 0.0000000001));
        
        System.out.println(pontos);
        System.out.println(integralNumerica.calcular());
        
//        System.out.println("------------------------------");
//        integralNumerica.setPontos(10);
//        System.out.println(integralNumerica.calcular());
        
//        for (int i = 0; i < pontos.size(); i++) {
//            System.out.println("x= "+pontos.get(i).getX()+" y= "+ pontos.get(i).getY());
//        }
    }
}
