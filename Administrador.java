public class Administrador extends Usuario {
    private Content contenidoActual;
    private boolean operacionExitosa;
    
    public Administrador() {
        super(0, "", "", 0);
        this.operacionExitosa = false;
    }

    public void eliminar() {
        if (contenidoActual != null) {
            contenidoActual.eliminar();
            contenidoActual = null;
            operacionExitosa = true;
        } else {
            operacionExitosa = false;
        }
    }

    public void publicar() {
        if (contenidoActual != null) {
            contenidoActual.publicar();
            operacionExitosa = true;
        } else {
            operacionExitosa = false;
        }
    }

    public void crear() {
        // Crear un nuevo contenido vacío
        operacionExitosa = true;
    }

    public void editar() {
        if (contenidoActual != null) {
            // Modificar el contenido actual
            operacionExitosa = true;
        } else {
            operacionExitosa = false;
        }
    }

    public Content getContenidoActual() {
        return contenidoActual;
    }
    
    public void setContenidoActual(Content contenidoActual) {
        this.contenidoActual = contenidoActual;
    }
    
    public boolean isOperacionExitosa() {
        return operacionExitosa;
    }
}
