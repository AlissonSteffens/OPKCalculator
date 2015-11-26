/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali;

import br.univali.equacao_diferencial.euler.EquacaoDiferencialMetododeEuler;
import br.univali.equacao_diferencial.euler.MetododeEuler;
import br.univali.funcoes.Funcao;

/**
 *
 * @author Alisson
 */
public class testr {
    public static void main(String[] args) {
        MetododeEuler metododeEuler = new EquacaoDiferencialMetododeEuler(2, new Funcao() {

            @Override
            public Double calcular(Double x) {
                return 
            }
        }, Double.NaN, Double.NaN, Double.NaN)
    }
}
