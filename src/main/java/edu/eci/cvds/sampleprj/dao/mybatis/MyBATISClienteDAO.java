package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

import java.util.*;
import java.util.Date;

public class MyBATISClienteDAO implements ClienteDAO{

	@Inject
	private ClienteMapper clienteMapper;    

	@Override
	public void save(Cliente cl) throws PersistenceException{
		try{
			clienteMapper.agregarCliente(cl);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error registrando cliente " + cl.toString(),e);
		}
	}

	@Override
	public Cliente load(long id) throws PersistenceException {
		try{
			return clienteMapper.consultarCliente(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error consultando cliente " + id,e);
		}
	}
	
	@Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        try {
            return clienteMapper.consultarClientes();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando cliente ", e);
        }
    }
	
	@Override
    public void agregarItemRentadoACliente(long idCl, int idItem, Date fechaInicial, Date fechaFinal) throws PersistenceException {
        try{
            clienteMapper.agregarItemRentadoACliente(idCl, idItem, fechaInicial, fechaFinal);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar el item" + idItem + " a los items rentados del cliente" + idCl, e);
        }
    }

    @Override
    public void vetar(long idCl, int vetado) throws PersistenceException {
        try{
            clienteMapper.vetar(idCl, vetado);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al cambiar el estado del cliente " + idCl, e);
        }

    }
}