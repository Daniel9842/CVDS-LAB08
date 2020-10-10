package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
	
	public Cliente consultarCliente(@Param("idCli") long id);
	
	public List<Cliente> consultarClientes();
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param idCli
     * @param idIt
     * @param fechaInicial
     * @param fechaFinal 
     */
    public void agregarItemRentadoACliente(@Param("idCli") long id, 
            @Param("idIt") int idit, 
            @Param("fechaI") Date fechaInicial,
            @Param("fechaF") Date fechaFinal);

    /**
     * Consultar todos los clientes
     * @return 
     */

    public void agregarCliente(@Param("cliente") Cliente cliente);
	
	public void vetar(@Param("cliente") long idCl, @Param("vetado") int vetar);
}
