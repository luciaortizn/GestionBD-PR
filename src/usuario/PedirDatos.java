package usuario;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import datos.CitaMedica;
import datos.Paciente;
import datos.PacienteHasCitaMedica;

public class PedirDatos {
	public static Paciente pedirDatosPaciente() {
		String dni = "";
		String nombre = "";
		String apellido = "";
		String sintomas = "";
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduce nombre:");
		try {
			nombre = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Introduce apellidos:");
		try {
			apellido = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Introduce dni:");
		try {
			dni = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Introduce síntomas:");
		try {
			sintomas = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return new Paciente(dni, nombre, apellido, sintomas);
	}

	public static CitaMedica pedirDatosCitaMedica() {
		String departamento = "";
		int dia = 0;
		String nombreMedico = "";
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduce día:");
		try {
			dia = lector.nextInt();
			lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Introduce departamento:");
		try {
			departamento = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Introduce el nombre del médico:");
		try {
			nombreMedico = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
	
		return new CitaMedica(dia, departamento, nombreMedico);
	}

	public static int pedirID() {
		int id = 0;
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduce el id:");
		try {
			id = lector.nextInt();
			lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return id;
	}

	// 6 pido un dato x y me da todas las citas Medicas que contengan x cosa
	public static String[] pedirDatoCitaMedica() {
		int[] anios = new int[2];
		String[] conjunto = new String[2];
		String dato="";
		String tipo="";
		// de la propia cita medica no de pac.
		Scanner lector = new Scanner(System.in);
		System.out.println("Escribe el nombre por el que filtrar las citas médicas : \n (dia, departamento o nombremedico)");
		try {
			tipo = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("Mete el valor del " + tipo + " :");
		try {
			dato = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		conjunto[0] = tipo;
		conjunto[1] = dato;
		return conjunto;
	}
	//5
	public static PacienteHasCitaMedica pedirDatosNumericos() {
		int[] ids = new int[2];
		int id1=0;
		int id2=0;
		Scanner lector = new Scanner(System.in);
		System.out.println("ID de paciente a asociar: ");
		try {
			id1 = lector.nextInt();
			lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		System.out.println("ID de cita médica a asociar: ");
		try {
			id2 = lector.nextInt();
			lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		
		ids[0] = id1;
		ids[1] = id2;
		return new PacienteHasCitaMedica(id1, id2);
	}
	
	// es como pedirEntidad pero con otro enunciado: devuelve el string que pide
	public static String pedirDatoCitaMedica1() {
		String dato="";
		// de la propia cita medica no de pac.
		Scanner lector = new Scanner(System.in);
		System.out.println("Un dato por el que filtrar las citas médicas : \n ('día', 'departamento' o 'nombremedico')");
		try {
			dato = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return dato;
	}

	public static String pedirPaciente1() {// para el count de atributos de cada tabla
		String dato="";
		// de la propia cita medica no de pac.
		Scanner lector = new Scanner(System.in);
		System.out.println("Un dato por el que filtrar los pacientes : \n ('dni', 'nombre', 'apellidos' o 'sintomas')");
		try {
			dato = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return dato;
	}
	public static String pedirEntidad() {
		String entidad="";
		Scanner lector = new Scanner(System.in);
		System.out.println("El total de registros de: \n (paciente, citamedica)");
		try {
			entidad = lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return entidad;
	}
	public static int pedirEntre3() {
		int valor=0;
		Scanner lector = new Scanner(System.in);
		System.out.println("VER: 1-Pacientes 2-Citas médicas 3-Asociación ");
		try {
			valor = lector.nextInt();
			lector.nextLine();
		}catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}catch (Exception e) {
			System.out.println();
			System.out.println("Error: " +e.getMessage() );
			
		}
		return valor;
		
	}

}
