package dominio;

import java.util.Random;
import operacao.Algoritimo;

/**
 * Classe que define um indivíduo
 *
 * @author pcollares
 */
public class Individuo {

    private double gene[] = new double[Algoritimo.N];
    private double aptidao;
    private int geracao;

    public Individuo(double[] gene) {
        this.gene = gene;
        aptidao = Algoritimo.getFuncao().resolve(gene);
    }

    public Individuo() {

        for (int i = 0; i < gene.length; i++) {
            double g = geneAleatorio();
            this.gene[i] = g;
        }
        aptidao = Algoritimo.getFuncao().resolve(gene);
    }

    public void aplicaMutacao(double aptidaoMedia) {
        Random r = new Random();
        double taxaMutacao = Algoritimo.getTaxaDeMutacao();

        //Melhores indivíduos tem menos chances de sofrerem mutação
        if (aptidao < aptidaoMedia) {
            taxaMutacao = taxaMutacao / 10;
        }

        if (r.nextDouble() <= taxaMutacao) {
            r = new Random();
            this.gene[r.nextInt(gene.length)] = geneAleatorio();
            aptidao = Algoritimo.getFuncao().resolve(gene);
        }
    }

    public double[] getGene() {
        return gene;
    }

    public double getAptidao() {
        return aptidao;
    }

    private double geneAleatorio() {
        Random r = new Random();
        double v = r.nextDouble();
        double diff = Algoritimo.getFuncao().getMax() - Algoritimo.getFuncao().getMin();
        double valor = Algoritimo.getFuncao().getMin() + v * diff;
        return valor;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (int i = 0; i < gene.length; i++) {
            s += gene[i] + " ";
        }
        s += " ]";
        return s;
    }
}