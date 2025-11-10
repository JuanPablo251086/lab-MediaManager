public class Video extends Content implements IAudio, IPlayable, IDisplayable {
    private String calidad;
    private double duracion;
    private boolean reproduciendo;
    private boolean publicado;
    private int tiempoActual;
    
    public Video() {
        super();
        this.reproduciendo = false;
        this.publicado = false;
        this.tiempoActual = 0;
    }
    
    @Override
    public void play() {
        this.reproduciendo = true;
    }
    
    @Override
    public void stop() {
        this.reproduciendo = false;
        this.tiempoActual = 0;
    }
    
    public void pause() {
        this.reproduciendo = false;
    }
    
    @Override
    public String getVideoProperties() {
        return "Calidad: " + calidad + ", Género: " + getGenere() + ", Duración: " + duracion + " min";
    }
    
    @Override
    public String contenido() {
        return "Video - Calidad: " + calidad + " - Duración: " + duracion + " min - Estado: " + (reproduciendo ? "Reproduciendo" : "Detenido");
    }
    
    @Override
    public void eliminar() {
        this.stop();
        this.publicado = false;
        this.calidad = null;
        this.duracion = 0;
    }
    
    @Override
    public void publicar() {
        this.publicado = true;
    }
    
    @Override
    public void visualizar() {
        this.play();
    }
    
    public String getCalidad() {
        return calidad;
    }
    
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }
    
    public double getDuracion() {
        return duracion;
    }
    
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    public boolean isReproduciendo() {
        return reproduciendo;
    }
    
    public boolean isPublicado() {
        return publicado;
    }
    
    public int getTiempoActual() {
        return tiempoActual;
    }
    
    public void setTiempoActual(int tiempoActual) {
        this.tiempoActual = tiempoActual;
    }
}
