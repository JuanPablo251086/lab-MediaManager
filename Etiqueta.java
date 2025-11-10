public class Etiqueta {
    private String nombre;
    private boolean activa;
    
    public Etiqueta() {
        super();
        this.activa = true;
    }
    
    public void getEtiqueta() {
        // Retorna información de la etiqueta a través del getter
    }
    
    @Override
    public String contenido() {
        return "Etiqueta: " + nombre;
    }
    
    @Override
    public void eliminar() {
        this.activa = false;
        this.nombre = null;
    }
    
    @Override
    public void publicar() {
        this.activa = true;
    }
    
    @Override
    public void visualizar() {
        // La visualización se hace a través del método contenido()
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean isActiva() {
        return activa;
    }
}
