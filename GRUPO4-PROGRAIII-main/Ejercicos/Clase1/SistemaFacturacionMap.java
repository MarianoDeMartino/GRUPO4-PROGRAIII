import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFacturacionConMap {

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

        
        List<ResumenCliente> resumenClientes = generarResumenConMap(facturas, clientes);

        for (ResumenCliente resumen : resumenClientes) {
            System.out.println(resumen);
        }
    }

    public static List<ResumenCliente> generarResumenConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> mapSumaImportes = new HashMap<>();

     
        for (Factura factura : facturas) {
            mapSumaImportes.put(factura.idCliente,
                    mapSumaImportes.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<ResumenCliente> resumenClientes = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double sumaImportes = mapSumaImportes.getOrDefault(cliente.idCliente, 0.0);
            resumenClientes.add(new ResumenCliente(cliente.idCliente, cliente.nombre, sumaImportes));
        }

        return resumenClientes;
    }
}
