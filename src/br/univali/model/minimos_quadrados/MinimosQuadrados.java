package br.univali.model.minimos_quadrados;

import br.univali.model.gauss.Sistema;
import java.util.*;

public class MinimosQuadrados {
        
    private List<Point> points;
    private int grau;
    private Double[] as;
    private Double[] vectorY;
    List<Double[]> vectors;
    private Double[][]matrizInicial;
   private Double[][]matrizEscalonada;

    public Double[][] getMatrizInicial() {
        return matrizInicial;
    }

    public Double[][] getMatrizEscalonada() {
        return matrizEscalonada;
    }
   
    public MinimosQuadrados(List<Point> points, int grau, String tipoAproximacao) {
        this.points = points;
        this.grau=grau;
        this.vectors = new ArrayList<>();
        if(tipoAproximacao.equals("Polinomial"))
        {
           calcularPolinomial(); 
        }
        else if(tipoAproximacao.equals("Geométrica"))
        {
            calcularGeometrica();
        }
        else if(tipoAproximacao.equals("ae^bx"))
        {
            calcular_aebx();
        }
    }

    private void calcularPolinomial()
    {
        for (int i = 0; i < this.grau+1; i++) {
            Double[] ui = new Double[points.size()];
            for (int j = 0; j < points.size(); j++) {
                ui[j]=Math.pow(points.get(j).getX(),i);
            }
            vectors.add(ui);
        }
        this.vectorY = new Double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            vectorY[i]=points.get(i).getY();
        }
        calcular();
    }
    
    private void calcularGeometrica()
    {
        Double[] u0 = new Double[points.size()];
        for (int j = 0; j < points.size(); j++) {
            u0[j]=1.0;
        }
        vectors.add(u0);
        for (int i = 1; i < this.grau+1; i++) {
            Double[] ui = new Double[points.size()];
            for (int j = 0; j < points.size(); j++) {
                ui[j]=Math.log(points.get(j).getX());
            }
            vectors.add(ui);
        }
        this.vectorY = new Double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            vectorY[i]=Math.log(points.get(i).getY());
        }
        calcular();
        this.as[0]=Math.exp(this.as[0]);
    }
    
    private void calcular_aebx()
    {
        Double[] u0 = new Double[points.size()];
        for (int j = 0; j < points.size(); j++) {
            u0[j]=1.0;
        }
        vectors.add(u0);
        for (int i = 1; i < this.grau+1; i++) {
            Double[] ui = new Double[points.size()];
            for (int j = 0; j < points.size(); j++) {
                ui[j]=points.get(j).getX();
            }
            vectors.add(ui);
        }
        this.vectorY = new Double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            vectorY[i]=Math.log(points.get(i).getY());
        }
        calcular();
        this.as[0]=Math.log(this.as[0]);
    }
    
    private void calcular() {
        
        Double[][] ampliedMatrix = new Double[this.grau+1][this.grau+2];
        
        for (int i = 0; i < this.grau+1; i++) {
            for (int j = 0; j < this.grau+1; j++) {
                ampliedMatrix[i][j]=addVectors(vectors.get(i), vectors.get(j));
            }
        }
        for (int i = 0; i < this.grau+1; i++) {
            ampliedMatrix[i][this.grau+1]=addVectors(vectors.get(i), vectorY);
        }
        this.matrizInicial = new Double[ampliedMatrix.length][ampliedMatrix[0].length];
        for(int i=0; i<ampliedMatrix.length;i++){
            for (int j = 0; j < ampliedMatrix[0].length; j++) {
                this.matrizInicial[i][j]=ampliedMatrix[i][j];
            }
        }
        Sistema sistema = new Sistema(ampliedMatrix);
        this.as = sistema.getVetorSolucao();
        this.matrizEscalonada = sistema.getMatriz();
    }
    
    private Double addVectors(Double[] vectA, Double[] vectB){
        Double sum=0.0;
        for (int i = 0; i < vectA.length; i++) {
            sum+=vectA[i]*vectB[i];
        }
        return sum;
    }
    
    public Double[] getList()
    {
        return as;
    }
}
