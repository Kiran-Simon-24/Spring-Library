/*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
// */
//package spring.library;
//
///**
// *
// * @author kingk
// */
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
// */
//package JFrame;
//import static JFrame.DBConnection.con;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
////import java.sql.SQLException;
//import javax.swing.JOptionPane;

// *
// * @author kingk
// */
//public class SingUpPage extends javax.swing.JFrame {
//
//    /**
//     * Creates new form SingUpPage
//     */
//    public SingUpPage() {
//        initComponents();
//    }
//    
//    //method to insert value into users table
//    public void insertSingupDetails(){
//        String name = txt_username.getText();
//        String pwd = txt_password.getText();
//        String email = txt_email.getText();
//        String contact = txt_contact.getText();
//        
//        try {
//           Connection con = DBConnection.getConnection();
//           String sql = "insert into users(name,password,email,contact) values(?,?,?,?)";
//            PreparedStatement pst = con.prepareStatement(sql);
//            
//            pst.setString(1, name);
//            pst.setString(2, pwd); 
//            pst.setString(3, email);
//            pst.setString(4, contact);
//            
//            int updatedRowCount = pst.executeUpdate();
//            
//            if(updatedRowCount > 0){
//                JOptionPane.showMessageDialog(this,"Recorded inserted Successfully" );
//            }
//            else {
//                JOptionPane.showMessageDialog(this,"Recorded inserted Failed" );
//            }
//        } 
//        catch (SQLException e){
//            e.printStackTrace();
//    
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    
//    //Validation
//    
//    public boolean validSingup(){
//        String name = txt_username.getText();
//        String pwd = txt_password.getText();
//        String email = txt_email.getText();
//        String contact = txt_contact.getText();
//        final String EMAIL_PATTERN  = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.com$";
//  
//        
//        if(name.equals("")){
//            JOptionPane.showMessageDialog(this,"Please enter Username");
//            return false;
//        }
//        
//        if(pwd.equals("" )){
//            JOptionPane.showMessageDialog(this,"Please enter Password");
//            return false;
//        }  
//        
//        if(email.equals("") || !email.matches(EMAIL_PATTERN) ){
//            JOptionPane.showMessageDialog(this,"Please enter valid Email");
//            return false;
//        }
//          
//        
//        if(contact.equals("")){
//            JOptionPane.showMessageDialog(this,"Please enter Contact number");
//            return false;
//        }
//        return true;
//    }
//    
//    //check duplication
//    
//    private boolean checkDuplicateUser(){
//        String name = txt_username.getText();
//        boolean isExit = false;
//        
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db","root","");
//            
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM users where name = ?");
//            pst.setString(1, name);
//            var resulSet = pst.executeQuery();
//            
//            if(resulSet.next()){
//              isExit = true;  
//            }
//            else
//                isExit = false;
//        }
//        
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return isExit;
//    }   
//
//
//    //Password Validation
//    
//    private boolean passwordValid(){
//        
//        String pwd = txt_password.getText();
//        int minLength = 8;
//        int maxlength = 20;
//        boolean hasUpperCase  = false;
//        boolean hasLowerCase  = false;
//        boolean hasdigit = false;
//        //boolean hasSpecialChar = false;
//        
//        //Check Length
//        if(pwd.length() < minLength || pwd.length() > maxlength){
//            return false;
//        }
//        
//        for(char ch : pwd.toCharArray()){
//            if(Character.isUpperCase(ch)){
//                hasUpperCase = true;
//                System.out.println("Must contain ");
//            }
//            else if(Character.isLowerCase(ch)){
//                hasLowerCase = true;
//            }
//            else if(Character.isDigit(ch)){
//                hasdigit = true;
//            }
//        }
//        
//        return hasUpperCase &&  hasLowerCase && hasdigit;
//
//    }
//    
//    
//    // Email Check Method
//    
//    private boolean emailExitsInDatabse(){
//            String email = txt_email.getText();
//            boolean isExit = false;
//            
//            try {
//                Connection con = DBConnection.getConnection();
//
//                try (PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) From users WHERE email = ?"))
//                {
//                    pst.setString(1, email);
//                    var resultSet = pst.executeQuery();
//                 
//                    if(resultSet.next() && resultSet.getInt(1) > 0 )
//                        return true;
//                } 
//            }      
//            catch (SQLException e)
//            {
//                e.printStackTrace();
//            }
//            return isExit;
//}
//    
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void initComponents() {
//
//        jPanel1 = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        jLabel3 = new javax.swing.JLabel();
//        jLabel4 = new javax.swing.JLabel();
//        jLabel6 = new javax.swing.JLabel();
//        jLabel7 = new javax.swing.JLabel();
//        jTextField1 = new javax.swing.JTextField();
//        jPanel2 = new javax.swing.JPanel();
//        jLabel8 = new javax.swing.JLabel();
//        txt_contact = new app.bolivia.swing.JCTextField();
//        jLabel9 = new javax.swing.JLabel();
//        jLabel10 = new javax.swing.JLabel();
//        jLabel11 = new javax.swing.JLabel();
//        jLabel12 = new javax.swing.JLabel();
//        txt_username = new app.bolivia.swing.JCTextField();
//        jLabel13 = new javax.swing.JLabel();
//        jLabel14 = new javax.swing.JLabel();
//        txt_password = new app.bolivia.swing.JCTextField();
//        jLabel16 = new javax.swing.JLabel();
//        txt_email = new app.bolivia.swing.JCTextField();
//        jLabel18 = new javax.swing.JLabel();
//        jLabel19 = new javax.swing.JLabel();
//        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
//        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
//        jLabel15 = new javax.swing.JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Spring Digital Library");
//        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//        setMinimumSize(new java.awt.Dimension(1205, 800));
//        setUndecorated(true);
//        setPreferredSize(new java.awt.Dimension(1205, 800));
//        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
//        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
//        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
//        jPanel1.setRequestFocusEnabled(false);
//        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
//        jLabel1.setText("Hub");
//        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));
//
//        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
//        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
//        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
//        jLabel2.setText("Digital");
//        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));
//
//        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
//        jLabel3.setForeground(new java.awt.Color(255, 165, 0));
//        jLabel3.setText("Wisdom");
//        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));
//
//        jLabel4.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
//        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
//        jLabel4.setText("Spring Digital library");
//        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, 40));
//
//        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/Library Singup.jpg"))); // NOI18N
//        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 740, 640));
//
//        jLabel7.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
//        jLabel7.setForeground(new java.awt.Color(251, 51, 51));
//        jLabel7.setText("Welcome To");
//        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 40));
//        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 230, 30));
//
//        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));
//        jPanel1.getAccessibleContext().setAccessibleName("");
//
//        jPanel2.setBackground(new java.awt.Color(153, 0, 255));
//        jPanel2.setMinimumSize(new java.awt.Dimension(600, 800));
//        jPanel2.setPreferredSize(new java.awt.Dimension(600, 800));
//        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
//        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel8.setText("X");
//        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jLabel8MouseClicked(evt);
//            }
//        });
//        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 40, 40));
//
//        txt_contact.setBackground(new java.awt.Color(153, 0, 255));
//        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
//        txt_contact.setPlaceholder("Enter Contact no ...");
//        txt_contact.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txt_contactActionPerformed(evt);
//            }
//        });
//        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 240, 50));
//
//        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel9.setText("Create New Account Here");
//        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 40));
//
//        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-smartphone-12-48.png"))); // NOI18N
//        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));
//
//        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel11.setText("Contact");
//        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, 40));
//
//        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel12.setText("Username");
//        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 40));
//
//        txt_username.setBackground(new java.awt.Color(153, 0, 255));
//        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
//        txt_username.setPlaceholder("Enter Username ...");
//        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                txt_usernameFocusLost(evt);
//            }
//        });
//        txt_username.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txt_usernameActionPerformed(evt);
//            }
//        });
//        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 240, 50));
//
//        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-lock-31-48.png"))); // NOI18N
//        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
//
//        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel14.setText("Password");
//        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 40));
//
//        txt_password.setBackground(new java.awt.Color(153, 0, 255));
//        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
//        txt_password.setPlaceholder("Enter Password ...");
//        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                txt_passwordFocusLost(evt);
//            }
//        });
//        txt_password.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txt_passwordActionPerformed(evt);
//            }
//        });
//        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 240, 50));
//
//        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel16.setText("Email");
//        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 40));
//
//        txt_email.setBackground(new java.awt.Color(153, 0, 255));
//        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
//        txt_email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
//        txt_email.setPlaceholder("Enter Email ...");
//        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
//            public void focusLost(java.awt.event.FocusEvent evt) {
//                txt_emailFocusLost(evt);
//            }
//        });
//        txt_email.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                txt_emailActionPerformed(evt);
//            }
//        });
//        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 240, 50));
//
//        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
//        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-email-10-48.png"))); // NOI18N
//        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));
//
//        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
//        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-user-20-48.png"))); // NOI18N
//        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
//
//        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 255));
//        rSMaterialButtonCircle2.setText("Login");
//        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 700, 230, 60));
//
//        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 102));
//        rSMaterialButtonCircle3.setText("Singup");
//        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                rSMaterialButtonCircle3ActionPerformed(evt);
//            }
//        });
//        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 630, 230, 60));
//
//        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 25)); // NOI18N
//        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
//        jLabel15.setText("Singup Page");
//        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 40));
//
//        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, -1, -1));
//
//        setSize(new java.awt.Dimension(1220, 800));
//        setLocationRelativeTo(null);
//    }// </editor-fold>                        
//
//    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {                                            
//        // TODO add your handling code here:
//    }                                           
//
//    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {                                             
//        // TODO add your handling code here:
//    }                                            
//
//    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {                                             
//        // TODO add your handling code here:
//    }                                            
//
//    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {                                          
//        // TODO add your handling code here:
//    }                                         
//
//    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {                                     
//        System.exit(0);
//    }                                    
//
//    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {                                                        
//        
//        if(validSingup() == true ){
//            insertSingupDetails();
//        }
//    }                                                       
//
//    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {                                       
//        if(checkDuplicateUser()== true){
//            JOptionPane.showMessageDialog(this, "Usrname already exist");
//        }
//    }                                      
//
//    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {                                    
//        if(emailExitsInDatabse() == true){
//            JOptionPane.showMessageDialog(this, "This email is already registered");
//        }
//    }                                   
//
//    private void txt_passwordFocusLost(java.awt.event.FocusEvent evt) {                                       
//        if(!passwordValid()){
//            JOptionPane.showMessageDialog(this,"Invalid Password!\nMust Contain at leat 8 characters\nMust contain at least one uppercase letter\n Must contain at laeat one lowercase letter\nMust contain at least a number");
//        }
//    }                                      
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SingUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SingUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SingUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SingUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SingUpPage().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify                     
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel11;
//    private javax.swing.JLabel jLabel12;
//    private javax.swing.JLabel jLabel13;
//    private javax.swing.JLabel jLabel14;
//    private javax.swing.JLabel jLabel15;
//    private javax.swing.JLabel jLabel16;
//    private javax.swing.JLabel jLabel18;
//    private javax.swing.JLabel jLabel19;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JLabel jLabel7;
//    private javax.swing.JLabel jLabel8;
//    private javax.swing.JLabel jLabel9;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JPanel jPanel2;
//    private javax.swing.JTextField jTextField1;
//    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
//    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
//    private app.bolivia.swing.JCTextField txt_contact;
//    private app.bolivia.swing.JCTextField txt_email;
//    private app.bolivia.swing.JCTextField txt_password;
//    private app.bolivia.swing.JCTextField txt_username;
//    // End of variables declaration                   
//}
//
