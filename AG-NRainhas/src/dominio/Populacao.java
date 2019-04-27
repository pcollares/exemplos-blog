package dominio;

//Define uma população
public class Populacao {

    private Individuo[] individuos;
    private int tamPopulacao;

    public Populacao(int tamPop, boolean individuosAleatorios) {
        tamPopulacao = tamPop;
        individuos = new Individuo[tamPop];

        for (int i = 0; i < individuos.length; i++) {
            if (individuosAleatorios) {
                individuos[i] = new Individuo(true);
            } else {
                individuos[i] = null;
            }
        }
    }

    public void setIndividuo(Individuo individuo, int posicao) {
        individuos[posicao] = individuo;
    }

    public void setIndividuo(Individuo individuo) {
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] == null) {
                individuos[i] = individuo;
                return;
            }
        }
    }

    public void ordenaPopulacao() {
        boolean trocou = true;
        while (trocou) {
            trocou = false;
            for (int i = 0; i < individuos.length - 1; i++) {
                if (individuos[i].getAptidao() > individuos[i + 1].getAptidao()) {
                    Individuo temp = individuos[i];
                    individuos[i] = individuos[i + 1];
                    individuos[i + 1] = temp;
                    trocou = true;
                }
            }
        }
    }

    public int getNumIndividuos() {
        int num = 0;
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] != null) {
                num++;
            }
        }
        return num;
    }

    public double getMediaAptidao() {
        return getTotalAptidao() / getNumIndividuos();
    }

    public double getTotalAptidao() {
        double total = 0;
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i] != null) {
                total += individuos[i].getAptidao();
            }
        }
        return total;
    }

    public int getTamPopulacao() {
        return tamPopulacao;
    }

    public Individuo getIndivduo(int pos) {
        return individuos[pos];
    }

    public Individuo[] getIndividuos() {
        return individuos;
    }
}