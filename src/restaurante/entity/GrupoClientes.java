package src.restaurante.entity;

import src.Entity;
import src.PetriNet;

import java.util.Random;

public class GrupoClientes extends Entity {

    private int quantity;

    public GrupoClientes(int id, String name) {
        super(name);
        this.quantity = new Random().nextInt(4)+1;
    }

    public GrupoClientes(String name, PetriNet petriNet) {
        super(name, petriNet);
    }

    public int getQuantity() {
        return quantity;
    }
}
