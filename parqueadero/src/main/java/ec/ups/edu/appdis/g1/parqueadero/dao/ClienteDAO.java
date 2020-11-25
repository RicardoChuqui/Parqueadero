package ec.ups.edu.appdis.g1.parqueadero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.ups.edu.appdis.g1.parqueadero.modelo.Cliente;

public class ClienteDAO {
	
 private Connection con;
	public boolean insert(Cliente entity) throws SQLException {
		String sql = "Insert into CLIENTE (dni,email,nombre,tipoDocumento)" + "Values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, entity.getDni());
		ps.setString(2, entity.getEmail());
		ps.setString(3, entity.getNombre());
		ps.setInt(4, entity.getTipoDocumento());
		
		ps.executeUpdate();
		ps.close();
		return true;
	}
	
	public List<Cliente> read() throws SQLException {
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=null;
		
	
		
		List<Cliente> listaCliente= new ArrayList<Cliente>();
		
		try {			
			
			
			rs=ps.executeQuery(sql);
			while (rs.next()) {
				Cliente c=new Cliente();
				c.setDni(rs.getString(1));
				c.setEmail(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setTipoDocumento(rs.getInt(4));
				listaCliente.add(c);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
 
	public boolean actualizar(Cliente cliente) throws SQLException {
		
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET dni='"+cliente.getDni()+"', nombres='"+cliente.getNombre()+"', tipoDucumento='"+cliente.getTipoDocumento()+"'" +" WHERE ID="+cliente.getDni();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			
			ps.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDao método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	public boolean eliminar(Cliente cliente) throws SQLException {
		Connection connect= null;
		
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getDni();
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			
		
			ps.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}

