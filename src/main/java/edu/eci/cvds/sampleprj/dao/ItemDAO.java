package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

import java.util.*;

public interface ItemDAO {

   public void save(Item it) throws PersistenceException;

   public Item load(int id) throws PersistenceException;
   
   public List<Item> consultarItems() throws PersistenceException;
   
   public List<Item> consultarItemsDisponibles() throws PersistenceException;
   
   public void tarifaItem( int id, long tarifa) throws PersistenceException;
}