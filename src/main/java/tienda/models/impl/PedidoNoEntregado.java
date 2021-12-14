package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoNoEntregado implements IEstadoPedido {
    
    private String id;
    private int motivo;

    public PedidoNoEntregado()   {
    }

    @Override
    public void procesar(Pedido pedido) {

        if (motivo == 1){
            System.out.println("No se encontró al cliente para entregarle el pedido");
            pedido.setEstadoPedido( new PedidoPorEntregar());
        }
        else if(motivo == 2){
            System.out.println("El cliente desea anular la compra");
            pedido.setEstadoPedido(new PedidoAnulado());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
