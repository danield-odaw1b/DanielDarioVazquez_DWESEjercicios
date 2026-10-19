package org.example.ejercicio3_5.Controllers;

import org.example.ejercicio3_5.Modelo.Inscripcion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controladorPrincipal {
    List<Inscripcion> lista = new ArrayList<>();

    @GetMapping("/menu")
    public String mostrarMenu() {
        return "menu";
    }

    @GetMapping("/inscripciones")
    public String mostrarListado(Model model) {
        model.addAttribute("listado", lista);
        return "inscripciones";
    }

    @GetMapping("/inscripciones/nueva")
    public String mostrarNueva(Model model) {
        model.addAttribute("inscripcion", new Inscripcion());
        return "nueva";
    }

    @PostMapping("/inscripciones")
    public String agregarInscripcion(String nombre, String email, Boolean turno, String texto, Boolean normas) {
        int newId = lista.stream().mapToInt(Inscripcion::getId).max().orElse(0) + 1; //A mí me gustaba más mi escopeta de feria con el length-1 +1
        lista.add(new Inscripcion(newId, nombre, email, turno, texto, normas));
        return "redirect:/inscripciones";
    }

    @GetMapping("/inscripciones/{id}/editar")
    public String editarInscripcion(@PathVariable Integer id, Model model) {
        Inscripcion ins = buscar(id);
        if (ins == null) {
            return "redirect:/inscripciones";
        }
        model.addAttribute("inscripcion", ins);
        return "nueva";
    }

    @PostMapping("/inscripciones/{id}/editar")
    public String guardarEdicion(@PathVariable Integer id, String nombre, String email, Boolean turno, String texto, Boolean normas) {
        Inscripcion ins = buscar(id);
        if (ins != null) {
            ins.setNombre(nombre);
            ins.setEmail(email);
            ins.setTurno(turno);
            ins.setTexto(texto);
            ins.setNormas(normas);
        }
        return "redirect:/inscripciones";
    }

    @PostMapping("/inscripciones/{id}/eliminar")
    public String eliminarInscripcion(@PathVariable Integer id) {
        lista.removeIf(ins -> ins.getId().equals(id));
        return "redirect:/inscripciones";
    }

    private Inscripcion buscar(Integer id) {
        for (Inscripcion ins : lista) {
            if (ins.getId().equals(id)) {
                return ins;
            }
        }
        return null;
    }
}