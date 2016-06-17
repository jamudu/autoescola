//
package vista;

import static autoescola.Autoescola.carnetJDBC;
import static autoescola.Autoescola.vehicleJDBC;
import dao.CarnetJDBC;
import dao.VehicleJDBC;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.util.Collections;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import model.Carnet;
import model.LlistaCarnet;
import model.Vehicle;
import utilidades.EntrdaDatos;

/**
 *
 * @author jaume
 */
public class DadesVehicle extends javax.swing.JDialog {

    private Carnet carnetSelecc;

    public Carnet getCarnetSelecc() {
        return carnetSelecc;
    }

    public void setCarnetSelecc(Carnet carnetSelecc) {
        this.carnetSelecc = carnetSelecc;
    }

    private LlistaCarnet listaCombo;

    public LlistaCarnet getListaCombo() {
        return listaCombo;
    }

    public void setListaCombo(LlistaCarnet listaCombo) {
        this.listaCombo = listaCombo;
    }

    private Vehicle nouVehicle;

    public Vehicle getNouVehicle() {
        return nouVehicle;
    }

    public void setNouVehicle(Vehicle nouVehicle) {
        this.nouVehicle = nouVehicle;
    }

    private String modo = "";
    public boolean cancelar;

    /**
     * Creates new form DadesVehicle
     */
    public DadesVehicle(java.awt.Frame parent, boolean modal, Vehicle v, String modo) {
        super(parent, modal);
        cancelar = true;
        this.modo = modo;
        vehicleJDBC = new VehicleJDBC();
        nouVehicle = v;
        carnetJDBC = new CarnetJDBC();
        listaCombo = carnetJDBC.totsCarnets();
        Carnet retol = new Carnet();
        retol.setTipus("-- Selecciona carnet --");
        listaCombo.altaCarnet(retol);
        Collections.sort(listaCombo.getLista());
        initComponents();
        formulario();
        if (modo.equals("modificar")) {
            matriculaTxt.setEditable(false);
            matriculaTxt.setFocusable(false);
            this.setTitle("Modificar vehicle");
        } else {
            this.setTitle("Alta vehicle");
        }
    }

    private void formulario() {
        aceptarBtn.setEnabled(false);
        marcaTxt.getMargin().left = 10;
        modelTxt.getMargin().left = 10;
        matriculaTxt.setHorizontalAlignment(JTextField.CENTER);

        if (!modo.equals("modificar")) {
            matriculaTxt.setText("");
            marcaTxt.setText("");
            modelTxt.setText("");
            jComboBox1.setSelectedIndex(0);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        tallaLbl = new javax.swing.JLabel();
        colorLbl = new javax.swing.JLabel();
        marcaTxt = new javax.swing.JTextField();
        descripcionLbl = new javax.swing.JLabel();
        matriculaTxt = new javax.swing.JTextField();
        codigoLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        modelTxt = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cancelarBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setOpaque(false);

        tallaLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tallaLbl.setText("Carnet:");

        colorLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        colorLbl.setText("Model:");

        marcaTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouVehicle.marca}"), marcaTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        marcaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                marcaTxtFocusGained(evt);
            }
        });

        descripcionLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descripcionLbl.setText("Marca:");

        matriculaTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouVehicle.matricula}"), matriculaTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        matriculaTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                matriculaTxtFocusLost(evt);
            }
        });
        matriculaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matriculaTxtKeyTyped(evt);
            }
        });

        codigoLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codigoLbl.setText("Matricula:");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouVehicle.model}"), modelTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${listaCombo.lista}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${carnetSelecc}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(descripcionLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(colorLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                    .addComponent(codigoLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tallaLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(matriculaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(modelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matriculaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tallaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marcaTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_marcaTxtFocusGained
        marcaTxt.selectAll();
    }//GEN-LAST:event_marcaTxtFocusGained

    private void matriculaTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matriculaTxtFocusLost
        jLabel1.setText("");
        if (vehicleJDBC.existeVehicle(matriculaTxt.getText())) {
            JOptionPane.showMessageDialog(this, "Ya existeix un vehicle amb aquesta matricula", "ERROR: Matricula duplicada", JOptionPane.ERROR_MESSAGE);
            matriculaTxt.requestFocusInWindow();
            matriculaTxt.selectAll();
            aceptarBtn.setEnabled(false);
        } else if (!matriculaTxt.getText().equals("")) {
            aceptarBtn.setEnabled(true);
        } else {
            aceptarBtn.setEnabled(false);
        }
    }//GEN-LAST:event_matriculaTxtFocusLost

    private void matriculaTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matriculaTxtKeyTyped
        jLabel1.setText(null);
        char c = evt.getKeyChar();
        if (c != VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER) {
            if (matriculaTxt.getText().length() > 6) {
                evt.consume();
                jLabel1.setText("maxim 7 caracters");
            } else {
                String lletraFinal = Character.toString(c).toUpperCase();
                c = lletraFinal.charAt(0);
                evt.consume();
                matriculaTxt.setText(matriculaTxt.getText() + c);
            }
        }
    }//GEN-LAST:event_matriculaTxtKeyTyped

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

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        if (comprobarCampos()) {
            if (modo.equals("alta")) {
                if (vehicleJDBC.insertarVehicle(nouVehicle, carnetSelecc)) {
                    JOptionPane.showMessageDialog(this, "Vehicle donat d'alta");
                    nouVehicle = new Vehicle();
                    formulario();
                    //                dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No s'ha pogut insertar el vehicle", "ERROR. Vehicle no donat d'alta", JOptionPane.ERROR_MESSAGE);
                }
            } else if (vehicleJDBC.modificarVehicle(nouVehicle)) {
                JOptionPane.showMessageDialog(this, "Vehicle modificat");
                cancelar = false;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No s'ha pogut modificar el vehicle", "ERROR. Vehicle no modificat", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_aceptarBtnActionPerformed
    private boolean comprobarCampos() {
        if (matriculaTxt.getText().isEmpty() || marcaTxt.getText().isEmpty() || modelTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No es poden deixar camps en blanc", "ERROR: Camps en blanc", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jComboBox1.getSelectedIndex()<1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un carnet", "ERROR: Carnet no seleccionat", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel codigoLbl;
    private javax.swing.JLabel colorLbl;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField marcaTxt;
    private javax.swing.JTextField matriculaTxt;
    private javax.swing.JTextField modelTxt;
    private javax.swing.JLabel tallaLbl;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
