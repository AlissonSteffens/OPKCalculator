/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.equacao_diferencial.euler;

import br.univali.model.funcoes.Funcao_Euler;
import br.univali.model.minimos_quadrados.Point;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adson Estevesa
 */
public class EquacaoDiferencialMetododeEulerMelhorado extends MetododeEuler{

    public EquacaoDiferencialMetododeEulerMelhorado(Double y0, Funcao_Euler funcao, Double h, Double xInicial, Double xFinal) {
        super(y0, funcao, h, xInicial, xFinal);
    }

    @Override
    public List<Point> calcular() {
        List<Point> points = new ArrayList<>();;
        points.add(new Point(xInicial, y0));
        int j=0;
        for(Double i=xInicial+h;i<=xFinal;i+=h){
            i= new BigDecimal(i).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            Double K1 = funcao.calcular(i-h, points.get(j).getY());
            Double K2 = funcao.calcular(i, points.get(j).getY()+(h*K1));
            Double y=points.get(j).getY()+(h*(K1+K2)/2);
            System.out.println(i);
            points.add(new Point(i, y));
            j++;
        }
        return points;
    }
    
}
