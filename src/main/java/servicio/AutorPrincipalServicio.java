/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AutorPrincipal;

/**
 *
 * @author erika
 */
public class AutorPrincipalServicio implements IAutorPrincipalServicio{

    private static List<AutorPrincipal> autorPrincipalList = new ArrayList<>();
    
    @Override
    public AutorPrincipal crear(AutorPrincipal autorPrincipal) {
        
        var autorBuscado=this.buscarPorCodigo(autorPrincipal.getCodigo());
        if(autorBuscado==null){
            this.autorPrincipalList.add(autorPrincipal);
            try {
                this.almacenarEnArchivo(autorPrincipal, "C:/carpeta1/archivoAutorPrincipal.dat");
            } catch (Exception ex) {
                throw new RuntimeException("El barco no se pudo almacenar en el "
                        + "archivo de objetos"+ex.getMessage());
            }
            
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al autor: "+autorBuscado.getNombre());
        }
    return autorPrincipal;
    }

    @Override
    public List<AutorPrincipal> listar() {
    try {
            this.autorPrincipalList=this.recuperarDeArchivo("C:/carpeta1/archivoAutorPrincipal.dat");
        } catch (Exception ex) {
            Logger.getLogger(AutorPrincipalServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.autorPrincipalList;
    }

    @Override
    public AutorPrincipal buscarPorCodigo(int codigoAutorPrincipal) {
    
          AutorPrincipal autorPrincipal=null;
        for(var c:this.autorPrincipalList){
            if(codigoAutorPrincipal==c.getCodigo()){
                autorPrincipal=c;
                break;
            }
        }
        return autorPrincipal;
    }

    @Override
    public boolean almacenarEnArchivo(AutorPrincipal autorPrincipal, String rutaArchivo) throws Exception {
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(autorPrincipal);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<AutorPrincipal> recuperarDeArchivo(String rutaArchivo) throws Exception {
         var autorPrincipalList = new ArrayList<AutorPrincipal>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                AutorPrincipal autorPrincipal = (AutorPrincipal) entrada.readObject();
                autorPrincipalList.add(autorPrincipal);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return autorPrincipalList;
     
    }
  
}
