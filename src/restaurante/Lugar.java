package src.restaurante;

import src.Resource;

public class Lugar extends Resource {
    public Lugar(String name, int quantity) {
        super(name, quantity);
    }

    public Lugar(int quantity) {
        super(quantity);
    }
}
