public class ArbolDeBusqueda {
public static void main(String[] args) {
    ArbolBinario arbol = new ArbolBinario();

    arbol.insertar(50);
    arbol.insertar(25);
    arbol.insertar(75);
    arbol.insertar(10);
    arbol.insertar(40);
    arbol.insertar(60);
    arbol.insertar(90);
    arbol.insertar(35);
    arbol.insertar(45);
    arbol.insertar(70);
    arbol.insertar(42);




System.out.println(arbol.calcularAltura());
System.out.println(arbol.contar());
arbol.inOrden(arbol.obtenerRaiz());








}
}
