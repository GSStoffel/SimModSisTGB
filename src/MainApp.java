package src;

import src.restaurante.Restaurante;
import src.restaurante.process.Chegada;
import src.restaurante.process.PagamentoPedido;
import src.restaurante.process.PreparandoPedido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        Restaurante r = new Restaurante();

        int balcaoId = r.createResource("bancosBalcão", 6);

        int mesa2Id = r.createResource("mesa2", 4);
        int mesa4Id = r.createResource("mesa4", 4);

        int atendenteCx1 = r.createResource("atendenteCx1", 1);
        int atendenteCx2 = r.createResource("atendenteCx2", 1);

        int cozinheirosId = r.createResource("cozinheiros", 3);

        // FILAS

        int filaCaixa1 = r.createEntitySet("caixa1", Mode.FIFO, 100);
        int filaCaixa2 = r.createEntitySet("caixa2", Mode.FIFO, 100);

        int filaCozinha = r.createEntitySet("cozinha", Mode.FIFO, 100);

        int filaBalcao = r.createEntitySet("filaBalcão", Mode.FIFO, 100);
        int filaM2 = r.createEntitySet("filaM2", Mode.FIFO, 100);
        int filaM4 = r.createEntitySet("filaM4", Mode.FIFO, 100);

        int pedidoEsperandoEntrega = r.createEntitySet("pedidoEsperandoEntrega", Mode.FIFO, 100);

        // PROCESSOS - Chegada

        int chegada = r.createProcess(new Chegada("chegada", r.exponential(3), new ArrayList<EntitySet>() {{add(r.getEntitySet(filaCaixa1));add(r.getEntitySet(filaCaixa2));}}, r));

        int pagamentoPedido1 = r.createProcess(new PagamentoPedido("pagamentoPedido1", r.normal(8, 2), r.getResource(atendenteCx1), r.getEntitySet(filaCaixa1), r.getEntitySet(filaCozinha), r.getEntitySet(filaBalcao), r.getEntitySet(filaM2), r.getEntitySet(filaM4)));
        int pagamentoPedido2 = r.createProcess(new PagamentoPedido("pagamentoPedido2", r.normal(8, 2), r.getResource(atendenteCx2), r.getEntitySet(filaCaixa2), r.getEntitySet(filaCozinha), r.getEntitySet(filaBalcao), r.getEntitySet(filaM2), r.getEntitySet(filaM4)));

//        r.createProcess(new PreparandoPedido())
        int preparandoPedido = r.createProcess(new PreparandoPedido("preparandoPedido", r.normal(14, 5), r.getResource(cozinheirosId), r.getEntitySet(filaCozinha), r.getEntitySet(pedidoEsperandoEntrega)));
//
//        // PROCESSOS - Comendo
//
//        int comendoBalcao = r.createProcess("ComendoBalcao", r.exponential(3), new ArrayList<EntitySet>() {{
//            add(r.getEntitySet(filaBalcao));
//        }}, r.getResource(balcaoId));
//        int comendoM2 = r.createProcess("ComendoM1", r.exponential(3), new ArrayList<EntitySet>() {{
//            add(r.getEntitySet(filaM2));
//        }}, r.getResource(mesa2Id));
//        int comendoM4 = r.createProcess("ComendoM2", r.exponential(3), new ArrayList<EntitySet>() {{
//            add(r.getEntitySet(filaM4));
//        }}, r.getResource(mesa4Id));

        r.simulateUntil(300);
        r.simulate();

    }
}