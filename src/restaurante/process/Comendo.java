package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;

public class Comendo extends Process {
    public Comendo(int processId, String name, double duration, EntitySet fila) {
        super(processId, name, duration);
    }

    @Override
    public void executeOnStart() {
        super.executeOnStart();
    }

    @Override
    public void executeOnEnd() {
        super.executeOnEnd();
    }
}
