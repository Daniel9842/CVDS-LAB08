package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.TipoItem;

import java.util.*;

public interface TipoItemDAO {

	public void save(TipoItem ti) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;

	public List<TipoItem> consultarTiposItem() throws PersistenceException;
}