package com.marin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.marin.aplicacion.Coordinador;




public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private AbstractButton itemRegistrarPersonas;
	private JMenuItem itemGestonPersonas;
	private JMenuItem itemRegistrarMascotas;
	private JMenuItem itemGestionMascota;
	private JMenuItem itemGestionProducto;
	private JMenuItem itemRegistroProductos;
	private JMenuItem itemListaTotal;
	private Coordinador miCoordinador;
	private JMenuItem itemConsultarProducto;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		iniciarComponentes();	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setResizable(false);
		setTitle("Clinica Veterinaria");
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuPersonas = new JMenu("Gestionar Personas");
		menuBar.add(menuPersonas);
		
		itemRegistrarPersonas = new JMenuItem("Registrar");
		itemRegistrarPersonas.addActionListener(this);
		menuPersonas.add(itemRegistrarPersonas);
		
		itemGestonPersonas = new JMenuItem("Gestion De Personas");
		itemGestonPersonas.addActionListener(this);
		menuPersonas.add(itemGestonPersonas);
		
		itemListaTotal = new JMenuItem("Lista total de Personas");
		itemListaTotal.addActionListener(this);
		menuPersonas.add(itemListaTotal);
		
		
		JMenu MenuMascotas = new JMenu("Gestionar Mascotas");
		menuBar.add(MenuMascotas);
		
		itemRegistrarMascotas = new JMenuItem("Registrar");
		itemRegistrarMascotas.addActionListener(this);
		MenuMascotas.add(itemRegistrarMascotas);
		
		itemGestionMascota = new JMenuItem("Gestion De Mascotas");
		itemGestionMascota.addActionListener(this);
		MenuMascotas.add(itemGestionMascota);
		
		
		JMenu menuProductos = new JMenu("Gestionar Productos");
		menuBar.add(menuProductos);
		
		itemRegistroProductos = new JMenuItem("Registrar");
		itemRegistroProductos.addActionListener(this);
		menuProductos.add(itemRegistroProductos);
		
		itemConsultarProducto = new JMenuItem("Consultar Producto");
		itemConsultarProducto.addActionListener(this);
		menuProductos.add(itemConsultarProducto);
		
		itemGestionProducto = new JMenuItem("Gestion de Productos");
		itemGestionProducto.addActionListener(this);
		menuProductos.add(itemGestionProducto);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("GESTION CLINICA VETERINARIA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/marin/images/CLINICA.jpg")));
		panel.add(lblImagen, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==itemRegistrarPersonas) {
			miCoordinador.mostrarVentanaRegistroPersonas();
		}
		else if (e.getSource()==itemRegistrarMascotas) {
			miCoordinador.mostrarVentanaRegistroMascotas();
		}
		else if (e.getSource()==itemRegistroProductos) {
			miCoordinador.registrarVentanaRegistrarProductos();
		}		
		else if(e.getSource() == itemGestonPersonas) {
			miCoordinador.mostrarVentanaConsultaPersona();
		}
		else if(e.getSource() == itemGestionMascota) {
			 miCoordinador.mostrarVentanaConsultaMascotas();
		}
		else if(e.getSource() == itemConsultarProducto) {
			miCoordinador.mostrarVentanaConsultProducto();
		}
		else if(e.getSource() == itemGestionProducto) {
			miCoordinador.mostrarVentanaConsultarProductos();
		}
		else if (e.getSource() == itemListaTotal) {
			miCoordinador.mostrarVentanaTotalDePersonasRegistradas();
		}
	
	}

	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador=miCoordinador;
	}

}
