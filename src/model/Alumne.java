
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Alumne extends Persona implements Cloneable{    
    private int numIntentsExamen;
    
    public static final String PROP_NUMINTENTSEXAMEN = "numIntentsExamen";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Alumne() {
        super();
        numIntentsExamen = 0;
    }
    
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            //Logger.getLogger(Alumne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        super.addPropertyChangeListener(listener);
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener);
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
