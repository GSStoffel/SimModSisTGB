package src;

import src.restaurante.Restaurante;

public class MainApp {

    public static void main(String[] args) {
        Restaurante r = new Restaurante();

        int bId = r.createResource("bancosBalcão", 1);
        int m2Id = r.createResource("mesa2", 1);
        int m4Id = r.createResource("mesa4", 1);
        int atendenteCx1 = r.createResource("atendenteCx1", 1);

        r.createResource("atendenteCx2", 1);
        r.createResource("cozinheiros", 1);
        r.createResource("", 1);

    }
}
