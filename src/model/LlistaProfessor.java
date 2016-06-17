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
public class LlistaProfessor {
    
    private ObservableList<Professor> lista;

    public LlistaProfessor() {
        lista=ObservableCollections.observableList(new ArrayList<Professor>());
    }

    public void altaProfessor(Professor p) {
        lista.add(p);
    }
    
    public void bajaProfessor(Professor p) {
        lista.remove(p);
    }
    public static final String PROP_LISTA = "lista";

    public ObservableList<Professor> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Professor> lista) {
        ObservableList<Professor> oldLista = this.lista;
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
