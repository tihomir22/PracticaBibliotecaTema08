/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicabibliotematema08;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author sportak
 */
public class PracticaBibliotemaTema08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Biblioteca biblio1 = null;
        Libro libro1 = null;
        Revista revista1;
        Publicacion activo;
        Articulo articul1;
        Articulo articulActiv;
        boolean unaVez = false;
        int opcion, isbn, numC = 1, numUs, numPag;
        String nombre, nombreP, autor, titulo;
        Calendar fecha = Calendar.getInstance();
        //No usé el switch porque lo vi innecesario debido a las pocas opciones que presentaba el ejercicio, en total 4 sin contar el salir...Se que te enfadaras, por ello te dejare al final del ejercicio un codigo ASCII
        do {
            if (!unaVez) {
                System.out.println("Introduzca nombre de la biblioteca");
                nombre = teclado.nextLine();
                biblio1 = new Biblioteca(nombre);
                unaVez = true;
            }
            mostrarMenu1();
            opcion = teclado.nextInt();
            if (opcion == 1) {
                mostrarMenuGP();
                opcion = teclado.nextInt();
                if (opcion == 1) {
                    System.out.println("Que nombre tiene la publicacion?");
                    teclado.nextLine();

                    nombreP = teclado.nextLine();
                    System.out.println("Que isbn tiene la publicacion?");
                    isbn = teclado.nextInt();

                    System.out.println("Que tipo de publicacion deseas dar de alta? Libro o Revista");
                    teclado.nextLine();
                    nombre = teclado.nextLine();
                    try {
                        if (nombre.equalsIgnoreCase("libro")) {
                            System.out.println("Cual es el autor?");
                            autor = teclado.nextLine();
                            libro1 = new Libro(autor, isbn, nombreP, fecha);
                            biblio1.añadirPublicacion(libro1);
                        } else if (nombre.equalsIgnoreCase("revista")) {
                            revista1 = new Revista(isbn, nombreP, fecha);
                            biblio1.añadirPublicacion(revista1);

                        } else {
                            System.out.println("No ha introducido ninguna opcion valida");
                        }
                    } catch (ExcepcionPubliYaExiste e) {
                        System.out.println(e.toString());
                    }
                } else if (opcion == 2) {
                    System.out.println("Introduzca el ISBN de la publicacion a borrar");
                    isbn = teclado.nextInt();
                    activo = biblio1.buscarPublicacion(isbn);
                    if (activo != null) {
                        if (activo instanceof Libro) {
                            if (biblio1.getListaPublicaciones().remove(activo)) {
                                System.out.println("Se ha eliminado exitosamente");
                            } else {
                                System.out.println("No pudo eliminarse");
                            }
                        } else if (activo instanceof Revista) {
                            if (((Revista) activo).getListaArticulos() == null || ((Revista) activo).getListaArticulos().isEmpty()) {
                                if (biblio1.getListaPublicaciones().remove(activo)) {
                                    System.out.println("Se ha eliminado exitosamente");
                                } else {
                                    System.out.println("No pudo eliminarse");
                                }
                            } else {
                                System.out.println("No se puede eliminar porque la revista tiene articulos");
                            }
                        }
                    } else {
                        System.out.println("No fue encontrado");
                    }
                }

            } else if (opcion == 2) {
                mostrarMenuGA();
                opcion = teclado.nextInt();
                if (opcion == 1) {
                    System.out.println("Introduzca ISBN de la revista ");
                    isbn = teclado.nextInt();
                    activo = biblio1.buscarPublicacion(isbn);
                    if (activo != null) {
                        try {
                            if (activo instanceof Revista) {
                                System.out.println("Introduce el titulo del articulo");
                                teclado.nextLine();
                                titulo = teclado.nextLine();
                                System.out.println("Introduce el autor del articulo");
                                autor = teclado.nextLine();
                                numPag = ((Revista) activo).buscarPaginas(titulo, autor);

                                if (numPag == -1) {
                                    System.out.println("Introduce las paginas que tendra el articulo");
                                    numPag = teclado.nextInt();
                                    articul1 = new Articulo(numC, titulo, autor, numPag);
                                    ((Revista) activo).añadirArticulo(articul1);
                                    System.out.println("Es la primera vez que se añade");
                                    System.out.println(articul1.toString());
                                    ((Revista) activo).imprimirArticulos();
                                } else {
                                    articul1 = new Articulo(numC, titulo, autor, numPag);
                                    ((Revista) activo).añadirArticulo(articul1);
                                    System.out.println("Los autores coinciden por lo que se copian las paginas");
                                    System.out.println(articul1.toString());
                                    ((Revista) activo).imprimirArticulos();
                                }
                            } else {
                                throw new NoEsUnaRevistaExcepcion(activo);
                            }
                        } catch (NoEsUnaRevistaExcepcion e) {
                            System.out.println(e.toString());
                        }
                    } else {
                        System.out.println("No fue encontrado...");
                    }
                } else if (opcion == 2) {
                    System.out.println("Introduce el numero de articulo");
                    numUs = teclado.nextInt();
                    System.out.println("En que revista?Introduzca ISBN");
                    isbn = teclado.nextInt();
                    activo = biblio1.buscarPublicacion(isbn);
                    try {
                        if (activo instanceof Revista) {
                            articulActiv = ((Revista) activo).buscarArticulo(numUs);
                            if (articulActiv != null) {
                                if (((Revista) activo).getListaArticulos().remove(articulActiv)) {
                                    System.out.println("Eliminacion exitosa pasamos a renumerar los articulos");
                                    ((Revista) activo).renumerarArticulos();
                                    ((Revista) activo).imprimirArticulos();
                                }
                            } else {
                                System.out.println("No se ha encontrado el articulo");
                            }
                        } else {
                            throw new NoEsUnaRevistaExcepcion(activo);
                        }
                    } catch (NoEsUnaRevistaExcepcion e) {
                        System.out.println(e.toString());
                    }
                }
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu1() {
        System.out.println("1.-Gestion de Publicaciones");
        System.out.println("2.-Gestion de Articulos");
        System.out.println("0.-Salir");

    }

    public static void mostrarMenuGP() {
        System.out.println("1.1.-Alta de publicaciones");
        System.out.println("1.2.-Borrado de publicaciones");
    }

    public static void mostrarMenuGA() {
        System.out.println("2.1.-Añadir articuclos a una revista");
        System.out.println("2.2.-Borrar articulo");
    }
}
