/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolação;

import java.util.ArrayList;
import java.util.List;
import minimos_quadrados.Point;

/**
 *
 * @author Alisson
 */
public class EquationCalculator {
    public static List<Point> calcularFuncao(Double[] equacao,Double numeroInicial, Double numeroFinal,Double intervalo)
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
}
