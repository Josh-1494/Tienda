/*dao = Data Access Object*/
package com.tienda.dao;

import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

                                    /*Nombre de la CLASE y el tipo de DATO de la LLAVE PRIMARIA*/
public interface ClienteDao extends JpaRepository<Cliente,Long>{
    
    /*Práctica #5: findByApellidos*/
    public List<Cliente> findByApellidos(String apellidos);
    
}
