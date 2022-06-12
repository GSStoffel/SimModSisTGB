package src.restaurante.process;

import src.EntitySet;
import src.Process;
import src.Resource;

public class Comendo extends Process {
    private EntitySet fila;
    private Resource resource;

    public Comendo(int processId, String name, double duration, EntitySet fila, Resource resource) {
        super(processId, name, duration);
        this.fila = fila;
        this.resource = resource;
    }

    @Override
    public void executeOnStart() {
        boolean allocated = resource.allocate(1);
        if (allocated) {
            fila.remove();
        }
    }

    @Override
    public void executeOnEnd() {
        resource.release(1);
    }
}
