package control;

import java.util.spi.LocaleServiceProvider;

import datos.CitaMedica;
import datos.Paciente;
import datos.PacienteHasCitaMedica;
import usuario.PedirDatos;

public class Control {
	// 1.
	public static String convertirInsertPaciente(Paciente paciente) {
		String sql = "INSERT INTO paciente (dni, nombre, apellidos, sintomas) VALUES ('" + paciente.getDni() + "','"
				+ paciente.getNombre() + "', '" + paciente.getApellido() + "', '" + paciente.getSintomas() + "')";
		System.out.println(sql);
		return sql;

	}

	// 2.
	public static String convertirInsertCitaMedica(CitaMedica citamedica) {
		String sql = null;
		try {
			sql = "INSERT INTO citamedica (dia, departamento, nombreMedico) VALUES (" + citamedica.getDia() + ", '"
					+ citamedica.getDepartamento() + "', '" + citamedica.getNombreMedico() + "')";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sql);
		return sql;

	}

	public static String convertirUpdatePaciente(Paciente paciente) {
		String sql = "";
		int id = PedirDatos.pedirID();// pido el id para saber cual modificar
		sql = "UPDATE paciente SET dni = '" + paciente.getDni() + "', nombre= '" + paciente.getNombre()
				+ "', apellidos= '" + paciente.getApellido() + "', sintomas ='" + paciente.getSintomas()
				+ "' WHERE id = " + id;
		System.out.println(sql);
		return sql;
	}

	public static String convertirUpdateCitaMedica(CitaMedica citaMedica) {
		String sql = "";
		int id = PedirDatos.pedirID();// pido el id para saber cual modificar
		sql = "UPDATE citamedica SET dia = " + citaMedica.getDia() + ", departamento= '" + citaMedica.getDepartamento()
				+ "', nombreMedico= '" + citaMedica.getNombreMedico() + "' WHERE id = " + id;
		System.out.println(sql);
		return sql;
	}

	// select porque si
	public static String convertirMostrarTablas(int dato) {
		String sql="";
		try {
			boolean repite=false;
			do {
				switch(dato) {
				case 1:
					sql = "SELECT * from paciente ";
					break;
				case 2:
					sql = "SELECT * from citamedica ";
					break;
				 case 3:
					sql = "SELECT * from paciente_has_citamedica ";
					break;
			     default:
			    	System.out.println("Valor inválido");
			    	repite=true;
			    	break;
				}	
			}while(repite);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sql;
	}

	public static String convertirMostrarCitaMedica() {
		String sql = "SELECT * from citamedica ";
		System.out.println(sql);
		return sql;
	}

	// arreglar lo de los datos
	public static String convertirMostrarCitaMedica(String[] conjunto) {
		String sql = "SELECT * from citamedica WHERE " + conjunto[0] + " = '" + conjunto[1] + "'";
		System.out.println(sql);
		return sql;
	}

	// 3.delete 1.
	public static String convertirEliminarPacientes() {
		int id = PedirDatos.pedirID();
		String sql = "DELETE FROM paciente WHERE id =  " + id;
		System.out.println(sql);
		return sql;
	}

	// 3.delete 2 cambiar porque borro de la tabla insterseccion
	public static String converitirEliminarCitaMedica() {
		int id = PedirDatos.pedirID();
		String sql = "DELETE FROM paciente_has_citamedica WHERE id =  " + id;
		System.out.println(sql);
		return sql;
	}
	//4.
	public static String convertirMostrarCount(String tipo) {
		String sql = "";
		try {
			if (tipo.equals("dni") || tipo.equals("nombre") || tipo.equals("apellidos") || tipo.equals("sintomas")) {
				sql = "SELECT COUNT(DISTINCT (" + tipo + ")) FROM  paciente";
			} else if (tipo.equals("dia") || tipo.equals("departamento") || tipo.equals("nombremedico")) {
				sql = "SELECT COUNT(DISTINCT (" + tipo + ")) FROM  citamedica ";
			}else if(tipo.equals("paciente")) {
				sql= "SELECT COUNT(*) FROM paciente"; //me da un entero
			}else if(tipo.equals("citamedica")) {
				sql= "SELECT COUNT(*) FROM citamedica";
			}else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sql;
	}

	//9.
	public static String convertirMostrarMax(String tipo) {
		String sql = "SELECT " + tipo + ",COUNT(" + tipo + ") FROM citamedica GROUP BY " + tipo + " ORDER BY COUNT("
				+ tipo + ") DESC LIMIT 1";
		return sql;
	}
	//10.
	public static String convertirMostrarVacio(String tabla) {
		String sql = "";
		try {
			if (tabla.equals("paciente")) {
				sql = "SELECT * FROM " + tabla + " WHERE dni = '' && nombre = '' && apellidos= '' && sintomas =''";
			} else if (tabla.equals("citamedica")) {
				sql = "SELECT * FROM " + tabla + " WHERE dia = NULL && departamento = '' && nombremedico  = ''";
			} else {
				System.out.println("mal");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sql;
	}
	//5.asociar ids
	public static String convertirAsociarIds(PacienteHasCitaMedica miPacienteHasCitaMedica) {
		String sql="INSERT INTO paciente_has_citamedica (id, paciente_id, citamedica_id) VALUES (null,"+miPacienteHasCitaMedica.getIdPaciente()+", "+miPacienteHasCitaMedica.getIdCitaMedica()+")" ;
		return sql;
	};

}
