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
    
    private String idAlumne;
    private String idProfessor;
    private String idVehicle;
    private Date diaPractica;
    private int horaInici;

    public Practica() {
        idAlumne="";
        idProfessor="";
        idVehicle="";
        diaPractica=new Date();
    }

    public static final String PROP_HORAINICI = "horaInici";
    public static final String PROP_DATA = "diaPractica";
    public static final String PROP_IDVEHICLE = "idVehicle";
    public static final String PROP_IDPROFESSOR = "idProfessor";
    public static final String PROP_IDALUMNE = "idAlumne";

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

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        String oldIdVehicle = this.idVehicle;
        this.idVehicle = idVehicle;
        propertyChangeSupport.firePropertyChange(PROP_IDVEHICLE, oldIdVehicle, idVehicle);
    }    

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        String oldIdProfessor = this.idProfessor;
        this.idProfessor = idProfessor;
        propertyChangeSupport.firePropertyChange(PROP_IDPROFESSOR, oldIdProfessor, idProfessor);
    }  

    public String getIdAlumne() {
        return idAlumne;
    }

    public void setIdAlumne(String idAlumne) {
        String oldIdAlumne = this.idAlumne;
        this.idAlumne = idAlumne;
        propertyChangeSupport.firePropertyChange(PROP_IDALUMNE, oldIdAlumne, idAlumne);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
