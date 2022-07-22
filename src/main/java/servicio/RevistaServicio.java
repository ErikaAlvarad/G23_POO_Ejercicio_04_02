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
import modelo.Revista;

/**
 *
 * @author erika
 */
public class RevistaServicio implements IRevistaServicio{

    private static List<Revista> revistaList = new ArrayList<>();
    
    @Override
    public Revista crear(Revista revista) {
        var revistaBuscada=this.buscarPorCodigo(revista.getCodigo());
        if(revistaBuscada==null){
            this.revistaList.add(revista);
            try {
                this.almacenarEnArchivo(revista, "C:/carpeta1/archivoRevista.dat");
            } catch (Exception ex) {
                throw new RuntimeException("La revista no se pudo almacenar en el "
                        + "archivo de objetos"+ex.getMessage());
            }
            
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado a la revista:  "+revistaBuscada.getNombre());
        }
        return revista;
    }

    @Override
    public List<Revista> listar() {
        try {
            this.revistaList=this.recuperarDeArchivo("C:/carpeta1/archivoRevista.dat");
        } catch (Exception ex) {
            Logger.getLogger(RevistaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.revistaList;
    }

    @Override
    public Revista buscarPorCodigo(int codigoRevista) {
        Revista revista=null;
        for(var c:this.revistaList){
            if(codigoRevista==c.getCodigo()){
                revista=c;
                break;
            }
        }
        return revista;
    }

    @Override
    public boolean almacenarEnArchivo(Revista revista, String rutaArchivo) throws Exception {
    
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(revista);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Revista> recuperarDeArchivo(String rutaArchivo) throws Exception {
    
        var revistaList = new ArrayList<Revista>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                Revista revista = (Revista) entrada.readObject();
                revistaList.add(revista);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return revistaList;
    }
    
}
