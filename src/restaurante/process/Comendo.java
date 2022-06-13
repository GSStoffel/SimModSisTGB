package src.restaurante.process;

import src.EntitySet;
import src.Process;
import src.Resource;

public class Comendo extends Process {
    private EntitySet filaPedidos;
    private EntitySet filaLugar;
    private Resource resource;

    public Comendo(int processId, String name, double duration, EntitySet filaPedidos, EntitySet filaLugar, Resource resource) {
        super(processId, name, duration);
        this.filaPedidos = filaPedidos;
        this.filaLugar = filaLugar;
        this.resource = resource;
    }

    @Override
    public void executeOnStart() {
    }

    @Override
    public void executeOnEnd() {
    }
}
