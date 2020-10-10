package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {
	public ExcepcionServiciosAlquiler(String message, PersistenceException cause) {
		super(message, cause);
	}

	public ExcepcionServiciosAlquiler(String message) {
		super(message);
	}
}