/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.derivada.numerica;

import br.univali.derivada.Derivada;
import br.univali.funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public abstract class DerivadaNumerica extends Derivada{
    Double x;
    Double h;

    public DerivadaNumerica(Double x, Double h, Funcao funcao) {
        super(funcao);
        this.x = x;
        this.h = h;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }
}
