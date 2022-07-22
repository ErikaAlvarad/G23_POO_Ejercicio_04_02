/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.Revista;

/**
 *
 * @author erika
 */
public interface IRevistaServicio {
    public Revista crear(Revista revista);
    public Revista buscarPorCodigo(int codigoRevista);
    public List<Revista> listar();
    public boolean almacenarEnArchivo(Revista revista, String rutaArchivo) throws Exception;
    public List<Revista> recuperarDeArchivo(String rutaArchivo) throws Exception;
    
}
