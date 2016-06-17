//

package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Persona {    
    private String nif;
    private String nom;
    private String cognoms;
    private Date dataNaixement;
    
    public static final String PROP_NIF = "nif";
    public static final String PROP_NOM = "nom";
    public static final String PROP_COGNOMS = "cognoms";
    public static final String PROP_DATANAIXEMENT = "dataNaixement";
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Persona() {
        nif = nom = cognoms = "";
        dataNaixement = null;
    }
    
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        String oldNif = this.nif;
        this.nif = nif;
        propertyChangeSupport.firePropertyChange(PROP_NIF, oldNif, nif);
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        propertyChangeSupport.firePropertyChange(PROP_NOM, oldNom, nom);
    }
    
    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        String oldCognoms = this.cognoms;
        this.cognoms = cognoms;
        propertyChangeSupport.firePropertyChange(PROP_COGNOMS, oldCognoms, cognoms);
    }
    
    public Date getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(Date dataNaixement) {
        Date oldDataNaixement = this.dataNaixement;
        this.dataNaixement = dataNaixement;
        propertyChangeSupport.firePropertyChange(PROP_DATANAIXEMENT, oldDataNaixement, dataNaixement);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
