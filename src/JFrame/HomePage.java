/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author kingk
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColorMin = new Color(187, 187, 187);
    Color mouseEnterColorExit = new Color(255, 0, 0);
    Color mouseExitColorPanel = new Color(102, 102, 255);
    Color mouseEnterColor = new Color(0, 0, 0);
    Color mouseExitColor = new Color(51, 51, 51);
    Color mouseEnterColorLogout = new Color(255,51,51);
    

    DefaultTableModel model;

    public HomePage() {
        initComponents();
        showPieChart();
        setBookDetailsToTable();
        setStudentDetailsToTable();
        setDataToCards();
    }

    // To set the studetn dtails to table
    public void setStudentDetailsToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT LPAD(student_id, 3, '0') AS student_id, student_name, course, branch FROM student_details");

            while (rs.next()) {
                String studentId = rs.getString("Student_id");
                String studentName = rs.getString("Student_name");
                String course = rs.getString("Course");
                String branch = rs.getString("Branch");

                Object[] obj = {studentId, studentName, course, branch};
                model = (DefaultTableModel) tb_studentDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To set the book dtails to table
    public void setBookDetailsToTable() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library-ms-db", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT LPAD(book_id, 3, '0') book_id, book_name, author, quantity FROM book_details");

            while (rs.next()) {
                String bookId = rs.getString("Book_id");
                String bookName = rs.getString("Book_name");
                String author = rs.getString("Author");
                int quantity = rs.getInt("Quantity");

                Object[] obj = {bookId, bookName, author, quantity};
                model = (DefaultTableModel) tb_bookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //set data to piechart
    public void setDataToCards() {
        Statement st = null;
        ResultSet rs = null;

        long time = System.currentTimeMillis();
        java.sql.Date todayDate = new java.sql.Date(time);

        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM book_details ");
            rs.last();
            lbl_NoOfBook.setText(Integer.toString(rs.getRow()));
            
            rs = st.executeQuery("SELECT * FROM student_details ");
            rs.last();
            lbl_NoOfStudent.setText(Integer.toString(rs.getRow()));
            
            rs = st.executeQuery("SELECT * FROM  issue_book where status = '"+"Pending"+"'");
            rs.last();
            lbl_NoOfIssueBook.setText(Integer.toString(rs.getRow()));
            
            rs = st.executeQuery("SELECT * FROM  issue_book where due_date <= '"+todayDate+"' AND  status = '"+"Pending"+"'");
            rs.last();
            lbl_NoOfDefaulterList.setText(Integer.toString(rs.getRow()));
            
            
        } catch (SQLException e) {
        }
    }

    public void showPieChart() {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT book_name, COUNT(*) as issue_count FROM book_details group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
              barDataset.setValue(rs.getString("book_name"), Double.valueOf(rs.getDouble("issue_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details", barDataset, true, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();

        //changing pie chart blocks colors
        piePlot.setSectionPaint("Java", new Color(255, 255, 102));
        piePlot.setSectionPaint("Python", new Color(102, 255, 102));
        piePlot.setSectionPaint("JavaScript", new Color(255, 102, 153));
        piePlot.setSectionPaint("SQL", new Color(0, 204, 204));

        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
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
        lbl_minimize = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pl_ManageBook = new javax.swing.JPanel();
        lbl_ManageBook = new javax.swing.JLabel();
        pl_ManageStudents = new javax.swing.JPanel();
        lbl_ManageStudents = new javax.swing.JLabel();
        pl_IssueBook = new javax.swing.JPanel();
        lbl_IssueBook = new javax.swing.JLabel();
        pl_ReturnBook = new javax.swing.JPanel();
        lbl_ReturnBook = new javax.swing.JLabel();
        pl_ViewRecord = new javax.swing.JPanel();
        lbl_ViewRecord = new javax.swing.JLabel();
        pl_ViewIssuedBook = new javax.swing.JPanel();
        lbl_ViewIssuedBook = new javax.swing.JLabel();
        pl_DefaultList = new javax.swing.JPanel();
        lbl_DefaultList = new javax.swing.JLabel();
        pl_Logout = new javax.swing.JPanel();
        lbl_Logout = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        lbl_NoOfBook = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        lbl_NoOfStudent = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        lbl_NoOfIssueBook = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        lbl_NoOfDefaulterList = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_bookDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel26 = new javax.swing.JLabel();
        panelPieChart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_studentDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_minimize.setBackground(new java.awt.Color(255, 255, 255));
        lbl_minimize.setFont(new java.awt.Font("Yu Gothic UI", 1, 38)); // NOI18N
        lbl_minimize.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(lbl_minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, 40, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/iconmonstr-book-21-64.png"))); // NOI18N
        jLabel3.setText("  Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 410, 50));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel5.setText("Welcome Admin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 210, -1));

        lbl_exit.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        lbl_exit.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(lbl_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 0, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1470, 70));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jLabel8.setText("   LMS Dashboard");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 220, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        pl_ManageBook.setBackground(new java.awt.Color(51, 51, 51));
        pl_ManageBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ManageBook.setBackground(new java.awt.Color(51, 51, 51));
        lbl_ManageBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_ManageBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_ManageBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ManageBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        lbl_ManageBook.setText("   Manage Books");
        lbl_ManageBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ManageBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ManageBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ManageBookMouseExited(evt);
            }
        });
        pl_ManageBook.add(lbl_ManageBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, 40));

        jPanel2.add(pl_ManageBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 340, 60));

        pl_ManageStudents.setBackground(new java.awt.Color(51, 51, 51));
        pl_ManageStudents.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ManageStudents.setBackground(new java.awt.Color(51, 51, 51));
        lbl_ManageStudents.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_ManageStudents.setForeground(new java.awt.Color(153, 153, 153));
        lbl_ManageStudents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ManageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        lbl_ManageStudents.setText("   Manage Students");
        lbl_ManageStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ManageStudentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ManageStudentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ManageStudentsMouseExited(evt);
            }
        });
        pl_ManageStudents.add(lbl_ManageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 210, 40));

        jPanel2.add(pl_ManageStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 340, 60));

        pl_IssueBook.setBackground(new java.awt.Color(51, 51, 51));
        pl_IssueBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_IssueBook.setBackground(new java.awt.Color(51, 51, 51));
        lbl_IssueBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_IssueBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_IssueBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IssueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        lbl_IssueBook.setText("   Issue Book");
        lbl_IssueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_IssueBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_IssueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_IssueBookMouseExited(evt);
            }
        });
        pl_IssueBook.add(lbl_IssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 40));

        jPanel2.add(pl_IssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 340, 60));

        pl_ReturnBook.setBackground(new java.awt.Color(51, 51, 51));
        pl_ReturnBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ReturnBook.setBackground(new java.awt.Color(51, 51, 51));
        lbl_ReturnBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_ReturnBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_ReturnBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ReturnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        lbl_ReturnBook.setText("   Return Book");
        lbl_ReturnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ReturnBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ReturnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ReturnBookMouseExited(evt);
            }
        });
        pl_ReturnBook.add(lbl_ReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 40));

        jPanel2.add(pl_ReturnBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 340, 60));

        pl_ViewRecord.setBackground(new java.awt.Color(51, 51, 51));
        pl_ViewRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ViewRecord.setBackground(new java.awt.Color(51, 51, 51));
        lbl_ViewRecord.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_ViewRecord.setForeground(new java.awt.Color(153, 153, 153));
        lbl_ViewRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ViewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        lbl_ViewRecord.setText("   View Record");
        lbl_ViewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ViewRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ViewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ViewRecordMouseExited(evt);
            }
        });
        pl_ViewRecord.add(lbl_ViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 40));

        jPanel2.add(pl_ViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 340, 60));

        pl_ViewIssuedBook.setBackground(new java.awt.Color(51, 51, 51));
        pl_ViewIssuedBook.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ViewIssuedBook.setBackground(new java.awt.Color(51, 51, 51));
        lbl_ViewIssuedBook.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_ViewIssuedBook.setForeground(new java.awt.Color(153, 153, 153));
        lbl_ViewIssuedBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ViewIssuedBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        lbl_ViewIssuedBook.setText("   View Issued Book");
        lbl_ViewIssuedBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ViewIssuedBookMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_ViewIssuedBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_ViewIssuedBookMouseExited(evt);
            }
        });
        pl_ViewIssuedBook.add(lbl_ViewIssuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 250, 50));

        jPanel2.add(pl_ViewIssuedBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 340, 60));

        pl_DefaultList.setBackground(new java.awt.Color(51, 51, 51));
        pl_DefaultList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_DefaultList.setBackground(new java.awt.Color(51, 51, 51));
        lbl_DefaultList.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_DefaultList.setForeground(new java.awt.Color(153, 153, 153));
        lbl_DefaultList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_DefaultList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        lbl_DefaultList.setText("   Default List");
        lbl_DefaultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DefaultListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_DefaultListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_DefaultListMouseExited(evt);
            }
        });
        pl_DefaultList.add(lbl_DefaultList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 40));

        jPanel2.add(pl_DefaultList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 340, 60));

        pl_Logout.setBackground(new java.awt.Color(102, 102, 255));
        pl_Logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Logout.setBackground(new java.awt.Color(240, 240, 240));
        lbl_Logout.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        lbl_Logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        lbl_Logout.setText("   Logout");
        lbl_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_LogoutMouseExited(evt);
            }
        });
        pl_Logout.add(lbl_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 40));

        jPanel2.add(pl_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 340, 60));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Features");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 340, 830));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("No of Students");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 180, -1));

        jPanel16.setBackground(new java.awt.Color(187, 187, 187));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel16.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NoOfBook.setBackground(new java.awt.Color(0, 0, 0));
        lbl_NoOfBook.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_NoOfBook.setForeground(new java.awt.Color(102, 102, 102));
        lbl_NoOfBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_NoOfBook.setText(" 10");
        jPanel16.add(lbl_NoOfBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 38, 142, -1));

        jPanel5.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 200, 130));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Books Details");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 180, -1));

        jPanel18.setBackground(new java.awt.Color(187, 187, 187));
        jPanel18.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel18.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NoOfStudent.setBackground(new java.awt.Color(0, 0, 0));
        lbl_NoOfStudent.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_NoOfStudent.setForeground(new java.awt.Color(102, 102, 102));
        lbl_NoOfStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_NoOfStudent.setText(" 10");
        jPanel18.add(lbl_NoOfStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 38, 142, -1));

        jPanel5.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 200, 130));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Issued Books");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 180, -1));

        jPanel17.setBackground(new java.awt.Color(187, 187, 187));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel17.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NoOfIssueBook.setBackground(new java.awt.Color(0, 0, 0));
        lbl_NoOfIssueBook.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_NoOfIssueBook.setForeground(new java.awt.Color(102, 102, 102));
        lbl_NoOfIssueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_NoOfIssueBook.setText(" 10");
        jPanel17.add(lbl_NoOfIssueBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 38, 142, -1));

        jPanel5.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 200, 130));

        jPanel19.setBackground(new java.awt.Color(187, 187, 187));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel19.setPreferredSize(new java.awt.Dimension(260, 1));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NoOfDefaulterList.setBackground(new java.awt.Color(0, 0, 0));
        lbl_NoOfDefaulterList.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_NoOfDefaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_NoOfDefaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_NoOfDefaulterList.setText(" 10");
        jPanel19.add(lbl_NoOfDefaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 38, 142, -1));

        jPanel5.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 200, 130));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Defaulter List");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 180, -1));

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("No of Books");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 180, -1));

        tb_bookDetails.setBackground(new java.awt.Color(187, 187, 187));
        tb_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book id", "Name", "Author", "Quantity"
            }
        ));
        tb_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tb_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tb_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tb_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tb_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tb_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tb_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tb_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tb_bookDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tb_bookDetails);
        if (tb_bookDetails.getColumnModel().getColumnCount() > 0) {
            tb_bookDetails.getColumnModel().getColumn(1).setResizable(false);
            tb_bookDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 580, 220));

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 1, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Students Details");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, -1));

        panelPieChart.setBackground(new java.awt.Color(187, 187, 187));
        panelPieChart.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel5.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 460, 350));

        tb_studentDetails.setBackground(new java.awt.Color(187, 187, 187));
        tb_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student id", "Name", "Course", "Branch"
            }
        ));
        tb_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tb_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tb_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tb_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tb_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        tb_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tb_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tb_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tb_studentDetails.setRowHeight(40);
        jScrollPane3.setViewportView(tb_studentDetails);
        if (tb_studentDetails.getColumnModel().getColumnCount() > 0) {
            tb_studentDetails.getColumnModel().getColumn(1).setResizable(false);
            tb_studentDetails.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 580, 220));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 1130, 820));

        setSize(new java.awt.Dimension(1472, 820));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void lbl_ManageBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageBookMouseClicked
        ManageBooks manageBooks = new ManageBooks();
        manageBooks.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_ManageBookMouseClicked

    private void lbl_ManageBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageBookMouseEntered
        pl_ManageBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_ManageBookMouseEntered

    private void lbl_ManageBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageBookMouseExited
        pl_ManageBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_ManageBookMouseExited

    private void lbl_ManageStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageStudentsMouseEntered
        pl_ManageStudents.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_ManageStudentsMouseEntered

    private void lbl_ManageStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageStudentsMouseExited
        pl_ManageStudents.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_ManageStudentsMouseExited

    private void lbl_ManageStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ManageStudentsMouseClicked
        ManageStudents manageStudent = new ManageStudents();
        manageStudent.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_ManageStudentsMouseClicked

    private void lbl_IssueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IssueBookMouseEntered
        pl_IssueBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_IssueBookMouseEntered

    private void lbl_IssueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IssueBookMouseExited
        pl_IssueBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_IssueBookMouseExited

    private void lbl_IssueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IssueBookMouseClicked
        IssuedBook issueBook = new IssuedBook();
        issueBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_IssueBookMouseClicked

    private void lbl_ReturnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ReturnBookMouseEntered
        pl_ReturnBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_ReturnBookMouseEntered

    private void lbl_ReturnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ReturnBookMouseExited
        pl_ReturnBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_ReturnBookMouseExited

    private void lbl_ViewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewRecordMouseEntered
        pl_ViewRecord.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_ViewRecordMouseEntered

    private void lbl_ViewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewRecordMouseExited
        pl_ViewRecord.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_ViewRecordMouseExited

    private void lbl_ViewIssuedBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewIssuedBookMouseEntered
        pl_ViewIssuedBook.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_ViewIssuedBookMouseEntered

    private void lbl_ViewIssuedBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewIssuedBookMouseExited
        pl_ViewIssuedBook.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_ViewIssuedBookMouseExited

    private void lbl_DefaultListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DefaultListMouseEntered
        pl_DefaultList.setBackground(mouseEnterColor);
    }//GEN-LAST:event_lbl_DefaultListMouseEntered

    private void lbl_DefaultListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DefaultListMouseExited
        pl_DefaultList.setBackground(mouseExitColor);
    }//GEN-LAST:event_lbl_DefaultListMouseExited

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void lbl_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseEntered
        lbl_exit.setBackground(mouseEnterColorExit);
        lbl_exit.setOpaque(true); // Make sure this is set to true
        lbl_exit.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_exitMouseEntered

    private void lbl_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseExited
        lbl_exit.setBackground(mouseExitColorPanel);
    }//GEN-LAST:event_lbl_exitMouseExited

    private void lbl_minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseEntered
        lbl_minimize.setBackground(mouseEnterColorMin);
        lbl_minimize.setOpaque(true); // Make sure this is set to true
        lbl_minimize.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_minimizeMouseEntered

    private void lbl_minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseExited
        lbl_minimize.setBackground(mouseExitColorPanel);
        lbl_minimize.setOpaque(true); // Make sure this is set to true
        lbl_minimize.repaint(); // Repaint to apply changes
    }//GEN-LAST:event_lbl_minimizeMouseExited

    private void lbl_ReturnBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ReturnBookMouseClicked
        ReturnBook returnBook = new ReturnBook();
        returnBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_ReturnBookMouseClicked

    private void lbl_ViewRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewRecordMouseClicked
        ViewAllRecord viewRecord = new ViewAllRecord();
        viewRecord.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_ViewRecordMouseClicked

    private void lbl_ViewIssuedBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ViewIssuedBookMouseClicked
        IssuedBookDetails issuedBook = new IssuedBookDetails();
        issuedBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_ViewIssuedBookMouseClicked

    private void lbl_DefaultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DefaultListMouseClicked
        DefaulterList defaulterList = new DefaulterList();
        defaulterList.setVisible(true);
        dispose();
    }//GEN-LAST:event_lbl_DefaultListMouseClicked

    private void lbl_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogoutMouseEntered
      pl_Logout.setBackground(mouseEnterColorLogout);
    }//GEN-LAST:event_lbl_LogoutMouseEntered

    private void lbl_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogoutMouseExited
        pl_Logout.setBackground(mouseExitColorPanel);
    }//GEN-LAST:event_lbl_LogoutMouseExited

    private void lbl_LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_LogoutMouseClicked
       LoginPage login = new LoginPage();
       login.setVisible(true);
       dispose();
    }//GEN-LAST:event_lbl_LogoutMouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_DefaultList;
    private javax.swing.JLabel lbl_IssueBook;
    private javax.swing.JLabel lbl_Logout;
    private javax.swing.JLabel lbl_ManageBook;
    private javax.swing.JLabel lbl_ManageStudents;
    private javax.swing.JLabel lbl_NoOfBook;
    private javax.swing.JLabel lbl_NoOfDefaulterList;
    private javax.swing.JLabel lbl_NoOfIssueBook;
    private javax.swing.JLabel lbl_NoOfStudent;
    private javax.swing.JLabel lbl_ReturnBook;
    private javax.swing.JLabel lbl_ViewIssuedBook;
    private javax.swing.JLabel lbl_ViewRecord;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimize;
    private javax.swing.JPanel panelPieChart;
    private javax.swing.JPanel pl_DefaultList;
    private javax.swing.JPanel pl_IssueBook;
    private javax.swing.JPanel pl_Logout;
    private javax.swing.JPanel pl_ManageBook;
    private javax.swing.JPanel pl_ManageStudents;
    private javax.swing.JPanel pl_ReturnBook;
    private javax.swing.JPanel pl_ViewIssuedBook;
    private javax.swing.JPanel pl_ViewRecord;
    private rojeru_san.complementos.RSTableMetro tb_bookDetails;
    private rojeru_san.complementos.RSTableMetro tb_studentDetails;
    // End of variables declaration//GEN-END:variables
}
