public class Vista {

    private final String[] menuOptions = {
        "===== MEDIA MANAGER =====",
        "1. Ver contenido",
        "2. Agregar contenido",
        "3. Eliminar contenido",
        "4. Buscar contenido",
        "5. Generar reporte",
        "6. Salir",
        "========================="
    };
    
    public void printMenu() {
        // El menú está disponible en menuOptions
    }
    
    public String[] getMenuOptions() {
        return menuOptions;
    }
}
