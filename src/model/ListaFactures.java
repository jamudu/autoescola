
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
public class ListaFactures {    
    private ObservableList<Factura> lista;
    
    public static final String PROP_LISTA = "lista";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ListaFactures() {
        lista = ObservableCollections.observableList(new ArrayList<Factura>());
    }    
    
    public ObservableList<Factura> getLista() {
        return lista;
    }    

    public void setLista(ObservableList<Factura> lista) {
        ObservableList<Factura> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    
    public void altaFactura(Factura f) {
        lista.add(f);
    }
    
    public void bajaFactura(Factura f) {
        lista.remove(f);
    }
}
