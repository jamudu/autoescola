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
    private String idAlumne;
    private int idCarnet;

    public Matricula() {
        idAlumne="";
    }

    public static final String PROP_IDCARNET = "idCarnet";
    public static final String PROP_NIFALUMNE = "idAlumne";
    public static final String PROP_IDMATRICULA = "idMatricula";

    public int getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(int idCarnet) {
        int oldIdCarnet = this.idCarnet;
        this.idCarnet = idCarnet;
        propertyChangeSupport.firePropertyChange(PROP_IDCARNET, oldIdCarnet, idCarnet);
    }
    
    public String getNifAlumne() {
        return idAlumne;
    }

    public void setNifAlumne(String nifAlumne) {
        String oldNifAlumne = this.idAlumne;
        this.idAlumne = nifAlumne;
        propertyChangeSupport.firePropertyChange(PROP_NIFALUMNE, oldNifAlumne, nifAlumne);
    }

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
