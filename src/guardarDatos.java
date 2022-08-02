import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
public class guardarDatos {
	
	public void guardar(String id,String nombre,String apellidoP,String apellidoM,String calle,String nCasa,String colonia)
	{
		boolean band = true;
		String arrCampos[] = {id,nombre,apellidoP,apellidoM,calle,nCasa,colonia};
		for(int i = 0; arrCampos.length > i; i++)
		{
			if(arrCampos[i].equals(""))
			{
				JOptionPane.showMessageDialog(null,"Favor de llenar todos los campos");
				i = arrCampos.length;
				band = false;
			}
		}
		if(band)
		{
			if(ComprobarId(id))
			{
				try {
			        Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebas_dp","root", "");
			
			        // Se crea un Statement, para realizar la consulta
			        Statement s = conexion.createStatement();
			
			        // Se realiza la consulta.
			        //Los resultados se alamcenarán en el
			        // ResultSet rs
			        ResultSet rs = s.executeQuery("call PROC_AGREGARDISTRIBUIDOR ('"+id+"',CURRENT_DATE,'"+nombre+"','"+apellidoP+"','"+apellidoM+"','"+calle+"','"+nCasa+"','"+colonia+"');");
			        // Se cierra la conexión con la base de datos.
			        conexion.close();
			        JOptionPane.showMessageDialog(null,"Usuario agregado con exito!");
			    } catch (Exception e) {
			        System.out.println("Error: " + e.getMessage());
			    }
			}
			else
			{
				JOptionPane.showMessageDialog(null,"El id proporcionado ya existe");
			}
		}
	}
	public boolean ComprobarId(String id)
	{
		boolean retorno = false;
		 try {
	            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pruebas_dp","root", "");

	            // Se crea un Statement, para realizar la consulta
	            Statement s = conexion.createStatement();

	            // Se realiza la consulta.
	            //Los resultados se alamcenarán en el
	            // ResultSet rs
	            ResultSet rs = s.executeQuery("select fnConsultarId('"+id+"') as id");
	            //System.out.println(rs);

	            // Se recorre el ResultSet haciendo uso de while.
	           while (rs.next()) {
	               // System.out.println(rs.getString("id"));
	                //System.out.println(rs.getInt("id"));
	        	   int algo = rs.getInt("id");
	                System.out.println(algo);
	        	   if(algo == 0)
		            {
		            	retorno = true;
		            }
	               
	            }
	           	

	            // Se cierra la conexión con la base de datos.
	            conexion.close();
	            
	            
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
		return retorno;
	}
	
}
