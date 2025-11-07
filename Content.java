import java.util.ArrayList;

public abstract class Content implements Comparable {
    protected ArrayList<Etiqueta> etiqueta;
    protected int age;
    protected String genere;

    public Content() {}

    public void contenido() {}

    public void eliminar() {}

    public void publicar() {}

    public void visualizar() {}

    @Override
    public int compareTo(Content other) { return 0; }
}
