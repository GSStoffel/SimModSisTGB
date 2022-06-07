package src.restaurante;

import src.Entity;
import src.PetriNet;

public class GrupoPessoa extends Entity {
    public GrupoPessoa(String name) {
        super(name);
    }

    public GrupoPessoa(String name, PetriNet petriNet) {
        super(name, petriNet);
    }


}
