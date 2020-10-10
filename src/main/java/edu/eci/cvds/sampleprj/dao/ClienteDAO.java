package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;

import java.util.*;

public interface ClienteDAO {

	public void save(Cliente cl) throws PersistenceException;

	public Cliente load(long id) throws PersistenceException;
   
    public List<Cliente> consultarClientes() throws PersistenceException;
	
	public void agregarItemRentadoACliente(long idCl, int idItem, Date fechaInicial, Date fechaFinal) throws PersistenceException;

    public void vetar(long idCl, int vetado) throws PersistenceException;
}