//

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.LlistaCarnet;
import model.Carnet;

/**
 *
 * @author jaume
 */
public class CarnetJDBC {
 private Connection conexion;

    //funcio eliminar carnet
    public boolean baixaCarnet(Carnet c){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from carnet where id="+ c.getIdCarnet()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return ok;
    }
    
    //funcion contar carnets
    public int contarCarnets(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from carnet";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    
    public LlistaCarnet totsCarnets(){
        LlistaCarnet lc=new LlistaCarnet();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from carnet order by tipus";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Carnet ca=new Carnet();
                    ca.setIdCarnet(rs.getInt("id"));
                    ca.setTipus(rs.getString("tipus"));  // =  rs.getString(1)
                    ca.setDescripcio(rs.getString("descripcio"));
                    ca.setPreuHora(rs.getDouble("preuHora"));
                    lc.altaCarnet(ca);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }
        }
        return lc;
    }
    
    //funcion existeix carnet
    public boolean existeCarnet(String codi){
        conectar();
        if (conexion !=null){
            try {
                String query = "select *from carnet where id=" + codi +";";
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
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());                
                return false;
            }finally {
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcio modificar carnet
    public boolean modificarCarnet(Carnet c){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "UPDATE carnet SET tipus='"+ c.getTipus()+ 
                        "',  descripcio='"+c.getDescripcio()+ "', preuHora="+c.getPreuHora()+
                        " WHERE id="+ c.getIdCarnet()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return true;
    }
    
    //funcion insertar carnet
    public boolean insertarCarnet(Carnet c){
        conectar();
        if (conexion != null){
            try {
                String insertar = "insert into carnet values (?, ?, ?, ?)";
                PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(insertar);
                ps.setInt(1, c.getIdCarnet());
                ps.setString(2, c.getTipus());
                ps.setString(3, c.getDescripcio());
                ps.setDouble(4, c.getPreuHora());
                
                ps.executeUpdate();     //ejecuta la consulta
                ps.close();             //liberamos recursos
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
    
    //funcion abrir conexion SQL
    private void conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String user="root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }
    
   //funcion para desconectar conexion SQL
    private void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(CarnetJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}