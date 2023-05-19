import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static final Integer DISCOLORED = -1;
    public static final int VERMELHO = 0;
    public static final int AZUL = 1;
    public static final int AMARELO = 2;
    public static final int VERDE = 3;

    public static void main(String[] args) throws Exception {

        File arquivoIncidencia = new File(
                "./src/matrizIncidencia.txt");
        File aqruivoVertices = new File("./src/vertices.txt");
        Scanner incidencia = new Scanner(arquivoIncidencia);
        Scanner vert = new Scanner(aqruivoVertices);

        Map<Integer, Vertice> vertices = new HashMap<>();
        String temps = "";
        Integer tempi = 0;
        Vertice holder = null;

        while (vert.hasNext()) {
            temps = vert.next();
            tempi = vert.nextInt();
            holder = new Vertice(temps);
            vertices.put(tempi, holder);
        }

        boolean[] colorAvailability = { true, true, true, true };
        Integer iterador = 0;
        Integer size = vertices.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempi = incidencia.nextInt();
                if (tempi == 0) {
                    continue;
                }

                holder = vertices.get(j);

                if (holder.getCor() == DISCOLORED) {
                    continue;
                }

                colorAvailability[holder.getCor()] = false;
                iterador++;

            }

            if (iterador > colorAvailability.length) {
                throw new Exception("Quantidade de cores insuficiente!!", null);
            }
            for (int k = 0; k < colorAvailability.length; k++) {
                if (colorAvailability[k]) {
                    vertices.get(i).setCor(k);
                }
            }
            colorAvailability = new boolean[] { true, true, true, true };
            iterador = 0;
        }

        for (Vertice v : vertices.values()) {
            switch (v.getCor()) {
                case VERMELHO: {
                    System.out.println("Nome: " + v.getName() + " - Cor: VERMELHO");
                    break;
                }
                case VERDE: {
                    System.out.println("Nome: " + v.getName() + " - Cor: VERDE");
                    break;
                }
                case AZUL: {
                    System.out.println("Nome: " + v.getName() + " - Cor: AZUL");
                    break;
                }
                case AMARELO: {
                    System.out.println("Nome: " + v.getName() + " - Cor: AMARELO");
                    break;
                }
            }
        }
    }
}
