/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabibliotematema08;

import java.util.Calendar;

/**
 *
 * @author sportak
 */
public class Libro extends Publicacion {

    private String autor;

    public Libro(String autor, int ISBN, String nombre, Calendar fecha) {
        super(ISBN, nombre, fecha);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return super.toString() +"\t"+ this.autor;
    }

}
