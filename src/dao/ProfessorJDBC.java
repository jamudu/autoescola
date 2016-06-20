//

package dao;

import exception.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.LlistaProfessor;
import model.Professor;

/**
 *
 * @author usu21
 */
public class ProfessorJDBC {
private Connection conexion;

    //funcio eliminar professor
    public boolean bajaProfessor(Professor p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from persona where codigo="+ p.getIdPersona()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return ok;
    }
    
    //funcion contar professors
    public int contarProfessor(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from professor";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    
    public LlistaProfessor totsProfessors(){
        LlistaProfessor lp=new LlistaProfessor();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from professor";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Professor pr=new Professor();
                    pr.setIdPersona(rs.getString("fk_persona"));  // =  rs.getString(1)
                    pr.setTipusEnsenyament(rs.getString("ensenyament"));
                    pr.setCarnet(rs.getInt("fk_carnet"));
                    lp.altaProfessor(pr);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }
        }
        return lp;
    }
    
    //funcion que comprueba si un professor existe, no recogemos el resultado de la busqueda
    public boolean existeProfessor(String codi){
        conectar();
        if (conexion !=null){
            try {
                String query = "select *from persona where codigo='" + codi + "'";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean existe=false;
                if (rs.next()){
                    existe= true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());                
                return false;
            }finally {
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcio modificar alumne
    public boolean modificarProfessor(Professor p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "UPDATE persona SET nom='"+ p.getNom()+ 
                        "',  cognoms='"+p.getCognoms()+ "', dataNaixement='"+p.getDataNaixement()+
                        "', ensenyament='"+p.getTipusEnsenyament()+ "' WHERE nif="+ p.getNif()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return true;
    }
    
    //funcion insertar professor
    public boolean insertarProfessor(Professor p){
        conectar();
        if (conexion != null){
            try {
                String insertar = "insert into professor values (?, ?, ?)";
                PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(insertar);
                ps.setString(1, p.getIdPersona());
                ps.setString(2, p.getTipusEnsenyament());
                ps.setInt(3, p.getCarnet());
                
                ps.executeUpdate();     //ejecuta la consulta
                ps.close();             //liberamos recursos
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al insertar: "+ ex.getLocalizedMessage());
                return false;
            }finally{
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcion abrir conexion SQL
    private void conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String user="root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }
    
   //funcion para desconectar conexion SQL
    private void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ProfessorJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}