package br.com.paulocollares.simple_http_server.pages;

import com.sun.management.OperatingSystemMXBean;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;

/**
 * Esta classe é responsável por gerenciar as requisições http feitas no
 * contexto /sobre
 *
 * @author Paulo Collares
 */
public class Stats implements HttpHandler {

    private final transient DecimalFormat df = new DecimalFormat("0.##");
    private OperatingSystemMXBean operatingSystemMXBean;

    public Stats() {
        operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    @Override
    public void handle(HttpExchange he) throws IOException {
        StringBuilder out = new StringBuilder();

        //Informações do SO
        String nameOS = System.getProperty("os.name");
        String versionOS = System.getProperty("os.version");
        String architectureOS = System.getProperty("os.arch");
        String sistemaOperacional = nameOS + " " + versionOS + " " + architectureOS;
        long totalSwapDisponivel = operatingSystemMXBean.getTotalSwapSpaceSize();
        long totalMemoriaSistema = operatingSystemMXBean.getTotalPhysicalMemorySize();

        //Informações do Java
        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String javaInfo = javaVendor + " " + javaVersion;

        //Processador
        int numeroProcessadores = Runtime.getRuntime().availableProcessors();
        double cargaCPUJava = operatingSystemMXBean.getProcessCpuLoad();
        double cargaCPUSistema = operatingSystemMXBean.getSystemCpuLoad();

        //Memoria
        long totalMemoriaJava = Runtime.getRuntime().totalMemory();
        long memoriaMaximaJava = Runtime.getRuntime().maxMemory();
        long memoriaSistema = totalMemoriaSistema - operatingSystemMXBean.getFreePhysicalMemorySize();
        long swap = totalSwapDisponivel - operatingSystemMXBean.getTotalSwapSpaceSize();

        long memoriaJava = totalMemoriaJava - Runtime.getRuntime().freeMemory();

        File[] roots = File.listRoots();

        String espacoDisco = "";
        for (File root : roots) {
            long espacoDiscoDisponivel = root.getFreeSpace();
            long espacoTotal = root.getTotalSpace();
            espacoDisco += root.getAbsolutePath() + ": " + byteLegivel(espacoTotal - espacoDiscoDisponivel, true) + "/" + byteLegivel(espacoTotal, true) + ";";
        }

        int threadsAtivas = ManagementFactory.getThreadMXBean().getThreadCount();

        out.append("<html>");
        out.append("<head>");
        out.append("<title>Stats").append("</title>");
        out.append("</head>");
        out.append("<body>");

        out.append("Sistema operacional: ").append(sistemaOperacional).append("<br/>")
                .append("Java: ").append(javaInfo).append("<br/><br/>")
                .append("Processadores: ").append(numeroProcessadores).append("<br/><br/>")
                .append("Mem. JVM: ").append(byteLegivel(memoriaJava, true)).append("/").append(byteLegivel(totalMemoriaJava, true)).append(" max: ").append(byteLegivel(memoriaMaximaJava, true)).append("<br/><br/>")
                .append("Mem. SO: ").append(byteLegivel(memoriaSistema, true)).append("/").append(byteLegivel(totalMemoriaSistema, true)).append("<br/><br/>")
                .append("Swap: ").append(byteLegivel(swap, true)).append("/").append(byteLegivel(totalSwapDisponivel, true)).append("<br/><br/>")
                .append("Uso de CPU: JVM: ").append(df.format(cargaCPUJava * 100)).append("%")
                .append(" SO: ").append(df.format(cargaCPUSistema * 100)).append("%").append("<br/><br/>")
                .append("Threads (JVM): ").append(threadsAtivas);

        out.append("</body>");
        out.append("</html>");

        String saida = out.toString();

        he.sendResponseHeaders(200, saida.length());

        try (OutputStream os = he.getResponseBody()) {
            os.write(saida.getBytes("ISO-8859-1"));
        }
    }

    /**
     * Retorna um valor em bytes legível
     *
     * @param bytes
     * @param si
     * @return
     */
    private String byteLegivel(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

}
