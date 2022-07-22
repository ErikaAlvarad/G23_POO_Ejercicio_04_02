/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;
import modelo.AutorPrincipal;

/**
 *
 * @author erika
 */
public interface IAutorPrincipalServicio {
    public AutorPrincipal crear(AutorPrincipal autorPrincipal);
    public AutorPrincipal buscarPorCodigo(int codigoAutorPrincipal);
    public List<AutorPrincipal> listar();
    public boolean almacenarEnArchivo(AutorPrincipal autorPrincipal, String rutaArchivo) throws Exception;
    public List<AutorPrincipal> recuperarDeArchivo(String rutaArchivo) throws Exception;
    
    
}
