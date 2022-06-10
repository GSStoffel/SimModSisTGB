package src;

import src.restaurante.Fila;
import src.restaurante.Lugar;
import src.restaurante.Process;

public class MainApp {

    public static void main(String[] args) {
        DesEngine de = new DesEngine();
        Resource m2 = de.createResource(new Lugar("mesas2",2));
        Resource m4 = de.createResource(new Lugar("mesas4", 2));
        Resource balcao = de.createResource(new Lugar("bancosBalcão", 2));

        EntitySet filaMesa2 = de.createEntitySet(new Fila("filaM2",1, 100));
        EntitySet filaMesa4 = de.createEntitySet(new Fila("filaM4",1, 100));
        EntitySet filaBalcao = de.createEntitySet(new Fila("filaBalcao",1, 100));

        Process FB = de.createProcess(new EntraNaFila(1,"Processo1", de.normal(8.0,2.0)));
    }
}
