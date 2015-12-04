/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali;

import br.univali.equacao_diferencial.euler.EquacaoDiferencialMetododeEuler;
import br.univali.equacao_diferencial.euler.EquacaoDiferencialMetododeEulerMelhorado;
import br.univali.equacao_diferencial.euler.EquacaoDiferencialMetododeEulerModificado;
import br.univali.equacao_diferencial.euler.MetododeEuler;
import br.univali.funcoes.Funcao;
import br.univali.funcoes.Funcao_Euler;
import br.univali.integral.numerica.IntegralNumerica;
import br.univali.integral.numerica.simpson.IntegralNumericaSimpsonTreisOitavos;
import br.univali.minimos_quadrados.Point;
import java.util.List;

/**
 *
 * @author Alisson
 */
public class testr {
    public static void main(String[] args) {
        IntegralNumerica integralNumerica =  new IntegralNumericaSimpsonTreisOitavos(7, 0.0, 1.0, new Funcao() {

            @Override
            public Double calcular(Double x) {
                return x*Math.exp(x);
            }
        });
        System.out.println(integralNumerica.calcular());
//        for (int i = 0; i < pontos.size(); i++) {
//            System.out.println("x= "+pontos.get(i).getX()+" y= "+ pontos.get(i).getY());
//        }
    }
}
