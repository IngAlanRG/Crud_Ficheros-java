package vista;
import funciones.Captura;
import funciones.Menu;


public class ClasePrincipal {
    public static void main(String[] args) {
        Captura objC = new Captura();
        Menu objM = new Menu();
        int opc;
        do {
            System.out.println("1. Registrar articulo");
            System.out.println("2. Listar articulos");
            System.out.println("3. Buscar articulo");
            System.out.println("4. Eliminar articulo");
            System.out.println("5. Modificar articulo");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opción:");
            opc = Integer.parseInt(objC.getString());
            objM.menuOpciones(opc);
            
        } while (opc != 6);
    }
}
