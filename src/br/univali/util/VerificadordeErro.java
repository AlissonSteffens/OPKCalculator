/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.util;

/**
 *
 * @author Alisson
 */
public class VerificadordeErro {
    private static Double calcularErro(Double xk, Double xkk){
        return (xkk-xk)/xkk;
    }
    
    public static Boolean verificarErro(Double xk, Double xkk, Double erro){
        if(calcularErro(xk, xkk)<=erro){
            return true;
        }
        return false;
    }
}
