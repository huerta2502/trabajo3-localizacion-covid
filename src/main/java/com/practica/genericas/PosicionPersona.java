package com.practica.genericas;

public class PosicionPersona {
	private Coordenada coordenada;
	private String documento;
	private FechaHora fechaPosicion;

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public FechaHora getFechaPosicion() {
		return fechaPosicion;
	}

	public void setFechaPosicion(FechaHora fechaPosicion) {
		this.fechaPosicion = fechaPosicion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getDocumento());
		builder.append(";");
		FechaHora fecha = getFechaPosicion();
		builder.append(fecha);
		builder.append(";");
		builder.append(coordenada);
		return builder.toString();
	}

}
