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
public class LlistaMatricula {    
    private ObservableList<Matricula> lista;

    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public LlistaMatricula() {
        lista=ObservableCollections.observableList(new ArrayList<Matricula>());
    }
    
    public ObservableList<Matricula> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Matricula> lista) {
        ObservableList<Matricula> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaMatricula(Matricula m) {
        lista.add(m);
    }
    
    public void bajaMatricula(Matricula m) {
        lista.remove(m);
    }
}
