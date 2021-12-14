package tienda.models.impl;

import tienda.models.Pedido;
import tienda.models.impl.DescuentoFactory;
import tienda.models.interfaces.IDescuento;
import tienda.models.interfaces.IEstadoPedido;

public class PedidoAnulado implements IEstadoPedido

{
    private String id;
    private int opc;

    public PedidoAnulado()   {
    }

    @Override
    public void procesar(Pedido pedido) {

        if(opc == 1){
            System.out.println("Pedido Anulado, no se pudo validar la compra.");
        }
        else if(opc == 4){
            System.out.println("Pedido Anulado, el monto a devolver es: " + pedido.getMontoTotal());
        }
        
        pedido.setEstadoPedido( new PedidoFinalizado() );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
