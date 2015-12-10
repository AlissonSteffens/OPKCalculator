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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adson Estevesa
 */
public class QuestoesIntegrais {
    private Double xInicial;
    private Double xFinal;
    private List<Double> resposta;
    private Funcao funcao;
    private Double erro;
    private int pontos;
    private int incremento;
    IntegralNumerica integral;

    public QuestoesIntegrais(Double xInicial, Double xFinal, String Tipo, String funcao, Double erro) {
        this.xInicial = xInicial;
        this.xFinal = xFinal;
        this.erro = erro;
        switch(funcao)
        {
            case "arcsen(3√x)":
                this.funcao = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.asin(Math.cbrt(x));
                        }
                    };
                break;
            case "cotan(x)+x^e":
                this.funcao = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return 1/Math.tan(x) + Math.pow(x, Math.E);
                        }
                    };
                break;
            case "√PIx":
                this.funcao= new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.sqrt(x*Math.PI);
                        }
                    };
                break;
        }
        switch (Tipo) {
            case "Simpson 3/8":
                pontos=4;
                integral = new IntegralNumericaSimpsonTreisOitavos(pontos, this.xInicial, this.xFinal, this.funcao);
                incremento=3;
                break;
                
            case "Simpson 1/3":
                pontos=3;
                integral = new IntegralNumericaSimpsonUmTerco(pontos, this.xInicial, this.xFinal, this.funcao);
                incremento = 2;
                break;
                
            case "Trapézio":
                pontos=2;
                integral =  new IntegralNumericaTrapezeio(pontos, this.xInicial, this.xFinal, this.funcao);
                incremento = 1;
                break;
        }
        this.resposta=new ArrayList<>();
        calcular();
    }
    
    public void calcular()
    {
        Double valorAnterior;
        Double temp;
        
        valorAnterior = integral.calcular();
        resposta.add(valorAnterior);
        temp = valorAnterior;
        do{
            valorAnterior=temp;
            pontos+=incremento;
            integral.setPontos(pontos);
            temp = integral.calcular();
            resposta.add(temp);
        }while(!VerificadordeErro.verificarErro(valorAnterior, temp, this.erro));

    }

    public List<Double> getResposta() {
        return resposta;
    }
}
