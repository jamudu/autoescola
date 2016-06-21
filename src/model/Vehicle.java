
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Vehicle implements Cloneable{    
    private String matricula;
    private String marca;
    private String model;      
    private Carnet carnet;

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        Carnet oldCarnet = this.carnet;
        this.carnet = carnet;
        propertyChangeSupport.firePropertyChange(PROP_CARNET, oldCarnet, carnet);
    }
  
    public static final String PROP_MATRICULA = "matricula";
    public static final String PROP_MARCA = "marca";
    public static final String PROP_MODEL = "model"; 
    public static final String PROP_CARNET = "carnet";

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public Vehicle() {
        matricula = marca = model = "";
        carnet = new Carnet();
    }
    
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            //Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
