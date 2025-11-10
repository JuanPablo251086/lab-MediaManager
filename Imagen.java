public class Imagen extends Content {
    private String nombre;
    private int ancho;
    private int alto;
    private int nivelZoom;
    private boolean publicada;
    
    public Imagen() {
        super();
        this.nivelZoom = 100;
        this.publicada = false;
    }
    
    public void zoomear(int nivel) {
        if (nivel > 0 && nivel <= 500) {
            this.nivelZoom = nivel;
        }
    }
    
    @Override
    public String contenido() {
        return "Imagen: " + nombre + " (" + ancho + "x" + alto + ") - Zoom: " + nivelZoom + "%";
    }

    @Override
    public void eliminar() {
        this.nombre = null;
        this.ancho = 0;
        this.alto = 0;
        this.publicada = false;
    }
    
    @Override
    public void publicar() {
        this.publicada = true;
    }
    
    @Override
    public void visualizar() {
        // La visualización se realiza a través del método contenido()
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public int getAlto() {
        return alto;
    }
    
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    public int getNivelZoom() {
        return nivelZoom;
    }
    
    public boolean isPublicada() {
        return publicada;
    }
}
