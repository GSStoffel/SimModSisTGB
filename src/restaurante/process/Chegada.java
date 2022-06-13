package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.restaurante.Restaurante;

import java.util.List;

public class Chegada extends Process {

    public Entity entity;
    private Restaurante restaurante;
    private List<EntitySet> entitySetList;

    public Chegada(String name, double duration, List<EntitySet> entitySetList, Restaurante restaurante) {
        super(name, duration);
        this.entitySetList = entitySetList;
        this.restaurante = restaurante;
        this.active = true;
    }

    @Override
    public void executeOnStart() {
        if (isCashierAvailable()) {
            restaurante.createEntity("GrupoClientes");
        }
    }

    @Override
    public void executeOnEnd() {
        if(entity != null) {
            EntitySet entitySet = shortestQueue();
            entitySet.getEntities().add(entity);
        }
    }

    private EntitySet shortestQueue() {
        EntitySet menorFila = entitySetList.get(0);
        for (EntitySet es : entitySetList) {
            if (es.getSize() < menorFila.getSize()) {
                menorFila = es;
            }
        }
        return menorFila;
    }

    private boolean isCashierAvailable() {
        for (EntitySet es : entitySetList) {
            if (!es.isFull()) {
                return true;
            }
        }
        return false;
    }
}
