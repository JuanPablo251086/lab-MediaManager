public class Podcast extends Content implements IAudio {
    private double largoAudio;
    private double decibellesMedios;
    private int volumen;
    private double velocidad;
    private boolean reproduciendo;
    private boolean publicado;
    
    public Podcast() {
        super();
        this.volumen = 50;
        this.velocidad = 1.0;
        this.reproduciendo = false;
        this.publicado = false;
    }
    
    public void reproducir() {
        this.reproduciendo = true;
    }
    
    public void detener() {
        this.reproduciendo = false;
    }

    @Override
    public void modificarVolumen() {
        // El volumen se modifica a través del setter
    }
    
    @Override
    public void cambiarVelocidad() {
        // La velocidad se modifica a través del setter
    }
    
    @Override
    public String contenido() {
        return "Podcast - Duración: " + largoAudio + " minutos - Volumen: " + volumen + "% - Velocidad: " + velocidad + "x";
    }
    
    @Override
    public void eliminar() {
        this.reproduciendo = false;
        this.publicado = false;
        this.largoAudio = 0;
    }

    @Override
    public void publicar() {
        this.publicado = true;
    }
    
    @Override
    public void visualizar() {
        // La visualización se realiza a través del método contenido()
    }


    //Getters y Setters
    public double getLargoAudio() {
        return largoAudio;
    }
    
    public void setLargoAudio(double largoAudio) {
        this.largoAudio = largoAudio;
    }
    
    public double getDecibellesMedios() {
        return decibellesMedios;
    }
    
    public void setDecibellesMedios(double decibellesMedios) {
        this.decibellesMedios = decibellesMedios;
    }
    
    public int getVolumen() {
        return volumen;
    }
    
    public void setVolumen(int volumen) {
        if (volumen >= 0 && volumen <= 100) {
            this.volumen = volumen;
        }
    }
    
    public double getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(double velocidad) {
        if (velocidad > 0 && velocidad <= 3.0) {
            this.velocidad = velocidad;
        }
    }
    
    public boolean isReproduciendo() {
        return reproduciendo;
    }
    
    public boolean isPublicado() {
        return publicado;
    }
}
