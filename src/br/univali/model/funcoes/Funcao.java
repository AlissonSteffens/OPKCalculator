/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.funcoes;

import br.univali.model.infinitesimal.derivada.Derivada;

/**
 *
 * @author 5663296
 */
public abstract class Funcao {
    Derivada derivada;
    
    
    public abstract Double calcular(Double x);
}
