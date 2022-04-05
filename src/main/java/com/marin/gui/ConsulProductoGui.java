package com.marin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.marin.aplicacion.Coordinador;
import com.marin.entidades.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

public class ConsulProductoGui extends JDialog implements ActionListener {

	private JPanel miPanel;
	private JLabel lblIdProducto;
	private JTextField textIdProducto;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private Coordinador miCoordinador;

	
	public ConsulProductoGui() {
		setBounds(100, 100, 408, 300);
		miPanel = new JPanel();
		miPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(miPanel);
		miPanel.setLayout(null);
		
		JLabel lbltitulo = new JLabel("Consultar Productos");
		lbltitulo.setForeground(new Color(0, 191, 255));
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltitulo.setBounds(128, 11, 154, 22);
		miPanel.add(lbltitulo);
		
		lblIdProducto = new JLabel("Id Producto");
		lblIdProducto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIdProducto.setBounds(31, 63, 87, 22);
		miPanel.add(lblIdProducto);
		
		textIdProducto = new JTextField();
		textIdProducto.setBounds(128, 65, 114, 20);
		miPanel.add(textIdProducto);
		textIdProducto.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.setBounds(271, 63, 106, 24);
		btnConsultar.addActionListener(this);
		miPanel.add(btnConsultar);
		
		JLabel lblNombrePro = new JLabel("Nombre:");
		lblNombrePro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombrePro.setBounds(31, 124, 73, 22);
		miPanel.add(lblNombrePro);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(31, 157, 73, 22);
		miPanel.add(lblPrecio);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(99, 126, 114, 20);
		miPanel.add(textNombre);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(99, 157, 114, 20);
		miPanel.add(textPrecio);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.setBounds(271, 123, 106, 24);
		btnActualizar.addActionListener(this);
		miPanel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminar.setBounds(271, 156, 106, 24);
		btnEliminar.addActionListener(this);
		miPanel.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(271, 226, 106, 24);
		btnCancelar.addActionListener(this);
		miPanel.add(btnCancelar);
	}


	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConsultar){
			
			if (textIdProducto.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor para consultar llene el Campo de ID Producto","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				Long idProducto = Long.parseLong(textIdProducto.getText());
				
				Producto miProducto = miCoordinador.consultarProducto(idProducto);
				
				String precio = Double.toString(miProducto.getPrecioProducto());
				
				if (miProducto != null) {
					System.out.println(miProducto);
					
					textNombre.setText(miProducto.getNombreProducto());
					textPrecio.setText(precio);
				
				}else {
					JOptionPane.showMessageDialog(null,"No se encuentra el producto, verifique el id del producto","ADVERTENCIA!!!",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
		else if (e.getSource() == btnActualizar) {
			
			if (textIdProducto.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor para Actualizar llene el Campo de ID Producto y consulte","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				Long idProducto = Long.parseLong(textIdProducto.getText());
				
				Producto miProducto = miCoordinador.consultarProducto(idProducto);
				
				miProducto.setNombreProducto(textNombre.getText());
				miProducto.setPrecioProducto(Double.parseDouble(textPrecio.getText()));
				
				String res = miCoordinador.actualizarProducto(miProducto, idProducto);
				
				if (res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Actualización Exitosa!");
					limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No se pudo Actualizacion el Producto" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}
		}
		
		
		else if (e.getSource() == btnEliminar) {
			
			if (textIdProducto.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Por favor para Eliminar llene el Campo de ID Producto y consulte","Campos incompletos",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				
				Long idProducto = Long.parseLong(textIdProducto.getText());
				
				Producto miProducto = miCoordinador.consultarProducto(idProducto);
				
				String res = miCoordinador.eliminarProducto(miProducto, idProducto);
				
				if (res.equals("ok")) {
					JOptionPane.showMessageDialog(null, "Eliminacion Exitosa!");
					limpiar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No se pudo Eliminar el Producto" ,"ERROR" ,JOptionPane.ERROR_MESSAGE );
				}
			}
		}
		
		else if (e.getSource() == btnCancelar) {
			setVisible(false);
		}
		
	}


	private void limpiar() {
		textIdProducto.setText("");
		textNombre.setText("");
		textPrecio.setText("");
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
