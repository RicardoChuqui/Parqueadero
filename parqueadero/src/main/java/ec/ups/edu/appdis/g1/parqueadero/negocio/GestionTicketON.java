package ec.ups.edu.appdis.g1.parqueadero.negocio;

import java.sql.SQLException;

import javax.inject.Inject;

import ec.ups.edu.appdis.g1.parqueadero.dao.ClienteDAO;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Ticket;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Vehiculo;

public class GestionTicketON {

	 @Inject
	private ClienteDAO clientedao;
	public boolean registrarTicket(Ticket ticket) {
		return true;
	}
	public Ticket salidaVehiculo(int idTicket) {
		return null;
	}
	public double  calcularTiempo(int idTicket) {
		return 0;
	}
	public boolean registrarCliente(Cliente cliente) {
		 try {
			clientedao.insert(cliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	public Vehiculo buscarVehiculo(String placa) {
		return null;
	}
}
