package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

import java.util.*;

public class MyBATISTipoItemDAO implements TipoItemDAO{

	@Inject
	private TipoItemMapper tipoItemMapper;    

	@Override
	public void save(TipoItem ti) throws PersistenceException{
		try{
			tipoItemMapper.addTipoItem(ti);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error registrando tipo " + ti.toString(),e);
		}        
	}

	@Override
	public TipoItem load(int id) throws PersistenceException {
		try{
			return tipoItemMapper.getTipoItem(id);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error consultando el tipo " + id,e);
		}
	}
	
	 @Override
    public List<TipoItem> consultarTiposItem() throws PersistenceException {
        try {
            return tipoItemMapper.consultarTiposItems();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando el tipo ", e);
        }
    }
}