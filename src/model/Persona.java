//
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author usu21
 */
abstract class Persona {

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
        dataNaixement = new Date();
    }

    @Override
    public String toString() {
        if (cognoms.equals("-- Selecciona alumne --") || cognoms.equals("-- Selecciona professor --")) {
            return cognoms;
        }
        return cognoms + ", " + nom;
    }

    public String getNif() {
        return nif;
    }

    public String getDataVista() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(dataNaixement);
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
        String old = getDataVista();
        this.dataNaixement = dataNaixement;
        String nova = getDataVista();
        propertyChangeSupport.firePropertyChange(PROP_DATANAIXEMENT, oldDataNaixement, dataNaixement);
        propertyChangeSupport.firePropertyChange("dataVista", old, nova);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
