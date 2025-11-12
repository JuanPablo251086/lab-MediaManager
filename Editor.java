public class Editor extends Usuario {
    private Content contenidoEnEdicion;
    private boolean puedeCrear;
    private int contadorCreaciones;
    
    public Editor() {
        super(0, "", "", 0);
        this.puedeCrear = true;
        this.contadorCreaciones = 0;
    }

    public void crear() {
        if (puedeCrear) {
            // Crear nuevo contenido
            contadorCreaciones++;
        }
    }

    public void editar() {
        if (contenidoEnEdicion != null) {
            // Editar el contenido asignado
        }
    }
}
