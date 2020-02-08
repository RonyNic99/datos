import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mensajesapp","root","12345678");
            if (connection != null){
                System.out.printf("Todo bien se logro conectar a la base de datos");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
