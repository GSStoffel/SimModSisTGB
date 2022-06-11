package src;

import src.restaurante.*;
import src.restaurante.Process;

public class MainApp {

    public static void main(String[] args) {
        DesEngine de = new DesEngine();

        Resource m2 = de.createResource(new Lugar("mesas2",2));
        Resource m4 = de.createResource(new Lugar("mesas4", 4));
        Resource b = de.createResource(new Lugar("bancosBalcão", 6));
        Resource c = de.createResource(new Lugar("cozinheiros", 5));

        EntitySet fM2 = de.createEntitySet(new Fila("filaM2",1, 100));
        EntitySet fM4 = de.createEntitySet(new Fila("filaM4",1, 100));
        EntitySet fB = de.createEntitySet(new Fila("filaBalcao",1, 100));
        EntitySet fp = de.createEntitySet(new Fila("filaPed",1, 100));

        Process comendoB = de.createProcess(new Comendo(1,"Comendo", de.normal(8.0, 2.0)));
        Process comendoM2 = de.createProcess(new Comendo(1,"ComendoM2", de.normal(8.0, 2.0)));
        Process comendoM4 = de.createProcess(new Comendo(1,"ComendoM4", de.normal(8.0, 2.0)));
    }
}
