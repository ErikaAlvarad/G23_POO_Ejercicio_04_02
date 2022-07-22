/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author erika
 */
public class Revista implements java.io.Serializable {
    private int codigo;
    private String nombre;
    private int costo;
    private int cantidadPaginas;
    private int yearPublicacion;

    public Revista(int codigo, String nombre, int costo, int cantidadPaginas, int yearPublicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidadPaginas = cantidadPaginas;
        this.yearPublicacion = yearPublicacion;
    }

    public boolean excedeCantidadPaginas(int pagMax){
        var retorno = false;
        if(this.getCantidadPaginas() > pagMax){
            retorno = true;
        }
        return retorno;
    }
    
    
    public boolean esRevistaActual(int yearLimite){
        var retorno = false;
        if(this.getYearPublicacion() > yearLimite){
            retorno = true;
        }
        return retorno;
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getYearPublicacion() {
        return yearPublicacion;
    }

    public void setYearPublicacion(int yearPublicacion) {
        this.yearPublicacion = yearPublicacion;
    }

    @Override
    public String toString() {
        return "Revista{" + "codigo=" + codigo + ", nombre=" + nombre + ", costo=" + costo + ", cantidadPaginas=" + cantidadPaginas + ", yearPublicacion=" + yearPublicacion + '}';
    }
   

   
    
    
}
