import java.util.ArrayList;

public abstract class Content implements Comparable {
    protected ArrayList<Etiqueta> etiqueta;
    protected int age;
    protected String genere;

    public Content() {
        this.etiqueta = new ArrayList<>();
    }

    //Getters y Setters
    public ArrayList<String> getEtiqueta() {
        return etiqueta;
    }
    
    public void setEtiqueta(ArrayList<String> etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public abstract String contenido() {}

    public abstract void eliminar() {}

    public abstract void publicar() {}

    public abstract void visualizar() {}

    @Override
    public int compareTo(Content other) { return this.id - content.id;; }
}
