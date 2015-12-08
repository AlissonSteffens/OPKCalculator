/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.questoes;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.integral.numerica.IntegralNumerica;
import br.univali.model.infinitesimal.integral.numerica.simpson.IntegralNumericaSimpsonTreisOitavos;
import br.univali.model.infinitesimal.integral.numerica.simpson.IntegralNumericaSimpsonUmTerco;
import br.univali.model.infinitesimal.integral.numerica.trapezio.IntegralNumericaTrapezeio;
import br.univali.model.util.VerificadordeErro;

/**
 *
 * @author Adson Estevesa
 */
public class QuestoesIntegrais {
    private Double xInicial;
    private Double xFinal;
    private Double h;
    private Double resposta;
    private Funcao calculo;
    private Double erro;
    IntegralNumerica integral;

    public QuestoesIntegrais(Double xInicial, Double xFinal, Double h, String Tipo, String funcao, Double erro) {
        this.xInicial = xInicial;
        this.xFinal = xFinal;
        this.h = h;
        this.erro = erro;
        switch(funcao)
        {
            case "arcsen(3√x)":
                calculo = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.asin(Math.cbrt(x));
                        }
                    };
                break;
            case " cotan x + x^e ":
                calculo = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return 1/Math.tan(x) + Math.pow(x, Math.E);
                        }
                    };
                break;
            case "√PIx":
                calculo= new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.sqrt(x*Math.PI);
                        }
                    };
                break;
        }
        switch (Tipo) {
            case "Simpson 3/8":  integral = new IntegralNumericaSimpsonTreisOitavos(4, this.xInicial, this.xFinal, calculo);
                
            case "Simpson 1/3":  integral = new IntegralNumericaSimpsonUmTerco(3, this.xInicial, this.xFinal, calculo);
                
            default:             integral =  new IntegralNumericaTrapezeio(2, this.xInicial, this.xFinal, calculo);
        }
        calcular();
    }
    
    public void calcular()
    {
        Double valorAnterior;
        Double temp;
        
        valorAnterior = integral.calcular();
        temp = valorAnterior;
        do{
            valorAnterior=temp;
            pontos+=2;
            integral.setPontos(pontos);
            temp = integral.calcular();
        }while(!VerificadordeErro.verificarErro(valorAnterior, temp, this.erro));
        this.resposta=temp;
    }
}
