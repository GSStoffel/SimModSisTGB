package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.Resource;
import src.restaurante.Restaurante;
import src.restaurante.entity.GrupoClientes;
import src.restaurante.entityset.Fila;

import java.util.List;

public class Chegada extends Process {

    public Entity entity;
    private List<EntitySet> entitySetList;

    public Chegada(int processId, String name, double duration, List<EntitySet> entitySetList) {
        super(processId, name, duration);
        this.entitySetList = entitySetList;
    }

    @Override
    public void executeOnStart() {
        if (isCashierAvailable()) {
            entity = new GrupoClientes("GrupoClientes");
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
