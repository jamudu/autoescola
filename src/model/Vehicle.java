
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Vehicle {    
    private String matricula;
    private String marca;
    private String model;
    private int idCarnet;
    
    public static final String PROP_MATRICULA = "matricula";
    public static final String PROP_MARCA = "marca";
    public static final String PROP_MODEL = "model";
    public static final String PROP_IDCARNET = "idCarnet";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Vehicle() {
        this("", "", "", 0);
    }
    
    public Vehicle(String matricula, String marca, String model, int idCarnet) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.idCarnet = idCarnet;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        String oldMatricula = this.matricula;
        this.matricula = matricula;
        propertyChangeSupport.firePropertyChange(PROP_MATRICULA, oldMatricula, matricula);
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;
        propertyChangeSupport.firePropertyChange(PROP_MARCA, oldMarca, marca);
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        String oldModel = this.model;
        this.model = model;
        propertyChangeSupport.firePropertyChange(PROP_MODEL, oldModel, model);
    }
    
    public int getIdCarnet() {
        return idCarnet;
    }
    
    public void setIdCarnet(int idCarnet) {
        int oldIdCarnet = this.idCarnet;
        this.idCarnet = idCarnet;
        propertyChangeSupport.firePropertyChange(PROP_IDCARNET, oldIdCarnet, idCarnet);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
