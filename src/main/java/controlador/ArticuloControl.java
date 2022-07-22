/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Articulo;
import modelo.AutorPrincipal;
import modelo.Revista;
import servicio.ArticuloServicio;
import servicio.AutorPrincipalServicio;
import servicio.RevistaServicio;

/**
 *
 * @author erika
 */
public class ArticuloControl {
    
    private final ArticuloServicio articuloServicio = new ArticuloServicio();
    private final AutorPrincipalServicio autorPrincipalServicio = new AutorPrincipalServicio();
    private final RevistaServicio revistaServicio = new RevistaServicio();
    
    public Articulo crear(String [] args){
        
        AutorPrincipal autorPrincipal = this.autorPrincipalServicio.buscarPorCodigo(convertirEntero(args[4]));
        Revista revista = this.revistaServicio.buscarPorCodigo(convertirEntero(args[5]));
        Articulo articulo = new Articulo(convertirEntero(args[0]), args[1],args[2],convertirEntero(args[3]), autorPrincipal,revista);
        
        this.articuloServicio.crear(articulo);
        return articulo;
    }
    
      public Articulo buscarArticulo(String arg){
        return this.articuloServicio.buscarPorCodigo(convertirEntero(arg));
    }
    
    public Articulo eliminar(String arg)
    {
        return this.articuloServicio.eliminar(convertirEntero(arg));
    }
    
    public Articulo modificar(String [] args){
        AutorPrincipal autorPrincipal = this.autorPrincipalServicio.buscarPorCodigo(convertirEntero(args[4]));
        Revista revista = this.revistaServicio.buscarPorCodigo(convertirEntero(args[5]));
        Articulo articuloNuevo = new Articulo(convertirEntero(args[0]), args[1],args[2],convertirEntero(args[3]), autorPrincipal,revista);
        this.articuloServicio.modificar(convertirEntero(args[0]), articuloNuevo);
        return articuloNuevo;
    }
    
    
    public List<Articulo> listar(){
        return this.articuloServicio.listar();
    }
    
    
     private int convertirEntero(String numero)
    {
        try{
            return Integer.valueOf(numero);
        }catch(NumberFormatException e1){
            throw new RuntimeException("Valor ingresado no es un número entero: "+e1.getMessage()); 
        }catch(Exception e1){
            throw new RuntimeException("Error inesperado"); 
        }
    }
}
