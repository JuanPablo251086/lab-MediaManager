public class Video extends Content implements IAudio, IPlayable, IDisplayable {
    private String calidad;

    public Video() {}

    public void Play() {}

    @Override
    public void modificarVolumen() {}

    @Override
    public void cambiarVelocidad() {}

    @Override
    public void play() {}

    @Override
    public void stop() {}

    @Override
    public String getVideoProperties() { return ""; }

    @Override
    public void mostrar() {}

    @Override
    public int getLargo() { return 0; }
}
