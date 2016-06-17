
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Alumne extends Persona {    
    private int numIntentsExamen;
    
    public static final String PROP_NUMINTENTSEXAMEN = "numIntentsExamen";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Alumne() {
        super();
        numIntentsExamen = 0;
    }
    
    public int getNumIntentsExamen() {
        return numIntentsExamen;
    }
    
    public void setNumIntentsExamen(int numIntentsExamen) {
        int oldNumIntentsExamen = this.numIntentsExamen;
        this.numIntentsExamen = numIntentsExamen;
        propertyChangeSupport.firePropertyChange(PROP_NUMINTENTSEXAMEN, oldNumIntentsExamen, numIntentsExamen);
    }    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
