//
package vista;

import static autoescola.Autoescola.professorJDBC;
import static autoescola.Autoescola.vehicleJDBC;
import static autoescola.Autoescola.alumneJDBC;
import static autoescola.Autoescola.practicaJDBC;
import dao.AlumneJDBC;
import dao.PracticaJDBC;
import dao.ProfessorJDBC;
import dao.VehicleJDBC;
import java.awt.event.KeyEvent;
import java.util.Collections;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Alumne;
import model.ListaVehicles;
import model.LlistaAlumne;
import model.LlistaProfessor;
import model.Practica;
import model.Professor;
import model.Vehicle;

/**
 *
 * @author jaume
 */
public class DadesPractica extends javax.swing.JDialog {

    private LlistaAlumne totsAlumnes;

    public LlistaAlumne getTotsAlumnes() {
        return totsAlumnes;
    }

    public void setTotsAlumnes(LlistaAlumne totsAlumnes) {
        this.totsAlumnes = totsAlumnes;
    }

    private LlistaProfessor totsProfessors;

    public LlistaProfessor getTotsProfessors() {
        return totsProfessors;
    }

    public void setTotsProfessors(LlistaProfessor totsProfessors) {
        this.totsProfessors = totsProfessors;
    }

    private ListaVehicles totsVehicles;

    public ListaVehicles getTotsVehicles() {
        return totsVehicles;
    }

    public void setTotsVehicles(ListaVehicles totsVehicles) {
        this.totsVehicles = totsVehicles;
    }

    private Practica novaPractica;

    public Practica getNovaPractica() {
        return novaPractica;
    }

    public void setNovaPractica(Practica novaPractica) {
        this.novaPractica = novaPractica;
    }
    private String modo = "";
    public boolean cancelar;

    /**
     * Creates new form DadesPractica
     */
    public DadesPractica(java.awt.Frame parent, boolean modal, String modo) {
        super(parent, modal);
        this.modo = modo;
//        alumneJDBC = new AlumneJDBC();
//        professorJDBC = new ProfessorJDBC();
//        vehicleJDBC = new VehicleJDBC();
        practicaJDBC = new PracticaJDBC();
        novaPractica = new Practica();

        totsAlumnes = alumneJDBC.seleccionarAllAlumnes();
        Alumne al = new Alumne();
        al.setCognoms("-- Selecciona alumne --");
        totsAlumnes.altaAlumne(al);
        Collections.sort(totsAlumnes.getLista());

        totsProfessors = professorJDBC.totsProfessors();
        Professor pr = new Professor();
        pr.setCognoms("-- Selecciona professor --");
        totsProfessors.altaProfessor(pr);
        Collections.sort(totsProfessors.getLista());

        totsVehicles = vehicleJDBC.totsVehicles();
        Vehicle ve = new Vehicle();
        ve.setModel("-- Selecciona vehicle --");
        totsVehicles.altaVehicle(ve);
        Collections.sort(totsVehicles.getLista());

        initComponents();
        formulario();
        if (modo.equals("modificar")) {
            this.setTitle("Modificar practica");
        } else {
            this.setTitle("Alta practica");
        }
    }

    private void formulario() {
        if (!modo.equals("modificar")) {
            jComboBox1.setSelectedIndex(0);
            jComboBox2.setSelectedIndex(0);
            jComboBox3.setSelectedIndex(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cancelarBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        descripcionLbl = new javax.swing.JLabel();
        codigoLbl = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cancelarBtnFocusGained(evt);
            }
        });
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        aceptarBtn.setText("Aceptar");
        aceptarBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                aceptarBtnFocusGained(evt);
            }
        });
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setOpaque(false);

        descripcionLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descripcionLbl.setText("Professor:");

        codigoLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codigoLbl.setText("Alumne:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vehicle:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Data:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Hora inici:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 8, 20, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(codigoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, 0, 285, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cancelarBtnFocusGained
        InputMap map = new InputMap();

        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");

        cancelarBtn.setInputMap(0, map);
    }//GEN-LAST:event_cancelarBtnFocusGained

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void aceptarBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_aceptarBtnFocusGained
        InputMap map = new InputMap();

        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
        map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");

        aceptarBtn.setInputMap(0, map);
    }//GEN-LAST:event_aceptarBtnFocusGained
    private boolean comprobarCampos() {
        if (jComboBox1.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un alumne", "ERROR: Alumne incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jComboBox2.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un professor", "ERROR: Professor incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jComboBox3.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un vehicle", "ERROR: Vehicle incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        if (comprobarCampos()) {
            if (practicaJDBC.insertarPractica(novaPractica)) {
                JOptionPane.showMessageDialog(this, "Practica donada d'alta");

                dispose();

            } else {
                JOptionPane.showMessageDialog(this, "No s'ha pogut insertar la nova practica", "ERROR. Practica no donada d'alta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_aceptarBtnActionPerformed

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel codigoLbl;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}