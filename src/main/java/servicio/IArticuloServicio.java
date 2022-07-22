/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Articulo;

/**
 *
 * @author erika
 */
public interface IArticuloServicio {
    
    public Articulo crear(Articulo articulo);
    public Articulo modificar(int codigoArticulo, Articulo articuloNuevo);
    public Articulo eliminar(int codigoArticulo);
    public Articulo buscarPorCodigo(int codigoArticulo);
    public int buscarPosicion(Articulo articulo);
    public List<Articulo> listar(); 
    public boolean almacenarEnArchivo(Articulo articulo, String rutaArchivo) throws Exception;
    public List<Articulo> recuperarDeArchivo(String rutaArchivo) throws Exception;
    
}
