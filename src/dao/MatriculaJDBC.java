//
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Alumne;
import model.Carnet;
import model.LlistaMatricula;
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
    
    public LlistaMatricula totesMatricules(){       //nomes idmatricula, noms , cognoms i tipus carnet
        LlistaMatricula lm=new LlistaMatricula();
        conectar();
        if (conexion !=null){
            try {
//                String query ="select * from matricula join carnet join persona join alumne on matricula.fk_carnet = carnet.id "
//                        + " and matricula.fk_alumne = alumne.fk_persona and alumne.fk_persona = persona.nif";
                
                String query ="select matricula.id, persona.nom, persona.cognoms, carnet.tipus from matricula join carnet join persona join alumne on matricula.fk_carnet = carnet.id "
                        + " and matricula.fk_alumne = alumne.fk_persona and alumne.fk_persona = persona.nif";
                
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Matricula ma=new Matricula();
                    
                    Alumne aux = new Alumne();                    
                    aux.setNom(rs.getString("persona.nom"));
                    aux.setCognoms(rs.getString("persona.cognoms"));
                    
                    Carnet aux2 = new Carnet();
                    aux2.setTipus("carnet.tipus");
                    
                    ma.setAlumne(aux);
                    ma.setCarnet(aux2);
                    ma.setIdMatricula(rs.getInt("matricula.id"));
                                       
                    lm.altaMatricula(ma);                    
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return lm;
    }

    //funcion contar matricules
    public int contarMatricules(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from matricula";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    public boolean insertarMatricula(Matricula m) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into matricula values (null, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                
                ps.setString(1, m.getAlumne().getNif());
                ps.setInt(2, m.getCarnet().getIdCarnet());
                ps.executeUpdate();
                ps.close();

                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir la matricula",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());

                return false;
            } finally {

                desconectar();
            }
        } else {
            return false;
        }
    }
}
