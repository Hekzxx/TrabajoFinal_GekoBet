package org.example.gekobetv1.dtos;

public class QueryTicketTicketXTeamDTO {
    private String nombre_equipo;
    private  float promedio_probabilidad;

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public float getPromedio_probabilidad() {
        return promedio_probabilidad;
    }

    public void setPromedio_probabilidad(float promedio_probabilidad) {
        this.promedio_probabilidad = promedio_probabilidad;
    }
}