class Cliente3 {
    int id;
    String nombre;
    int scoring;

    public Cliente3(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class Actividad3Clase3 {
    public static void main(String[] args) {
        Cliente3[] clientes = {
                new Cliente3(1, "Juan", 80),
                new Cliente3(2, "Ana", 95),
                new Cliente3(3, "Luis", 85),
                new Cliente3(4, "Pedro", 75),
                new Cliente3(5, "Maria", 92)
        };

        Cliente3[] resultado = encontrarDosMayoresClientes(clientes);
        System.out.println("Cliente con mayor scoring: " + resultado[0]);
        System.out.println("Cliente con segundo mayor scoring: " + resultado[1]);
    }

    private static Cliente3[] encontrarDosMayoresClientes(Cliente3[] clientes) {
        return encontrarDosMayoresClientes(clientes, 0, clientes.length);
    }

    private static Cliente3[] encontrarDosMayoresClientes(Cliente3[] clientes, int inicio, int fin) {
        if (fin - inicio == 1) {
            return new Cliente3[]{clientes[inicio], null}; // Solo un cliente
        }

        if (fin - inicio == 2) {
            Cliente3 mayor = (clientes[inicio].scoring > clientes[inicio + 1].scoring) ? clientes[inicio] : clientes[inicio + 1];
            Cliente3 segundoMayor = (mayor == clientes[inicio]) ? clientes[inicio + 1] : clientes[inicio];
            return new Cliente3[]{mayor, segundoMayor}; // Dos clientes
        }

        int mitad = (fin + inicio) / 2;
        Cliente3[] izq = encontrarDosMayoresClientes(clientes, inicio, mitad);
        Cliente3[] der = encontrarDosMayoresClientes(clientes, mitad, fin);

        Cliente3 nuevoMayor, nuevoSegundoMayor;

        if (izq[0].scoring > der[0].scoring) {
            nuevoMayor = izq[0];
            nuevoSegundoMayor = (izq[1] != null && izq[1].scoring > der[0].scoring) ? izq[1] : der[0];
        } else {
            nuevoMayor = der[0];
            nuevoSegundoMayor = (der[1] != null && der[1].scoring > izq[0].scoring) ? der[1] : izq[0];
        }

        return new Cliente3[]{nuevoMayor, nuevoSegundoMayor};
    }
}
