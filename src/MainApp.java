package src;

import src.restaurante.Restaurante;

public class MainApp {

    public static void main(String[] args) {
        Restaurante r = new Restaurante();

        int bId = r.createResource("bancosBalcão", 6);

        int mesa2Id = r.createResource("mesa2", 4);
        int mesa4Id = r.createResource("mesa4", 4);

        int atendenteCx1 = r.createResource("atendenteCx1", 1);
        int atendenteCx2 = r.createResource("atendenteCx2", 1);

        int cozinheirosId = r.createResource("cozinheiros", 3);



    }
}
//se tu ta zoiunho vai pro balcao
//se 3 ou mais vai f4
//se 2oumeno vai pra mesa que tem menos(2 ou 4)