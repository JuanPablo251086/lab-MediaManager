import java.util.ArrayList;

public class Sistema {
    private ArrayList<Content> contenidos;
    private ArrayList<Usuario> usuarios;

    public Sistema() {
        this.contenidos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Content> getContenido() {
        return contenidos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void agregarContenido(Content c) {
        if (c != null) {
            contenidos.add(c);
        }
    }

    public void agregarUsuario(Usuario u) {
        if (u != null) {
            usuarios.add(u);
        }
    }

    public ArrayList<String> generarResumen() {
        ArrayList<String> resumen = new ArrayList<>();
        for (Content c : contenidos) {
            StringBuilder info = new StringBuilder();
            info.append("Género: ").append(c.getGenere()).append("\n");
            info.append("Edad: ").append(c.age).append("\n");
            
            if (c.getEtiqueta() != null && !c.getEtiqueta().isEmpty()) {
                info.append("Etiquetas: ");
                for (Object e : c.getEtiqueta()) {
                    info.append(e.toString()).append(", ");
                }
                info.setLength(info.length() - 2); // remover última coma
            } else {
                info.append("Etiquetas: Ninguna");
            }
            info.append("\nContenido: ").append(c.contenido());
            resumen.add(info.toString());
        }
        return resumen;
    }

    public ArrayList<String> generarReporte() {
        return generarResumen(); //nos equivocamos y estos metodos deberian ser iguales, se incluye un shortcut aqui de este
    }

    public Content Buscar(Etiqueta etiqueta) {
        if (etiqueta == null) return null;
        for (Content c : contenidos) {
            if (c.getEtiqueta() != null) {
                for (Object e : c.getEtiqueta()) {
                    if (e instanceof Etiqueta) {
                        Etiqueta et = (Etiqueta) e;
                        if (et.getNombre().equalsIgnoreCase(etiqueta.getNombre())) {
                            return c;
                        }
                    }
                }
            }
        }
        return null;
    }

    public Content Buscar(String nombre) {
        if (nombre == null || nombre.isEmpty()) return null;
        for (Content c : contenidos) {
            if (c.contenido().toLowerCase().contains(nombre.toLowerCase())) {
                return c;
            }
        }
        return null;
    }
}