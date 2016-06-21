
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
    private Matricula matricula;
    
    public static final String PROP_CODI = "codi";
    public static final String PROP_DATA = "data";
    public static final String PROP_TOTAL = "total";
    public static final String PROP_MATRICULA = "matricula";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Factura() {
        data = new Date();
        matricula = new Matricula();
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
    
    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        Matricula oldMatricula = this.matricula;
        this.matricula = matricula;
        propertyChangeSupport.firePropertyChange(PROP_MATRICULA, oldMatricula, matricula);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
