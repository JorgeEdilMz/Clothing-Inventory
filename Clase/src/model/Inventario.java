package model;

public class Inventario {

	public static final int NEST=10;
	private Prendas[] prendas;
	private int pos;
	
	public Inventario() {
	  prendas = new Prendas[NEST];
	  pos = 0;
	}
	
	public int agregarPrenda(Prendas pEst) {
	  int posi;
	  if(pos<NEST) {
		prendas[pos] = pEst;
		posi=pos;
		pos++;
	  } else {
		posi = -1;  
	  }		
	  return posi;
	}

	public int buscarPrenda(int cod) {
	   int i, posic=-1;
	   boolean encontrado = false;
	   for(i=0;i<pos&&encontrado!=true;i++) {
		 if(prendas[i].getCodigo() == cod) {
			   encontrado = true;
			   posic = i;
		 }
	   }
	   return posic;
	}
	
	public int buscarPrendaPorCodigo(int pCod) {
	   int i, posic=-1;
	   boolean encontrado = false;
	   for(i=0;i<pos&&encontrado!=true;i++) {
		 if(prendas[i].getCodigo()==pCod) {
		   encontrado = true;
		   posic = i;
		 }
	   }
	   return posic;
	}
	
	public void actualizarPrenda(int pCompra,int pVenta,int can,int pPos) {
       prendas[pPos].setPrecioCompra(pCompra);
       prendas[pPos].setPrecioVenta(pVenta);
       prendas[pPos].setCantidad(can);
	}

	public void actualizarPrendaPorVenta(int can,int pPos) {
		prendas[pPos].setCantidad(can);
	}
	
	public void eliminarPrenda(int pPos) {
	   int i;
	   for(i=pPos;i<pos;i++) {
		 prendas[i] = prendas[i+1];
	   }
	   prendas[pos-1] = null;
	   pos--;
	}
	
	public String listarArreglo() {
	   int i;
	   String cad = "Listado de Prendas\n";
	   for(i=0;i<pos;i++) {
		 cad = cad + prendas[i].toString()+"\n";
	   }
	   return cad;
	}

	public int calcularPrecioCompra(){
		int precioCompra = 0;
		for (int i = 0; i < pos; i++) {
			precioCompra += prendas[i].getPrecioCompra();
		}
		return precioCompra;
	}

	public int calcularPrecioVenta(){
		int precioVenta = 0;
		for (int i = 0; i < pos; i++) {
			precioVenta += prendas[i].getPrecioVenta();
		}
		return precioVenta;
	}

	public Prendas[] getPrendas() {
		return prendas;
	}

	public void setEstudiantes(Prendas[] prendas) {
		this.prendas = prendas;
	}
}
