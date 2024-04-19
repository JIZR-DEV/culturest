import java.util.*;

class Vertice {
    String nombre;
    List<Arco> adyacentes;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
    }

    void añadirArco(Vertice destino, double peso) {
        adyacentes.add(new Arco(destino, peso));
    }
}

class Arco {
    Vertice destino;
    double peso;

    public Arco(Vertice destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

class Grafo {
    Map<String, Vertice> vertices;

    public Grafo() {
        vertices = new HashMap<>();
    }

    void añadirVertice(String nombre) {
        vertices.putIfAbsent(nombre, new Vertice(nombre));
    }

    void añadirArco(String origen, String destino, double peso) {
        Vertice vOrigen = vertices.get(origen);
        Vertice vDestino = vertices.get(destino);
        if (vOrigen != null && vDestino != null) {
            vOrigen.añadirArco(vDestino, peso);
        } else {
            System.out.println("Error: Uno o ambos vértices no existen.");
        }
    }
    

    void bfs(String inicio) {
        if (!vertices.containsKey(inicio)) {
            System.out.println("El vértice no existe.");
            return;
        }
        Set<Vertice> visitados = new HashSet<>();
        Queue<Vertice> cola = new LinkedList<>();
        cola.add(vertices.get(inicio));
        visitados.add(vertices.get(inicio));

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            System.out.print(actual.nombre + " ");
            for (Arco arco : actual.adyacentes) {
                if (!visitados.contains(arco.destino)) {
                    cola.add(arco.destino);
                    visitados.add(arco.destino);
                }
            }
        }
        System.out.println();
    }

    void dfs(String inicio) {
        if (!vertices.containsKey(inicio)) {
            System.out.println("El vértice no existe.");
            return;
        }
        Set<Vertice> visitados = new HashSet<>();
        Stack<Vertice> pila = new Stack<>();
        pila.push(vertices.get(inicio));

        while (!pila.isEmpty()) {
            Vertice actual = pila.pop();
            if (!visitados.contains(actual)) {
                System.out.print(actual.nombre + " ");
                visitados.add(actual);
                for (Arco arco : actual.adyacentes) {
                    pila.push(arco.destino);
                }
            }
        }
        System.out.println();
    }
    
   void mostrarGrafo() {
        System.out.println("Estructura del Grafo:");
        for (Vertice v : vertices.values()) {
            System.out.print(v.nombre + " -> ");
            for (Arco arco : v.adyacentes) {
                System.out.print(arco.destino.nombre + " (" + arco.peso + ") ");
            }
            System.out.println();  // Para un mejor formato en la salida
        }
    }
}  
    
    
    

