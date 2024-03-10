import java.util.ArrayList;
class Mercaderia {
    private String nombre;
    private double precio;
    private int existenciasActuales;
    public Mercaderia(String nombre, double precio, int existenciasActuales) {
        this.nombre = nombre;
        this.precio = precio;
        this.existenciasActuales = existenciasActuales;
    }
    public String obtenerNombre() {
        return nombre;
    }
    public double obtenerPrecio() {
        return precio;
    }
    public int obtenerExistenciasActuales() {
        return existenciasActuales;
    }
    public void reducirExistencias(int cantidad) {
        if (cantidad <= existenciasActuales) {
            existenciasActuales -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para la venta de " + nombre);
        }
    }
    public double calcularValorVenta(int cantidad) {
        return precio * cantidad;
    }
}
class TiendaVirtual {
    private ArrayList<Mercaderia> inventario;
    private double total;
    public TiendaVirtual() {
        this.inventario = new ArrayList<>();
        this.total = 0.0;
    }
    public void agregarProducto(Mercaderia producto) {
        inventario.add(producto);
    }
    public void mostrarInventario() {
        System.out.println("Inventario Actual:");
        for (Mercaderia producto : inventario) {
            System.out.println("Nombre del producto: " + producto.obtenerNombre() + ", Precio: Q." + producto.obtenerPrecio() + ", Existencias Actuales: " + producto.obtenerExistenciasActuales());
        }
    }
    public void ventas(String nombreMercaderia, int cantidad) {
        for (Mercaderia producto : inventario) {
            if (producto.obtenerNombre().equals(nombreMercaderia)) {
                if (producto.obtenerExistenciasActuales() >= cantidad) {
                    double valorVenta = producto.calcularValorVenta(cantidad);
                    System.out.println("Venta realizada: " + cantidad + " unidades de " + producto.obtenerNombre() + " por Q." + valorVenta);
                    producto.reducirExistencias(cantidad);
                    total += valorVenta;
                } else {
                    System.out.println("No hay suficiente stock para la venta de " + producto.obtenerNombre());
                }
                return;
            }
        }
        System.out.println("Producto '" + nombreMercaderia + "' no encontrado en el inventario");
    }
    public double total() {
        return total;
    }
}
public class Main {
    public static void main(String[] args) {
        Mercaderia producto1 = new Mercaderia("Microondas", 675.0, 15);
        Mercaderia producto2 = new Mercaderia("Nevera", 820.0, 4);
        TiendaVirtual tienda = new TiendaVirtual();
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.mostrarInventario();
        tienda.ventas("Microondas", 5);
        tienda.ventas("Nevera", 3);
        System.out.println("--------------------------------------------------------");
        System.out.println("Total de Ventas Realizadas en Super Gangas: Q." + tienda.total());
        System.out.println("--------------------------------------------------------");
        tienda.mostrarInventario();
    }
}
