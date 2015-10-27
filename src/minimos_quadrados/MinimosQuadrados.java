package minimos_quadrados;



import java.util.*;
import java.util.Map.Entry;


public class MinimosQuadrados {
        
    private double somaX = 0;
    private double somaY = 0;
    private double somaXY = 0;
    private double somaX2 = 0;
    private double somaY2 = 0;
    private double m;
    
    public String calculaMinQuadrado(Map<Double, Double> xyMap) {
            m = (double)xyMap.size();

            // Somatorias
            for (Entry<Double, Double> entry : xyMap.entrySet()) {
                    double x = entry.getKey().doubleValue();
                    double y = entry.getValue().doubleValue();
                    somaX += x;
                    somaY += y;
                    somaXY += (x * y);
                    somaX2 += (x * x);
                    somaY2 += (y * y);
            }
            double a = (somaX * somaXY - somaX2 * somaY) / (somaX * somaX - m * somaX2);
            double b = (somaX * somaY - m * somaXY) / (somaX * somaX - m * somaX2);
            
            String resposta = "";
            resposta+="Soma_X = "+somaX;
            resposta+="\nSoma_Y = "+somaY;
            resposta+="\nSoma_X2 = "+somaX2;
            resposta+="\nSoma_Y2 = "+somaY2;
            resposta+="\nSoma_XY = "+somaXY;
            resposta+="\nA = "+a;
            resposta+="\nB = "+b;
            resposta+="\nEquação = "+b+"x + "+a;
            
            return resposta;
    }
}
