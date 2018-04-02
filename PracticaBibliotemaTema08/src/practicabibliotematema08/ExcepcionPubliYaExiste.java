/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabibliotematema08;

/**
 *
 * @author sportak
 */
public class ExcepcionPubliYaExiste extends Exception {

    Publicacion publi1;

    public ExcepcionPubliYaExiste(Publicacion publi1) {
        this.publi1 = publi1;
    }

    public Publicacion getPubli1() {
        return publi1;
    }

    public void setPubli1(Publicacion publi1) {
        this.publi1 = publi1;
    }

    @Override
    public String toString() {
        return "La publicacion " + "\t" + publi1.getNombre() + "\t" + "ya existe";
    }

}
