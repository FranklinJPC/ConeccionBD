import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        /*
        new conexion();
        JFrame ventana = new JFrame("BD_show");
        ventana.setContentPane(new BD_show().JPanelBD);
        ventana.pack();
        ventana.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        ventana.setVisible(true);
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba_1", "root", "esfot123");
            String query = "SELECT * FROM estudiantes";
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            JTable table = new JTable();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 1; i<= columnCount; i++)
            {
                model.addColumn(rsmd.getColumnName(i));
            }
            while (rs.next())
            {
                Object[] row = new Object[columnCount];
                for (int i = 1; i<=columnCount; i++)
                {
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            JFrame ventana = new JFrame();
            ventana.add(new JScrollPane(table));
            ventana.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            ventana.setVisible(true);

            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rs.close();
            st.close();
            conexion.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}