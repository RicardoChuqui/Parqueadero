package ec.ups.edu.appdis.g1.parqueadero.modelo;

import java.util.Date;

public class Ticket {
	private int codigo;
	private Date FechaIngreso;
	private Date FechaSalida;
	private int tiempo;
	private double valor;
	private Vehiculo vehiculo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFechaIngreso() {
		return FechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		FechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
