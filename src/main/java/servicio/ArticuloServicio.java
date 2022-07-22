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
import modelo.Articulo;

/**
 *
 * @author erika
 */
public class ArticuloServicio implements IArticuloServicio{

    private static List<Articulo> articuloList = new ArrayList<>();
    
    @Override
    public Articulo crear(Articulo articulo) {
        var articuloBuscado=this.buscarPorCodigo(articulo.getCodigo());
        if(articuloBuscado==null){
            this.articuloList.add(articulo);
            
            try {
                this.almacenarEnArchivo(articulo, "C:/carpeta1/archivoArticulo.dat");
            } catch (Exception ex) {
                throw new RuntimeException("El articulo no se pudo almacenar en el "
                        + "archivo de objetos"+ex.getMessage());
            }
            
        }else{
            throw new RuntimeException("El código ingresado ya se encuentra "
                    + "asignado al articulo: "+articuloBuscado.getTitulo());
        }
       return articulo;
    }

    @Override
    public List<Articulo> listar() {try {
            this.articuloList=this.recuperarDeArchivo("C:/carpeta1/archivoArticulo.dat");
        } catch (Exception ex) {
            Logger.getLogger(ArticuloServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.articuloList;
    }

    @Override
    public Articulo modificar(int codigoArticulo, Articulo articuloNuevo) {
    
        var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoArticulo));
        this.listar().get(posicion).setTitulo(articuloNuevo.getTitulo());
        this.listar().get(posicion).setIdioma(articuloNuevo.getIdioma());
        this.listar().get(posicion).setNumPublicaiones(articuloNuevo.getNumPublicaiones());
        this.listar().get(posicion).setAutorP(articuloNuevo.getAutorP());
        this.listar().get(posicion).setRevista(articuloNuevo.getRevista());
        return articuloNuevo;
    }

    @Override
    public Articulo eliminar(int codigoArticulo) {
    
        Articulo articulo=this.buscarPorCodigo(codigoArticulo);
        var posicion=this.buscarPosicion(articulo);
        this.listar().remove(posicion);
        return articulo;
        
        
    }

    @Override
    public Articulo buscarPorCodigo(int codigoArticulo) {
        Articulo articulo=null;
        for(var b:this.articuloList){
            if(codigoArticulo==b.getCodigo()){
                
                articulo=b;
                break;
            }
        }
        return articulo;
//    throw new RuntimeException("No se encontró el código de la profesión");
    }

    @Override
    public int buscarPosicion(Articulo articulo) {
    
        int posicion=-1;
        for(var b:this.articuloList){
            posicion++;
            if(b.getCodigo()==articulo.getCodigo()){
                break;
            }
        }
        return posicion;
    }

    @Override
    public boolean almacenarEnArchivo(Articulo articulo, String rutaArchivo) throws Exception {
    
        ObjectOutputStream salida=null;
        var retorno=false;
        try{
            salida = new ObjectOutputStream(new FileOutputStream(new File(rutaArchivo),true));
            salida.writeObject(articulo);
            salida.close();
            retorno=true;
        }catch(Exception e1){
            System.out.println(e1.toString());
            salida.close();
        }
        return retorno;
    }

    @Override
    public List<Articulo> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var articuloList = new ArrayList<Articulo>();
        var fis = new FileInputStream(new File(rutaArchivo));
        ObjectInputStream entrada = null;
        try{        
            while(fis.available()>0){
                entrada = new ObjectInputStream(fis);
                Articulo articulo = (Articulo) entrada.readObject();
                articuloList.add(articulo);
            }
            entrada.close();
        }catch(Exception ex){
            entrada.close();
        }
        return articuloList;
    
    }
    
} 
