package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import edu.eci.cvds.samples.entities.Item;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("idIt") int id);
    
    public void insertarItem(@Param("item") Item it);
	
	public void tarifaItem(@Param("id") int id, @Param("tarifa") long tarifa);

    public List<Item> consultarDisponibles();
}
