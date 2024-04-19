import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Grafo grafo = new Grafo();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Crear Grafo");
            System.out.println("2. Recorrido en Anchura");
            System.out.println("3. Recorrido en Profundidad");
            System.out.println("4. Mostrar Grafo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume el newline left-over

            switch (opcion) {
                case 1:
                    crearGrafo();
                    break;
                case 2:
                    realizarRecorrido(true);
                    break;
                case 3:
                    realizarRecorrido(false);
                    break;
                    case 4:
                    grafo.mostrarGrafo();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void crearGrafo() {
        grafo = new Grafo(); // Resetear o crear un nuevo grafo
        System.out.println("Introduzca los nodos del grafo (ej. A B C D):");
        String[] nodos = scanner.nextLine().split("\\s+");
        for (String nodo : nodos) {
            grafo.añadirVertice(nodo);
        }

        System.out.println("Introduzca las aristas en formato 'Origen Destino Peso' (ej. A B 5.0), escriba 'fin' para terminar:");
        while (true) {
            String entrada = scanner.nextLine();
            if ("fin".equalsIgnoreCase(entrada)) break;
            String[] partes = entrada.split("\\s+");
            grafo.añadirArco(partes[0], partes[1], Double.parseDouble(partes[2]));
        }
    }

    private static void realizarRecorrido(boolean esAnchura) {
        System.out.print("Ingrese el vértice de origen para el recorrido: ");
        String origen = scanner.nextLine();
        if (esAnchura) {
            System.out.println("Recorrido en Anchura (BFS) desde " + origen + ":");
            grafo.bfs(origen);
        } else {
            System.out.println("Recorrido en Profundidad (DFS) desde " + origen + ":");
            grafo.dfs(origen);
        }
    }
}
