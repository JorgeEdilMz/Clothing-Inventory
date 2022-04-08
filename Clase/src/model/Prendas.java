package model;

public class Prendas {

	private String nombre;
	private String color;
	private int codigo;
	private int talla;
	private int cantidad;
	private int precioCompra;
	private int precioVenta;

	public Prendas(String pNombre, String pColor, int pCodigo, int pTalla, int pCantidad, int pPrecioCompra, int pPrecioVenta) {
		nombre = pNombre;
		color = pColor;
		codigo = pCodigo;
		talla = pTalla;
		cantidad = pCantidad;
		precioCompra = pPrecioCompra;
		precioVenta = pPrecioVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Prendas{" +
				"nombre='" + nombre + '\'' +
				", color='" + color + '\'' +
				", codigo=" + codigo +
				", cantidad=" + cantidad +
				'}';
	}
}
