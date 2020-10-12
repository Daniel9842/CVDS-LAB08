package edu.eci.cvds.test;

import java.util.*;
import java.sql.Date;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.text.SimpleDateFormat;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }
	
	@Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for(int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }
	
	@Test
    public void clienteOK() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(54321);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "Error al consultar el cliente con identificacion 54321");
        }
    }
	
	@Test
    public void clienteNoOK() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(6996);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "Error al consultar el cliente con identificacion 6996");
        }
    }
	
	@Test
    public void clienteDuplicadoOk() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(699601231);
            serviciosAlquiler.registrarCliente(cliente);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "Error al consultar el cliente con identificacion 699601231");
        }
	}
	
	@Test
    public void clienteDuplicadoNoOk() {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(6996);
            serviciosAlquiler.registrarCliente(cliente);
        } catch (ExcepcionServiciosAlquiler e) {
            Assert.assertEquals(e.getMessage(), "Error al consultar el cliente con identificacion 6996");
        }
	}
	
	@Test
	public void registrarItemOK(){
        try {
            serviciosAlquiler.registrarItem(new Item(new TipoItem(8899, "Celuco1"), 489212, "Celular Samsung", "Se llama y se chatea baby", new SimpleDateFormat("yyyy/MM/dd").parse("2010/11/12"),350000, "Tecnologia", "Celuco1"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
	
	@Test
	public void registrarItemNoOK(){
        try {
            serviciosAlquiler.registrarItem(new Item(new TipoItem(8899, "Celuco"), 48921, "Celular Samsung", "Se llama y se chatea baby", new SimpleDateFormat("yyyy/MM/dd").parse("2010/11/12"),350000, "Tecnologia", "Celuco1"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}