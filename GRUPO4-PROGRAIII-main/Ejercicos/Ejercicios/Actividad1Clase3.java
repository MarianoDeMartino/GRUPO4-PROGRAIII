class Cliente4 {
    int id;
    String nombre;
    int scoring;

    public Cliente4(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class Actividad1Clase3 {
    public static void main(String[] args) {
        Cliente4[] clientes = {
                new Cliente4(1, "Juan", 80),
                new Cliente4(2, "Ana", 95),
                new Cliente4(3, "Luis", 85),
                new Cliente4(4, "Pedro", 75),
                new Cliente4(5, "Maria", 92)
        };

        Cliente4 maxCliente = encontrarMaxCliente(clientes);
        System.out.println("Cliente con el mayor scoring: " + maxCliente);
    }

    private static Cliente4 encontrarMaxCliente(Cliente4[] clientes) {
        return encontrarMaxCliente(clientes, 0, clientes.length);
    }

    private static Cliente4 encontrarMaxCliente(Cliente4[] clientes, int i, int f) {
        if (i == f - 1) return clientes[i]; // Caso base: un solo cliente

        int mitad = (f + i) / 2;  // Encontrar el punto medio
        Cliente4 izq = encontrarMaxCliente(clientes, i, mitad);  // Lado izquierdo
        Cliente4 der = encontrarMaxCliente(clientes, mitad, f);  // Lado derecho

        // Comparar clientes por su scoring y retornar el que tiene el mayor
        return (izq.scoring > der.scoring) ? izq : der;
    }
}
