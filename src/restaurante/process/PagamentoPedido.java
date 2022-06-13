package src.restaurante.process;

import src.Entity;
import src.EntitySet;
import src.Process;
import src.Resource;
import src.restaurante.entity.GrupoClientes;
import src.restaurante.entity.Pedido;

public class PagamentoPedido extends Process {

    private GrupoClientes grupoClientes;
    private Resource atendenteCx;
    private EntitySet filaCaixa;
    private EntitySet filaCozinha;
    private EntitySet filaBalcao;
    private EntitySet filaMesa2;
    private EntitySet filaMesa4;

    public PagamentoPedido(String name, double duration, Resource atendenteCx, EntitySet filaCaixa, EntitySet filaCozinha, EntitySet filaBalcao, EntitySet filaMesa2, EntitySet filaMesa4) {
        super(name, duration);
        this.atendenteCx = atendenteCx;
        this.filaCaixa = filaCaixa;
        this.filaCozinha = filaCozinha;
        this.filaBalcao = filaBalcao;
        this.filaMesa2 = filaMesa2;
        this.filaMesa4 = filaMesa4;
        this.active = true;
        this.startTime = 0;
        this.endTime = startTime + duration;
    }

    @Override
    public void executeOnStart() {
        super.executeOnStart();
        if (!filaCaixa.getEntities().isEmpty()) {
            boolean isAllocated = atendenteCx.allocate(1);
            if (isAllocated) {
                grupoClientes = (GrupoClientes) filaCaixa.remove();
            }
        }
    }

    @Override
    public void executeOnEnd() {
        super.executeOnEnd();
        if (!filaCozinha.isFull() && grupoClientes != null) {
            if (grupoClientes.getQuantity() == 1) {
                if (!filaBalcao.isFull()) {
                    filaCozinha.getEntities().add(new Pedido("Pedido", grupoClientes));
                    filaBalcao.getEntities().add(grupoClientes);
                    atendenteCx.release(1);
                }
            } else if (grupoClientes.getQuantity() == 2) {
                if (!filaMesa2.isFull()) {
                    filaCozinha.getEntities().add(new Pedido("Pedido", grupoClientes));
                    filaMesa2.getEntities().add(grupoClientes);
                    atendenteCx.release(1);
                } else if (!filaMesa4.isFull()) {
                    filaCozinha.getEntities().add(new Pedido("Pedido", grupoClientes));
                    filaMesa4.getEntities().add(grupoClientes);
                    atendenteCx.release(1);
                }
            } else {
                if (!filaMesa4.isFull()) {
                    filaCozinha.getEntities().add(new Pedido("Pedido", grupoClientes));
                    filaMesa4.getEntities().add(grupoClientes);
                    atendenteCx.release(1);
                }
            }
        }
    }
}

