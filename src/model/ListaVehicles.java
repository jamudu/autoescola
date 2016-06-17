
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
public class ListaVehicles {    
    private ObservableList<Vehicle> lista;
    
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaVehicles() {
        lista = ObservableCollections.observableList(new ArrayList<Vehicle>());
    }    
    
    public ObservableList<Vehicle> getLista() {
        return lista;
    }    

    public void setLista(ObservableList<Vehicle> lista) {
        ObservableList<Vehicle> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaVehicle(Vehicle v) {
        lista.add(v);
    }
    
    public void bajaVehicle(Vehicle v) {
        lista.remove(v);
    }
}
