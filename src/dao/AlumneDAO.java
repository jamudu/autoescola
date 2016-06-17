
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Alumne;
import model.LlistaAlumne;

/**
 *
 * @author usu21
 */
public class AlumneDAO {
    private Connection conexion;
    
    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            System.out.println("Error al conectar: " + ex.getMessage());
            conexion = null;
        }
    }
    
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar: " + ex.getMessage());
        }
    }
    
    public boolean inserirAlumne(Alumne a) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into pelicula values (?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, a.getNif());
                ps.setString(2, a.getNom());
                ps.setString(3, a.getCognoms());
                ps.setDate(4, new java.sql.Date(a.getDataNaixement().getTime()));
                ps.setInt(5, a.getNumIntentsExamen());
                ps.executeUpdate();
                ps.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error al insertar: " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
    
    public boolean existeixAlumne(String nif) {
        conectar();
        if (conexion != null) {
            try {
                String query = "select * from persona where nif = '" + nif + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                boolean existe = false;
                if (rs.next()) {
                    existe = true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                System.out.println("Error al consultar " + ex.getMessage());
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }
    
    public LlistaAlumne selectAllAlumnes() {
        LlistaAlumne llista = new LlistaAlumne();
        conectar();
        
        if (conexion != null) {
            try {
                String query = "select * from persona join alumne where nif = alumne.fk_persona;";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Alumne alumne = new Alumne();
                    alumne.setNif(rs.getString("nif"));
                    alumne.setNom(rs.getString("nom"));
                    alumne.setCognoms(rs.getString("cognoms"));
                    alumne.setDataNaixement(rs.getDate("dataNaixement"));
                    alumne.setNumIntentsExamen(rs.getInt("numIntents"));
                    //llista.
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconectar();
            }
        }
        
        return llista;
    }
}
