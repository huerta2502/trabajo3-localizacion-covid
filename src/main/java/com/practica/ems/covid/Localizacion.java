package com.practica.ems.covid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.practica.excecption.EmsDuplicateLocationException;
import com.practica.excecption.EmsLocalizationNotFoundException;
import com.practica.genericas.FechaHora;
import com.practica.genericas.PosicionPersona;

public class Localizacion {
	LinkedList<PosicionPersona> lista;

	public Localizacion() {
		super();
		this.lista = new LinkedList<>();
	}

	public List<PosicionPersona> getLista() {
		return lista;
	}

	public void setLista(LinkedList<PosicionPersona> lista) {
		this.lista = lista;
	}

	public void addLocalizacion(PosicionPersona p) throws EmsDuplicateLocationException {
		try {
			findLocalizacion(p.getDocumento(), p.getFechaPosicion().getFecha().toString(),
					p.getFechaPosicion().getHora().toString());
			throw new EmsDuplicateLocationException();
		} catch (EmsLocalizationNotFoundException e) {
			lista.add(p);
		}
	}

	public int findLocalizacion(String documento, String fecha, String hora) throws EmsLocalizationNotFoundException {
		int cont = 0;
		Iterator<PosicionPersona> it = lista.iterator();
		while (it.hasNext()) {
			cont++;
			PosicionPersona pp = it.next();
			FechaHora fechaHora = FechaHora.parseDateTime(fecha, hora);
			if (documento.equals(pp.getDocumento()) &&
					fechaHora.equals(pp.getFechaPosicion())) {
				return cont;
			}
		}
		throw new EmsLocalizationNotFoundException();
	}

	public void delLocalizacion(String documento, String fecha, String hora) throws EmsLocalizationNotFoundException {
		int pos = -1;
		/**
		 * Busca la localización, sino existe lanza una excepción
		 */
		try {
			pos = findLocalizacion(documento, fecha, hora);
		} catch (EmsLocalizationNotFoundException e) {
			throw new EmsLocalizationNotFoundException();
		}
		this.lista.remove(pos);

	}

	void printLocalizacion() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		lista.forEach(builder::append);
		return builder.toString();
	}

}
