package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.*;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemRentadoMapper {

    public List<Item> consultarItems();

    public Item consultarItem(@Param("idIt") int id);

    public void insertarItem(@Param("item") Item it);

    public void actualizarTarifaItem(@Param("idItem") int id, @Param("itemTarifa") long tarifa);
}