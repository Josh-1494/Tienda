
package com.tienda.controller;

import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String inicio(Model model){
        
        //Este tiene que ser un var en vez del String
        var texto="Estamos en semana 4";
        
        model.addAttribute("mensaje",texto);
        
        Cliente cliente1 = new Cliente("Juan","Perez Moreno","jperez@gmail.com","2222-8888");
        Cliente cliente2 = new Cliente("Joshua","Oviedo Arias","joviedo@gmail.com","1234-5678");
        Cliente cliente3 = new Cliente("Maria","Solis Arguedas","msolis@gmail.com","7894-1235");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3); 
        
        model.addAttribute("clientes",clientes);
        
        return "index";
    }
    
}
