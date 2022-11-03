/*dao = Data Access Object*/
package com.tienda.dao;

import com.tienda.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

                                    /*Nombre de la CLASE y el tipo de DATO de la LLAVE PRIMARIA*/
public interface CreditoDao extends JpaRepository<Credito,Long>{
    
}
