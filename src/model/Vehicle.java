
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

/**
 *
 * @author usu21
 */
public class Vehicle implements Cloneable, Comparable{    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (model.equals("-- Selecciona vehicle --")) {
            return model;
        }
        return marca + ", " + model;
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
    
    @Override
    public int compareTo(Object o) {
        Vehicle other = (Vehicle)o;
        return model.compareTo(other.getModel());
    }
}
