package dominio;

import java.util.Random;

/**
 * Classe que define as funções usadas no AG
 *
 * @author pcollares
 */
public class Funcoes {

    private int numFuncao;
    private int maximoGeracoes;
    private double min;
    private double max;
    private int incremento;
    private double incrementoGrafico;
    private double minimoDaFuncao;

    public Funcoes(int numFuncao, double min, double max, int maximoGeracoes) {
        this.numFuncao = numFuncao;
        this.min = min;
        this.max = max;

        this.setMaximoGeracoes(maximoGeracoes);

        if (numFuncao == 8) {
            minimoDaFuncao = -12569.5;
        } else {
            minimoDaFuncao = 0;
        }

        incrementoGrafico = (Math.abs(min) + max) / 30;

    }

    public double resolve(double x[]) {
        double resultado = 0;
        switch (numFuncao) {
            case 1:
                resultado = f1(x);
                break;
            case 2:
                resultado = f2(x);
                break;
            case 3:
                resultado = f3(x);
                break;
            case 4:
                resultado = f4(x);
                break;
            case 5:
                resultado = f5(x);
                break;
            case 6:
                resultado = f6(x);
                break;
            case 7:
                resultado = f7(x);
                break;
            case 8:
                resultado = f8(x);
                break;
            case 9:
                resultado = f9(x);
                break;
            case 10:
                resultado = f10(x);
                break;
            case 11:
                resultado = f11(x);
                break;
        }
        return resultado;
    }

    private double f1(double x[]) {
        double resultado = 0;

        for (int i = 0; i < x.length; i++) {
            resultado += Math.pow(x[i], 2);
        }

        return resultado;
    }

    private double f2(double x[]) {
        double somatorio = 0;
        double produtorio = 0;
        double resultado = 0;

        for (int i = 0; i < x.length; i++) {
            somatorio += Math.abs(x[i]);
        }
        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                produtorio = Math.abs(x[i]);
            } else {
                produtorio *= Math.abs(x[i]);
            }
        }
        resultado = somatorio + produtorio;

        return resultado;
    }

    private double f3(double x[]) {
        double somatorio1 = 0;

        for (int i = 0; i < x.length; i++) {
            double somatorio2 = 0;
            for (int j = 0; j < i; j++) {
                somatorio2 += x[i];
            }
            somatorio1 += Math.pow(somatorio2, 2);
        }

        return somatorio1;
    }

    private double f4(double x[]) {

        for (int i = 0; i < x.length; i++) {
            x[i] = Math.abs(x[i]);
        }

        double maximo = x[0];

        for (int i = 0; i < x.length; i++) {
            if (x[i] > maximo) {
                maximo = x[i];
            }
        }

        return maximo;
    }

    private double f5(double x[]) {
        double resultado = 0;

        for (int i = 0; i < x.length - 1; i++) {
            resultado += 100 * Math.pow((x[i + 1] - Math.pow(x[i], 2)), 2) + (Math.pow(x[i] - 1, 2));
        }

        return resultado;
    }

    private double f6(double x[]) {
        double resultado = 0;

        for (int i = 0; i < x.length; i++) {
            resultado += Math.pow(x[i] + 0.5, 2);
        }

        return resultado;
    }

    private double f7(double x[]) {
        double resultado = 0;

        Random r = new Random();

        for (int i = 0; i < x.length; i++) {
            resultado += (i + 1) * Math.pow(x[i], 4) + r.nextDouble();
        }

        return resultado;
    }

    private double f8(double x[]) {
        double resultado = 0;

        for (int i = 0; i < x.length; i++) {
            resultado += (x[i] * -1) * Math.sin(Math.sqrt(Math.abs(x[i])));
        }

        return resultado;
    }

    private double f9(double x[]) {
        double resultado = 0;

        for (int i = 0; i < x.length; i++) {
            resultado += Math.pow(x[i], 2) - 10 * Math.cos(2 * Math.PI * x[i]) + 10;
        }

        return resultado;
    }

    private double f10(double x[]) {
        double sum1 = 0.0;
        double sum2 = 0.0;

        for (int i = 0; i < x.length; i++) {
            sum1 += (x[i] * x[i]);
            sum2 += (Math.cos(2 * Math.PI * x[i]));
        }

        return (-20.0 * Math.exp(-0.2 * Math.sqrt(sum1 / ((double) x.length)))
                - Math.exp(sum2 / ((double) x.length)) + 20.0 + Math.E);
    }

    private double f11(double x[]) {
        double resultado;
        double somatorio = 0;
        double produtorio = 0;

        for (int i = 0; i < x.length; i++) {
            somatorio += Math.pow(x[i], 2);
        }

        for (int i = 0; i < x.length; i++) {
            if (i == 0) {
                produtorio = Math.cos(x[i] / Math.sqrt(i + 1));
            } else {
                produtorio = produtorio * (Math.cos(x[i] / Math.sqrt(i + 1)));
            }
        }

        resultado = (((1 / 4000) * somatorio) - produtorio) + 1;

        return resultado;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public int getIncremento() {
        return incremento;
    }

    public int getMaximoGeracoes() {
        return maximoGeracoes;
    }

    public void setMaximoGeracoes(int maximoGeracoes) {
        this.maximoGeracoes = maximoGeracoes;
        incremento = maximoGeracoes / 20;
    }

    public double getMinimoDaFuncao() {
        return minimoDaFuncao;
    }

    public double getIncrementoGrafico() {
        return incrementoGrafico;
    }

    public int getNumFuncao() {
        return numFuncao;
    }

    @Override
    public String toString() {
        return "F" + numFuncao + "(x) :: [" + min + "," + max + "] :: fmin=" + minimoDaFuncao;
    }
}
