//
package vista;

import autoescola.Autoescola;
import static autoescola.Autoescola.alumneJDBC;
import static autoescola.Autoescola.practicaJDBC;
import static autoescola.Autoescola.professorJDBC;
import static autoescola.Autoescola.vehicleJDBC;
import dao.AlumneJDBC;
import dao.PracticaJDBC;
import dao.ProfessorJDBC;
import dao.VehicleJDBC;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.Alumne;
import model.Carnet;
import model.ListaVehicles;
import model.LlistaPractica;
import model.LlistaProfessor;
import model.Practica;
import model.Professor;
import model.Vehicle;

/**
 *
 * @author jaume
 */
public class DadesPractica extends javax.swing.JDialog {

    private TableRowSorter<TableModel> modeloOrdenado;

    private Alumne alumnePractica;

    public Alumne getAlumnePractica() {
        return alumnePractica;
    }

    public void setAlumnePractica(Alumne alumnePractica) {
        this.alumnePractica = alumnePractica;
    }

    private LlistaProfessor totsProfessors;

    public LlistaProfessor getTotsProfessors() {
        return totsProfessors;
    }

    public void setTotsProfessors(LlistaProfessor totsProfessors) {
        this.totsProfessors = totsProfessors;
    }

    private Professor professorSelecc;

    public Professor getProfessorSelecc() {
        return professorSelecc;
    }

    public void setProfessorSelecc(Professor professorSelecc) {
        this.professorSelecc = professorSelecc;
    }

    private ListaVehicles totsVehicles;

    public ListaVehicles getTotsVehicles() {
        return totsVehicles;
    }

    public void setTotsVehicles(ListaVehicles totsVehicles) {
        this.totsVehicles = totsVehicles;
    }

    private Vehicle vehicleSelecc;

    public Vehicle getVehicleSelecc() {
        return vehicleSelecc;
    }

    public void setVehicleSelecc(Vehicle vehicleSelecc) {
        this.vehicleSelecc = vehicleSelecc;
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
    public DadesPractica(java.awt.Frame parent, boolean modal, Alumne a, Carnet c) {
        super(parent, modal);
        this.modo = modo;
        alumneJDBC = new AlumneJDBC();
        professorJDBC = new ProfessorJDBC();
        vehicleJDBC = new VehicleJDBC();
        practicaJDBC = new PracticaJDBC();
        novaPractica = new Practica();
        alumnePractica = a;

        totsProfessors = professorJDBC.professorsCarnet(c.getIdCarnet());
        Professor pr = new Professor();
        pr.setCognoms("-- Selecciona professor --");
        totsProfessors.altaProfessor(pr);
        Collections.sort(totsProfessors.getLista());

        totsVehicles = vehicleJDBC.vehiclesCarnet(c.getIdCarnet());
        Vehicle ve = new Vehicle();
        ve.setModel("-- Selecciona vehicle --");
        totsVehicles.altaVehicle(ve);
        Collections.sort(totsVehicles.getLista());

        initComponents();
        TableModel modelo = jTable1.getModel();
//        modeloOrdenado = new TableRowSorter<TableModel>(modelo);
//        jTable1.setRowSorter(modeloOrdenado);

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

        jTable1.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);

        TableModel modelo1 = jTable2.getModel();
//        modeloOrdenado = new TableRowSorter<TableModel>(modelo1);
//        jTable1.setRowSorter(modeloOrdenado);

        jTable2.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        jTable2.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);

        DefaultTableCellRenderer modelocentrar1 = new DefaultTableCellRenderer();
        modelocentrar1.setHorizontalAlignment(SwingConstants.CENTER);

        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField2.setHorizontalAlignment(JTextField.CENTER);

        jTextField2.setText(a.getCognoms()+",  "+a.getNom());
        
        formulario();
        jTextField1.setText(c.getTipus());
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
            jXDatePicker1.setDate(new Date());
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
        descripcionLbl = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Practica");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${totsProfessors.lista}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${professorSelecc}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${totsVehicles.lista}");
        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${vehicleSelecc}"), jComboBox2, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Vehicle:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Data:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Hora:");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(8, 8, 20, 1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Carnet:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setBackground(new java.awt.Color(255, 255, 204));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setText("Horas assignades professor");

        jLabel6.setText("Horas assiganes vehicle");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTextField2.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 299, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            novaPractica.setAlumne(alumnePractica);
            novaPractica.setProfessor(professorSelecc);
            novaPractica.setVehicle(vehicleSelecc);
            novaPractica.setData(jXDatePicker1.getDate());
            novaPractica.setHoraInici((Integer) jSpinner1.getValue());
            if (practicaJDBC.insertarPractica(novaPractica)) {
                prepararTablaProfes();
                prepararTablaVehicles();
                JOptionPane.showMessageDialog(this, "Practica donada d'alta");
                //dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No s'ha pogut insertar la nova practica", "ERROR. Practica no donada d'alta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_aceptarBtnActionPerformed
    private void prepararTablaProfes() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modeloOrdenado = new TableRowSorter<TableModel>(modelo);
            jTable1.setRowSorter(modeloOrdenado);
            int filas = jTable1.getRowCount();
            for (int i = 0; i < filas; i++) {
                modelo.removeRow(0);
            }
            Object[] fila = new Object[modelo.getColumnCount()];
            LlistaPractica lista = Autoescola.practicaJDBC.practiquesProfessor(professorSelecc);
            for (int i = 0; i < lista.getLista().size(); i++) {
                fila[0] = lista.getLista().get(i).getDataVista();
                fila[1] = lista.getLista().get(i).getHoraInici();
                modelo.addRow(fila);
            }
        } catch (NullPointerException ex) {

        }
    }
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        prepararTablaProfes();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    private void prepararTablaVehicles() {
        try {
            DefaultTableModel modelo1 = (DefaultTableModel) jTable2.getModel();
            modeloOrdenado = new TableRowSorter<TableModel>(modelo1);
            jTable2.setRowSorter(modeloOrdenado);
            int filas = jTable2.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo1.removeRow(0);
            }
            Object[] fila = new Object[modelo1.getColumnCount()];
            LlistaPractica lista = Autoescola.practicaJDBC.practiquesVehicle(vehicleSelecc);
            for (int i = 0; i < lista.getLista().size(); i++) {
                fila[0] = lista.getLista().get(i).getDataVista();
                fila[1] = lista.getLista().get(i).getHoraInici();
                modelo1.addRow(fila);
            }
        } catch (NullPointerException ex) {

        }
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        prepararTablaVehicles();
    }//GEN-LAST:event_jComboBox2ActionPerformed
    private boolean comprobarCampos() {
        if (jComboBox1.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un professor", "ERROR: Professor incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (jComboBox2.getSelectedIndex() < 1) {
            JOptionPane.showMessageDialog(this, "Has de seleccionar un vehicle", "ERROR: Vehicle incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
               
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String split[] = sdf.format(jXDatePicker1.getDate()).split("-");
        int dia = Integer.parseInt(split[0]);
        int mes = Integer.parseInt(split[1]);
        int any = Integer.parseInt(split[2]);
        Calendar ahora = Calendar.getInstance();
        System.out.println(ahora.get(Calendar.YEAR)+"--"+(ahora.get(Calendar.MONTH)+1)+"--"+ahora.get(Calendar.DAY_OF_MONTH));
        if (any<ahora.get(Calendar.YEAR) 
                || (mes<ahora.get(Calendar.MONTH) && any==ahora.get(Calendar.YEAR))
                || (dia<ahora.get(Calendar.DAY_OF_MONTH) && mes==(ahora.get(Calendar.MONTH)+1))
                || ((Integer) jSpinner1.getValue())<ahora.get(Calendar.HOUR_OF_DAY) && dia==(ahora.get(Calendar.DAY_OF_MONTH))){
            JOptionPane.showMessageDialog(this, "La data no pot ser anterior a l'actual", "ERROR: Data incorrecte", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        boolean ocupat = false;
        if (practicaJDBC.comprobarDatProfessor(professorSelecc, dia, mes, any, (Integer) jSpinner1.getValue())) {
            JOptionPane.showMessageDialog(this, "El professor " + professorSelecc + "\nja te assignat aquesta data i hora",
                    "ATENCIO: Dia i hora ja reservats", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (practicaJDBC.comprobarDatVehicle(vehicleSelecc, dia, mes, any, (Integer) jSpinner1.getValue()) & !ocupat) {
            JOptionPane.showMessageDialog(this, "El vehicle " + vehicleSelecc.getMatricula() + " - " + vehicleSelecc + "\nja te assignat aquesta data i hora",
                    "ATENCIO: Dia i hora ja reservats", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel descripcionLbl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    // </editor-fold> 
}
