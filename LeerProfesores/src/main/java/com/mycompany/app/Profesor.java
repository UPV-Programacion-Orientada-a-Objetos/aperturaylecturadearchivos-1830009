package com.mycompany.app;

public class Profesor {

    private String Nombre,Apellido,Correo,Telefono,Grado,Carrera;
    private int Clave,Director;

    public Profesor(int clave,String nombre, String apellido, String correo, String telefono, String grado, String carrera, int director) {
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Telefono = telefono;
        Grado = grado;
        Carrera = carrera;
        Clave = clave;
        Director = director;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String grado) {
        Grado = grado;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        Carrera = carrera;
    }

    public int getClave() {
        return Clave;
    }

    public void setClave(int clave) {
        Clave = clave;
    }

    public int getDirector() {
        return Director;
    }

    public void setDirector(int director) {
        Director = director;
    }
}
