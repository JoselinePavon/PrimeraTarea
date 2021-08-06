package com.company;

import java.util.Scanner;
public class RegistroAlumno {

    Scanner entradaDeTeclado = new Scanner(System.in);
    private String[][] alumnosRegistrados;// solo se declara el vector multidimensional
    private int indiceVector;

    //{ Area de métodos de clase}
    public RegistroAlumno(int cantidadDeRegistros) {
        //se inicializan los valores
        this.alumnosRegistrados = new String[cantidadDeRegistros][6];
        this.indiceVector = 0;
    }

    public boolean registrarAlumno(Alumno alumno) {
        String[] datos_alumnos = alumno.pasarDatos();
        if (!(this.existeAlumnoRegistrado(datos_alumnos[2]))) {
            this.alumnosRegistrados[this.indiceVector][0] = datos_alumnos[0];
            this.alumnosRegistrados[this.indiceVector][1] = datos_alumnos[1];
            this.alumnosRegistrados[this.indiceVector][2] = datos_alumnos[2];
            this.alumnosRegistrados[this.indiceVector][3] = datos_alumnos[3];
            this.alumnosRegistrados[this.indiceVector][4] = datos_alumnos[4];
            this.alumnosRegistrados[this.indiceVector][5] = datos_alumnos[5];
            this.incrementarIndice();
            return true;
        } else {
            return false;
        }
    }

    private void incrementarIndice() {
        this.indiceVector = this.indiceVector + 1;
    }

    //getAlumnosRegistrados();
    public String[][] obtenerAlumnosRegistrados(){
        return this.alumnosRegistrados;
    }

    public boolean existeAlumnoRegistrado(String carneAlumno){
        for(int i=0; i<this.alumnosRegistrados.length; i++){//length devuelve el tamaño del vector
            if(this.alumnosRegistrados[i][2]!=null){
                //nombreAlumno==alumnosRegistrados[i] esto tambien funciona
                if(carneAlumno.equals(this.alumnosRegistrados[i][2])){
                    return true;
                }
            }
        }
        return false;
    }

    public void modificarAlumno(String carneAlumno){
        for(int i=0; i<this.alumnosRegistrados.length; i++){//length devuelve el tamaño del vector
            if(this.alumnosRegistrados[i][2]!=null){
                //nombreAlumno==alumnosRegistrados[i] esto tambien funciona
                if(carneAlumno.equals(this.alumnosRegistrados[i][2])){
                    System.out.println("\nInformacion de alumno: ");
                    for(int j=0; j<this.alumnosRegistrados[0].length; j++){
                        if(!(this.alumnosRegistrados[i]==null)){//se valida si el registro no es nulo
                            System.out.println("\nNombre: " + this.alumnosRegistrados[i][0]);
                            System.out.println("Apellidos: " + this.alumnosRegistrados[i][1]);
                            System.out.println("Carne: " + this.alumnosRegistrados[i][2]);
                            System.out.println("Correo: " + this.alumnosRegistrados[i][3]);
                            System.out.println("Telefono: " + this.alumnosRegistrados[i][4]);
                            System.out.println("Dpi: " + this.alumnosRegistrados[i][5]);
                            System.out.println("\nNuevo nombre: ");
                            this.alumnosRegistrados[i][0] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo apellido: ");
                            this.alumnosRegistrados[i][1] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo correo: ");
                            this.alumnosRegistrados[i][3] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo telefono: ");
                            this.alumnosRegistrados[i][4] = entradaDeTeclado.nextLine();
                            System.out.println("Nuevo dpi: ");
                            this.alumnosRegistrados[i][5] = entradaDeTeclado.nextLine();
                            break;
                        }
                    }
                }
            }
        }
    }
}
