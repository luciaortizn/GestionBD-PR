package datos;

public class PacienteHasCitaMedica {
	private int idPaciente;
	private int idCitaMedica;
	public PacienteHasCitaMedica(int idPaciente, int idCitaMedica) {
		super();
		this.idPaciente = idPaciente;
		this.idCitaMedica = idCitaMedica;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getIdCitaMedica() {
		return idCitaMedica;
	}
	public void setIdCitaMedica(int idCitaMedica) {
		this.idCitaMedica = idCitaMedica;
	}

}
