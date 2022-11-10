package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {
    //Se definen los 4 metodos de un CRUD
    // Read / Create / Update / Delete
    
    //Retorna la lista de clientes
    //  / READ /  *********************
    public List<Cliente> getClientes();
    
    //Dado un cliente.id se busca en la tabla y 
    //se retorna todo el objeto Cliente
    //  / READ /  *********************
    public Cliente getCliente(Cliente cliente);
    
    //Si el cliente.id tien un calor se busca y se actualiza
    //si el cliente.id NO tiene valor, se inserta el objeto en la tabla
    //  / CREATE / UPDATE / **********************
    public void save(Cliente cliente);
    
    //Elimina el registro que tiene el id igual a cliente.id
    //  / DELETE /  *********************
    public void delete(Cliente cliente);
    
    
    /*Práctica #5: findByApellidos*/
    public List<Cliente> getClientesPorApellido(String Apellidos);
    
}
