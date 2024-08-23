public class ResumenCliente {
    int idCliente;
    String nombre;
    double sumaImportes;


    public ResumenCliente(int idCliente, String nombre, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.sumaImportes = sumaImportes;
    }

    public String toString(){
        return "ID Cliente: "+ idCliente + ", Nombre: " + ", Suma importes: " + sumaImportes;
    }
}