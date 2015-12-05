/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.model.util;

/**
 *
 * @author Alisson
 */
public class VerificadordeErro {
    private static Double calcularErro(Double xk, Double xkk){
//        System.out.println(Math.abs((xkk-xk)/xkk));
        return Math.abs((xkk-xk)/xkk);
    }
    
    public static Boolean verificarErro(Double xk, Double xkk, Double erro){
        return calcularErro(xk, xkk)<=erro;
    }
}
