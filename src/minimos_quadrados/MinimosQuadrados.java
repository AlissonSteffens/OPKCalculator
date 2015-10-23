/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimos_quadrados;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 5663296
 */
public class MinimosQuadrados {
    
    private MinimosQuadrados(int grau, double[][] matrix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static String calcular(String in) {
            Scanner sc = new Scanner(in);
            try{
                int grau = sc.nextInt();
                int numberOfPoints = sc.nextInt();
                double matrix[][] = new double[2][numberOfPoints+1];
                
                for (int i = 0; i <= 2; i++){
                    for (int j = 0; j < numberOfPoints; j++) {
                        matrix[i][j] = sc.nextDouble();
                    }
                }
                MinimosQuadrados m=new MinimosQuadrados(grau, matrix);
                return m.toString();
            } catch (InputMismatchException ex) {
                    String msg = "Você digitou um caractere errado\nTente de novo.";
                    return msg;
            }
	}
}
