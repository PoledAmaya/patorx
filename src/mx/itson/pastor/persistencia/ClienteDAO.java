/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.pastor.persistencia;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastor.entidades.Cliente;

/**
 *
 * @author alumnog
 */
public class ClienteDAO {
    
    public static List<Cliente> obtenerTodos(){
        
        List<Cliente> cliente = new ArrayList<>();
        try{
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, nombre, direccion, telefono, gmail FROM cliente");
            
            while(resultSet.next()){
                Cliente c = new Cliente();
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setDireccion(resultSet.getString(3));
                c.setTelefono(resultSet.getString(4));
                c.setGmail(resultSet.getString(5));
                cliente.add(c);
            }
            
        } catch (Exception ex){
            System.err.print("Ocurrio un Error:" + ex.getMessage());
        }
        return cliente;
    }
        public static boolean guardar (String nombre, String direccion, String telefono, String gmail){
          boolean resultado = false;
          
          try{
    Connection connection = Conexion.obtener();
    String consulta = "INSERT INTO cliente(nombre, direccion, telefono, gmail) VALUES (?, ? , ? ,?)";
    PreparedStatement statement = connection.prepareStatement(consulta);
    statement.setString(1, nombre);
    statement.setString(2, direccion);
    statement.setString(3, telefono);
    statement.setString(4, gmail);
    }catch (Exception ex){
    System.err.print("Ocurrio un error:" + ex.getMessage());
    
}
       return resultado;   
        }
 public static Cliente validarCorreo(String nombre, String direccion, String telefono, String gmail) {
        
        Cliente c = new Cliente();
        
        try{
            Connection coneccion = Conexion.obtener();
            String consulta = "SELECT id, nombre, direccion, telefono, gmail FROM cliente  WHERE gmail like?";
            PreparedStatement statement = coneccion.prepareStatement(consulta);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()){
            
                c.setId(resultSet.getInt(1));
                c.setNombre(resultSet.getString(2));
                c.setGmail(resultSet.getString(3));
        }
            
        }catch (Exception e){
            
            System.out.println("Hubo un error al validar" + e.getMessage());
        }
            
             return c;
            }
 }

    



