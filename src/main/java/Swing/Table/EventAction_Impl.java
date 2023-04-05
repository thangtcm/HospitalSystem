/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Swing.Table;

import AdminForm.Drug.DetailsDrug;
import DatabaseAccessObject_DAO.Patient_Dao;
import DatabaseAccessObject_DAO.Staff_Dao;
import DatabaseAccessObject_Impl.Patient_DaoImpl;
import DatabaseAccessObject_Impl.Staff_DaoImpl;
import Dialog.Swal_Confirm;
import Dialog.Swal_Notification;
import Enum.RoleName;
import Enum.TypeInterface;
import Enum.TypeNotification;
import Form.Employee.EmployeeProfile;
import Form.Employee.NewEmployee;
import Form.Medical.NewMedical;
import Form.Patient.NewPatient;
import Form.Patient.PatientDetails;
import Model.Drug;
import Model.Employee;
import Model.MedicalExamination;
import Model.Patient;
import ViewForm.Main;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author couni
 */
public abstract class EventAction_Impl implements EventAction{
    private final JTable table;
    private final Employee employeecurrent;
    private final JPanel main;

    public EventAction_Impl(JTable table, Employee employeecurrent, JPanel main) {
        this.table = table;
        this.employeecurrent = employeecurrent;
        this.main = main;
    }

    @Override
    public <T> void delete(T obj, int row) {
        if (obj instanceof Patient) {
            Patient patient = (Patient)obj;
            System.out.println(".delete()" + patient.getID());
            if (row != -1) {
                if(!this.employeecurrent.getRoleName().equals(RoleName.Admin.toString()))
                    showMessageError("<html><div style='text-align:center;'>You do not have permission to delete <br>Patient : " 
                            + patient.getFullName() + "(ID: " + patient.getID() + ")</div></html>", TypeNotification.Error);
                else 
                {
                    showMessageError("Can't Delete Patient", TypeNotification.Default);
//                    if(showMessage("Delete Patient : " + patient.getFullName() + "(ID: " + patient.getID() + ")", TypeNotification.Default)) {
//                        // Xóa sinh viên tại vị trí rowIndex trong dữ liệu của JTable
//                        int PatientID = patient.getID();
//                        //Hàm Xóa
//                        System.out.println("UserId = " + PatientID);
//
//                        if (this.table.isEditing()) {
//                            this.table.getCellEditor().stopCellEditing();
//                        }
//                        DefaultTableModel model = (DefaultTableModel) table.getModel();
//                        model.removeRow(row);
//                        
//                    
//                    } else {
//                        System.out.println("User click Cancel");
//                    }
                }
            } else {
                System.out.println("No row selected");
            }
        }
        if (obj instanceof Employee) {
            Employee employee = (Employee) obj;
            System.out.println(".delete()" + employee.getID());
            if (row != -1) {
                if (showMessage("Delete Employee : " + employee.getFullName() + "(ID: " + employee.getID() + ")", TypeNotification.Default)) {
                    if (this.table.isEditing()) {
                        this.table.getCellEditor().stopCellEditing();
                    }
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(row);
                    
                    Staff_Dao employee_Dao = new Staff_DaoImpl();
                    employee_Dao.Delete_Staff(employee.getID());
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
    }
    
    @Override
    public <T> void update(T obj, int row) {
        if(obj instanceof Patient)
        {
            int rowIndex = table.getSelectedRow();
            Patient patient = (Patient)obj;
            if (rowIndex >= 0) {
                if (showMessage("You are going to the patient edit interface : " + patient.getFullName()+ "(ID: " + patient.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện sang Edit
                    showForm(new NewPatient(main, TypeInterface.Edit, patient, this.employeecurrent));
                    // ...
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
        if(obj instanceof Employee)
        {
            int rowIndex = table.getSelectedRow();
            Employee object = (Employee)obj;
            if (rowIndex >= 0) {
                if (showMessage("You are going to the employee edit interface : " + object.getFullName()+ "(ID: " + object.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện sang Edit
                    showForm(new NewEmployee(main, TypeInterface.Edit, object, this.employeecurrent));
                    // ...
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
        if(obj instanceof MedicalExamination)
        {
            int rowIndex = table.getSelectedRow();
            MedicalExamination object = (MedicalExamination)obj;
            if (rowIndex >= 0) {
                if (showMessage("You are going to the medical edit interface : " + object.getPatient().getFullName()+ "(ID: " + object.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện sang Edit
                    //Patient_Dao patient_Dao = new Patient_DaoImpl();
                    showForm(new NewMedical(main, TypeInterface.Edit, this.employeecurrent, object));
                    // ...
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
    }
    
    @Override
    public <T> void view(T obj, int row) {
        if(obj instanceof Patient)
        {
            int rowIndex = table.getSelectedRow();
            Patient object = (Patient)obj;
            if (rowIndex >= 0) {
                if (showMessage("View Patient : " + object.getFullName()+ "(ID: " + object.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện xem tại đây
                    showForm(new PatientDetails(main, this.employeecurrent, object));
                    // ...
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
        else if(obj instanceof Employee)
        {
            int rowIndex = table.getSelectedRow();
            Employee object = (Employee)obj;
            if (rowIndex >= 0) {
                if (showMessage("View Patient : " + object.getFullName()+ "(ID: " + object.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện xem tại đây
                    showForm(new EmployeeProfile(main, this.employeecurrent, object));
                    // ...
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }
        else if(obj instanceof Drug)
        {
            int rowIndex = table.getSelectedRow();
            Drug object = (Drug)obj;
            if (rowIndex >= 0) {
                if (showMessage("View Patient : " + object.getDrugName()+ "(ID: " + object.getID()+ ")", TypeNotification.Default)) {
                    // Chuyển giao diện xem tại đây
                    //showForm(new DetailsDrug(main, this.employeecurrent, object));
                    // ...
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            } else {
                System.out.println("No row selected");
            }
        }

    }
    
    private boolean showMessage(String message, TypeNotification type ) {
        Swal_Confirm obj = new Swal_Confirm(Main.getFrames()[0], true);
        obj.showMessage(message, type);
        return obj.isOk();
    }
    
    private boolean showMessageError(String message, TypeNotification type ) {
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
}
