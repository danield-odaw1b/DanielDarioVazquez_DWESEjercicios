package org.example.ejercicio3_3.Model;

public class Modulo {
    private int id;
    private String nombre;
    private Integer curso;
    private int horas;

    public Modulo(int id, String nombre, int horas, Integer curso) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
