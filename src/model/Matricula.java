//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Matricula {
    
    private int idMatricula;    
    private Alumne alumne;
    private Carnet carnet;

    public static final String PROP_CARNET = "carnet";

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        Carnet oldCarnet = this.carnet;
        this.carnet = carnet;
        propertyChangeSupport.firePropertyChange(PROP_CARNET, oldCarnet, carnet);
    }

    public static final String PROP_ALUMNE = "alumne";

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        Alumne oldAlumne = this.alumne;
        this.alumne = alumne;
        propertyChangeSupport.firePropertyChange(PROP_ALUMNE, oldAlumne, alumne);
    }

    public Matricula() {
        
    }

    public static final String PROP_IDMATRICULA = "idMatricula";

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        int oldIdMatricula = this.idMatricula;
        this.idMatricula = idMatricula;
        propertyChangeSupport.firePropertyChange(PROP_IDMATRICULA, oldIdMatricula, idMatricula);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
