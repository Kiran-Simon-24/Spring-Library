/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kingk
 */
public class IssuedBookDetails extends javax.swing.JFrame {

    /**
     * Creates new form IssuedBookDetails
     */
    Color mouseEnterColorMin = new Color(187, 187, 187);
    Color mouseEnterColorExit = new Color(255, 0, 0);
    Color mouseExitColor = new Color(255, 255, 255);

    DefaultTableModel model;

    public IssuedBookDetails() {
        initComponents();
        setIssuedBookDetailToTable();
    }

    public void setIssuedBookDetailToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db", "root", "");
            Statement st = con.createStatement();
            String sql = "SELECT\n"
                    + "    LPAD(id, 3, '0') as id,\n"
                    + "    book_name,\n"
                    + "    student_name,\n"
                    + "    DATE_FORMAT(issue_date, '%d/%m/%y') as Issue_date,\n"
                    + "    DATE_FORMAT(due_date, '%d/%m/%y') as Due_date,\n"
                    + "    status\n"
                    + "FROM\n"
                    + "    issue_book WHERE status = '" + "pending" + "'";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String id = rs.getString("id");
                String studentName = rs.getString("Student_name");
                String bookName = rs.getString("Book_name");
                String issueDate = rs.getString("Issue_date");
                String dueDate = rs.getString("Due_date");
                String status = rs.getString("status");

                Object[] obj = {id, studentName, bookName, issueDate, dueDate, status};
                model = (DefaultTableModel) tb_IssuedBookDetails.getModel();
                model.addRow(obj);
            }
        } catch (ClassNotFoundException | SQLException e) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lbl_minimize = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        lbl_back = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_IssuedBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText(" Issued Book Details");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 300, -1));

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 350, 5));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 0, 120, 50));

        lbl_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/iconmonstr-arrow-left-alt-filled-48.png"))); // NOI18N
        lbl_back.setBackground(new java.awt.Color(255, 255, 255));
        lbl_back.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        lbl_back.setForeground(new java.awt.Color(51, 51, 51));
        lbl_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_backMouseClicked(evt);
            }
        });
        jPanel1.add(lbl_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));

        tb_IssuedBookDetails.setBackground(new java.awt.Color(187, 187, 187));
        tb_IssuedBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tb_IssuedBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tb_IssuedBookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tb_IssuedBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tb_IssuedBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tb_IssuedBookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tb_IssuedBookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tb_IssuedBookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tb_IssuedBookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tb_IssuedBookDetails.setRowHeight(40);
        tb_IssuedBookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_IssuedBookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_IssuedBookDetails);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 1100, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1376, 654));

        setSize(new java.awt.Dimension(1376, 654));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void lbl_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_backMouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_backMouseClicked

    private void tb_IssuedBookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_IssuedBookDetailsMouseClicked

    }//GEN-LAST:event_tb_IssuedBookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuedBookDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBookDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_back;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimize;
    private rojeru_san.complementos.RSTableMetro tb_IssuedBookDetails;
    // End of variables declaration//GEN-END:variables
}
