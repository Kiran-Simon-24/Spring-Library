/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author kingk
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form SingUpPage
     */
    Color mouseEnterColor = new Color(255, 0, 0);
    Color mouseExitColor = new Color(153, 153, 255);

    public LoginPage() {
        initComponents();
    }

    //Validation
    public boolean validateLogin() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Username");
            return false;
        }

        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter Password");
            return false;
        }

        return true;
    }

    //verify creditencial
    private void login() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE name =? and password = ?");

            pst.setString(1, name);
            pst.setString(2, pwd);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "login successful");
                HomePage home = new HomePage();
                home.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Singup() {
        SingUpPage singUp = new SingUpPage();
        singUp.setVisible(true);
        this.dispose();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        jLabel16 = new javax.swing.JLabel();
        lbl_exit1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Spring Digital Library");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1205, 800));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Hub");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Digital");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 165, 0));
        jLabel3.setText("Wisdom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Spring Digital library");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-3.png.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 770, 570));

        jLabel7.setFont(new java.awt.Font("Sitka Display", 0, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(251, 51, 51));
        jLabel7.setText("Welcome To");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 40));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 790));
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 800));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 800));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Good to see you again");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 40));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, 40));

        txt_username.setBackground(new java.awt.Color(153, 153, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_username.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_username.setPlaceholder("Enter Username ...");
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 240, 50));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-lock-31-48.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Password");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, 40));

        txt_password.setBackground(new java.awt.Color(153, 153, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txt_password.setPlaceholder("Enter Password ...");
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 240, 50));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/iconmonstr-user-20-48.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 255));
        rSMaterialButtonCircle2.setText("Login");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 230, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 102));
        rSMaterialButtonCircle3.setText("Singup");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 230, 60));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 25)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Library Login");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, 40));

        lbl_exit1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_exit1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        lbl_exit1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_exit1.setText("  X");
        lbl_exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseExited(evt);
            }
        });
        jPanel2.add(lbl_exit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 0, 420, 790));

        setSize(new java.awt.Dimension(1220, 788));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        Singup();
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (validateLogin());
        {
            login();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void lbl_exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseClicked

    private void lbl_exit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseEntered

    private void lbl_exit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseExited

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_exit1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables

}
