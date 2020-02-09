import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Escribe tu mensaje");
        String contenidoMensaje = sc.nextLine();
        System.out.printf("Nombre del autor");
        String autor_mensaje = sc.nextLine();
        Mensajes mensaje = new Mensajes();
        mensaje.setMensaje(contenidoMensaje);
        mensaje.setAutor_mensaje(autor_mensaje);

        MensajeDAO.crearMensajeDB(mensaje);
    }
    public static void listarMensaje(){
        MensajeDAO.leerMensajeDB();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajeDAO.eliminarMensajeDB(id_mensaje);
    }
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String nuevoMensaje = sc.nextLine();
        System.out.println("Escribe el id del mensaje que quieres actualizar");
        int id_mensaje = sc.nextInt();
        Mensajes mensaje = new Mensajes();
        mensaje.setMensaje(nuevoMensaje);
        mensaje.setId_mensaje(id_mensaje);
        MensajeDAO.actualizarMensajeDB(mensaje);
    }
}
