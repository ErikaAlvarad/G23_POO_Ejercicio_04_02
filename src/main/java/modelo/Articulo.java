/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author erika
 */
public class Articulo implements java.io.Serializable {
    private int codigo;
    private String titulo;
    private String idioma;
    private int numPublicaiones;
    private AutorPrincipal autorP;
    private Revista revista;

    public Articulo(int codigo, String titulo, String idioma, int numPublicaiones, AutorPrincipal autorP, Revista revista) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.idioma = idioma;
        this.numPublicaiones = numPublicaiones;
        this.autorP = autorP;
        this.revista = revista;
    }

    

    public boolean excedeNumPublicaciones(int numMax){
        var retorno = false;
        if (this.getNumPublicaiones() > numMax){
            retorno = true;
        }
        return retorno;
    }
    
    
    public boolean esIngles(){
        var retorno = false;
        if (this.getIdioma() == "Ingles"){
            retorno = true;
        }
        return retorno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumPublicaiones() {
        return numPublicaiones;
    }

    public void setNumPublicaiones(int numPublicaiones) {
        this.numPublicaiones = numPublicaiones;
    }

    public AutorPrincipal getAutorP() {
        return autorP;
    }

    public void setAutorP(AutorPrincipal autorP) {
        this.autorP = autorP;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    @Override
    public String toString() {
        return "Articulo{" + "codigo=" + codigo + ", titulo=" + titulo +
                ", idioma=" + idioma + ", numPublicaiones=" + numPublicaiones 
                + ", autorP=" + autorP + ", revista=" + revista + '}';
        
    }


    
    
    
}
