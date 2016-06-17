//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Carnet {
    
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

}
