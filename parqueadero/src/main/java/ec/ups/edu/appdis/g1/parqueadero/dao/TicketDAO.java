package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;
import ec.ups.edu.appdis.g1.parqueadero.modelo.Ticket;

public class TicketDAO {
	 private Connection con;

	public boolean insert(Ticket entity) throws SQLException {
		String sql = "Insert into TICKET (codigo,fachaIngreso,fechaSalida,tiempo,valor)" + "Values (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, entity.getCodigo());
		ps.setDate(2, (Date) entity.getFechaIngreso());
		ps.setDate(3, (Date) entity.getFechaSalida());
		ps.setInt(4, entity.getTiempo());
		ps.setDouble(5, entity.getValor());
		
		ps.executeUpdate();
		ps.close();
		return true;
	}
	public List<Ticket> read() throws SQLException {
		String sql="SELECT * FROM TICKET ORDER BY ID";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=null;
		
	
		
		List<Ticket> listaTicket= new ArrayList<Ticket>();
		
		try {			
			
			
			rs=ps.executeQuery(sql);
			while (rs.next()) {
				Ticket t=new Ticket();
				t.setCodigo(rs.getInt(1));
				t.setFechaIngreso(rs.getDate(2));
				t.setFechaSalida(rs.getDate(3));
				t.setTiempo(rs.getInt(4));
				t.setValor(rs.getDouble(5));
				listaTicket.add(t);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaTicket;
	}
	
	public boolean update(Ticket ticket) throws SQLException {
		boolean actualizar=false;
		
		String sql="UPDATE TICKET SET fechaIngreso='"+ticket.getFechaIngreso()+"', fechaSalida='"+ticket.getFechaSalida()+"', valor='"+ticket.getValor()+"'" +" WHERE ID="+ticket.getCodigo();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			
			ps.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase TicketDao método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	public Ticket read(int id) {
		return null;
	}
	public boolean delete(int id) {
		return true;
	}
}
