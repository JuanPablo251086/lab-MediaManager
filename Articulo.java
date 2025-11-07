public class Articulo extends Content implements IDisplayable {
    private String nombre;
    private int numPaginas;

    public Articulo() {}

    @Override
    public void mostrar() {}

    @Override
    public int getLargo() { return 0; }
}
