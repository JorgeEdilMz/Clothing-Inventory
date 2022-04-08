package controller;

import model.Curso;
import model.Estudiante;
import view.VistaConsola;

public class Controller {

	private Curso cur;
	private Estudiante es;
	private VistaConsola view;
	
	public Controller() {
	   cur = new Curso();
	   view = new VistaConsola();
	   funcionar();
	}
	
	public void funcionar() {
	   int opc;
	   String menu = "Bienvenido Usuario a su curso\n"+
	                 "1. Registrar estudiante\n"+
	                 "2. Actualizar estudiante\n"+
			         "3. Calcular promedio de notas\n"+
	                 "4. Calcular n�mero de estudiante >= promedio\n"+
	                 "5. Listar estudiantes\n"+
			         "6. Salir\n";
	   do {
	     view.mostrarMensaje(menu);
	     opc = view.leerEntero("Seleccione su opci�n:");
         switch (opc) {
         case 1:
    	    registrarEstudiante();
    	    break;
         case 2:
    	    actualizarEstudiante();
    	    break;    	    
         case 3:
    	    calcularPromedio();
    	    break;
         case 4:
    	    calcularNEstMayorIgualPromedio();
    	    break;
         case 5:
    	    listarPrendas();
    	    break;
         case 6:
    	    view.mostrarMensaje("Hasta pronto");
    	    break;
         default:
    	    view.mostrarMensaje("Opci�n incorrecta");
         }
	   }while(opc!=6);
	}
	
	public void registrarEstudiante() {
	   String nom,ape;
	   double not;
	   int posic;
	   nom = view.leerString("Digite el nombre del estudiante:");
	   ape = view.leerString("Digite el apellido del estudiante:");
	   not = view.leerDecimal("Digite la nota del estudiante:");
	   es = new Estudiante(nom,ape,not);
	   posic = cur.agregarEstudiante(es);
	   if(posic < 0) {
		 view.mostrarMensaje("No se pudo agregar el estudiante");
	   }
	}
	
	public void cambiarEstudiante() {
	   Estudiante est;
	   int posic;
	   String nom;
	   double not;
	   nom = view.leerString("Digite el nombre del estudiante a modificar:");
	   posic = cur.buscarEstudiante(nom);
	   if(posic<0)
		 view.mostrarMensaje("El estudiante "+nom+" no fue encontrado");
	   else {
		 not = view.leerDecimal("Digite la nueva nota del estudiante:");
		 est.setNota(not);
	   }
		 
	}
	
	public void calcularPromedio() {
	   view.mostrarMensaje("Calculando promedio");
	}
	
	public void calcularNEstMayorIgualPromedio() {
	   view.mostrarMensaje("Calculando >= promedio");
	}
	
	public void listarEstudiantes() {
	   view.mostrarMensaje(cur.listarArreglo());
	}
}
