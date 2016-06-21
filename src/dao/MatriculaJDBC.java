//

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Matricula;

/**
 *
 * @author jaume
 */
public class MatriculaJDBC {
 private Connection conexion;
    
    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            //Logger.getLogger(MatriculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
        }
    }
    
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(MatriculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertarMatricula(Matricula m) {
        conectar();
        if (conexion != null) {
            try {                
                String sentencia = "insert into Matricula values (?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setInt(1, m.getIdMatricula());
//                ps.setString(2, m.getNifAlumne());
//                ps.setInt(3, m.getIdCarnet());
                ps.executeUpdate();            
                
                ps.close();
                
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al insertar: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
                return false;
            }finally{
                desconectar();
            }
        }else{
            return false;
        }
    }
}
