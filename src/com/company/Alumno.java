package com.company;

import java.util.Random;
public class Alumno {

    private String apellido;
    private String carne;
    private String nombre;
    private String correo;
    private String telefono;
    private String dpi;
    private int indice;

    //Constructor #1
    public Alumno(){
        this.indice = 1;
    }
    //Constructor #2
    public Alumno(String nombre, String apellido, String correo, String telefono, String dpi, String carne){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carne = carne;
        this.correo = correo;
        this.telefono = telefono;
        this.dpi = dpi;
    }

    public String[] pasarDatos(){
        String[] lista = new String[6];
        lista[0] = this.nombre;
        lista[1] = this.apellido;
        lista[2] = this.carne;
        lista[3] = this.correo;
        lista[4] = this.telefono;
        lista[5] = this.dpi;
        return lista;
    }

    public String mostrar_carne(){
        return this.carne;
    }

    public String generarCarne(RegistroAlumno registro){
        //Generamos un carne con el siguiente formato carrera-año-secuencia_random
        String carrera = "0909";
        String anio = "2021";
        Random  rnd = new Random();
        int n_random = rnd.nextInt(5000);
        String random = Integer.toString(n_random);
        String carne = carrera + "-" + anio + "-" + random;
        while(registro.existeAlumnoRegistrado(carne)){
            n_random = rnd.nextInt(5000);
            random = Integer.toString(n_random);
            carne = carrera + "-" + anio + "-" + random;
            if (!(registro.existeAlumnoRegistrado(carne))){
                break;
            }else{

            }
        }
        this.carne = carne;

        return "";
    }

}
