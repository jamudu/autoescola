//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class LlistaAlumne{

    private ObservableList<Alumne> lista;

    public LlistaAlumne() {
        lista=ObservableCollections.observableList(new ArrayList<Alumne>());
    }

    public void altaAlumne(Alumne a) {
        lista.add(a);
    }
    
    public void bajaAlumne(Alumne a) {
        lista.remove(a);
    }
    public static final String PROP_LISTA = "lista";

    public ObservableList<Alumne> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Alumne> lista) {
        ObservableList<Alumne> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
