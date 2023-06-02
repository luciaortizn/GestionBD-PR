import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import control.BaseDatos;
import control.Control;
import datos.CitaMedica;
import datos.Paciente;
import datos.PacienteHasCitaMedica;
import usuario.PedirDatos;

public class Controlador {

	public static void main(String[] args) {

		menuHospital();

	}

	public static void menuHospital() {

		int seleccion = 0;
		int seleccionConsulta = 0;
		String rojo = "\033[1;31m"; // para eliminar y salir del programa
		String reset = "\033[0m";
		String fondoMorado = "\033[44m";
		String moradoBrillanteBold = "\033[1;34m";
		String blancoBold = "\033[0;97m";
		String fondoRojo = "\033[0;101m";
		boolean salir = false;
		Scanner lector = new Scanner(System.in);
		
		try {
			do {
				System.out.println(rojo + "         " + fondoRojo + "\t   " + reset);
				System.out.println("    \t " + fondoRojo + "    ");
				System.out.println(reset + "     " + fondoRojo + "   \t " + reset);
				System.out.println(reset + "     " + fondoRojo + "   \t " + reset);
				System.out.println(rojo + "         " + fondoRojo + "\t   " + reset);
				System.out.println("    \t " + fondoRojo + "    " + reset);

				System.out.println(fondoMorado + blancoBold + fondoMorado
						+ "\n \t \t \t \t \n      GESTIÓN DEL HOSPITAL       \n\t\t \t \t \n" + reset + moradoBrillanteBold
						+ " \n \n 0. Ver pacientes y citas \n 1. Insertar en la T1 \n 2. Insertar en la T2 asociando a la T1 \n 3. Borrar \n 4. Modificar T1 y T2 \n 5. Asociar un T2 a un nuevo T1 \n 6. Consultas \n 7. Salir "
						+ reset);

				try {
					seleccion = lector.nextInt();
					lector.nextLine();
				}catch (InputMismatchException e) {
					System.out.println();
					System.out.println(rojo+ "Error: " +e.getMessage() +reset);
				} catch (NoSuchElementException e) {
					System.out.println();
					System.out.println(rojo + "Error: " +e.getMessage() +reset);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(rojo + "Error: " +e.getMessage() + reset);
				} catch (Exception e) {
					System.out.println();
					System.out.println(rojo + "Error: " +e.getMessage() + reset);
					
				}

				switch (seleccion) {
				case 0:
					Controlador.mostrarTablas();
					break;
				case 1:
					Controlador.insertarT1();
					break;
				case 2:
					// insertar en la T2 asociando a la T1
					Controlador.insertarT2AsociandoT1();
					break;
				case 3:
					// Borrar
					Controlador.borrar();
					break;
				case 4:
					// Modificar T1 y T2
					Controlador.modificar();
					break;
				case 5:
					// Asociar un T2 a un nuevo T1
					Controlador.asociar();
					break;
				// CONSULTAS
				case 6:
					System.out.println(moradoBrillanteBold
							+ " 1. Filtrar citas médicas por nombre del dato \n 2. Filtrar registros por el nombre del dato \n 3. Total de citas médicas o de pacientes no repetidos \n 4. Las características más usadas de la cita médica \n 5. Ver pacientes o citas médicas sin valores"
							+ reset);
					try {
						seleccionConsulta = lector.nextInt();
						lector.nextLine();
					}catch (InputMismatchException e) {
						System.out.println();
						System.out.println(rojo+ "Error: " +e.getMessage() +reset);
						
					} catch (NoSuchElementException e) {
						System.out.println();
						System.out.println(rojo + "Error: " +e.getMessage() +reset);	
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(rojo + "Error: " +e.getMessage() + reset);
					} catch (Exception e) {
						System.out.println();
						System.out.println(rojo + "Error: " +e.getMessage() + reset);
					}

					switch (seleccionConsulta) {
					// 6
					case 1:
						Controlador.filtraPorDato();
						break;
					// 7
					case 2:
						// pido una entidad y me da la cantidad de registros
						Controlador.numRegPorEntidad();
						break;
					// 8
					case 3:	
						// 8 cuantas entidades
						Controlador.numEntNoRepes();
						break;
					// 9
					case 4:
						// atributo más usado
						Controlador.valorMasUsado();
						break;
					// 10
					case 5:
						// devuelve entidades sin atributos
						Controlador.verEntVacias();
						break;
					default:
						System.out.println(rojo + "Selección no válida" + reset);
						break;
					}
					break;
				case 7:
					salir = true;
					System.out.println(rojo + "Se ha salido del programa" + reset);
					break;
				default:
					System.out.println(rojo + "Selección no válida " + reset);
					break;
				}
			} while (!salir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarTablas() {
		int valor = PedirDatos.pedirEntre3();
		String cadena = Control.convertirMostrarTablas(valor);
		try {
			BaseDatos.mostrarConOpciones(cadena, valor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void insertarT1() {
		String sqlString;
		String moradoBrillanteBold = "\033[1;34m";
		String reset = "\033[0m";
		// Insertar en la T1
		System.out.println(moradoBrillanteBold + "INSERTAR" + reset);
		Paciente miPaciente = PedirDatos.pedirDatosPaciente();// devuelve la pelicula
		sqlString = Control.convertirInsertPaciente(miPaciente);
		try {
			BaseDatos.insertar(sqlString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insertarT2AsociandoT1() {
		String sqlString;
		String moradoBrillanteBold = "\033[1;34m";
		String reset = "\033[0m";
		System.out.println(moradoBrillanteBold + "INSERTAR" + reset);
		CitaMedica micCitaMedica = PedirDatos.pedirDatosCitaMedica();// devuelve la pelicula
		sqlString = Control.convertirInsertCitaMedica(micCitaMedica);
		try {
			BaseDatos.insertar(sqlString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ahora lo relaciono
		System.out.println("Se debe relacionar con un paciente, elija la opción 1 para ver con cuál: ");
		Controlador.mostrarTablas();
		System.out.println("Ahora vea el id de la nueva inserción eligiendo la opción 2: ");
		//acaba de ver pacientes, asocio
		Controlador.mostrarTablas();
		Controlador.asociar();
	}

	public static void borrar() {
		// Borrar
		int seleccion;
		String borraString;
		String rojo = "\033[1;31m";
		String moradoBrillanteBold = "\033[1;34m";
		String reset = "\033[0m";
		Scanner lector = new Scanner(System.in);
		System.out.println(moradoBrillanteBold + "BORRAR" + reset);
		System.out.println("¿Qué desea borrar: \n 1. Pacientes \n 2. Citas médicas?)");
		seleccion = lector.nextInt();
		switch (seleccion) {
		case 1:
			// borrar pacientes
			borraString = Control.convertirEliminarPacientes(); // tiene el sql
			try {
				BaseDatos.delete(borraString); // ejecuta el sql con bd
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			// borrar interseccion
			borraString = Control.converitirEliminarCitaMedica(); // tiene el sql
			try {
				BaseDatos.delete(borraString); // ejecuta el sql con bd
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println(rojo + "No hay selección" + reset);
			break;
		}
	}

	public static void modificar() {
		int seleccion;
		String moradoBrillanteBold = "\033[1;34m";
		String reset = "\033[0m";
		String sqlString;
		Scanner lector = new Scanner(System.in);
		System.out.println(moradoBrillanteBold + "MODIFICAR" + reset + "\n 1.Datos paciente \n 2.Datos cita médica");
		seleccion = lector.nextInt();
		lector.nextLine();
		switch (seleccion) {
		case 1:

			Paciente miPaciente2 = PedirDatos.pedirDatosPaciente();
			sqlString = Control.convertirUpdatePaciente(miPaciente2);
			try {
				BaseDatos.update(sqlString);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			// mod t2
			CitaMedica micCitaMedica = PedirDatos.pedirDatosCitaMedica();
			sqlString = Control.convertirUpdateCitaMedica(micCitaMedica);
			try {
				BaseDatos.update(sqlString);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	public static void asociar() {
		String moradoBrillanteBold = "\033[1;34m";
		String reset = "\033[0m";
		String sqlString;
		System.out.println(moradoBrillanteBold + "ASOCIAR" + reset);
		// sería: 1.pedir id de t2 2.usar la tabla intersección con un insert de los 2
		// id fk 3.bd: executeUpdate
		PacienteHasCitaMedica miPacienteHasCitaMedica = PedirDatos.pedirDatosNumericos(); // da un array con 2
																							// numeros
		sqlString = Control.convertirAsociarIds(miPacienteHasCitaMedica);
		try {
			BaseDatos.insertar(sqlString);
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	public static void filtraPorDato() {
		String datoCitaMedica[] = new String[2];
		String sqlString;
		datoCitaMedica = PedirDatos.pedirDatoCitaMedica();
		sqlString = Control.convertirMostrarCitaMedica(datoCitaMedica);
		try {
			BaseDatos.mostrarConOpciones(sqlString, 2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void numRegPorEntidad() {
		String entidad;
		String sqlString;
		entidad = PedirDatos.pedirEntidad();
		sqlString = Control.convertirMostrarCount(entidad);
		try {
			BaseDatos.mostrar(sqlString, entidad);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	public static void numEntNoRepes() {
		int seleccion1;
		String mostrarPac="";
		String sqlString2;
		String cita;
		String sqlString;
		Scanner lector = new Scanner(System.in);
		System.out.println("Elige: \t 1-Pacientes  \t 2-Citas médicas");
		seleccion1 = lector.nextInt();
		lector.nextLine();
		switch (seleccion1) {
		case 1:
			mostrarPac = PedirDatos.pedirPaciente1();
			sqlString2 = Control.convertirMostrarCount(mostrarPac);
			try {
				BaseDatos.mostrarCountDato(sqlString2, mostrarPac);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case 2:
			cita = PedirDatos.pedirDatoCitaMedica1();
			sqlString = Control.convertirMostrarCount(cita);
			try {
				BaseDatos.mostrarCountDato(sqlString, mostrarPac);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Opcion inválida");
			break;
		}
	}
	public static void valorMasUsado() {
		String mostrarPac;
		String sqlString;
		mostrarPac = PedirDatos.pedirDatoCitaMedica1();
		sqlString = Control.convertirMostrarMax(mostrarPac);
		try {
			BaseDatos.mostrarMaxDatoCitaMedica(sqlString, mostrarPac);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void verEntVacias() {
		String sqlString;
		String seleccion2;
		Scanner lector = new Scanner(System.in);
		System.out.println(
				"Ver: \t Pacientes sin valores \t Citas médicas sin valores \n (escribe 'paciente' o 'citamedica' )");
		seleccion2 = lector.nextLine();
		switch (seleccion2) {
		case "paciente":
			sqlString = Control.convertirMostrarVacio(seleccion2);
			try {
				BaseDatos.mostrarVacio(sqlString, seleccion2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "citamedica":
			sqlString = Control.convertirMostrarVacio(seleccion2);
			try {
				BaseDatos.mostrarVacio(sqlString, seleccion2);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Error en sql");
				e.printStackTrace();
			}

			break;
		default:
			System.out.println("");
		}
	}

}
