package com.marin.aplicacion;

import com.marin.dao.MascotaDao;
import com.marin.dao.PersonaDao;
import com.marin.dao.ProductoDao;
import com.marin.gui.ConsulProductoGui;
import com.marin.gui.ConsultarMascotasGui;
import com.marin.gui.ConsultarPersonaGui;
import com.marin.gui.ConsultarProductosGui;
import com.marin.gui.RegistrarMascotasGui;
import com.marin.gui.RegistrarPersonasGui;
import com.marin.gui.RegistrarProductosGui;
import com.marin.gui.TotalDePersonasRegistradas;
import com.marin.gui.VentanaPrincipal;

public class Relaciones {

	VentanaPrincipal miVentanaPrincipal;
	
	public Relaciones() {
		
		Coordinador miCoordinador;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;	
		ConsultarPersonaGui miConsultarPersonaGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ConsultarProductosGui miConsultarProductosGui;
		ConsulProductoGui miConsulProductoGui;	
		TotalDePersonasRegistradas miTotalDePersonasRegistradas;		
		PersonaDao miPersonaDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		
		miVentanaPrincipal = new VentanaPrincipal();
		miCoordinador = new Coordinador();
		miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui = new RegistrarProductosGui(miVentanaPrincipal, true);	
		miConsultarPersonaGui = new ConsultarPersonaGui();
		miConsultarMascotasGui = new ConsultarMascotasGui();
		miConsultarProductosGui = new ConsultarProductosGui();
		miConsulProductoGui = new ConsulProductoGui();		
		miTotalDePersonasRegistradas = new TotalDePersonasRegistradas();		
		miPersonaDao = new PersonaDao();
		miMascotaDao = new MascotaDao();
		miProductoDao = new ProductoDao();
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotaGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);	
		miCoordinador.setConsultarPersonaGui(miConsultarPersonaGui);
		miCoordinador.setConsultarMascotaGui(miConsultarMascotasGui);
		miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
		miCoordinador.setConsultarProductosGui(miConsulProductoGui);	
		miCoordinador.setTotalDePersonasRegistradas(miTotalDePersonasRegistradas);		
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setProductoDao(miProductoDao);
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miConsultarProductosGui.setCoordinador(miCoordinador);
		miConsulProductoGui.setCoordinador(miCoordinador);
		miTotalDePersonasRegistradas.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
	}
	
	public void iniciar() {
		miVentanaPrincipal.setVisible(true);
	}

}
