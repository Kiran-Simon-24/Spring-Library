/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kingk
 */
public class IssuedBook extends javax.swing.JFrame {

    

    /**
     * Creates new form IssuedBook
     */
    Color mouseEnterColorMin = new Color(187,187,187);
    Color mouseEnterColorExit = new Color(255,0,0);    
    Color mouseExitColor = new Color(255,255,255);
    
    public IssuedBook() {
        initComponents();
    }
    
    // to fetch the book details from the DB
    public void getBookDetails(){
        int book_id = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT LPAD(book_id, 3, '0') book_id, book_name, author, quantity FROM book_details where book_id =?");
            pst.setInt(1, book_id);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));  
            }
            else{
                lbl_bookError.setText("Invalid Book id");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     // to fetch the Student details from the DB
    public void getStudentDetails(){
        int student_id = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT LPAD(student_id, 3, '0') AS student_id, student_name, course, branch FROM student_details where student_id =?");
            pst.setInt(1, student_id);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_course.setText(rs.getString("course"));
                lbl_branch.setText(rs.getString("branch"));  
            }
            else{
                lbl_studentError.setText("Invalid Student id");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // insert issue book details to DB
    public boolean issueBook(){
        
        boolean isIssue = false;
        int book_id = Integer.parseInt(txt_bookId.getText());
        int student_id = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        java.time.LocalDate uIssueDate = datepicker_DueDate.getDate();
        java.time.LocalDate uDueDate = datepicker_DueDate.getDate();
        
        //long l1 = uIssueDate.getTime();
        //long l2 = uDueDate.getTime();
        java.sql.Date sIssueDate = java.sql.Date.valueOf(uIssueDate);
        java.sql.Date sDueDate = java.sql.Date.valueOf(uDueDate);
       
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Insert into issue_book (Book_id,Book_name, Student_id, Student_name, Issue_date ,Due_date,status) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setString(2, bookName);
            pst.setInt(3, student_id);
            pst.setString(4, studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7, "Pending");
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
                isIssue = true;
            }
            else{
                isIssue = false;
            }      
            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return isIssue;
}
 
    //Updating Book count
    
    public void updateBookCount(){
        int book_id = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Update book_details set quantity = quantity - 1 where book_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0){
                JOptionPane.showMessageDialog(this, "Book count updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Can't update Book count");
            }
        } 
        catch (Exception e) {
            
          e.printStackTrace();
        }
    }
    
    //Checking whether book already issued or not
    
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int book_id = Integer.parseInt(txt_bookId.getText());
        int student_id = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Select * from issue_book where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setInt(2, student_id);
            pst.setString(3, "pending");
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                isAlreadyIssued = true;
            }
            else{
            isAlreadyIssued = false;
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        pl_bookDetails = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pl_studentDetails = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_minimize = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        datepicker_DueDate = new com.github.lgooddatepicker.components.DatePicker();
        datepicker_IssueDate1 = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setForeground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pl_bookDetails.setBackground(new java.awt.Color(255, 0, 51));
        pl_bookDetails.setForeground(new java.awt.Color(0, 0, 0));
        pl_bookDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        pl_bookDetails.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 320, 5));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        pl_bookDetails.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 320, 40));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        pl_bookDetails.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 190, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name :");
        pl_bookDetails.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 140, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author :");
        pl_bookDetails.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 130, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Book id :");
        pl_bookDetails.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, -1));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        pl_bookDetails.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 190, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        pl_bookDetails.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 190, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        pl_bookDetails.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 190, 30));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel14.setText(" Book Details");
        pl_bookDetails.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 300, 100));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        pl_bookDetails.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Quantity :");
        pl_bookDetails.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 130, -1));

        panel_main.add(pl_bookDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 800));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, 350, 5));

        pl_studentDetails.setBackground(new java.awt.Color(102, 102, 255));
        pl_studentDetails.setForeground(new java.awt.Color(0, 0, 0));
        pl_studentDetails.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        pl_studentDetails.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 320, 5));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Branch :");
        pl_studentDetails.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 130, -1));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        pl_studentDetails.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 190, 30));

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Student Name :");
        pl_studentDetails.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 140, -1));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Course :");
        pl_studentDetails.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 130, -1));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Student id :");
        pl_studentDetails.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, -1));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        pl_studentDetails.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 190, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        pl_studentDetails.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 190, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        pl_studentDetails.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 190, 30));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel25.setText(" Student Details");
        pl_studentDetails.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 300, 100));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        pl_studentDetails.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 320, 40));

        panel_main.add(pl_studentDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 420, 800));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_minimize.setText(" -");
        lbl_minimize.setBackground(new java.awt.Color(255, 255, 255));
        lbl_minimize.setFont(new java.awt.Font("Verdana", 0, 35)); // NOI18N
        lbl_minimize.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel7.add(lbl_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 40, 40));

        lbl_exit.setText(" X");
        lbl_exit.setBackground(new java.awt.Color(255, 255, 255));
        lbl_exit.setFont(new java.awt.Font("Verdana", 0, 25)); // NOI18N
        lbl_exit.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel7.add(lbl_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 120, 50));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText(" Issued Book");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 300, -1));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Enter Student ID");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 180, 40));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Book id :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 280, 130, 30));

        txt_bookId.setBackground(new java.awt.Color(255, 255, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book id ...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 260, 270, 40));

        txt_studentId.setBackground(new java.awt.Color(255, 255, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student id ...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 350, 270, 50));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setText("Issue Date :");
        panel_main.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 470, 130, 30));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 51));
        jLabel26.setText("Student id :");
        panel_main.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 370, 130, 30));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 51, 51));
        jLabel27.setText("Due Date :");
        panel_main.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 130, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 660, 310, 70));

        datepicker_DueDate.setText("  Select Due Date");
        datepicker_DueDate.setBackground(new java.awt.Color(0, 0, 0));
        datepicker_DueDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        datepicker_DueDate.setForeground(new java.awt.Color(255, 255, 255));
        panel_main.add(datepicker_DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 560, 270, 40));
        datepicker_DueDate.getAccessibleContext().setAccessibleName("");

        datepicker_IssueDate1.setText("  Select Issue Date"); // NOI18N
        datepicker_IssueDate1.setBackground(new java.awt.Color(0, 0, 0));
        datepicker_IssueDate1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        datepicker_IssueDate1.setForeground(new java.awt.Color(255, 255, 255));
        panel_main.add(datepicker_IssueDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 460, 270, 40));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1410, 800));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        
        if(lbl_quantity.getText().equals("0")){
            JOptionPane.showMessageDialog(this, "Book is not avaliable");
        }
        else{
            if(isAlreadyIssued() == false){
            
                if(issueBook() == true){
                    JOptionPane.showMessageDialog(this, "Book issued successfully");
                    updateBookCount();
                }
                else{
                    JOptionPane.showMessageDialog(this, "Book can't issue!");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "This student already has this book!");
            }   
        }  
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

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
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datepicker_DueDate;
    private com.github.lgooddatepicker.components.DatePicker datepicker_IssueDate1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimize;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel pl_bookDetails;
    private javax.swing.JPanel pl_studentDetails;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
