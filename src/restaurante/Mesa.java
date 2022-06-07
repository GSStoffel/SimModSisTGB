package src.restaurante;

import src.Resource;

public class Mesa extends Resource {
    public Mesa(String name, int quantity) {
        super(name, quantity);
    }

    public Mesa(int quantity) {
        super(quantity);
    }
}
