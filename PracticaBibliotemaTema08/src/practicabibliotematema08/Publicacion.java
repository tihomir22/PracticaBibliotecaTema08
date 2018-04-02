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
abstract class Publicacion {

    protected int ISBN;
    protected String nombre;
    protected Calendar fecha;

    public Publicacion(int ISBN, String nombre, Calendar fecha) {
        this.ISBN = ISBN;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return this.nombre + "\t"+this.ISBN +"\t"+ this.fecha.getTime();
    }

}
