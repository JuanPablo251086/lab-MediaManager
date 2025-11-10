public class Imagen extends Content {
    private String nombre;

    public Imagen() {
        super();
    }

    public void zoomear(int nivel) {
        System.out.println("Haciendo zoom al nivel: " + nivel);
    }

    @Override
    public String contenido() {
        return "Imagen: " + nombre;
    }
    
    @Override
    public String eliminar() {
        return "Eliminando imagen: " + nombre;
    }
    
    @Override
    public String publicar() {
        return "Publicando imagen: " + nombre;
    }
    
    @Override
    public String visualizar() {
        return "Visualizando imagen: " + nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
