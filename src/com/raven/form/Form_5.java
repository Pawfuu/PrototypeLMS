
package com.raven.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_5 extends javax.swing.JPanel {

   DefaultTableModel model;
    public Form_5() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
    
    // to set the book details into the table
    public void setIssueBookDetailsToTable(){
         
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs =  st.executeQuery("select * from issue_book_details " );
           
           while (rs.next()){
                   String id = rs.getString("id");
                   String bookName = rs.getString("book_name");
                   String studentName = rs.getString("student_name");
                   String issueDate = rs.getString("issue_date");
                   String dueDate = rs.getString("due_date");
                   String status = rs.getString("status");
                   
                   Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                   model = (DefaultTableModel)tbl_issueBookDetails .getModel();
                   model.addRow(obj);
           }
           
        } catch (Exception e) {
            // Handle the exception and print an error message
            e.printStackTrace();
        }
    }
    //method to clear table
    public void clearTable(){
         DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
         model.setRowCount(0);
    }
    
    //to fetch teh record using date fields 
    public void search() {
        //u means utilFromDate
        Date ufromDate = date_fromDate.getDatoFecha();
        Date uToDate = date_toDate.getDatoFecha();

        //have to convert it into sql because util package dont support sql 
        long l1 = ufromDate.getTime();
        long l2 = uToDate.getTime();

        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);

            ResultSet rs = pst.executeQuery();
            if (rs.next() == false) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            } else {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String studentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj = {id, bookName, studentName, issueDate, dueDate, status};
                    model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                    model.addRow(obj);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bookError = new javax.swing.JLabel();
        card_background1 = new com.raven.component.Card_background();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();
        panelBorder1 = new com.raven.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 150, 30));

        card_background1.setColor1(new java.awt.Color(0, 0, 70));
        card_background1.setColor2(new java.awt.Color(130, 130, 149));

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(0, 0, 70));
        tbl_issueBookDetails.setColorBordeFilas(new java.awt.Color(0, 0, 70));
        tbl_issueBookDetails.setColorBordeHead(new java.awt.Color(130, 130, 149));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setRowHeight(40);
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        javax.swing.GroupLayout card_background1Layout = new javax.swing.GroupLayout(card_background1);
        card_background1.setLayout(card_background1Layout);
        card_background1Layout.setHorizontalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1190, Short.MAX_VALUE)
            .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(card_background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        card_background1Layout.setVerticalGroup(
            card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(card_background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(card_background1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(card_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 210, 1190, 450));

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/folder.png"))); // NOI18N
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        date_toDate.setColorBackground(new java.awt.Color(0, 0, 70));
        date_toDate.setColorForeground(new java.awt.Color(255, 255, 255));
        date_toDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_toDate.setPlaceholder("Select Due Date");
        panelBorder1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 320, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 70));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 70));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VIEW ALL RECORDS");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 460, 70));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Due Date :");
        panelBorder1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, 150, 70));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 70));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel52.setText("Due Date :");
        panelBorder1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 100, 70));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 70));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Issue Date :");
        panelBorder1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 70));

        date_fromDate.setColorBackground(new java.awt.Color(0, 0, 70));
        date_fromDate.setColorForeground(new java.awt.Color(255, 255, 255));
        date_fromDate.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        date_fromDate.setPlaceholder("Select Issue Date");
        panelBorder1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 320, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("sesarch");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panelBorder1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 140, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 70));
        rSMaterialButtonCircle2.setText("all");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        panelBorder1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 100, 140, 70));

        add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 210));
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null){
            clearTable();
            search();
        }else{
            JOptionPane.showMessageDialog(this, "Please select a date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card_background card_background1;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_bookError;
    private com.raven.swing.PanelBorder panelBorder1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
