
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Factura {    
    private int codi;
    private Date data;
    private double total;
    private int idMatricula;
    
    public static final String PROP_CODI = "codi";
    public static final String PROP_DATA = "data";
    public static final String PROP_TOTAL = "total";
    public static final String PROP_IDMATRICULA = "idMatricula";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Factura() {
        this(0, null, 0, 0);
    }
    
    public Factura(int codi, Date data, double total, int idMatricula) {
        this.codi = codi;
        this.data = data;
        this.total = total;
        this.idMatricula = idMatricula;
    }
    
    public int getCodi() {
        return codi;
    }
    
    public void setCodi(int codi) {
        int oldCodi = this.codi;
        this.codi = codi;
        propertyChangeSupport.firePropertyChange(PROP_CODI, oldCodi, codi);
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange(PROP_DATA, oldData, data);
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        double oldTotal = this.total;
        this.total = total;
        propertyChangeSupport.firePropertyChange(PROP_TOTAL, oldTotal, total);
    }
    
    public int getIdMatricula() {
        return idMatricula;
    }
    
    public void setIdMatricula(int idMatricula) {
        int oldIdMatricula = this.idMatricula;
        this.idMatricula = idMatricula;
        propertyChangeSupport.firePropertyChange(PROP_IDMATRICULA, oldIdMatricula, idMatricula);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }    
}
