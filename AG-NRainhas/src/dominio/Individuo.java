package dominio;

import java.util.Random;
import operacao.Algoritimo;

//Classe que define uma possível solução
public class Individuo {

    private double aptidao;
    private int[] posicoesY;
    private Tabuleiro tabuleiro;
    private int colisoes;

    public Individuo(boolean rainhasAleatorias) {
        posicoesY = new int[Algoritimo.getN()];
        tabuleiro = new Tabuleiro(Algoritimo.getN());

        for (int i = 0; i < posicoesY.length; i++) {
            posicoesY[i] = -1;
        }

        for (int i = 0; i < posicoesY.length; i++) {
            if (rainhasAleatorias) {
                posicoesY[i] = this.gerarYAleatorioExclusivo();
                tabuleiro.atualizaTabuleiro(posicoesY);
            }
        }

        if (rainhasAleatorias) {
            geraAptidao();
        }
    }

    //Gera aleatóriamente um valor de Y sem colisões
    public int gerarYAleatorioExclusivo() {
        int y;
        Random r;
        boolean encontrou;

        do {
            r = new Random();
            y = r.nextInt(Algoritimo.getN());
            encontrou = false;

            for (int i = 0; i < Algoritimo.getN(); i++) {
                if (posicoesY[i] == y) {
                    encontrou = true;
                    break;
                }
            }

        } while (encontrou);

        return y;
    }

    //Gera a aptidão baseado no número de colisões
    public void geraAptidao() {
        this.colisoes = geraColisoes();
        this.aptidao = colisoes;
    }

    //adiciona uma rainha no tabuleiro
    public void addRainha(int x, int y) {
        Random r = new Random();
        if (r.nextDouble() < Algoritimo.getTaxaDeMutacao()) {
            y = gerarYAleatorioExclusivo();
        }
        posicoesY[x] = y;
        tabuleiro.atualizaTabuleiro(posicoesY);
    }

    public double getAptidao() {
        return aptidao;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public int getColisoes() {
        return colisoes;
    }

    public int geraColisoes() {
        int x = 0;
        int y = 0;
        int tempx = 0;
        int tempy = 0;

        int conflicts = 0;
        int dx[] = new int[]{-1, 1, -1, 1};
        int dy[] = new int[]{-1, 1, 1, -1};
        boolean done;

        //Checa na horizontal
        for (int i = 0; i < Algoritimo.getN(); i++) {
            y = posicoesY[i];
            if (y != -1) {
                for (int j = 0; j < Algoritimo.getN(); j++) {
                    if (posicoesY[j] == y && j != i) {
                        conflicts++;
                    }
                }
            }
        }

        //Checa nas diagonais
        for (int i = 0; i < Algoritimo.getN(); i++) {
            x = i;
            y = this.posicoesY[i];
            if (y != -1) {
                for (int j = 0; j <= 3; j++) {
                    tempx = x;
                    tempy = y;
                    done = false;
                    while (!done) {
                        tempx += dx[j];
                        tempy += dy[j];
                        if ((tempx < 0 || tempx >= Algoritimo.getN()) || (tempy < 0 || tempy >= Algoritimo.getN())) {
                            done = true;
                        } else {
                            if (tabuleiro.getTabuleiro()[tempx][tempy]) {
                                conflicts++;
                            }
                        }
                    }
                }
            }
        }


        return conflicts;
    }

    public int[] getPosicoesY() {
        return posicoesY;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < Algoritimo.getN(); i++) {
            s += "[" + i + "," + posicoesY[i] + "] ";
        }
        return s;
    }
}