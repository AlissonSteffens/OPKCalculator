/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.questoes;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaCentrada;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaInferior;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaNumerica;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaSuperior;
import br.univali.model.util.VerificadordeErro;

/**
 *
 * @author Adson Estevesa
 */
public class QuestoesDerivadas {
    private Double x;
    private Double h;
    private Funcao funcao;
    private Double resposta;
    private int incremento;
    private Double erro;
    DerivadaNumerica derivada;
    

    public QuestoesDerivadas(String funcao, String Tipo, int incremento,  Double x, Double h, Double erro) {
        this.x = x;
        this.h = h;  
        this.erro = erro;
        this.incremento = incremento;
        switch(funcao)
        {
            case "sen(lnx)":
                this.funcao = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.cbrt(Math.exp(1/Math.cos(x)));
                        }
                    };
                break;
            case "tan(x).cos(x)":
                this.funcao = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.tan(x)*Math.cos(x);
                        }
                    };
                break;
            case "3√e^secx":
                this.funcao= new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.sin(Math.log(x));
                        }
                    };
                break;
        }
        switch (Tipo) {
            case "Centrada":  derivada = new DerivadaCentrada(this.x, this.h, this.funcao);
                
            case "Inferior":  derivada = new DerivadaInferior(this.x, this.h, this.funcao);
                
            default:          derivada = new DerivadaSuperior(this.x, this.h, this.funcao);
        }
        calcular();
    }

    public Double getResposta() {
        return resposta;
    }
    public void calcular()
    {
        Double valorAnterior;
        Double temp;
        valorAnterior = derivada.calcular();
        temp = valorAnterior;
        do{
            valorAnterior=temp;
            h=h/incremento;
            derivada.setH(h);
            temp = derivada.calcular();
        }while(!VerificadordeErro.verificarErro(valorAnterior, temp, this.erro));
        this.resposta=temp;
    }
    
}
