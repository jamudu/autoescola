
package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Alumne;
import model.LlistaAlumne;

/**
 *
 * @author usu21
 */
public class AlumneJDBC {
    private Connection conexion;
    
    
    private void connectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
        }
    }
    
    private void desconnectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inserirAlumne(Alumne a) {
        connectar();
        if (conexion != null) {
            try {
                conexion.setAutoCommit(false);
                String sentencia = "insert into persona values (?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, a.getNif());
                ps.setString(2, a.getNom());
                ps.setString(3, a.getCognoms());
                ps.setDate(4, new java.sql.Date(a.getDataNaixement().getTime()));                
                ps.executeUpdate();                
                sentencia = "insert into alumne values (?, ?)";                
                ps = conexion.prepareStatement(sentencia);
                ps.setString(1, a.getNif());
                ps.setInt(2, a.getNumIntentsExamen());
                ps.executeUpdate();
                conexion.commit();
                ps.close();
                
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir l'alumne.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                try {
                    conexion.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en desfer la transacció.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                return false;
            } finally {
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en desconnectar.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                desconnectar();
            }
        } else {
            return false;
        }
    }
    
    public boolean existeixAlumne(String nif) {
        connectar();
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
                //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                desconnectar();
            }
        } else {
            return false;
        }
    }
    
    //funcio modificar alumne
    public boolean modificarAlumne(Alumne a){
        boolean ok=false;
        connectar();
        if (conexion != null){
            try {
                conexion.setAutoCommit(false);
                String query = "UPDATE persona SET nom='"+ a.getNom()+ 
                        "',  cognoms='"+a.getCognoms()+ "', dataNaixement='"+new java.sql.Date(a.getDataNaixement().getTime())+
                        "' WHERE nif='"+ a.getNif()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);                                
               
                query = "UPDATE alumne SET numIntents="+a.getNumIntentsExamen()+ " WHERE fk_persona='"+ a.getNif()+"';";
                st=conexion.createStatement();
                st.executeUpdate(query);                    
                                               
                st.close();
                
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error en moddificar l'alumne.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en desfer la transacció.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                return false;
            }finally{
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en desconnectar.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                desconnectar();
            }        
        }
        return true;
    }
    
    //funcio eliminar alumne
    public boolean baixaAlumne(Alumne a){
        boolean ok=false;
        connectar();
        if (conexion != null){
            try {
                conexion.setAutoCommit(false);
                String query = "delete from alumne where fk_persona='"+ a.getNif()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                
                query = "delete from persona where nif='"+ a.getNif()+"';";
                st=conexion.createStatement();
                st.executeUpdate(query);
                
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
                JOptionPane.showMessageDialog(null, "Error en donar de l'alumne.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                try {
                    conexion.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en desfer la transacció.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                return false;
            }finally{
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en desconnectar.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                desconnectar();
            }        
        }
        return ok;
    }
    
    //funcion contar alumnes
    public int contarAlumne(){
        int cont=0;
        connectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from alumne";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(AlumneJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconnectar();
            }        
        }
        return cont;
    }
    
    public LlistaAlumne seleccionarAllAlumnes() {
        LlistaAlumne llista = new LlistaAlumne();
        connectar();
        
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
                    llista.altaAlumne(alumne);
                }
                
                rs.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Error en la consulta " + ex.getMessage());
            } finally {
                desconnectar();
            }
        }
        
        return llista;
    }
}
