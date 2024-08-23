import java.util.ArrayList;
import java.util.List;

public class SistemaFacturacion {
    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 100.50));
        facturas.add(new Factura(2, 102, 200.00));
        facturas.add(new Factura(3, 101, 300.75));
        facturas.add(new Factura(4, 103, 150.00));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Cliente A"));
        clientes.add(new Cliente(102, "Cliente B"));
        clientes.add(new Cliente(103, "Cliente C"));

        List<ResumenCliente> resumenClientes = generarResumen(facturas, clientes);

        for (ResumenCliente resumen : resumenClientes) {
            System.out.println(resumen);
        }
    }

    public static List<ResumenCliente> generarResumen(List<Factura> facturas, List<Cliente> clientes) {
        List<ResumenCliente> resumenClientes = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double sumaImportes = 0.0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    sumaImportes += factura.importe;
                }
            }
            resumenClientes.add(new ResumenCliente(cliente.idCliente, cliente.nombre, sumaImportes));
        }

        return resumenClientes;
    }
}


/*
La complejidad es O( m x n ) donde M es la cantidad de clientes y N la cantidad de facturas
 */
