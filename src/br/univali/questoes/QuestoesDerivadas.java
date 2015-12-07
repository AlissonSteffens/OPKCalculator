/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.questoes;

import br.univali.model.funcoes.Funcao;
import br.univali.model.infinitesimal.derivada.Derivada;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaCentrada;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaInferior;
import br.univali.model.infinitesimal.derivada.numerica.DerivadaSuperior;

/**
 *
 * @author Adson Estevesa
 */
public class QuestoesDerivadas {
    private Double x;
    private Double h;
    private Funcao calculo;
    private String funcao;
    private Double resposta;
    

    public QuestoesDerivadas(String funcao, String Tipo, Double x, Double h) {
        this.x = x;
        this.h = h;        
        switch(funcao)
        {
            case "sen(lnx)":
                calculo = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.cbrt(Math.exp(1/Math.cos(x)));
                        }
                    };
                break;
            case "tan(x).cos(x)":
                calculo = new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.tan(x)*Math.cos(x);
                        }
                    };
                break;
            case " 3√e^secx ":
                calculo= new Funcao() {
                        @Override
                        public Double calcular(Double x) {
                            return Math.sin(Math.log(x));
                        }
                    };
                break;
        }
        switch (Tipo) {
            case "Centrada":
                calcularCentrada();
                break;
            case "Inferior":
                calcularInferior();
                break;
            default:
                calcularSuperior();
                break;
        }
        
    }

    public Double getResposta() {
        return resposta;
    }
    public void calcularInferior()
    {
        Derivada derivadaI = new DerivadaInferior(this.x, this.h, calculo);
        this.resposta = derivadaI.calcular();
    }
    public void calcularSuperior()
    {
        Derivada derivadaS = new DerivadaSuperior(this.x, this.h, calculo);
         this.resposta = derivadaS.calcular();
    }
    public void calcularCentrada()
    {
        Derivada derivadaC =  new DerivadaCentrada(this.x, this.h, calculo);
         this.resposta = derivadaC.calcular();
    }
    
}
