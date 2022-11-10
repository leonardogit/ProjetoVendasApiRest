package io.github.leonardogit.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClienteController {

    @RequestMapping(
            value = {"/api/clientes/hello/{nome}"},//Caminho da url desejado
            method = RequestMethod.GET, // Tipo da requisição
            consumes = {"application/json" ,"application/xml"}, //Qual tipo do request Body será enviado ?
            produces = {"application/json,application/xml"}) // Qual tipo do response Body será enviado ?
    @ResponseBody
    public String helloClientes( @PathVariable("nome") String nomeCliente ){
        return String.format("Hello %s ", nomeCliente);
    }

}
