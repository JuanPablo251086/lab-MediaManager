import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainMediaManager {

    private static Sistema sistema = new Sistema();
    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static HashMap<String, String> contraseñas = new HashMap<>(); // <nombreUsuario, contraseña>
    private static Usuario usuarioActual = null;

    public static void main(String[] args) {
        inicializarUsuarios();
        seedSampleData();
        mostrarLogin();
    }

    // =========================================================
    // LOGIN Y REGISTRO
    // =========================================================
    private static void mostrarLogin() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n===== SISTEMA DE LOGIN =====");
            System.out.println("Usuario admin: Admin  |  Contraseña: 123");
            System.out.println("----------------------------");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar nuevo usuario (Editor)");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    login();
                    break;
                case "2":
                    registrarUsuario();
                    break;
                case "3":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void inicializarUsuarios() {
        Administrador admin = new Administrador();
        admin.setNombre("Admin");
        usuarios.add(admin);
        contraseñas.put("Admin", "123");
    }

    private static void login() {
        System.out.print("Usuario: ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Contraseña: ");
        String pass = scanner.nextLine().trim();

        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                String guardada = contraseñas.get(nombre);
                if (guardada != null && guardada.equals(pass)) {
                    usuarioActual = u;
                    System.out.println("Inicio de sesión exitoso. Bienvenido, " + nombre + " (" + tipoUsuario(u) + ")");
                    menuPrincipal();
                    return;
                }
            }
        }
        System.out.println("Credenciales incorrectas.");
    }

    private static void registrarUsuario() {
        System.out.println("\n=== REGISTRO DE NUEVO EDITOR ===");
        System.out.print("Nombre de usuario: ");
        String nombre = scanner.nextLine().trim();

        for (Usuario u : usuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ese nombre de usuario ya existe.");
                return;
            }
        }

        System.out.print("Contraseña: ");
        String pass = scanner.nextLine().trim();

        Editor nuevo = new Editor();
        nuevo.setNombre(nombre);
        usuarios.add(nuevo);
        contraseñas.put(nombre, pass);

        System.out.println("Usuario registrado con éxito. Ahora puede iniciar sesión como Editor.");
    }

    private static String tipoUsuario(Usuario u) {
        if (u instanceof Administrador)
            return "Administrador";
        if (u instanceof Editor)
            return "Editor";
        return "Desconocido";
    }

    // =========================================================
    // MENÚ PRINCIPAL
    // =========================================================
    private static void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Ver contenido");
            System.out.println("2. Agregar contenido");
            System.out.println("3. Buscar contenido");
            if (usuarioActual instanceof Administrador)
                System.out.println("4. Eliminar contenido");
            System.out.println("5. Generar reporte");
            System.out.println("6. Cerrar sesión");
            System.out.print("Elija una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    verContenido();
                    break;
                case "2":
                    agregarContenido();
                    break;
                case "3":
                    buscarContenido();
                    break;
                case "4":
                    if (usuarioActual instanceof Administrador)
                        eliminarContenido();
                    else
                        System.out.println("Solo el administrador puede eliminar contenido.");
                    break;
                case "5":
                    generarReporte();
                    break;
                case "6":
                    usuarioActual = null;
                    System.out.println("Sesión cerrada.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // =========================================================
    // FUNCIONES DE CONTENIDO
    // =========================================================
    private static void seedSampleData() {
        Articulo art = new Articulo();
        art.setId(1);
        art.setGenere("Educación");
        art.setContenidoTexto("Artículo: Aprende Java desde cero.");
        sistema.getContenido().add(art);

        Imagen img = new Imagen();
        img.setId(2);
        img.setGenere("Fotografía");
        img.setNombre("Atardecer en el mar - 4K");
        img.setAncho(1920);
        img.setAlto(1080);
        sistema.getContenido().add(img);

        Video v = new Video();
        v.setId(3);
        v.setGenere("Entretenimiento");
        v.setCalidad("HD");
        v.setDuracion(15);
        sistema.getContenido().add(v);

        Podcast p = new Podcast();
        p.setId(4);
        p.setGenere("Ciencia");
        p.setLargoAudio(42.5);
        p.setVolumen(70);
        sistema.getContenido().add(p);
    }

    private static void verContenido() {
        ArrayList<Content> lista = sistema.getContenido();
        if (lista.isEmpty()) {
            System.out.println("No hay contenido registrado.");
            return;
        }
        System.out.println("==== CONTENIDO REGISTRADO ====");
        for (Content c : lista) {
            System.out.printf("ID: %d | Tipo: %s | Género: %s | Info: %s%n",
                    c.getId(), c.getClass().getSimpleName(), c.getGenere(), safeContenidoSummary(c));
        }
    }

    private static void agregarContenido() {
        System.out.println("\nSeleccione tipo de contenido a agregar:");
        System.out.println("1. Artículo");
        System.out.println("2. Imagen");
        System.out.println("3. Video");
        System.out.println("4. Podcast");
        System.out.print("Opción: ");
        String tipo = scanner.nextLine().trim();

        int nextId = nextId();
        Content nuevo = null;
        System.out.print("Género: ");
        String genero = scanner.nextLine();

        switch (tipo) {
            case "1":
                Articulo a = new Articulo();
                a.setId(nextId);
                a.setGenere(genero);
                System.out.print("Texto: ");
                a.setContenidoTexto(scanner.nextLine());
                nuevo = a;
                break;
            case "2":
                Imagen im = new Imagen();
                im.setId(nextId);
                im.setGenere(genero);
                System.out.print("Nombre: ");
                im.setNombre(scanner.nextLine());
                System.out.print("Ancho (px): ");
                im.setAncho(parseIntOrDefault(scanner.nextLine(), 1920));
                System.out.print("Alto (px): ");
                im.setAlto(parseIntOrDefault(scanner.nextLine(), 1080));
                nuevo = im;
                break;
            case "3":
                Video v = new Video();
                v.setId(nextId);
                v.setGenere(genero);
                System.out.print("Calidad: ");
                v.setCalidad(scanner.nextLine());
                System.out.print("Duración (min): ");
                v.setDuracion(parseIntOrDefault(scanner.nextLine(), 10));
                nuevo = v;
                break;
            case "4":
                Podcast p = new Podcast();
                p.setId(nextId);
                p.setGenere(genero);
                System.out.print("Duración (min): ");
                p.setLargoAudio(parseDoubleOrDefault(scanner.nextLine(), 30.0));
                p.setVolumen(70);
                nuevo = p;
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }

        sistema.getContenido().add(nuevo);
        System.out.println("Contenido agregado con ID " + nuevo.getId());
    }

    private static int nextId() {
        int max = 0;
        for (Content c : sistema.getContenido()) {
            if (c.getId() > max)
                max = c.getId();
        }
        return max + 1;
    }

    private static int parseIntOrDefault(String s, int def) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    private static double parseDoubleOrDefault(String s, double def) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    private static void eliminarContenido() {
        System.out.print("Ingrese ID a eliminar: ");
        String s = scanner.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            Content toRemove = null;
            for (Content c : sistema.getContenido()) {
                if (c.getId() == id) {
                    toRemove = c;
                    break;
                }
            }
            if (toRemove != null) {
                sistema.getContenido().remove(toRemove);
                try {
                    toRemove.eliminar();
                } catch (Exception e) {
                }
                System.out.println("Contenido eliminado (ID " + id + ").");
            } else {
                System.out.println("No se encontró contenido con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
        }
    }

    private static void buscarContenido() {
        System.out.print("Ingrese texto de búsqueda: ");
        String q = scanner.nextLine().trim().toLowerCase();
        ArrayList<Content> resultados = new ArrayList<>();

        for (Content c : sistema.getContenido()) {
            String data = (safe(c.getGenere()) + " " + safeContenidoSummary(c)).toLowerCase();
            if (data.contains(q))
                resultados.add(c);
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
        } else {
            System.out.println("Coincidencias encontradas:");
            for (Content c : resultados) {
                System.out.printf("ID: %d | Tipo: %s | Género: %s | Info: %s%n",
                        c.getId(), c.getClass().getSimpleName(), c.getGenere(), safeContenidoSummary(c));
            }
        }
    }

    private static void generarReporte() {
        int articulos = 0, imagenes = 0, videos = 0, podcasts = 0;
        for (Content c : sistema.getContenido()) {
            String t = c.getClass().getSimpleName();
            switch (t) {
                case "Articulo":
                    articulos++;
                    break;
                case "Imagen":
                    imagenes++;
                    break;
                case "Video":
                    videos++;
                    break;
                case "Podcast":
                    podcasts++;
                    break;
            }
        }
        System.out.println("==== REPORTE ====");
        System.out.println("Artículos: " + articulos);
        System.out.println("Imágenes:  " + imagenes);
        System.out.println("Videos:    " + videos);
        System.out.println("Podcasts:  " + podcasts);
        System.out.println("Total:     " + sistema.getContenido().size());
    }

    private static String safe(String s) {
        return (s == null || s.isEmpty()) ? "(sin dato)" : s;
    }

    private static String safeContenidoSummary(Content c) {
        try {
            return c.contenido();
        } catch (Exception e) {
            return "(sin descripción)";
        }
    }
}
