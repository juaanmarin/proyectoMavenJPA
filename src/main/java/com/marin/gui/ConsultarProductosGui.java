package com.marin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.marin.aplicacion.Coordinador;
import com.marin.entidades.PersonasProductos;
import com.marin.entidades.Producto;

import java.awt.Color;

public class ConsultarProductosGui extends JDialog implements ActionListener {

	private JPanel miPanel;
	private JTextArea AreaResultado;
	private JTextField textIdProducto;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private Coordinador miCoordinador;
	private JTextField textIdPersona;
	private JButton btnComprar;

	
	public ConsultarProductosGui() {
		setBounds(100, 100, 474, 284);
		setLocationRelativeTo(null);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel etiTitulo = new JLabel("Gestion Productos");
		etiTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		etiTitulo.setBounds(150, 11, 176, 20);
		miPanel.add(etiTitulo);
		
		AreaResultado = new JTextArea();
		AreaResultado.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(AreaResultado, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(25, 42, 423, 105);
		miPanel.add(scroll);
		
		JLabel etiidProducto = new JLabel("Id Producto:");
		etiidProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiidProducto.setBounds(25, 169, 86, 20);
		miPanel.add(etiidProducto);
		
		textIdProducto = new JTextField();
		textIdProducto.setBounds(114, 170, 86, 20);
		miPanel.add(textIdProducto);
		textIdProducto.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(Color.GREEN);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(25, 215, 86, 23);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(362, 215, 86, 23);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
		
		JLabel etiIdPersona = new JLabel("Id Persona:");
		etiIdPersona.setFont(new Font("Tahoma", Font.BOLD, 12));
		etiIdPersona.setBounds(240, 169, 86, 20);
		miPanel.add(etiIdPersona);
		
		textIdPersona = new JTextField();
		textIdPersona.setColumns(10);
		textIdPersona.setBounds(338, 170, 110, 20);
		miPanel.add(textIdPersona);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setBackground(Color.GREEN);
		btnComprar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComprar.setBounds(114, 215, 86, 23);
		btnComprar.addActionListener(this);
		miPanel.add(btnComprar);
	}

	

	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == btnConsultar) {
			List<Producto> productos = miCoordinador.consultarTodosProductos();
			AreaResultado.setText(""+productos);
			
		}
		
		
		else if(e.getSource() == btnComprar) {
			
			if(textIdProducto.getText().equals("") || textIdPersona.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor para comprar llene el Campo de ID Producto y ID persona","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				PersonasProductos producto = null;
				
				Long personaId = Long.parseLong(textIdPersona.getText());
				Long productoId = Long.parseLong(textIdProducto.getText());
				
				producto = new PersonasProductos();
				producto.setPersonaId(personaId);
				producto.setProductoId(productoId);
				
				String res = miCoordinador.registrarCompra(producto);
				
				if (res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Compra Exitoso!");
					limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null,res+", verifique que el la persona este registrada y el producto","ERROR",JOptionPane.ERROR_MESSAGE );
				}
				
			}
		}
		
		
		
		
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}

	private void limpiar() {
		textIdPersona.setText("");
		textIdProducto.setText("");
		AreaResultado.setText("");
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
		
	}
}
