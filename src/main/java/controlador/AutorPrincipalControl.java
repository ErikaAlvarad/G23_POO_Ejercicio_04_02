/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import modelo.AutorPrincipal;
import servicio.AutorPrincipalServicio;

/**
 *
 * @author erika
 */
public class AutorPrincipalControl {
    private final AutorPrincipalServicio autorPrincipalServicio = new AutorPrincipalServicio();
    
    public AutorPrincipal crear(String [] args) {
        var autorPrincipal = new AutorPrincipal(convertirEntero(args[0]),args[1],args[2],
        convertirEntero(args[3]),convertirEnteroDouble(args[4]));
        this.autorPrincipalServicio.crear(autorPrincipal);
        return autorPrincipal;
    }
    
    public List<AutorPrincipal> listar() {
        return this.autorPrincipalServicio.listar();
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
    
    private double convertirEnteroDouble(String numero)
    {
        try{
            return Double.valueOf(numero);
        }catch(NumberFormatException e1){
            throw new RuntimeException("Valor ingresado no es un número entero: "+e1.getMessage()); 
        }catch(Exception e1){
            throw new RuntimeException("Error inesperado"); 
        }
    }
}
