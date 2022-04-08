package controller;

import model.Inventario;
import model.Prendas;
import view.VistaConsola;

public class Controller {

	private Inventario inventario;
	private Prendas pre;
	private VistaConsola view;
	
	public Controller() {
	   inventario = new Inventario();
	   view = new VistaConsola();
	   funcionar();
	}
	
	public void funcionar() {
	   int opc;
	   String menu = "Bienvenido a la tienda de Ropa\n"+
	                 "1. Ingresar Prendas al inventario\n"+
	                 "2. Modificar prenda\n"+
	                 "3. Actualizar cantidad de prendas\n"+
	                 "4. Buscar prenda por codigo\n"+
			         "5. Eliminar prenda del inventario por codigo \n"+
	                 "6. Listado de Prendas\n"+
	                 "7. Valor total de la compra y venta \n"+
			         "8. Salir\n";
	   do {
	     view.mostrarMensaje(menu);
	     opc = view.leerEntero("Seleccione su opción:");
         switch (opc) {
         case 1:
    	    registrarPrenda();
    	    break;
         case 2:
			modificarPrenda();
    	    break;    	    
         case 3:
         	actualizarPorPrendasVendidas();
    	    break;    	    
         case 4:
    	    buscarPrenda();
    	    break;
         case 5:
    	    eliminarPrenda();
    	    break;
         case 6:
         	listarPrendas();
    	    break;
         case 7:
			calcularValorTotal();
    	    break;
         case 8:
    	    view.mostrarMensaje("Hasta pronto");
    	    break;
         default:
    	    view.mostrarMensaje("Opción incorrecta");
         }
	   }while(opc!=8);
	}

	private void calcularValorTotal() {
		view.mostrarMensaje("Valor total de compras = " + inventario.calcularPrecioCompra() +
							" Valor total de ventas = " + inventario.calcularPrecioVenta());
	}

	public void registrarPrenda() {
	   String nom,col;
	   int cod,talla,can,preCompra,preVenta,posic;
	   view.mostrarMensaje("---Ingrese los datos de la Prenda---");
	   nom = view.leerString("Digite su nombre: ");
	   col = view.leerString("Digite su color: ");
	   cod = view.leerEntero("Digite la codigo: ");
	   talla = view.leerEntero("Digite la talla: ");
	   can = view.leerEntero("Digite la cantidad: ");
	   preCompra = view.leerEntero("DIgite el precio de compra: ");
	   preVenta = view.leerEntero("DIgite el precio de venta: ");
	   pre = new Prendas(nom,col,cod,talla,can,preCompra,preVenta);
	   posic = inventario.agregarPrenda(pre);
	   if(posic < 0) {
		 view.mostrarMensaje("No se pudo agregar la prenda");
	   }
	}
	
	public void buscarPrenda() {
	   int cod,posic;
	   cod = view.leerEntero("Digite el código de la prenda a buscar:");
	   posic = inventario.buscarPrendaPorCodigo(cod);
	   if(posic<0)
		 view.mostrarMensaje("La prenda con código "+cod+" no fue encontrado");
	   else {
		 view.mostrarMensaje(inventario.getPrendas()[posic].toString());
	   }	 
	}
	public void modificarPrenda() {
		int posic;
		int cod;
		int pCompra;
		int pVenta;
		int can;
		cod = view.leerEntero("Digite el codigo de la prenda a modificar:");
		posic = inventario.buscarPrenda(cod);
		if (posic < 0)
			view.mostrarMensaje("La prenda " + cod + " no fue encontrado");
		else {
			pCompra = view.leerEntero("Digite el nuevo precio de la prenda:");
			pVenta = view.leerEntero("Digite el nuevo precio de venta:");
			can = view.leerEntero("Digite la nuevo cantidad:");
			inventario.actualizarPrenda(pCompra, pVenta, can, posic);
		}

	}

	public void actualizarPorPrendasVendidas() {
		int posic;
		int cod;
		int can;
		cod = view.leerEntero("Digite el codigo de la prenda a vendido:");
		posic = inventario.buscarPrenda(cod);
		if(posic<0)
			view.mostrarMensaje("La prenda "+ cod +" no fue encontrado");
		else {
			can = view.leerEntero("Digite la nuevo cantidad:");
			inventario.actualizarPrendaPorVenta(can, posic);
		}
	}
	
	public void eliminarPrenda() {
	   int i,cod,posic;
	   cod = view.leerEntero("Digite el código de la prenda a eliminar:");
	   posic = inventario.buscarPrendaPorCodigo(cod);
	   if(posic<0)
		 view.mostrarMensaje("La prenda con código "+cod+" no fue encontrado");
	   else {
		 inventario.eliminarPrenda(posic);
	   }		
	}
	
	public void listarPrendas() {
	   view.mostrarMensaje(inventario.listarArreglo());
	}
}
