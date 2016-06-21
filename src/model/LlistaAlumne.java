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
public class LlistaAlumne {
    private ObservableList<Alumne> lista;
    
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public LlistaAlumne() {
        lista=ObservableCollections.observableList(new ArrayList<Alumne>());
    }

    public ObservableList<Alumne> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Alumne> lista) {
        ObservableList<Alumne> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaAlumne(Alumne a) {
        lista.add(a);
    }
    
    public void bajaAlumne(Alumne a) {
        lista.remove(a);
    }
}
