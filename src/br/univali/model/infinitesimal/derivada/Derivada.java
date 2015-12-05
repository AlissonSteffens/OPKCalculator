/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.infinitesimal.derivada;

import br.univali.model.infinitesimal.Calculable;
import br.univali.model.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public abstract class Derivada implements Calculable{
    protected Funcao funcao;
    public Derivada(Funcao funcao) {
        this.funcao = funcao;
    }
}
