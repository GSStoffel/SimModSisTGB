package src.restaurante;

import src.DesEngine;
import src.Process;

public class Restaurante extends DesEngine {

    @Override
    public void simulate() {
        for (Process p : processes) {
            if (p.isActive() && p.getStartTime() >= time) {
                p.executeOnStart();
            }

            if (p.isActive() && p.getEndTime() <= time) {
                p.executeOnEnd();
            }
        }
    }
}
