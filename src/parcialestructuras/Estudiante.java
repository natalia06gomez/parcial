/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialestructuras;

import java.util.Objects;

/**
 *
 * @author linan
 */
public class Estudiante extends Item {

  private String nombre;
  private String programa;
  private int año;
  private int semestre;

    public Estudiante(String nombre, String programa, int año, int semestre) {
        this.nombre = nombre;
        this.programa = programa;
        this.año = año;
        this.semestre = semestre;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.año != other.año) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.programa, other.programa);
    }

  

 
  public int compareTo(Item otroEstudiante) {
    Estudiante otro = (Estudiante) otroEstudiante;
    if (this.año != otro.año) {
      return this.año - otro.año;
    } else if (this.semestre != otro.semestre) {
      return this.semestre - otro.semestre;
    } else {
      return this.nombre.compareTo(otro.nombre);
    }
  }

    String getNombre() {
        return nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public int getAño() {
        return año;
    }

    public int getSemestre() {
        return semestre;
    }

}
