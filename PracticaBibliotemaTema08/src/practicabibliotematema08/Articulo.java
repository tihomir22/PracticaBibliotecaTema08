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
public class Articulo {

    private int numero;
    private String titulo;
    private String autor;
    private int numPag;

    public Articulo(int numero, String titulo, String autor, int numPag) {
        this.numero = numero;
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    @Override
    public String toString() {
        return this.numero + "\t" + this.titulo + "\t" + this.autor + "\t" + this.numPag;
    }

}
