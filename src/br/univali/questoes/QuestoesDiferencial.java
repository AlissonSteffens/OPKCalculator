/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.questoes;

import br.univali.model.equacao_diferencial.euler.EquacaoDiferencialMetododeEuler;
import br.univali.model.equacao_diferencial.euler.EquacaoDiferencialMetododeEulerMelhorado;
import br.univali.model.equacao_diferencial.euler.EquacaoDiferencialMetododeEulerModificado;
import br.univali.model.equacao_diferencial.euler.MetododeEuler;
import br.univali.model.funcoes.Funcao_Euler;
import br.univali.model.minimos_quadrados.Point;
import java.util.List;

/**
 *
 * @author Adson Estevesa
 */
public class QuestoesDiferencial {

    public List<Point> getResposta() {
        return resposta;
    }
    private Double y0;
    private Funcao_Euler funcao;
    private Double h;
    private Double xInicial;
    private Double xFinal;
    private List<Point> resposta;
    private MetododeEuler metododeEuler;

    public QuestoesDiferencial(String funcao, String Tipo, Double y0, Double h, Double xInicial, Double xFinal) {
        this.y0 = y0;
        this.h = h;
        this.xInicial = xInicial;
        this.xFinal = xFinal;
        
        switch(funcao)
        {
            case "y-x" : 
                this.funcao = new Funcao_Euler() {
                    @Override
                    public Double calcular(Double x, Double y) {
                        return y-x;
                    }
                };
            
            case "2x^3-2xy" :
                this.funcao =  new Funcao_Euler() {
                    @Override
                    public Double calcular(Double x, Double y) {
                        return 2*Math.pow(x, 3) - 2*x*y;
                    }
                };
                
            case "y+x^(3/2)" :
                this.funcao =  new Funcao_Euler() {
                    @Override
                    public Double calcular(Double x, Double y) {
                        return y+Math.pow(x, 3/2);
                    }
                };
        }
        
        switch(Tipo)
        {
            case "Euler" :
                this.metododeEuler = new EquacaoDiferencialMetododeEuler(this.y0, this.funcao, this.h, this.xInicial, this.xFinal);
                break;
            
            case "Euler Modificado" : 
                this.metododeEuler =  new EquacaoDiferencialMetododeEulerModificado(this.y0, this.funcao, this.h, this.xInicial, this.xFinal);
                break;
            
            case "Euler Melhorado" :
                this.metododeEuler =  new EquacaoDiferencialMetododeEulerMelhorado(this.y0, this.funcao, this.h, this.xInicial, this.xFinal);
                break;
        }
        calcular();
    }

    public void calcular() {
       this.resposta = this.metododeEuler.calcular();
    }
    
    
}
