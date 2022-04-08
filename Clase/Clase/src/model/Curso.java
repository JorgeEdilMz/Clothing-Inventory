package model;

public class Curso {

	public static final int NEST=2;
	private Estudiante[] estudiantes;
	private int pos;
	
	public Curso() {
	  estudiantes = new Estudiante[NEST];
	  pos = 0;
	}
	
	public int agregarEstudiante(Estudiante pEst) {
	  int posi;
	  if(pos<NEST) {
		estudiantes[pos] = pEst;
		posi=pos;
		pos++;
	  } else {
		posi = -1;  
	  }		
	  return posi;
	}
	
	public int buscarEstudiante(String pNom) {
	   int i, posic=-1;
	   boolean encontrado = false;
	   for(i=0;i<pos&&encontrado!=true;i++) {
		 if(estudiantes[i].getNombre().equalsIgnoreCase(pNom)) {
		   encontrado = true;
		   posic = i;
		 }
	   }
	   return posic;
	}
	
	public int actualizarEstudiante(double pNot) {
       
	}
	
	public String listarArreglo() {
	   int i;
	   String cad = "Listado de Estudiantes\n";
	   for(i=0;i<NEST;i++) {
		 cad = cad + estudiantes[i].toString()+"\n"; 
	   }
	   return cad;
	}

	public Estudiante[] getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Estudiante[] estudiantes) {
		this.estudiantes = estudiantes;
	}
}
