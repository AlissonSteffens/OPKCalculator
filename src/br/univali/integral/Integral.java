/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.integral;

import br.univali.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public abstract class Integral {
    protected Funcao funcao;

    public Integral(Funcao funcao) {
        this.funcao = funcao;
    }
    
    public abstract Double calcular();
}
