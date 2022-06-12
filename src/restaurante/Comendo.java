package src.restaurante;

import src.Process;

public class Comendo extends Process {
    public Comendo(int processId, String name, double duration) {
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
