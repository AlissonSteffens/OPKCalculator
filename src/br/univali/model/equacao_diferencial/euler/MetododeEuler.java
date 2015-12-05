/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.equacao_diferencial.euler;

import br.univali.model.funcoes.Funcao;
import br.univali.model.funcoes.Funcao_Euler;
import br.univali.model.minimos_quadrados.Point;
import java.util.List;

/**
 *
 * @author Alisson
 */
public abstract class MetododeEuler {
    protected Double y0;
    protected Funcao_Euler funcao;
    protected Double h;
    protected Double xInicial;
    protected Double xFinal;

    public MetododeEuler(Double y0, Funcao_Euler funcao, Double h, Double xInicial, Double xFinal) {
        this.y0 = y0;
        this.funcao = funcao;
        this.h = h;
        this.xInicial = xInicial;
        this.xFinal = xFinal;
    }
    
    public abstract List<Point> calcular();
    
}
