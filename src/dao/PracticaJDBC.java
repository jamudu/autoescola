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
            //Logger.getLogger(PracticaaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //funcio eliminar practica
    public boolean baixaPractica(Practica p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from practica where codi="+ p.getCodi()+";";
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
    
    public LlistaPractica practiquesAlumne(Alumne a){       
        LlistaPractica lp=new LlistaPractica();
        conectar();
        if (conexion !=null){
            try {

                String query ="select data, horaInici from practica join persona on fk_alumne ='"+a.getNif()
                        +"' and nif='"+a.getNif()+"' order by data, horaInici";
                
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Practica pr=new Practica();
                    
                    Alumne aux = new Alumne();                    
                                        
                    Professor aux2 = new Professor();
                    
                    Vehicle aux3 = new Vehicle();
                    
                    pr.setAlumne(aux);
                    pr.setProfessor(aux2);
                    pr.setVehicle(aux3);
                    pr.setData(rs.getDate("data"));
                    pr.setHoraInici(rs.getInt("horaInici"));
                    lp.altaPractica(pr);                    
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return lp;
    }
    
    public LlistaPractica practiquesProfessor(Professor p){       
        LlistaPractica lp=new LlistaPractica();
        conectar();
        if (conexion !=null){
            try {

                String query ="select data, horaInici from practica join persona on fk_professor ='"+p.getNif()
                        +"' and nif='"+p.getNif()+"' order by data, horaInici";
                
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Practica pr=new Practica();
                    
                    Alumne aux = new Alumne();                    
                                        
                    Professor aux2 = new Professor();
                    
                    Vehicle aux3 = new Vehicle();
                    
                    pr.setAlumne(aux);
                    pr.setProfessor(aux2);
                    pr.setVehicle(aux3);
                    pr.setData(rs.getDate("data"));
                    pr.setHoraInici(rs.getInt("horaInici"));
                    lp.altaPractica(pr);                    
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return lp;
    }
    
    public LlistaPractica practiquesVehicle(Vehicle v){       
        LlistaPractica lp=new LlistaPractica();
        conectar();
        if (conexion !=null){
            try {

                String query ="select data, horaInici from practica join vehicle on fk_vehicle ='"+v.getMatricula()
                        +"' group by data, horaInici order by data, horaInici;";
                
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Practica pr=new Practica();
                    
                    Alumne aux = new Alumne();                    
                                        
                    Professor aux2 = new Professor();
                    
                    Vehicle aux3 = new Vehicle();
                    
                    pr.setAlumne(aux);
                    pr.setProfessor(aux2);
                    pr.setVehicle(aux3);
                    pr.setData(rs.getDate("data"));
                    pr.setHoraInici(rs.getInt("horaInici"));
                    lp.altaPractica(pr);                    
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return lp;
    }
    
    public LlistaPractica totesPractiques(){       
        LlistaPractica lp=new LlistaPractica();
        conectar();
        if (conexion !=null){
            try {
                Statement st=conexion.createStatement();
                st.executeUpdate("DROP table if exists temporal");
                String crear="create table if not exists temporal"
                        + "(nifp varchar(9) not null PRIMARY KEY, "
                        + "nomp varchar(20) NOT NULL, "
                        + "cognomsp varchar(45) NOT NULL);";
                //Statement st=conexion.createStatement();
                st.executeUpdate(crear);
                
                String copiar="insert temporal (nifp, nomp, cognomsp) select nif, nom, cognoms from persona";
                st=conexion.createStatement();
                st.executeUpdate(copiar);
                
                String query ="select * from practica join carnet join persona join alumne join professor join vehicle join temporal " 
                        + "on fk_alumne=nif and fk_vehicle=matricula and alumne.fk_persona=nif and "
                        + "fk_professor=nifp and professor.fk_persona=nifp and "
                        + "practica.fk_professor=professor.fk_persona and vehicle.fk_carnet=id order by codi";     
                
                st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Practica pr=new Practica();
                    
                    Alumne aux = new Alumne();   
                    aux.setNif(rs.getString("alumne.fk_persona"));
                    aux.setNom(rs.getString("persona.nom"));
                    aux.setCognoms(rs.getString("persona.cognoms"));
                    
                    Professor aux2 = new Professor();
                    aux2.setNif(rs.getString("professor.fk_persona"));
                    aux2.setNom(rs.getString("temporal.nomp"));
                    aux2.setCognoms(rs.getString("temporal.cognomsp"));
                    
                    Vehicle aux3 = new Vehicle();
                    aux3.setMatricula(rs.getString("vehicle.matricula"));
                    aux3.setMarca(rs.getString("vehicle.marca"));
                    aux3.setModel(rs.getString("vehicle.model"));
                    
                    pr.setAlumne(aux);
                    pr.setProfessor(aux2);
                    pr.setVehicle(aux3);
                    
                    pr.setCodi(rs.getInt("codi"));
                    pr.setData(rs.getDate("data"));
                    pr.setHoraInici(rs.getInt("horaInici"));
                                       
                    lp.altaPractica(pr);                    
                }
                st.executeUpdate("DROP table temporal");
                rs.close();
                st.close();
                
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconectar();
                
            }
        }
        return lp;
    }
    
    //funcion contar practiques per alumne
    public int contarPractiquesAlumne(Alumne a){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from practica where fk_alumne='"+a.getNif()+"';";
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
           
    //funcion comprobar dates del professor
    public boolean comprobarDatProfessor(Professor p, int dia, int mes, int any, int hora){
        conectar();
        if (conexion != null){
            try {
                String query = "select data from practica join professor join persona "
                        + "on fk_professor='"+ p.getNif()+"' and DAY(data)="+dia+" and MONTH(data)="+mes
                        +" and YEAR(data)="+any+" and horaInici="+hora+" group by data;";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean yaExisteix=false;
                if (rs.next()){
                yaExisteix=true;
                }
                
                rs.close();
                st.close(); 
                return yaExisteix;
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return false;
    }
    
    //funcion comprobar dates del vehicle
    public boolean comprobarDatVehicle(Vehicle v, int dia, int mes, int any, int hora){
        conectar();
        if (conexion != null){
            try {
                String query = "select data from practica join vehicle "
                        + "on fk_vehicle='"+ v.getMatricula()+"' and DAY(data)="+dia+" and MONTH(data)="+mes
                        +" and YEAR(data)="+any+" and horaInici="+hora+" group by data;";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean yaExisteix=false;
                if (rs.next()){
                yaExisteix=true;
                }
                
                rs.close();
                st.close(); 
                return yaExisteix;
            } catch (SQLException ex) {
                //Logger.getLogger(PracticaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return false;
    }
    
    public boolean insertarPractica(Practica p) {
        conectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into practica values (null, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                
                ps.setString(1, p.getAlumne().getNif());
                ps.setString(2, p.getProfessor().getNif());
                ps.setString(3, p.getVehicle().getMatricula());
                ps.setDate(4, new java.sql.Date(p.getData().getTime()));
                ps.setInt(5, p.getHoraInici());
                ps.executeUpdate();
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

