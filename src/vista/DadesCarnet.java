//

package vista;

import static autoescola.Autoescola.carnetJDBC;
import dao.CarnetJDBC;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import model.Carnet;

/**
 *
 * @author jaume
 */
public class DadesCarnet extends javax.swing.JDialog {

    private Carnet nouCarnet;

    public Carnet getNouCarnet() {
        return nouCarnet;
    }

    public void setNouCarnet(Carnet nouCarnet) {
        this.nouCarnet = nouCarnet;
    }

    private String modo = "";
    public boolean cancelar;
    /**
     * Creates new form DadesCarnet
     */
    public DadesCarnet(java.awt.Frame parent, boolean modal, Carnet c, String modo) {
        super(parent, modal);
        cancelar = true;
        this.modo = modo;
        carnetJDBC = new CarnetJDBC();
        nouCarnet = c;
        initComponents();
        formulario();
        if (modo.equals("modificar")) {
            codiTxt.setEditable(false);
            codiTxt.setFocusable(false);
            aceptarBtn.setEnabled(true);
            this.setTitle("Modificar carnet");
        }else{            
            this.setTitle("Alta carnet");
        }    
    }
    private void formulario() {
        aceptarBtn.setEnabled(false);
        carnetTxt.getMargin().left = 10;
        descripcioTxt.getMargin().left = 10;
        preuTxt.setHorizontalAlignment(JTextField.RIGHT);
        preuTxt.getMargin().right = 10;
        codiTxt.setHorizontalAlignment(JTextField.CENTER);

        if (!modo.equals("modificar")) {
            codiTxt.setText("");
            carnetTxt.setText("");
            descripcioTxt.setText("");
            preuTxt.setText("0");
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

        jPanel2 = new javax.swing.JPanel();
        cancelarBtn = new javax.swing.JButton();
        aceptarBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        colorLbl = new javax.swing.JLabel();
        descripcioTxt = new javax.swing.JTextField();
        descripcionLbl = new javax.swing.JLabel();
        carnetTxt = new javax.swing.JTextField();
        codigoLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        preuTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codiTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setOpaque(false);

        colorLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        colorLbl.setText("Preu:");

        descripcioTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouCarnet.descripcio}"), descripcioTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        descripcioTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                descripcioTxtFocusGained(evt);
            }
        });

        descripcionLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descripcionLbl.setText("Descripcio:");

        carnetTxt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouCarnet.tipus}"), carnetTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        carnetTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                carnetTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                carnetTxtFocusLost(evt);
            }
        });

        codigoLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        codigoLbl.setText("Carnet:");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouCarnet.preuHora}"), preuTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        preuTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                preuTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                preuTxtFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("€ / hora");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Codi:");

        codiTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${nouCarnet.idCarnet}"), codiTxt, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        codiTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codiTxtFocusLost(evt);
            }
        });
        codiTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codiTxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(preuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descripcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(codiTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carnetTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(codiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carnetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                if (carnetJDBC.insertarCarnet(nouCarnet)){
                    JOptionPane.showMessageDialog(this, "Carnet donat d'alta");
                    nouCarnet = new Carnet();
                    formulario();
                    //                dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No s'ha pogut insertar el carnet", "ERROR. Carnet no donat d'alta", JOptionPane.ERROR_MESSAGE);
                }
            } else if (carnetJDBC.modificarCarnet(nouCarnet)) {
                JOptionPane.showMessageDialog(this, "Carnet modificat");
                cancelar = false;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No s'ha pogut modificar el carnet", "ERROR. Carnet no modificat", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_aceptarBtnActionPerformed
    private boolean comprobarCampos() {
        if (carnetTxt.getText().isEmpty() || descripcioTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No es poden deixar camps en blanc", "ERROR: Camps en blanc", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Double.parseDouble(preuTxt.getText())<0){
            JOptionPane.showMessageDialog(this, "El preu ha de ser positiu", "ERROR: Preu incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void descripcioTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_descripcioTxtFocusGained
        descripcioTxt.selectAll();
    }//GEN-LAST:event_descripcioTxtFocusGained

    private void codiTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codiTxtKeyTyped
        jLabel1.setText(null);
        char c = evt.getKeyChar();
        if (c != VK_BACK_SPACE && c != KeyEvent.VK_DELETE && c != KeyEvent.VK_ENTER) {
            evt.consume();
            if (codiTxt.getText().length() > 4) {                
                jLabel1.setText("maxim 5 caracters");
            } else {
                String lletra=Character.toString(c).toUpperCase();
                c=lletra.charAt(0);
                codiTxt.setText(codiTxt.getText()+c);                    
            }
        }
    }//GEN-LAST:event_codiTxtKeyTyped

    private void codiTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codiTxtFocusLost
        jLabel1.setText("");
        if (carnetJDBC.existeCarnet(codiTxt.getText())) {
            JOptionPane.showMessageDialog(this, "Ya existeix un carnet amb aquest codi", "ERROR: Carnet duplicat", JOptionPane.ERROR_MESSAGE);
            codiTxt.requestFocusInWindow();
            codiTxt.selectAll();
            aceptarBtn.setEnabled(false);
        } else if (!codiTxt.getText().equals("")) {
            aceptarBtn.setEnabled(true);
        } else {
            aceptarBtn.setEnabled(false);
        }
    }//GEN-LAST:event_codiTxtFocusLost

    private void preuTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_preuTxtFocusGained
        preuTxt.selectAll();
    }//GEN-LAST:event_preuTxtFocusGained

    private void preuTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_preuTxtFocusLost
        try{
            double preu=Double.parseDouble(preuTxt.getText());
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "El preu es incorrecte", "ERROR: Preu incorrecte", JOptionPane.ERROR_MESSAGE);
            preuTxt.requestFocusInWindow();
            preuTxt.selectAll();
        }
    }//GEN-LAST:event_preuTxtFocusLost

    private void carnetTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carnetTxtFocusLost
        nouCarnet.setTipus(nouCarnet.getTipus().toUpperCase());
    }//GEN-LAST:event_carnetTxtFocusLost

    private void carnetTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_carnetTxtFocusGained
        carnetTxt.selectAll();
    }//GEN-LAST:event_carnetTxtFocusGained
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField carnetTxt;
    private javax.swing.JTextField codiTxt;
    private javax.swing.JLabel codigoLbl;
    private javax.swing.JLabel colorLbl;
    private javax.swing.JTextField descripcioTxt;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField preuTxt;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
