//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Carnet implements Cloneable, Comparable{
    
    private int idCarnet;
    private String tipus;
    private String descripcio;
    private double preuHora;

    public Carnet() {
        tipus="";
        descripcio="";
    }

    public static final String PROP_PREUHORA = "preuHora";
    public static final String PROP_DESCRIPCIO = "descripcio";
    public static final String PROP_TIPUS = "tipus";
    public static final String PROP_IDCARNET = "idCarnet";

    public double getPreuHora() {
        return preuHora;
    }

    @Override
    public String toString() {
        return tipus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.tipus);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carnet other = (Carnet) obj;
        if (!Objects.equals(this.tipus, other.tipus)) {
            return false;
        }
        return true;
    }

    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            //Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setPreuHora(double preuHora) {
        double oldPreuHora = this.preuHora;
        this.preuHora = preuHora;
        propertyChangeSupport.firePropertyChange(PROP_PREUHORA, oldPreuHora, preuHora);
    }
    
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        String oldDescripcio = this.descripcio;
        this.descripcio = descripcio;
        propertyChangeSupport.firePropertyChange(PROP_DESCRIPCIO, oldDescripcio, descripcio);
    }
    
    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        String oldTipus = this.tipus;
        this.tipus = tipus;
        propertyChangeSupport.firePropertyChange(PROP_TIPUS, oldTipus, tipus);
    }
    
    public int getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(int idCarnet) {
        int oldIdCarnet = this.idCarnet;
        this.idCarnet = idCarnet;
        propertyChangeSupport.firePropertyChange(PROP_IDCARNET, oldIdCarnet, idCarnet);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public int compareTo(Object o) {
        Carnet other = (Carnet)o;
        return tipus.compareTo(other.getTipus());
    }

}
