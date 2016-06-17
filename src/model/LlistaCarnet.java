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
public class LlistaCarnet {
    
    private ObservableList<Carnet> lista;

    public LlistaCarnet() {
        lista=ObservableCollections.observableList(new ArrayList<Carnet>());
    }

    public void altaCarnet(Carnet c) {
        lista.add(c);
    }
    
    public void bajaCarnet(Carnet c) {
        lista.remove(c);
    }
    public static final String PROP_LISTA = "lista";

    public ObservableList<Carnet> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Carnet> lista) {
        ObservableList<Carnet> oldLista = this.lista;
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
