package src;

import src.restaurante.Comendo;
import src.restaurante.Restaurante;

public class MainApp {

    public static void main(String[] args) {
        Restaurante r = new Restaurante();

        int balcaoId = r.createResource("bancosBalcão", 6);

        int mesa2Id = r.createResource("mesa2", 4);
        int mesa4Id = r.createResource("mesa4", 4);

        int atendenteCx1 = r.createResource("atendenteCx1", 1);
        int atendenteCx2 = r.createResource("atendenteCx2", 1);

        int cozinheirosId = r.createResource("cozinheiros", 3);

        int caixa1 = r.createEntitySet("caixa1", Mode.FIFO, 100);
        int caixa2 = r.createEntitySet("caixa2", Mode.FIFO, 100);

        int cozinha = r.createEntitySet("cozinha", Mode.FIFO, 100);

        // FILAS

        int filaBalcao = r.createEntitySet("filaBalcão", Mode.FIFO, 100);

        int fila1 = r.createEntitySet("fila1", Mode.FIFO, 100);
        int fila2 = r.createEntitySet("fila2", Mode.FIFO, 100);

        // PROCESSOS - Chegada

        int chegada_1 = r.createProcess("Chegada1", r.exponential(3), r.getEntitySet(caixa1), r.getResource(atendenteCx1));
        int chegada_2 = r.createProcess("Chegada2", r.exponential(3), r.getEntitySet(caixa2), r.getResource(atendenteCx2));

        int chegadaPedidos = r.createProcess("ChegadaPedidos", r.exponential(3), r.getEntitySet(cozinha), r.getResource(cozinheirosId));

        // PROCESSOS - Comendo

        int comendoBalcao = r.createProcess("ComendoBalcao", r.exponential(3), r.getEntitySet(filaBalcao).remove(), r.getResource(balcaoId));

        int comendoM1 = r.createProcess("ComendoM1", r.exponential(3), r.getEntitySet(fila1).remove(), r.getResource(mesa2Id));
        int comendoM2 = r.createProcess("ComendoM2", r.exponential(3), r.getEntitySet(fila2).remove(), r.getResource(mesa4Id));

    }
}