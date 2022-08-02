import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmPersona extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtApellidoP;
	private JTextField txtApellidoM;
	private JTextField txtNCasa;
	private JTextField txtCalle;
	private JTextField txtColonia;
	private JButton btnLimpiar;
	private JButton btnConsultar;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtConsultar;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPersona frame = new frmPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 
	}

	/**
	 * Create the frame.
	 */
	public frmPersona() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID distribuidor");
		lblNewLabel.setBounds(23, 34, 97, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre(s)");
		lblNewLabel_1.setBounds(23, 71, 81, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Primer apellido");
		lblNewLabel_2.setBounds(23, 113, 97, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Segundo apellido");
		lblNewLabel_3.setBounds(23, 153, 108, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Calle");
		lblNewLabel_4.setBounds(262, 40, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero de casa");
		lblNewLabel_5.setBounds(262, 75, 97, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Colonia");
		lblNewLabel_6.setBounds(262, 116, 49, 20);
		contentPane.add(lblNewLabel_6);
		
		txtID = new JTextField();
		txtID.setBounds(130, 37, 96, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 76, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidoP = new JTextField();
		txtApellidoP.setBounds(130, 116, 96, 20);
		contentPane.add(txtApellidoP);
		txtApellidoP.setColumns(10);
		
		txtApellidoM = new JTextField();
		txtApellidoM.setBounds(130, 156, 96, 20);
		contentPane.add(txtApellidoM);
		txtApellidoM.setColumns(10);
		
		txtNCasa = new JTextField();
		txtNCasa.setBounds(371, 76, 96, 20);
		contentPane.add(txtNCasa);
		txtNCasa.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(371, 37, 96, 20);
		contentPane.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtColonia = new JTextField();
		txtColonia.setBounds(371, 116, 96, 20);
		contentPane.add(txtColonia);
		txtColonia.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Asignar valores a variables
			    String id = txtID.getText();
			    String nombre = txtNombre.getText();
			    String apellidoP = txtApellidoP.getText();
			    String apellidoM = txtApellidoM.getText();
			    String calle = txtCalle.getText();
			    String nCasa = txtNCasa.getText();
			    String colonia = txtColonia .getText();
				guardarDatos obj = new guardarDatos();
				obj.guardar(id,nombre,apellidoP,apellidoM,calle,nCasa,colonia);
				System.out.println();
			}
		});
		btnNewButton.setBounds(378, 156, 89, 23);
		contentPane.add(btnNewButton);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setText("");
				txtNombre.setText("");
				txtApellidoP.setText("");
				txtApellidoM.setText("");
				txtCalle.setText("");
				txtNCasa.setText("");
				txtColonia.setText("");
			}
		});
		btnLimpiar.setBounds(477, 155, 89, 23);
		contentPane.add(btnLimpiar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*frmConsultar verForm = new frmConsultar();
				verForm.setVisible(true);*/
				consultarDatos consultar = new consultarDatos();
				consultar.consultarID(txtConsultar.getText());
			}
		});
		btnConsultar.setBounds(286, 312, 135, 23);
		contentPane.add(btnConsultar);
		
		lblNewLabel_7 = new JLabel("AGREGAR DISTRIBUIDORES");
		lblNewLabel_7.setBounds(243, 11, 259, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("CONSULTAR DISTRIBUIDORES");
		lblNewLabel_8.setBounds(262, 239, 226, 23);
		contentPane.add(lblNewLabel_8);
		
		txtConsultar = new JTextField();
		txtConsultar.setBounds(286, 273, 135, 20);
		contentPane.add(txtConsultar);
		txtConsultar.setColumns(10);
		
		lblNewLabel_9 = new JLabel("ID");
		lblNewLabel_9.setBounds(264, 276, 27, 14);
		contentPane.add(lblNewLabel_9);
	}
}
