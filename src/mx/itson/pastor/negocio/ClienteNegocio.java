/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastor.negocio;

import javax.swing.JOptionPane;
import mx.itson.pastor.entidades.Cliente;
import mx.itson.pastor.persistencia.ClienteDAO;

/**
 *
 * @author pyatq
 */
public class ClienteNegocio {
    
    public static boolean guardar(String nombre, String direccion, String telefono, String gmail ){
        boolean resultado = false;
        
        Cliente c = ClienteDAO.validarCorreo(nombre, direccion, telefono, gmail);
        
        try{
            
            if(c.getId() != 0){
                
                JOptionPane.showInputDialog(null, "Hay un error en el correo", "Error", JOptionPane.ERROR_MESSAGE);
               
            }else{
                
            resultado = ClienteDAO.guardar(nombre, direccion, telefono, gmail);
            
            } 
        }catch (Exception ex){
            System.err.println("A ocurrid un error " + ex.getMessage());
            
        }
        return resultado; 
    }
     
    
}
