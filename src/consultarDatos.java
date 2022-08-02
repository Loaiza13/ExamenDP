import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class consultarDatos {
	public void consultarID(String id)
	{
		try {
	        Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebas_dp","root", "");
	
	        // Se crea un Statement, para realizar la consulta
	        Statement s = conexion.createStatement();
	
	        // Se realiza la consulta.
	        //Los resultados se alamcenarán en el
	        // ResultSet rs
	        ResultSet rs = s.executeQuery("call consultarDatosDistribuidor('"+id+"')");
	        int cont = 0;
	        while (rs.next()) {
	        		cont ++;
	               // System.out.println(rs.getString("id"));
	                //System.out.println(rs.getInt("id"));
	        		String datos = rs.getString("nombre_completo") + " " + rs.getString("Calle") + " " + rs.getString("Numero_de_casa") + " " + rs.getString("Colonia");
	        		JOptionPane.showMessageDialog(null,datos);
	            }
	        if(cont == 0)
    		{
    			JOptionPane.showMessageDialog(null,"El ID proporcionado no existe");
    		}
	        // Se cierra la conexión con la base de datos.
	        conexion.close();
	        //JOptionPane.showMessageDialog(null,"Usuario agregado con exito!");
	    } catch (Exception e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
}
