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
public class LlistaPractica {
    
    private ObservableList<Practica> lista;
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public LlistaPractica() {
        lista=ObservableCollections.observableList(new ArrayList<Practica>());
    }

    public void altaPractica(Practica p) {
        lista.add(p);
    }
    
    public void bajaPractica(Practica p) {
        lista.remove(p);
    }
    
    public ObservableList<Practica> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Practica> lista) {
        ObservableList<Practica> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
