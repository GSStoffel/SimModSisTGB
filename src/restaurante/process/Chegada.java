package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.Resource;

public class Chegada extends Process {

    private EntitySet fila;
    private Resource atendenteCx;

    public Chegada(int processId, String name, double duration, EntitySet fila, Resource atendenteCx) {
        super(processId, name, duration);
        this.fila = fila;
        this.atendenteCx = atendenteCx;
    }

    @Override
    public void executeOnStart() {

    }

    @Override
    public void executeOnEnd() {
        super.executeOnEnd();
    }
}
