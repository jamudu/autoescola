//

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Factura;
import model.ListaFactures;
import model.Matricula;

/**
 *
 * @author jaume
 */
public class FacturaJDBC {    
    private Connection conexion;
    
    private void connectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoescola";
            String usr = "root";
            String pass = "jeveris";
            conexion = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            //Logger.getLogger(FacturaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
        }
    }
    
    private void desconnectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(FacturaJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertarFra(Factura f, int cod) {
        connectar();
        if (conexion != null) {
            try {
                String sentencia = "insert into factura values (?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(sentencia);
                ps.setInt(1, f.getCodi());
                ps.setDate(2, new java.sql.Date(f.getData().getTime()));
                ps.setDouble(3, f.getTotal());
                ps.setInt(4, cod);                
                ps.executeUpdate();                
                
                ps.close();
                
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error en inserir la factura.",
                        "Error!!!", JOptionPane.ERROR_MESSAGE);                
                return false;
            } finally {                
                desconnectar();
            }
        } else {
            return false;
        }
    }
    
    public boolean existeixFactura(int codi) {
        connectar();
        if (conexion != null) {
            try {
                String query = "select * from factura join matricula on fk_matricula=id and id="+codi+";";
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
                //Logger.getLogger(FacturaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                desconnectar();
            }
        } else {
            return false;
        }
    }
    
    public boolean exisFactura(int codi) {
        connectar();
        if (conexion != null) {
            try {
                String query = "select * from factura where codi="+codi+";";
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
                //Logger.getLogger(FacturaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                desconnectar();
            }
        } else {
            return false;
        }
    }
    
    //funcion contar factures
    public int contarFactura(){
        int cont=0;
        connectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from factura";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(FacturaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
            }finally{
                desconnectar();
            }        
        }
        return cont;
    }
    
    //funcio eliminar factura
    public boolean baixaFactura(Factura f){
        boolean ok=false;
        connectar();
        if (conexion != null){
            try {
                String query = "delete from factura where codi="+ f.getCodi()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(VehicleJDBC.class.getName()).log(Level.SEVERE, null, ex);
                //throw new MyException("Error al actualizar dades: "+ ex.getLocalizedMessage());
                System.out.println(ex.getMessage());
            }finally{
                desconnectar();
            }        
        }
        return ok;
    }
    
    public ListaFactures seleccionarAllFactures() {
        ListaFactures llista = new ListaFactures();
        connectar();        
        if (conexion != null) {
            try {
                String query = "select * from factura join matricula join alumne join persona join carnet "
                        + "on fk_matricula=matricula.id and fk_carnet=carnet.id and fk_alumne=fk_persona and fk_persona=nif;";
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()) {
                    Factura f = new Factura();
                    f.setCodi(rs.getInt("codi"));
                    f.setData(rs.getDate("data"));
                    f.setTotal(rs.getDouble("total"));
                    
                    Matricula m=new Matricula();
                    m.getAlumne().setNom(rs.getString("nom"));
                    m.getAlumne().setCognoms(rs.getString("cognoms"));
                    
                    m.getCarnet().setTipus(rs.getString("tipus"));
                    
                    f.setMatricula(m);
                    llista.altaFactura(f);
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