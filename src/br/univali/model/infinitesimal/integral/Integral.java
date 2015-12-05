/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.infinitesimal.integral;

import br.univali.model.infinitesimal.Calculable;
import br.univali.model.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public abstract class Integral implements Calculable{
    protected Funcao funcao;

    public Integral(Funcao funcao) {
        this.funcao = funcao;
    }
}
