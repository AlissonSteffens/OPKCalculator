/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolação;

import gauss.Sistema;
import java.util.List;
import minimos_quadrados.Point;

/**
 *
 * @author Alisson
 */
public class Interpolacao {
   private int grau;
   private List<Point> points;
   private Double[] as;

    public Interpolacao(List<Point> points, String tipoInterpolação) {
        this.points=points;
        
        if(tipoInterpolação.equals("Polinomial"))
        {
            this.grau=points.size()-1;
            calcularInterpolacaoPolinomial();
        }
        else if(tipoInterpolação.equals("SPline"))
        {
            this.grau=points.size()-1;
            calcularSPline();
        }
    }
     
    
    private void calcularInterpolacaoPolinomial()
    {
        Double[][] ampliedMatrix = new Double[this.grau+1][this.grau+2];
        for (int i = 0; i < this.grau+1; i++) {
            for (int j = 0; j < this.grau+1; j++) {
                ampliedMatrix[i][j]=Math.pow(points.get(i).getX(), j);
            }
        }
        for (int i = 0; i < this.grau+1; i++) {
            ampliedMatrix[i][this.grau+1]=points.get(i).getY();
        }
        Sistema sistema = new Sistema(ampliedMatrix);
        this.as = sistema.getVetorSolucao();
    }
    
    private void calcularSPline()
    {
        Double[] h = new Double[this.grau];
        for (int j = 0; j < this.grau; j++) {
            h[j]=points.get(j+1).getX() - points.get(j).getX();
        }
        
        Double[] b = new Double[this.grau-1];
        for (int j = 0; j < this.grau-1; j++) {
            b[j]=(points.get(j+2).getY() - points.get(j+1).getY())/h[j+1] - (points.get(j+1).getY() - points.get(j).getY())/h[j];
        }
        Double[][] ampliedMatrix = new Double[this.grau-1][this.grau];
        
        for (int i = 0; i < this.grau-1; i++) {
            for (int j = 0; j < this.grau; j++) {
                ampliedMatrix[i][j]=0.0;
            }
        }
        
        for (int i = 0; i < this.grau-1; i++) {
            if(i>0)
            {
             ampliedMatrix[i][i-1]=h[i];   
            }           
            ampliedMatrix[i][i]=2*(h[i]+h[i+1]);
            ampliedMatrix[i][i+1]=h[i+1];
            ampliedMatrix[i][this.grau-1]=b[i];
        }
        Sistema sistema = new Sistema(ampliedMatrix);
        this.as = sistema.getVetorSolucao();
    }
    
    public Double[] getList()
    {
        return as;
    }
}
