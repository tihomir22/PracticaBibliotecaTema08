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
public class NoEsUnaRevistaExcepcion extends Exception {

    Publicacion p;

    public NoEsUnaRevistaExcepcion(Publicacion p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "Se ha generado un error" + "\t" + p.getNombre() + "\t" + "no es una revista";
    }

}
