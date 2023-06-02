package datos;
public class CitaMedica {
	private int dia;
	private String departamento;
	private String nombreMedico;
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getNombreMedico() {
		return nombreMedico;
	}
	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}
	public CitaMedica(int dia, String departamento, String nombreMedico) {
		super();
		this.dia = dia;
		this.departamento = departamento;
		this.nombreMedico = nombreMedico;
	}
	@Override
	public String toString() {
		return "CitaMedica [dia=" + dia + ", departamento=" + departamento + ", nombreMedico=" + nombreMedico + "]";
	}
	
}
