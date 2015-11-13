/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package derivada;

import funcoes.Funcao;

/**
 *
 * @author 5663296
 */
public abstract class Derivada {
    protected Funcao funcao;

    public Derivada(Funcao funcao) {
        this.funcao = funcao;
    }
    
    public abstract Double calcular();
}
