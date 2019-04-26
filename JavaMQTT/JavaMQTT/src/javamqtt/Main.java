package javamqtt;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://broker.mqttdashboard.com:1883", null, null);
        clienteMQTT.iniciar();

        new Ouvinte(clienteMQTT, "br/com/paulocollares/#", 0);

        while (true) {
            Thread.sleep(1000);
            String mensagem = "Mensagem enviada em " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis()) + " - Teste de MQTT disponivel em www.paulocollares.com.br";

            clienteMQTT.publicar("br/com/paulocollares/teste", mensagem.getBytes(), 0);
        }

    }

}
