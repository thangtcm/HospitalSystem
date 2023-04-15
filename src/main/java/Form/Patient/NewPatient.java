/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form.Patient;

import DatabaseAccessObject_DAO.Patient_Dao;
import DatabaseAccessObject_Impl.Patient_DaoImpl;
import Dialog.Swal_Notification;
import Enum.TypeInterface;
import Enum.TypeList;
import Enum.TypeNotification;
import Form.List.ListOfObject;
import Model.Employee;
import Model.Patient;
import Services.CheckHandle;
import ViewForm.Main;
import java.awt.Component;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class NewPatient extends javax.swing.JPanel {
    
    private final JPanel main;
    private final TypeInterface type;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Patient patients;
    private final Employee employee;
    public NewPatient(JPanel main, TypeInterface type, Employee employee) {
        initComponents();
        this.main = main;
        this.type = type;
        this.employee = employee;
        init(type);
    }
    
    public NewPatient(JPanel main, TypeInterface type, Patient patient, Employee employee) {
        initComponents();
        this.main = main;
        this.type = type;
        this.patients = patient;
        this.employee = employee;
        init(type);
    }
    
    private void init(TypeInterface type)
    {
        if(type == TypeInterface.Create)
        {
            txtFirstName.setText("");
            txtMiddleName.setText("");
            txtLastName.setText("");
            txtEmail.setText("");
            txtAddress.setText("");
            txtPhone.setText("");
            txtCID.setText("");
            btnSave.setText("Submit");
        }
        if(type == TypeInterface.Edit)
        {
            txtFirstName.setText(this.patients.getFirstName());
            txtMiddleName.setText(this.patients.getMiddleName());
            txtLastName.setText(this.patients.getLastName());
            txtEmail.setText(this.patients.getEmail());
            txtAddress.setText(this.patients.getAddress());
            txtPhone.setText(this.patients.getNumberPhone());
            txtCID.setText(this.patients.getID().toString());
            JBirthday.setDate(this.patients.getBirthDay());
            btnSave.setText("Save");
        }
    }
    
    private boolean initCreateData()
    {
        Patient patient = new Patient();
        patient.setID(Integer.valueOf(txtCID.getText()));
        patient.setFirstName(txtFirstName.getText());
        patient.setMiddleName(txtMiddleName.getText());
        patient.setLastName(txtLastName.getText());
        if(CheckHandle.isValidEmail(txtEmail.getText()))
        {
            patient.setEmail(txtEmail.getText().trim());
        }
        else{
            showMessage("Email bạn nhập không hợp lệ", TypeNotification.Warning);
            return false;
        }
        if(CheckHandle.isValidPhone(txtPhone.getText().trim()))
        {
            patient.setNumberPhone(txtPhone.getText().trim());
        }
        else{
            showMessage("Phone bạn nhập không hợp lệ", TypeNotification.Warning);
            return false;
        }
        patient.setAddress(txtAddress.getText());
        patient.setGender(JGender.getSelectedItem().toString());
        System.out.println("Form.Patient.NewPatient.initCreateData()" + JBirthday.getDate());
        String birthday = dateFormat.format(JBirthday.getDate());
        patient.setBirthDay(java.sql.Date.valueOf(birthday));

        Patient_Dao patient_Dao = new Patient_DaoImpl();
        if(this.type == TypeInterface.Create)
        {
            if(patient_Dao.AddPatient(patient))
            {
                showMessage("Bạn vừa tạo mới bệnh nhân thành công", TypeNotification.Success);
                return true;
            }
            
        }
        else if(this.type == TypeInterface.Edit)
        {
            patient.setID(this.patients.getID());
            if(patient_Dao.Update_Patient(patient))
            {
                showMessage("Bạn vừa cập nhật bệnh nhân thành công", TypeNotification.Success);
                return true;
            }
        }
        return false;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        JGender = new javax.swing.JComboBox<>();
        txtAddress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TitleTable1 = new javax.swing.JLabel();
        btnSave = new Swing.Button.Button2();
        jLabel8 = new javax.swing.JLabel();
        txtMiddleName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        JBirthday = new com.toedter.calendar.JDateChooser();

        setForeground(new java.awt.Color(79, 98, 203));
        setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Group 31.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icons/Group 455.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Avatar/Group 40_50x50.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 98, 203));
        jLabel4.setText("First Name:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(79, 98, 203));
        jLabel5.setText("Phone Number:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(79, 98, 203));
        jLabel7.setText("Bitrthday: (dd/mm/yyyy)");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(79, 98, 203));
        jLabel9.setText("Gender:");

        txtFirstName.setBackground(new java.awt.Color(238, 245, 255));
        txtFirstName.setColumns(1);
        txtFirstName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtFirstName.setText("Customer Name");
        txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        txtPhone.setBackground(new java.awt.Color(238, 245, 255));
        txtPhone.setColumns(1);
        txtPhone.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPhone.setText("0922113123");
        txtPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        JGender.setBackground(new java.awt.Color(238, 245, 255));
        JGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        JGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));
        JGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JGenderActionPerformed(evt);
            }
        });

        txtAddress.setBackground(new java.awt.Color(238, 245, 255));
        txtAddress.setColumns(1);
        txtAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAddress.setText("141 Dien Bien Phu, Binh Thanh, Ho Chi Minh ");
        txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(79, 98, 203));
        jLabel10.setText("Address:");

        txtCID.setBackground(new java.awt.Color(238, 245, 255));
        txtCID.setColumns(1);
        txtCID.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtCID.setText("1111111");
        txtCID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(79, 98, 203));
        jLabel11.setText("CID");

        txtEmail.setBackground(new java.awt.Color(238, 245, 255));
        txtEmail.setColumns(1);
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEmail.setText("khanhhlg20@gmail.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(79, 98, 203));
        jLabel12.setText("Email:");

        TitleTable1.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        TitleTable1.setText("New Patient");

        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.setFont(new java.awt.Font("Inter", 0, 18)); // NOI18N
        btnSave.setRadius(15);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(79, 98, 203));
        jLabel8.setText("Middle Name:");

        txtMiddleName.setBackground(new java.awt.Color(238, 245, 255));
        txtMiddleName.setColumns(1);
        txtMiddleName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtMiddleName.setText("Customer Name");
        txtMiddleName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(79, 98, 203));
        jLabel13.setText("Last Name:");

        txtLastName.setBackground(new java.awt.Color(238, 245, 255));
        txtLastName.setColumns(1);
        txtLastName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLastName.setText("Customer Name");
        txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));

        JBirthday.setBackground(new java.awt.Color(238, 245, 255));
        JBirthday.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(126, 175, 255), 2));
        JBirthday.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(TitleTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(JBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JGender, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel11)
                            .addComponent(txtCID, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(TitleTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtCID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JGender, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        showForm(new ListOfObject(main, TypeList.Patient, this.employee));
    }//GEN-LAST:event_jLabel1MouseClicked

    private void JGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JGenderActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(initCreateData())
        {
            showForm(new ListOfObject(main, TypeList.Patient, this.employee));
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private boolean showMessage(String message, TypeNotification type ) {
        Swal_Notification obj = new Swal_Notification(Main.getFrames()[0], true);
        obj.showMessage(message, type);
        return obj.isOk();
    }

    private void showForm(Component com){
        main.removeAll();
        main.add(com);
        main.repaint();
        main.revalidate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JBirthday;
    private javax.swing.JComboBox<String> JGender;
    private javax.swing.JLabel TitleTable1;
    private Swing.Button.Button2 btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}