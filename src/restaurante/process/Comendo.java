package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.Resource;
import src.restaurante.entity.GrupoClientes;
import src.restaurante.entity.Pedido;

public class Comendo extends Process {
    private EntitySet filaPedidosEsperando;
    private EntitySet filaLugar;
    private Resource resource;

    private Entity entity;

    public Comendo(String name, double duration, EntitySet filaPedidosEsperando, EntitySet filaLugar, Resource resource) {
        super(name, duration);
        this.filaPedidosEsperando = filaPedidosEsperando;
        this.filaLugar = filaLugar;
        this.resource = resource;
    }

    @Override
    public void executeOnStart() {
        super.executeOnStart();
        if (!filaPedidosEsperando.getEntities().isEmpty()) {
            if (!filaLugar.getEntities().isEmpty()) {
                Entity grupoClientes = null;
                Entity pedido = null;
                for (Entity gc : filaLugar.getEntities()) {
                    for (Entity p : filaPedidosEsperando.getEntities()) {
                        if (((GrupoClientes) gc).getId() == ((Pedido) p).getGrupoClientes().getId()){
                            grupoClientes = gc;
                            pedido = p;
                        }
                    }
                }
                if (grupoClientes != null && pedido != null){
                    boolean isAllocated = resource.allocate(1);
                    if (isAllocated) {
                        entity = filaLugar.removerId(grupoClientes.getId());
                        filaPedidosEsperando.removerId(pedido.getId());
                    }
                }
            }
        }
    }

    @Override
    public void executeOnEnd() {
        super.executeOnEnd();
        if (entity != null) {
            resource.release(1);
            entity.setEndTime(endTime);
            entity = null;
        }
    }
}
