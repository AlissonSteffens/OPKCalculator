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
import br.univali.minimos_quadrados.Point;
import java.util.List;

/**
 *
 * @author Alisson
 */
public class testr {
    public static void main(String[] args) {
        MetododeEuler metododeEuler = new EquacaoDiferencialMetododeEulerMelhorado( 2.0, new Funcao_Euler() {

            @Override
            public Double calcular(Double x, Double y) {
                return -y+x+2;
            }
        }, 0.1, 0.0, 0.4);
        List<Point> pontos = metododeEuler.calcular();
        for (int i = 0; i < pontos.size(); i++) {
            System.out.println("x= "+pontos.get(i).getX()+" y= "+ pontos.get(i).getY());
        }
    }
}
