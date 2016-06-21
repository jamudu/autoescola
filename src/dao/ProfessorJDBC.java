//
package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Carnet;
import model.LlistaProfessor;
import model.Professor;

/**
 *
 * @author usu21
 */
public class ProfessorJDBC {

    private Connection conexion;

    //funcio eliminar professor
    public boolean bajaProfessor(Professor p) {
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                conexion.setAutoCommit(false);
                String query = "delete from professor where fk_persona='"+ p.getNif()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                
                query = "delete from persona where nif='"+ p.getNif()+"';";
                st=conexion.createStatement();
                st.executeUpdate(query);
                
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
                desconectar();
            }        
        }
        return ok;
    }

    //funcion contar professors
    public int contarProfessor() {
        int cont = 0;
        conectar();
        if (conexion != null) {
            try {
                String query = "select count(*) as total from professor";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)

                if (rs.next()) {
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            } finally {
                desconectar();
            }
        }
        return cont;
    }

    public LlistaProfessor totsProfessors() {
        LlistaProfessor lp = new LlistaProfessor();
        conectar();
        if (conexion != null) {
            try {
                conexion.setAutoCommit(false);
                String query = "select * from professor INNER join persona on persona.nif = professor.fk_persona "
                        + "INNER join carnet on carnet.id = professor.fk_carnet";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Professor pr = new Professor();
                    pr.setNif(rs.getString("nif"));
                    pr.setNom(rs.getString("nom"));
                    pr.setCognoms(rs.getString("cognoms"));
                    pr.setDataNaixement(rs.getDate("dataNaixement"));
                    pr.setTipusEnsenyament(rs.getString("ensenyament"));
                    Carnet aux = new Carnet();
                    aux.setTipus(rs.getString("tipus"));
                    aux.setDescripcio(rs.getString("descripcio"));
                    aux.setPreuHora(rs.getDouble("preuHora"));
                    aux.setIdCarnet(rs.getInt("fk_carnet"));
                    pr.setCarnet(aux);
                    lp.altaProfessor(pr);
                }

                rs.close();
                st.close();

                return lp;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error en desfer la transacció.",
                            "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                return lp;
            } finally {
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en desconnectar.",
                            "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                desconectar();
            }
        }
        return lp;
    }

    //funcion que comprueba si un professor existe, no recogemos el resultado de la busqueda
    public boolean existeProfessor(String codi) {
        conectar();
        if (conexion != null) {
            try {
                String query = "select *from persona where nif='" + codi + "'";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean existe = false;
                if (rs.next()) {
                    existe = true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());                
                return false;
            } finally {
                desconectar();
            }
        } else {
            return false;
        }
    }

    //funcio modificar professor
    public boolean modificarProfessor(Professor p) {        
        conectar();
        if (conexion != null) {
            try {
                conexion.setAutoCommit(false);
                String query = "UPDATE persona SET nom='" + p.getNom()
                        + "',  cognoms='" + p.getCognoms() + "', dataNaixement='" + new java.sql.Date(p.getDataNaixement().getTime())
                        + "' WHERE nif='" + p.getNif() + "';";
                Statement st = conexion.createStatement();
                st.executeUpdate(query);
                
                query = "UPDATE professor SET ensenyament='" + p.getTipusEnsenyament() 
                        + "', fk_carnet=" + p.getCarnet().getIdCarnet()+ " WHERE fk_persona='" + p.getNif() + "';";
                st = conexion.createStatement();
                st.executeUpdate(query);                
                
                
                conexion.commit();
                
                st.close();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir el professor",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
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
                desconectar();
            }
        } else {
            return false;
        }
    }

    //funcion insertar professor
    public boolean insertarProfessor(Professor p) {
        conectar();
        if (conexion != null) {
            try {
                conexion.setAutoCommit(false);
                String sentencia = "insert into persona values (?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, p.getNif());
                ps.setString(2, p.getNom());
                ps.setString(3, p.getCognoms());
                ps.setDate(4, new java.sql.Date(p.getDataNaixement().getTime()));
                ps.executeUpdate();
                sentencia = "insert into professor values (?, ?, ?)";
                ps = conexion.prepareStatement(sentencia);
                ps.setString(1, p.getNif());
                ps.setString(2, p.getTipusEnsenyament());
                ps.setInt(3, p.getCarnet().getIdCarnet());
                ps.executeUpdate();
                conexion.commit();
                ps.close();

                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir el professor",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
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
                desconectar();
            }
        } else {
            return false;
        }
    }

    //funcion abrir conexion SQL
    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String user = "root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }

    //funcion para desconectar conexion SQL
    private void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}
