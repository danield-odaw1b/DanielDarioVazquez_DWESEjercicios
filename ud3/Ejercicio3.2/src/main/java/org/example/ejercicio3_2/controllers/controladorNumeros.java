package org.example.ejercicio3_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controladorNumeros {
    private List<Integer> lista = new ArrayList<>();

    public controladorNumeros(){
        inicializarNumeros();
    }

    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("lista", lista);
        return "listaAleatorio";
    }

    private void inicializarNumeros() {
        for(int i = 0; i < Math.random()*50+1; i ++){
            lista.add((int) ((Math.random()*100)+1));
        }
    }
}
