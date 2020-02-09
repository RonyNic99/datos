import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response = 0;

        do {
            System.out.println("----------------");
            System.out.println("Aplicacion de mensaje");
            System.out.println("1. Crear un mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Editar un mensaje");
            System.out.println("4. Eleminar un mensaje");
            System.out.println("0. Salir");
            //Leer la opcion del ususario
            response = sc.nextInt();
            switch (response){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    System.out.printf("Selecione una opcion valida");
                    break;
            }
        }while (response != 0);

    }
}
