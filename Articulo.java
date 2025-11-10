public class Articulo extends Content implements IDisplayable {
    private String nombre;
    private int numPaginas;
    private boolean visible;
    private boolean publicado;
    private String contenidoTexto;
    
    public Articulo() {
        super();
        this.visible = false;
        this.publicado = false;
    }
    
    @Override
    public void mostrar() {
        this.visible = true;
    }
    
    public void ocultar() {
        this.visible = false;
    }
    
    @Override
    public int getLargo() {
        return numPaginas;
    }
    
    @Override
    public String contenido() {
        return "Artículo: " + nombre + " (" + numPaginas + " páginas) - " + (publicado ? "Publicado" : "No publicado");
    }
    
    @Override
    public void eliminar() {
        this.visible = false;
        this.publicado = false;
        this.nombre = null;
        this.numPaginas = 0;
        this.contenidoTexto = null;
    }
    
    @Override
    public void publicar() {
        this.publicado = true;
    }
    
    @Override
    public void visualizar() {
        this.mostrar();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNumPaginas() {
        return numPaginas;
    }
    
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public boolean isPublicado() {
        return publicado;
    }
    
    public String getContenidoTexto() {
        return contenidoTexto;
    }
    
    public void setContenidoTexto(String contenidoTexto) {
        this.contenidoTexto = contenidoTexto;
    }
}
