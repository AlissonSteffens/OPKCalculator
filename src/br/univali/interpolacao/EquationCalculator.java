/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.interpolacao;

import java.util.ArrayList;
import java.util.List;
import br.univali.minimos_quadrados.Point;

/**
 *
 * @author Alisson
 */
public class EquationCalculator {
    public static List<Point> calcularFuncao(Double[] equacao,Double numeroInicial, Double numeroFinal,Double intervalo, String tipo)
    {
        if(tipo.equals("Polinomial")){
            return calcularFuncaoPolinomial(equacao, numeroInicial, numeroFinal, intervalo);
        }else if(tipo.equals("Geométrica")){
            return calcularFuncaoGeometrica(equacao, numeroInicial, numeroFinal, intervalo);
        }else{
            return calcularFuncaoAeBX(equacao, numeroInicial, numeroFinal, intervalo);
        }
    }
    private static List<Point> calcularFuncaoPolinomial(Double[] equacao,Double numeroInicial, Double numeroFinal,Double intervalo)
    {
        List<Point> resposta = new ArrayList<>();
        for(Double x=numeroInicial; x<=numeroFinal ;x+=intervalo)
        {
            Double xPonto=x;
            Double yPonto=0.0;
            for(int i=equacao.length-1; i>=0;i--){
                yPonto+=equacao[i]*Math.pow(x,i);
            }
            resposta.add(new Point(xPonto, yPonto));
        }
        return resposta;
    }
    private static List<Point> calcularFuncaoGeometrica(Double[] equacao,Double numeroInicial, Double numeroFinal,Double intervalo)
    {
        List<Point> resposta = new ArrayList<>();
        for(Double x=numeroInicial; x<=numeroFinal ;x+=intervalo)
        {
            Double xPonto=x;
            Double yPonto=0.0;
            yPonto+=equacao[0]*Math.pow(x, equacao[1]);
            resposta.add(new Point(xPonto, yPonto));
        }
        return resposta;
    }
    private static List<Point> calcularFuncaoAeBX(Double[] equacao,Double numeroInicial, Double numeroFinal,Double intervalo)
    {
        List<Point> resposta = new ArrayList<>();
        for(Double x=numeroInicial; x<=numeroFinal ;x+=intervalo)
        {
            Double xPonto=x;
            Double yPonto=0.0;
            yPonto+=equacao[1]*Math.exp(x*equacao[0]);
            resposta.add(new Point(xPonto, yPonto));
        }
        return resposta;
    }
}
