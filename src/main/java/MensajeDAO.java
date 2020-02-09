import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db = new Conexion();
        try(Connection connection = db.getConnection()) {
            PreparedStatement ps = null;
            try {
                //query de consulta
                String query = "insert into mensajesapp.mensaje (mensaje, autor_mensaje) value (?,?)";
                //Pasar el query como paramentro
                ps = connection.prepareStatement(query);
                //Asigar los signos de interogacion del query
                ps.setString(1,mensaje.getMensaje());
                ps.setString(2,mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.printf("El mensaje fue creado corretamente");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void leerMensajeDB(){
        Conexion db = new Conexion();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connection = db.getConnection()){
            String query = "select * from  mensajesApp.mensaje";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("Id: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor de el: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }

        } catch (SQLException e) {
            System.out.printf("No se pudieron recuperar los mensajes");
            e.printStackTrace();
        }

    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db = new Conexion();
        try(Connection connection = db.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "update mensajesApp.mensaje set mensajesApp.mensaje.mensaje = ? where mensajesApp.mensaje.id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1,mensaje.getMensaje());
                ps.setInt(2,mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("El mensaje a sido actualizado exitosamente");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("No se pudo actualizar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void eliminarMensajeDB(int id_mensaje){
        Conexion db = new Conexion();
        try(Connection connection = db.getConnection()){
            PreparedStatement ps = null;
            try {
                String query = "delete from mensajesApp.mensaje where mensaje.id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje a sido borrado");
            } catch (Exception e) {
                System.out.printf("No se pudo borrar el dato");
                e.printStackTrace();
            }

        }catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
