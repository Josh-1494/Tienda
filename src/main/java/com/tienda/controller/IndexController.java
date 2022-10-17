
package com.tienda.controller;

import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired //El objeto se crea en menoria si no existe y si existe se usa este 
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var texto="Estamos en semana 4";
        model.addAttribute("mensaje",texto);
        
        /* 
        Cliente cliente = new Cliente("Juan","Perez Moreno","jperez@gmail.com","2222-8888");
        model.addAttribute("cliente",cliente);
        
        Cliente cliente1 = new Cliente("Juan","Perez Moreno","jperez@gmail.com","2222-8888");
        Cliente cliente2 = new Cliente("Joshua","Oviedo Arias","joviedo@gmail.com","1234-5678");
        Cliente cliente3 = new Cliente("Maria","Solis Arguedas","msolis@gmail.com","7894-1235");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3); 
        
                           /*ESTE ES EL NOMBRE CON EL QUE SE LLAMA A LA LISTA*/
                                    /*     ▼     */
        /*model.addAttribute("clientes",clientes); */
        
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
    
}
