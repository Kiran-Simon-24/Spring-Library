/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kingk
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
     Color mouseEnterColorMin = new Color(187,187,187);
    Color mouseEnterColorExit = new Color(255,0,0);    
    Color mouseExitColor = new Color(255,255,255);
    
    String student_name, course, branch;
    int student_id;
    DefaultTableModel model;
    
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    // To set the studetn dtails to table
    public void setStudentDetailsToTable(){
       
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db","root","");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT LPAD(student_id, 3, '0') AS student_id, student_name, course, branch FROM student_details");
                
                while(rs.next()){
                   String studentId = rs.getString("Student_id");
                   String studentName = rs.getString("Student_name");
                   String course = rs.getString("Course");
                   String branch = rs.getString("Branch");
                   
                   Object[] obj = {studentId, studentName, course,branch};
                   model = (DefaultTableModel) tb_Studentdetails.getModel();
                   model.addRow(obj);
                }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Add Student to table
 
    public boolean addStudent(){
       
        boolean isAdded = false;
        
        student_id = Integer.parseInt(txt_studentID.getText());
        student_name = txt_studentName.getText();
        course = combo_Course.getSelectedItem().toString();
        branch = combo_Branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql;
            PreparedStatement pst;
            sql = "INSERT INTO student_details (student_id, student_name, course, branch) VALUES (?, ?, ?, ?)";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, student_id);
            pst.setString(2, student_name);
            pst.setString(3, course);
            pst.setString(4, branch);    
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){       
                isAdded = true;
            }
            else{
                isAdded = false;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return isAdded;
   }
    
    
    // Update Student 
    
    public boolean updateStudent(){
        
        boolean isUpdated = false;
        student_id = Integer.parseInt(txt_studentID.getText()) ;
        student_name = txt_studentName.getText();
        course = combo_Course.getSelectedItem().toString();
        branch = combo_Branch.getSelectedItem().toString();
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set student_name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, student_name);
            pst.setString(2, course);
            pst.setString(3, branch);  
            pst.setInt(4, student_id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                isUpdated = true;
            }
            else{
                isUpdated = false;
            }
            
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return isUpdated;
    }
    
    //Delete Student
    
    public boolean deleteStudent(){
        
        boolean isDeleted = false;
        student_id = Integer.parseInt(txt_studentID.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
                isDeleted = true;
            }
            else{
                isDeleted = false;
            }
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    //Clear Table method
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tb_Studentdetails.getModel();
        model.setRowCount(0);
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_studentID = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_Branch = new javax.swing.JComboBox<>();
        combo_Course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_minimize = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Studentdetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        txt_studentID.setBackground(new java.awt.Color(153, 153, 255));
        txt_studentID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentID.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentID.setPlaceholder("Enter Student id ...");
        txt_studentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIDActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 240, 50));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Student ID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 40));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txt_studentName.setBackground(new java.awt.Color(153, 153, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name ...");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 240, 50));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Select Course ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 180, 40));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Enter Student Name :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 190, 40));

        jLabel22.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Select Branch");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 180, 40));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, 120, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 660, 120, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 120, 70));

        combo_Branch.setBackground(new java.awt.Color(255, 255, 255));
        combo_Branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Branch.setForeground(new java.awt.Color(0, 0, 0));
        combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "AERO", "ELECTRONICS" }));
        jPanel1.add(combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, -1));

        combo_Course.setBackground(new java.awt.Color(255, 255, 255));
        combo_Course.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Course.setForeground(new java.awt.Color(0, 0, 0));
        combo_Course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        jPanel1.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_minimize.setBackground(new java.awt.Color(255, 255, 255));
        lbl_minimize.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        lbl_minimize.setForeground(new java.awt.Color(51, 51, 51));
        lbl_minimize.setText(" -");
        lbl_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseExited(evt);
            }
        });
        jPanel5.add(lbl_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        lbl_exit.setBackground(new java.awt.Color(255, 255, 255));
        lbl_exit.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        lbl_exit.setForeground(new java.awt.Color(51, 51, 51));
        lbl_exit.setText(" X");
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_exitMouseExited(evt);
            }
        });
        jPanel5.add(lbl_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 120, 50));

        tb_Studentdetails.setBackground(new java.awt.Color(187, 187, 187));
        tb_Studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student id", "Name", "Course", "Branch"
            }
        ));
        tb_Studentdetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tb_Studentdetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tb_Studentdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tb_Studentdetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tb_Studentdetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tb_Studentdetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tb_Studentdetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tb_Studentdetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tb_Studentdetails.setRowHeight(40);
        tb_Studentdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_StudentdetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_Studentdetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 770, 340));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText(" Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 370, -1));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 410, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 910, 800));

        setSize(new java.awt.Dimension(1400, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void txt_studentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIDActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteStudent() == true){
           JOptionPane.showMessageDialog(this, "Student Deleted");
           clearTable();
           setStudentDetailsToTable();
       }
       else{
           JOptionPane.showMessageDialog(this, "Student Deletion Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      
        // Call with a specific book ID
        if(addStudent()== true){
           JOptionPane.showMessageDialog(this, "Student Added");
           clearTable();
           setStudentDetailsToTable();
       }
       else{
           JOptionPane.showMessageDialog(this, "Student Addition Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(updateStudent() == true){
           JOptionPane.showMessageDialog(this, "Student Updated");
           clearTable();
           setStudentDetailsToTable();
       }
       else{
           JOptionPane.showMessageDialog(this, "Student  Update Failed");
       }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void tb_StudentdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_StudentdetailsMouseClicked
        
        int rowNo = tb_Studentdetails.getSelectedRow();
        TableModel model = tb_Studentdetails.getModel();
        txt_studentID.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_Course.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_Branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tb_StudentdetailsMouseClicked

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CourseActionPerformed

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void lbl_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseEntered
        lbl_minimize.setBackground(mouseEnterColorMin);
        lbl_minimize.setOpaque(true); // Make sure this is set to true
        lbl_minimize.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_minimizeMouseEntered

    private void lbl_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseExited
        lbl_minimize.setBackground(mouseExitColor);
        lbl_minimize.setOpaque(true); // Make sure this is set to true
        lbl_minimize.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_minimizeMouseExited

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void lbl_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseEntered
        lbl_exit.setBackground(mouseEnterColorExit);
        lbl_exit.setOpaque(true); // Make sure this is set to true
        lbl_exit.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_exitMouseEntered

    private void lbl_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseExited
        lbl_exit.setBackground(mouseExitColor);
        lbl_exit.setOpaque(true); // Make sure this is set to true
        lbl_exit.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_exitMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Branch;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimize;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tb_Studentdetails;
    private app.bolivia.swing.JCTextField txt_studentID;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
