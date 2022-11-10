package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    //Se implementan los 4 metodos de un CRUD
    // Read / Create / Update / Delete  -- Mediante ClienteDao
    
    //Se utiliza una anotacion Autowired para que el objeto clienteDao
    //Si ya esta en memoria se use ese... sino se crea (Patron singleton)
    
    @Autowired  //Es un enlace automatico
    private ClienteDao clienteDao;
     
    @Autowired  //Es un enlace automatico
    private CreditoDao creditoDao;
    
    //Retorna la lista de clientes
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }
    
    //Dado un cliente.id se busca en la tabla y 
    //se retorna todo el objeto Cliente
    //  / READ /  *********************
    @Override
    @Transactional(readOnly=true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    //Si el cliente.id tien un calor se busca y se actualiza
    //si el cliente.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    @Override
    @Transactional
    public void save(Cliente cliente){
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }
    
    //Elimina el registro que tiene el id igual a cliente.id
    //  / DELETE /  *********************
    @Override
    @Transactional
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }

    
    /*Práctica #5: findByApellidos*/
    @Override
    public List<Cliente> getClientesPorApellido(String Apellidos) {
        return clienteDao.findByApellidos(Apellidos);
    }

}
