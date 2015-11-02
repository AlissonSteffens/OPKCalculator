package minimos_quadrados;

import gauss.Sistema;
import java.util.*;

public class MinimosQuadrados {
        
    private List<Point> points;
    private int grau;
    private Double[] as;
    private Double[] vectorY;
    List<Double[]> vectors;

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
        else if(tipoAproximacao.equals("Interpolação Polinomial"))
        {
            this.grau=points.size()-1;
            calcularInterpolacaoPolinomial();
        }
        else if(tipoAproximacao.equals("Interpolação SPline"))
        {
            this.grau=points.size()-1;
            calcularSPline();
            
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
        this.as[0]=Math.log(this.as[0]);
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
        Double[] h = new Double[this.grau-1];
        for (int j = 0; j < this.grau-1; j++) {
            h[j]=points.get(j+1).getX() - points.get(j).getX();
        }
        
        Double[] b = new Double[this.grau-2];
        for (int j = 0; j < this.grau-2; j++) {
            b[j]=(points.get(j+2).getY() - points.get(j+1).getY())/h[j+1] - (points.get(j+1).getY() - points.get(j).getY())/h[j];
        }
        Double[][] ampliedMatrix = new Double[this.grau-2][this.grau-1];
        
        for (int i = 0; i < this.grau-2; i++) {
            for (int j = 0; j < this.grau; j++) {
                ampliedMatrix[i][j]=0.0;
            }
        }
        
        for (int i = 0; i < this.grau-2; i++) {
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
        
        Sistema sistema = new Sistema(ampliedMatrix);
        this.as = sistema.getVetorSolucao();
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
