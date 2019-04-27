package operacao;

import dominio.Individuo;
import dominio.Populacao;
import ihm.Frame;
import java.util.ArrayList;
import java.util.Random;

public class Algoritimo {

    private static int N;
    private static double taxaDeCrossover;
    private static double taxaDeMutacao;
    private static int numeroMaximoGeracoes;
    private static int tamanhoPopulacao;
    private static boolean elitismo;

    public static void AG(Frame frame) {
        new Thread(new ExecutaAG(frame)).start();
    }

    public static Populacao novaGeracao(Populacao populacao) {

        Random r;
        Populacao novaPopulacao = new Populacao(populacao.getTamPopulacao(), false);

        if (isElitismo()) {
            novaPopulacao.setIndividuo(populacao.getIndivduo(0));
        }

        while (novaPopulacao.getNumIndividuos() < novaPopulacao.getTamPopulacao()) {

            Individuo pais[] = new Individuo[2];
            Individuo filhos[] = new Individuo[2];

            pais[0] = selecaoTorneio(populacao);
            pais[1] = selecaoTorneio(populacao);

            r = new Random();
            if (r.nextDouble() <= taxaDeCrossover) {
                filhos = Algoritimo.crossover(pais[0], pais[1]);
                filhos[0].geraAptidao();
                filhos[1].geraAptidao();
            } else {
                filhos[0] = pais[0];
                filhos[1] = pais[1];
            }

            novaPopulacao.setIndividuo(filhos[0]);
            novaPopulacao.setIndividuo(filhos[1]);

        }
        novaPopulacao.ordenaPopulacao();
        return novaPopulacao;
    }

    public static Individuo[] crossover(Individuo pai1, Individuo pai2) {
        Random r = new Random();
        Individuo filhos[] = new Individuo[2];

        filhos[0] = new Individuo(false);
        filhos[1] = new Individuo(false);

        int pontoCorte = r.nextInt(Algoritimo.N);

        for (int i = 0; i < Algoritimo.N; i++) {
            if (i < pontoCorte) {
                filhos[0].addRainha(i, pai1.getPosicoesY()[i]);
                filhos[1].addRainha(i, pai2.getPosicoesY()[i]);
            } else {
                filhos[0].addRainha(i, pai2.getPosicoesY()[i]);
                filhos[1].addRainha(i, pai1.getPosicoesY()[i]);
            }
        }

        filhos[0].geraAptidao();
        filhos[1].geraAptidao();

        return filhos;
    }

    public static Individuo selecaoTorneio(Populacao populacao) {
        Random r = new Random();
        Populacao populacaoIntermediaria = new Populacao(2, false);

        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));
        r = new Random();
        populacaoIntermediaria.setIndividuo(populacao.getIndivduo(r.nextInt(populacao.getTamPopulacao())));

        populacaoIntermediaria.ordenaPopulacao();

        int pos;

        r = new Random();
        if (r.nextDouble() < 0.9) {
            pos = 0;
        } else {
            pos = 1;
        }

        return populacaoIntermediaria.getIndivduo(pos);
    }

    public static Individuo[] selecaoRodaDaRoleta(Populacao populacao) {
        Individuo[] individuosEscolhidos = new Individuo[2];

        ArrayList<Double> individuosTemp = new ArrayList<Double>();

        double aptidaoAcumulada = 0;

        for (int i = 0; i < populacao.getNumIndividuos(); i++) {
            if (i == 0) {
                aptidaoAcumulada = populacao.getIndivduo(i).getAptidao();
            } else {
                aptidaoAcumulada += populacao.getIndivduo(i).getAptidao();
            }

            individuosTemp.add(i, aptidaoAcumulada);
        }

        Random r = new Random();
        double ponteiro = r.nextDouble() * aptidaoAcumulada;

        for (int i = 0; i < individuosTemp.size(); i++) {
            if (individuosTemp.get(i) > ponteiro) {
                individuosEscolhidos[0] = populacao.getIndivduo(i);
                break;
            }
        }

        r = new Random();
        ponteiro = r.nextDouble() * aptidaoAcumulada;

        for (int i = 0; i < individuosTemp.size(); i++) {
            if (individuosTemp.get(i) > ponteiro) {
                individuosEscolhidos[1] = populacao.getIndivduo(i);
                break;
            }
        }

        return individuosEscolhidos;
    }

    public static double getTaxaDeCrossover() {
        return taxaDeCrossover;
    }

    public static void setTaxaDeCrossover(double taxaDeCrossover) {
        Algoritimo.taxaDeCrossover = taxaDeCrossover;
    }

    public static double getTaxaDeMutacao() {
        return taxaDeMutacao;
    }

    public static void setTaxaDeMutacao(double taxaDeMutacao) {
        Algoritimo.taxaDeMutacao = taxaDeMutacao;
    }

    public static int getNumeroMaximoGeracoes() {
        return numeroMaximoGeracoes;
    }

    public static void setNumeroMaximoGeracoes(int numeroMaximoGeracoes) {
        Algoritimo.numeroMaximoGeracoes = numeroMaximoGeracoes;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int N) {
        Algoritimo.N = N;
    }

    public static int getTamanhoPopulacao() {
        return tamanhoPopulacao;
    }

    public static void setTamanhoPopulacao(int tamanhoPopulacao) {
        Algoritimo.tamanhoPopulacao = tamanhoPopulacao;
    }

    public static boolean isElitismo() {
        return elitismo;
    }

    public static void setElitismo(boolean elitismo) {
        Algoritimo.elitismo = elitismo;
    }

    private static class ExecutaAG implements Runnable {

        private Frame frame;

        public ExecutaAG(Frame frame) {
            this.frame = frame;
        }

        @Override
        public void run() {

            frame.setEstadoIniciarBotao(false);

            int geracao = 1;

            Populacao populacao = new Populacao(getTamanhoPopulacao(), true);
            populacao.ordenaPopulacao();
            frame.setLog("Geração " + geracao + ":\n"
                    + "Melhor: " + populacao.getIndivduo(0).getAptidao() + " (" + populacao.getIndivduo(0).getColisoes() + ")" + "\n"
                    + "Média: " + populacao.getMediaAptidao() + "\n"
                    + "Pior: " + populacao.getIndivduo(populacao.getNumIndividuos() - 1).getAptidao() + "(" + populacao.getIndivduo(populacao.getNumIndividuos() - 1).getColisoes() + ")" + "\n"
                    + "-------------------------------------");

            frame.getTabuleiroVisual().setTabuleiro(populacao.getIndivduo(0).getTabuleiro());

            while (geracao < getNumeroMaximoGeracoes()) {
                geracao++;

                populacao = Algoritimo.novaGeracao(populacao);

                frame.setLog("Geração " + geracao + ":\n"
                        + "Melhor: " + populacao.getIndivduo(0).getAptidao() + " (" + populacao.getIndivduo(0).getColisoes() + ")" + "\n"
                        + "Média: " + populacao.getMediaAptidao() + "\n"
                        + "Pior: " + populacao.getIndivduo(populacao.getNumIndividuos() - 1).getAptidao() + "(" + populacao.getIndivduo(populacao.getNumIndividuos() - 1).getColisoes() + ")" + "\n"
                        + "-------------------------------------");


                if (geracao % (getNumeroMaximoGeracoes() / 1000) == 0) {
                    frame.getChart().update(geracao, populacao.getIndivduo(0).getAptidao(), populacao.getMediaAptidao(), populacao.getIndivduo(populacao.getNumIndividuos() - 1).getAptidao());
                }


                if (populacao.getIndivduo(0).getColisoes() == 0) {
                    frame.setLog("SOLUÇÃO ENCONTRADA!");
                    frame.getChart().update(geracao, populacao.getIndivduo(0).getAptidao(), populacao.getMediaAptidao(), populacao.getIndivduo(populacao.getNumIndividuos() - 1).getAptidao());
                    break;
                }

            }
            frame.getTabuleiroVisual().setTabuleiro(populacao.getIndivduo(0).getTabuleiro());

            frame.setEstadoIniciarBotao(true);

        }
    }
}