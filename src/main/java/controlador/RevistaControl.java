/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.Revista;
import servicio.RevistaServicio;

/**
 *
 * @author erika
 */
public class RevistaControl {
    private final RevistaServicio revistaServicio = new RevistaServicio();
    
    public Revista crear(String [] args) {
        var revista = new Revista(convertirEntero(args[0]),args[1],
        convertirEntero(args[2]),convertirEntero(args[3]),convertirEntero(args[4]));
        this.revistaServicio.crear(revista);
        return revista;
    }
    
    public List<Revista> listar() {
        return this.revistaServicio.listar();
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
