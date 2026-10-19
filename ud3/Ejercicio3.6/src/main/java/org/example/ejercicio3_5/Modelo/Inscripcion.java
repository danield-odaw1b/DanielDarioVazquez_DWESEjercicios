package org.example.ejercicio3_5.Modelo;

public class Inscripcion{
    private Integer id;
    private String nombre;
    private String email;
    private Boolean turno;
    private String texto;
    private Boolean normas;

    public Inscripcion(){}

    public Inscripcion( Integer id, String nombre, String email, Boolean turno, String texto, Boolean normas) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.turno = turno;
        this.texto = texto;
        this.normas = normas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isNormas() {
        return normas;
    }

    public void setNormas(Boolean normas) {
        this.normas = normas;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Inscripcion buscarInscripcion(Integer id) {
        if (this.id.equals(id)) {
            return this; //Preguntarle a la profe por qué esto funcuiona . _.
        }
        return null;
    }
}
