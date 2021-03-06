//

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Carnet;
import model.ListaVehicles;
import model.Vehicle;

/**
 *
 * @author jaume
 */
public class VehicleJDBC {
 private Connection conexion;
 
    public ListaVehicles vehiclesCarnet(int id_carn) {
        ListaVehicles lv = new ListaVehicles();
        conectar();
        if (conexion != null) {
            try {
                conexion.setAutoCommit(false);
                String query = "select * from vehicle INNER join carnet on fk_carnet ="+ id_carn+" group by model;";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Vehicle ve = new Vehicle();
                    ve.setMatricula(rs.getString("matricula"));
                    ve.setMarca(rs.getString("marca"));
                    ve.setModel(rs.getString("model"));
                    
                    Carnet aux = new Carnet();
                    aux.setTipus(rs.getString("tipus"));
                    aux.setDescripcio(rs.getString("descripcio"));
                    aux.setPreuHora(rs.getDouble("preuHora"));
                    aux.setIdCarnet(rs.getInt("fk_carnet"));
                    ve.setCarnet(aux);
                    
                    lv.altaVehicle(ve);
                }
                rs.close();
                st.close();

                return lv;

            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error",
//                        "Error!!!", JOptionPane.ERROR_MESSAGE);
//                System.out.println(ex.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, "Error en desfer la transacció.",
//                            "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                return lv;
            } finally {
                try {
                    conexion.setAutoCommit(true);
                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Error en desconnectar.",
//                            "Error!!!", JOptionPane.ERROR_MESSAGE);
                }
                desconectar();
            }
        }
        return lv;
    }

    //funcio eliminar vehicle
    public boolean baixaVehicle(Vehicle v){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from vehicle where matricula='"+ v.getMatricula()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconectar();
            }        
        }
        return ok;
    }
    
    //funcion contar vehicles
    public int contarVehicles(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from vehicle";
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
    
    
    public ListaVehicles totsVehicles(){
        ListaVehicles lp=new ListaVehicles();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from vehicle join carnet on vehicle.fk_carnet = carnet.id ";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Vehicle ve=new Vehicle();
                    ve.setMatricula(rs.getString("matricula"));  // =  rs.getString(1)
                    ve.setMarca(rs.getString("marca"));
                    ve.setModel(rs.getString("model"));
                    Carnet aux = new Carnet();
                    aux.setTipus(rs.getString("tipus"));
                    aux.setDescripcio(rs.getString("descripcio"));
                    aux.setPreuHora(rs.getDouble("preuHora"));
                    aux.setIdCarnet(rs.getInt("fk_carnet"));
                    ve.setCarnet(aux);
                   
                    lp.altaVehicle(ve);                    
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
    
    //funcion existeix vehicle
    public boolean existeVehicle(String codi){
        conectar();
        if (conexion !=null){
            try {
                String query = "select *from vehicle where matricula='" + codi + "'";
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
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al consultar dades: "+ ex.getLocalizedMessage());                
                return false;
            }finally {
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcio modificar vehicle
    public boolean modificarVehicle(Vehicle v){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "UPDATE vehicle SET matricula='"+ v.getMatricula()+ 
                        "',  marca='"+v.getMarca()+ "', model='"+v.getModel()+ "', fk_carnet="+v.getCarnet().getIdCarnet()+
                        " WHERE matricula='"+ v.getMatricula()+"';";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return true;
    }
    
    //funcion insertar vehicle
    public boolean insertarVehicle(Vehicle v){
        conectar();
        if (conexion != null){
            try {
                String sentencia = "insert into vehicle values (?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setString(1, v.getMatricula());
                ps.setString(2, v.getMarca());
                ps.setString(3, v.getModel());
                ps.setInt(4, v.getCarnet().getIdCarnet());  
                
                ps.executeUpdate();     //ejecuta la consulta
                ps.close();             //liberamos recursos
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
            //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }
    
   //funcion para desconectar conexion SQL
    private void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}