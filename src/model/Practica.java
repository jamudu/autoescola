//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Practica {
//    private String idVehicle;
    
    private Alumne alumne;
    private Professor professor;
    private Vehicle vehicle;
    private int horaInici;
    private Date diaPractica;
    
    public Practica() {
        alumne = new Alumne();
        professor = new Professor();
        vehicle = new Vehicle();
        diaPractica=new Date();
    }
    
    public static final String PROP_ALUMNE = "alumne";
    public static final String PROP_PROFESSOR = "professor";
    public static final String PROP_VEHICLE = "vehicle";
    public static final String PROP_HORAINICI = "horaInici";
    public static final String PROP_DATA = "diaPractica";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public int getHoraInici() {
        return horaInici;
    }

    public void setHoraInici(int horaInici) {
        int oldHoraInici = this.horaInici;
        this.horaInici = horaInici;
        propertyChangeSupport.firePropertyChange(PROP_HORAINICI, oldHoraInici, horaInici);
    }    

    public Date getData() {
        return diaPractica;
    }

    public void setData(Date data) {
        Date oldData = this.diaPractica;
        this.diaPractica = data;
        propertyChangeSupport.firePropertyChange(PROP_DATA, oldData, data);
    }    
    
    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        Alumne oldAlumne = this.alumne;
        this.alumne = alumne;
        propertyChangeSupport.firePropertyChange(PROP_ALUMNE, oldAlumne, alumne);
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        Professor oldProfessor = this.professor;
        this.professor = professor;
        propertyChangeSupport.firePropertyChange(PROP_PROFESSOR, oldProfessor, professor);
    }
    
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        Vehicle oldVehicle = this.vehicle;
        this.vehicle = vehicle;
        propertyChangeSupport.firePropertyChange(PROP_VEHICLE, oldVehicle, vehicle);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
