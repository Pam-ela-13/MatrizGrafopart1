package grafos;
import java.util.Scanner;
//import java.util.ArrayList;
import java.util.List;
public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int numVertices = 0;
		GrafoMatriz grafo = null;

		int opcion;

		do {
			System.out.println("\n===== Menú =====");
			System.out.println("1. Crear grafo con un número de vértices");
			System.out.println("2. Agregar vértices");
			System.out.println("3. Agregar aristas");
			System.out.println("4. Verificar adyacencia");
			System.out.println("5. Salir");
			System.out.print("Ingrese la opción deseada: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				System.out.print("Ingrese el número de vértices (entre 0 y 20): ");
				numVertices = scanner.nextInt();
				if (numVertices < 0 || numVertices > 20) {
					System.out.println("Número de vértices inválido. Debe estar entre 0 y 20.");
				} else {
					grafo = new GrafoMatriz(numVertices);
					System.out.println("Grafo creado con " + numVertices + " vértices.");
				}
				break;
			case 2:
				if (grafo == null) {
					System.out.println("Primero debe crear el grafo con un número de vértices.");
				} else {
					for (int i = 0; i < numVertices; i++) {
						System.out.print("Ingrese el nombre del vértice " + (i + 1) + ": ");
						String nombreVertice = scanner.next();
						grafo.nuevoVertice(nombreVertice);
					}
					System.out.println("Vértices agregados correctamente.");
				}
				break;
			case 3:
				if (grafo == null) {
					System.out.println("Primero debe crear el grafo con un número de vértices.");
				} else {
					System.out.print("Ingrese el nombre del vértice A: ");
					String verticeA = scanner.next();
					System.out.print("Ingrese el nombre del vértice B: ");
					String verticeB = scanner.next();

					try {
						grafo.nuevoArco(verticeA, verticeB);
						System.out.println("Arista agregada entre " + verticeA + " y " + verticeB);
					} catch (Exception e) {
						System.out.println("Error al agregar arista: " + e.getMessage());
					}
				}
				break;
			case 4:
				if (grafo == null) {
					System.out.println("Primero debe crear el grafo con un número de vértices.");
				} else {
					System.out.print("Ingrese el nombre del vértice para verificar adyacencia: ");
					String nombreVertice = scanner.next();
					try {
						int indiceVertice = grafo.numVertice(nombreVertice);
						List<Vertice> verticesAdyacentes = grafo.verticesAdyacentes(indiceVertice);
						System.out.println("Vértices adyacentes a " + nombreVertice + ": ");
						for (Vertice v : verticesAdyacentes) {
							System.out.println(v.numVertice());
						}
					} catch (Exception e) {
						System.out.println("Error al obtener vértices adyacentes: " + e.getMessage());
					}
				}
				break;
			case 5:
				System.out.println("Saliendo del programa. ¡Hasta luego!");
				break;
			default:
				System.out.println("Opción inválida. Intente nuevamente.");
				break;
			}
		} while (opcion != 5);
	}

}
