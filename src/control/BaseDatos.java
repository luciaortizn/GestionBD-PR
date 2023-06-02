package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos {
	public static void insertar(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado;
		String verde = "\033[0;32m";
		String reset = "\033[0m";
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
																							

			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();

			//execute update: 
			//execute query: select
			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println(verde+"Se ha insertado bien."+ reset);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}

		System.out.println("Conectado/desconectado");

	}
	public static void mostrarMaxDatoCitaMedica(String sql, String dato)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String negroBold = "\033[1;30m";
		String reset = "\033[0m";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			
			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();
			rs = sentenciaSQL.executeQuery(sql);
			// chequeo que el result set no sea vacÃ­o, moviendo el cursor a la
						// primer fila. (El cursor inicia antes de la primer fila)
						System.out.println(negroBold+" \n VALORES MÁS USADOS \n "+reset);
						while (rs.next()) {
							// Si hay resultados obtengo el valor.
							System.out.println("Máximo valor de "+dato+": "+rs.getString(dato) + "."); //en teoria ejecuto la query
						}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		// no pongo resultado porque da más de 1 línea
		
		System.out.println("Conectado/desconectado");
	}
	public static void mostrarCountDato(String sql, String dato)throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String negroBold = "\033[1;30m";
		String reset = "\033[0m";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			int cont=0 ;
			System.out.println(sql);
			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();
			rs = sentenciaSQL.executeQuery(sql);
			// chequeo que el result set no sea vacÃ­o, moviendo el cursor a la
						// primer fila. (El cursor inicia antes de la primer fila)
						System.out.println(negroBold+" \n CANTIDAD DE VALORES EN CITAS MÉDICAS \n "+reset);
						while (rs.next()) {
							cont++;
							// Si hay resultados obtengo el valor.
							cont = rs.getInt(cont);
							// Si hay resultados obtengo el valor.
						}
						System.out.println("hay un total de "+cont); //en teoria ejecuto la query

			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		// no pongo resultado porque da más de 1 línea
		
		System.out.println("Conectado/desconectado");
	}
	public static void mostrarConOpciones(String sql, int valor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String negroBold = "\033[1;30m";
		String reset = "\033[0m";
		String verde = "\033[0;32m";
		

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			
			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();
			rs = sentenciaSQL.executeQuery(sql);
			int cont=0;
			switch(valor) {
				case 1:
					System.out.println(negroBold+" \n TABLA DE PACIENTES REGISTRADOS \n "+reset);
					while (rs.next()) {
						// Si hay resultados obtengo el valor.
						
						System.out.println("\t"+"ID: "+rs.getString("id") + " -DNI: " + rs.getString("dni")+ "\t"+ " -Nombre: " + rs.getString("nombre")+ "\t \t"+ " -Apellidos: " + rs.getString("apellidos")+ "\t \t"+ " -Síntomas: " + rs.getString("sintomas"));
						cont++;
						//"id: " + rs.getInt("idPelicula")+
					}
					System.out.println(verde+"\n Hay "+cont + " pacientes registrados."+reset);
		
					break;
				case 2:
					System.out.println(negroBold+" \n TABLA DE CITAS CONCERTADAS \n "+reset);
					while (rs.next()) {
						// Si hay resultados obtengo el valor.
						
						System.out.println("\t"+"ID: "+rs.getString("id") + " -Día del mes: " + rs.getString("dia")+ "\t"+ " -Departamento: " + rs.getString("departamento")+ "\t \t"+ " -Nombre del Médico: " + rs.getString("nombremedico")+ "\t");
						cont++;
						//"id: " + rs.getInt("idPelicula")+
					}
					System.out.println(verde+"\n Hay "+cont + " citas médicas registradas."+reset);
					break;
				case 3:
					System.out.println(negroBold+" \n TABLA DE ASOCIACIÓN \n "+reset);
					while (rs.next()) {
						// Si hay resultados obtengo el valor.
						
						System.out.println("\t"+"ID: "+rs.getString("id") + " -ID del paciente: " + rs.getString("paciente_id")+ "\t"+ " -ID de la cita médica: " + rs.getString("citamedica_id")+ "\t");
						cont++;
						//"id: " + rs.getInt("idPelicula")+
					}
					System.out.println(verde+"\n Hay "+cont + " asociaciones registradas."+reset);
					break;
				default:
					break;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		// no pongo resultado porque da más de 1 línea
		
		System.out.println("Conectado/desconectado");

	}

	
	public static void update(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado;
		String verde = "\033[0;32m";
		String reset = "\033[0m";
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
																							

			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();

			//execute update, delete, insert: 
			//execute query: select
			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println(verde+"Se ha actualizado bien."+reset);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();
		}

	}
	public static void delete(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado;
		String verde = "\033[0;32m";
		String reset = "\033[0m";
		
		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
																							

			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();

			//execute update, delete, insert: 
			//execute query: select
			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 1) {
				System.out.println(verde+"Se ha eliminado correctamente."+reset);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}

		System.out.println("Conectado/desconectado");
		System.out.println("/t");
		System.out.println("/t");

	}
	public static void mostrarVacio(String sql,String valor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String negroBold = "\033[1;30m";
		String reset = "\033[0m";
		String verde = "\033[0;32m";
	
		

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			
			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();
			rs = sentenciaSQL.executeQuery(sql);
			int cont=0;
			// chequeo que el result set no sea vacÃ­o, moviendo el cursor a la
						// primer fila. (El cursor inicia antes de la primer fila)
						System.out.println(negroBold+" \n  \n "+reset);
						while (rs.next()) {
							// Si hay resultados obtengo el valor.
							try {
								if(valor.equals("paciente")) {
								
									System.out.println("\t"+"ID: "+rs.getString("id") + " -DNI: " + rs.getString("dni")+ "\t"+ " -Nombre: " + rs.getString("nombre")+ "\t \t"+ " -Apellidos: " + rs.getString("apellidos")+ "\t \t"+ " -Síntomas: " + rs.getString("sintomas"));
									cont++;
	
								}else if(valor.equals("citamedica")) {
									
									System.out.println("\t"+"ID: "+rs.getString("id") + " -Día del mes: " + rs.getString("dia")+ "\t"+ " -Departamento: " + rs.getString("departamento")+ "\t \t"+ " -Nombre del Médico: " + rs.getString("nombremedico")+ "\t");
									cont++;
								}else {
									System.out.println("Error al introducir datos");
								}
								
							}catch(SQLException sqle) {
								System.out.println("Error");
							}finally {
								System.out.println(verde+"\n Hay "+cont+"."+reset);
							}	
						}
						
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		
		System.out.println("Conectado/desconectado");

	}
	public static void mostrar(String sql,String valor) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs;
		String negroBold = "\033[1;30m";
		String reset = "\033[0m";
		String verde = "\033[0;32m";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
			
			// creamos sentencias ejecutables sobre esa conexiÃ³n
			sentenciaSQL = conexion.createStatement();
			rs = sentenciaSQL.executeQuery(sql);
			System.out.println(sql);
			int cont = 0;
			// chequeo que el result set no sea vacÃ­o, moviendo el cursor a la
						// primer fila. (El cursor inicia antes de la primer fila)
						System.out.println(negroBold+" \n  \n "+reset);
						while (rs.next()) {
							cont++;
							// Si hay resultados obtengo el valor
							cont = rs.getInt(cont);
						   // System.out.println("El número de registros en mi_tabla es: " + cont);
							
						}
						System.out.println(verde+"El número de registros en "+ valor +" es:"+ cont+reset);	
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} finally {
			sentenciaSQL.close();
			conexion.close();

		}
		
		System.out.println("Conectado/desconectado");

	}
	
}
