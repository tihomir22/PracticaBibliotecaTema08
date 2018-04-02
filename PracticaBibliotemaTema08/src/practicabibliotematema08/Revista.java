/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabibliotematema08;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sportak
 */
public class Revista extends Publicacion {

    private ArrayList<Articulo> listaArticulos = new ArrayList<>();

    public Revista(int ISBN, String nombre, Calendar fecha) {
        super(ISBN, nombre, fecha);
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public int buscarPaginas(String titulo, String autor) {
        if (this.listaArticulos != null) {
            for (int i = 0; i < this.listaArticulos.size(); i++) {
                if (this.listaArticulos.get(i).getAutor().equalsIgnoreCase(autor) && this.listaArticulos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                    return this.listaArticulos.get(i).getNumPag();
                }
            }
        }
        return -1;
    }

    public void añadirArticulo(Articulo a) {
        this.listaArticulos.add(a);
    }

    public Articulo buscarArticulo(int artcod) {
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            if (this.listaArticulos.get(i).getNumero() == artcod) {
                return this.listaArticulos.get(i);
            }
        }
        return null;
    }

    public void imprimirArticulos() {
        System.out.println("La revista " + this.getNombre() + " tiene los siguientes articulos");
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            System.out.println(this.listaArticulos.get(i).toString());
        }
    }

    public void renumerarArticulos() {
        for (int i = 0; i < this.listaArticulos.size(); i++) {
            this.listaArticulos.get(i).setNumero(i);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
