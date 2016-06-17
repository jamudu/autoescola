//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Professor extends Persona implements Cloneable{
    
    private String idPersona;
    private String tipusEnsenyament;
    private int carnet;

    public static final String PROP_IDPERSONA = "idPersona";
    public static final String PROP_TIPUSENSENYAMENT = "tipusEnsenyament";
    public static final String PROP_CARNET = "carnet";

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        String oldIdPersona = this.idPersona;
        this.idPersona = idPersona;
        propertyChangeSupport.firePropertyChange(PROP_IDPERSONA, oldIdPersona, idPersona);
    }

    public Professor() {
        super();
        idPersona="";
        tipusEnsenyament="";
    }

    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            //Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        int oldCarnet = this.carnet;
        this.carnet = carnet;
        propertyChangeSupport.firePropertyChange(PROP_CARNET, oldCarnet, carnet);
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
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
