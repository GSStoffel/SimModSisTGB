package src.restaurante.entity;

import src.Entity;
import src.PetriNet;

public class Pedido extends Entity {

    private GrupoClientes grupoClientes;

    public Pedido(String name, GrupoClientes grupoClientes) {
        super(name);
        this.grupoClientes = grupoClientes;
    }

    public Pedido(String name, PetriNet petriNet) {
        super(name, petriNet);
    }

    public Pedido(String name, PetriNet petriNet, double creationTime) {
        super(name, petriNet, creationTime);
    }

    public Pedido(String name, PetriNet petriNet, double creationTime, int priority) {
        super(name, petriNet, creationTime, priority);
    }

    public GrupoClientes getGrupoClientes() {
        return grupoClientes;
    }
}
