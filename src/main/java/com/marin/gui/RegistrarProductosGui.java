package com.marin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.marin.aplicacion.Coordinador;
import com.marin.entidades.Producto;



public class RegistrarProductosGui extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 235);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 76, 380, 109);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 43, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(271, 66, 89, 23);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 66, 89, 23);
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(33, 49, 63, 21);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(92, 49, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(194, 49, 71, 21);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(270, 49, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar) {
			if(txtNombre.getText().equals("") || txtPrecio.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor llene todos los campos","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				Producto miProducto = new Producto();
				miProducto.setNombreProducto(txtNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
				
				System.out.println(miProducto);
				
				String res = miCoordinador.registrarProducto(miProducto);
				
				if (res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Registro Exitoso!");
					limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null,"No spudo registrar, intente de nuevo","ERROR",JOptionPane.ERROR_MESSAGE );

				}

			}
			
		}
		
		
		else if(e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}

	public void limpiar() {
		txtNombre.setText("");
		txtPrecio.setText("");
	}


	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
