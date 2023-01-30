import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexion
{
    public conexion()
    {
        try
        {
            /*
            * CONEXION A LA BD
            */

            //Registro del driver de MYSQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba_1", "root", "esfot123");
            //Stament de consulta
            Statement s = conexion.createStatement();
            //Realizacion de la consulta
            //El resultado se guarda en "rs"
            ResultSet rs = s.executeQuery("SELECT * FROM estudiantes");
            while (rs.next())
            {
                System.out.println(rs.getString("NombrePr1") + " " + rs.getString("CelularPr1"));
            }
            //Cierra la BD, siempre
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
