//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Professor extends Persona implements Cloneable, Comparable{
    
    private String tipusEnsenyament;    
    private Carnet carnet;

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        Carnet oldCarnet = this.carnet;
        this.carnet = carnet;
        propertyChangeSupport.firePropertyChange(PROP_CARNET, oldCarnet, carnet);
    }

    public static final String PROP_IDPERSONA = "idPersona";
    public static final String PROP_TIPUSENSENYAMENT = "tipusEnsenyament";
    public static final String PROP_CARNET = "carnet";
    
    public Professor() {
        super();
        tipusEnsenyament="";
        carnet=new Carnet();
    }

    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            //Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public String getTipusEnsenyament() {
        return tipusEnsenyament;
    }

    public void setTipusEnsenyament(String tipusEnsenyament) {
        String oldTipusEnsenyament = this.tipusEnsenyament;
        this.tipusEnsenyament = tipusEnsenyament;
        propertyChangeSupport.firePropertyChange(PROP_TIPUSENSENYAMENT, oldTipusEnsenyament, tipusEnsenyament);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        super.removePropertyChangeListener(listener);
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    @Override
    public int compareTo(Object o) {
        Professor other = (Professor)o;
        return this.getCognoms().compareTo(other.getCognoms());
    }
}
