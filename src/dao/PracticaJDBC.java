//

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.LlistaPractica;
import model.Alumne;
import model.Carnet;
import model.Practica;
import model.Professor;
import model.Vehicle;

/**
 *
 * @author jaume
 */
public class PracticaJDBC {
  private Connection conexion;

    private void conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //funcio eliminar matricula
    public boolean baixaPractica(Practica p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from practica where id='";     //+ p.getIdMatricula()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
            }        
        }
        return ok;
    }
    
    public LlistaPractica totesPractiques(){       
        LlistaPractica lp=new LlistaPractica();
        conectar();
        if (conexion !=null){
            try {

                String query ="select matricula.id, persona.nom, persona.cognoms, carnet.tipus from matricula join carnet join persona join alumne on matricula.fk_carnet = carnet.id "
                        + " and matricula.fk_alumne = alumne.fk_persona and alumne.fk_persona = persona.nif";
                
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Practica pr=new Practica();
                    
                    Alumne aux = new Alumne();                    
                    aux.setNom(rs.getString("persona.nom"));
                    aux.setCognoms(rs.getString("persona.cognoms"));
                    
                    Professor aux2 = new Professor();
                    aux2.setCognoms(rs.getString("persona.cognoms"));
                    
                    Vehicle aux3 = new Vehicle();
                    aux3.setModel(rs.getString("vehicle.model"));
                    
                    pr.setAlumne(aux);
                    pr.setProfessor(aux2);
                    pr.setVehicle(aux3);
                                       
                    lp.altaPractica(pr);                    
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
        return lp;
    }

    //funcion contar practiques
    public int contarPractiques(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from practica";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    //funcion buscar carnet alumne
    public Carnet buscaCarnet(String a){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                int id_car=0;
                String query = "select * from matricula where fk_alumne='" + a+"'";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                if (rs.next()){
                id_car=(rs.getInt("fk_carnet"));
                }
                query = "select * from carnet where id="+id_car+";";
                st=conexion.createStatement();
                rs=st.executeQuery(query);
                
                Carnet ca = new Carnet();
                if (rs.next()){
                    ca.setIdCarnet(rs.getInt("id"));
                    ca.setTipus(rs.getString("tipus"));
                }
                rs.close();
                st.close(); 
                return ca;
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return null;
    }
    
    //funcion comprobar dates
    public boolean comprobarDat(Date d, int h){
        conectar();
        if (conexion != null){
//            try {
//                String query = "select * from matricula where fk_alumne='" + a+"'";
//                Statement st=conexion.createStatement();
//                ResultSet rs=st.executeQuery(query);
//                //si ResultSet tiene algo (si tiene next)
//                if (rs.next()){
//                id_car=(rs.getInt("fk_carnet"));
//                }
//                query = "select * from carnet where id="+id_car+";";
//                st=conexion.createStatement();
//                rs=st.executeQuery(query);
//                
//                Carnet ca = new Carnet();
//                if (rs.next()){
//                    ca.setIdCarnet(rs.getInt("id"));
//                    ca.setTipus(rs.getString("tipus"));
//                }
//                rs.close();
//                st.close(); 
//                return ca;
//            } catch (SQLException ex) {
//                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
//                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
//            }finally{
//                desconectar();
//            }        
        }
        return false;
    }
    
    public boolean insertarPractica(Practica p) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into practica values (null, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                
//                ps.setString(1, p.getAlumne().getNif());
//                ps.setInt(2, p.getCarnet().getIdCarnet());
//                ps.executeUpdate();
                ps.close();

                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir la practica",
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

