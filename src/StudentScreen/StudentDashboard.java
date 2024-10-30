
package StudentScreen;
import User.Student;
import javax.swing.table.DefaultTableModel;

public class StudentDashboard extends javax.swing.JFrame {

    User.Student st;
    studentHelper stuHelper = new studentHelper();
    
    public StudentDashboard(Student st) {
        this.st = st;
        initComponents();
        setLocationRelativeTo(null);
        lbl_hosgeldiniz.setText("Hoşgeldiniz " + st.getName() );
        loadTable();
        loadDevamsizlik();
    }
    
    public void loadTable () {
        DefaultTableModel model = (DefaultTableModel) tbl_ogrenci.getModel();
        model.setRowCount(0);
        stuHelper.load_tbl_notlar(st.getStdNo(), model);
    }
    
    public void loadDevamsizlik () {
        DefaultTableModel model = (DefaultTableModel) tbl_devamsizlik.getModel();
        model.setRowCount(0);
        stuHelper.load_tbl_devamsizlik(st.getStdNo(), model);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_hosgeldiniz = new javax.swing.JLabel();
        pn_dashboard_ogrenci = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ogrenci = new javax.swing.JTable();
        pn_devamsizlik = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_devamsizlik = new javax.swing.JTable();
        pnp_background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Öğrenci Ekranı");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_hosgeldiniz.setText("Öğrenci Ekranı");
        getContentPane().add(lbl_hosgeldiniz, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 270, -1));

        pn_dashboard_ogrenci.setBackground(new java.awt.Color(255, 255, 255));

        tbl_ogrenci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dersler", "Vize Not", "Final Not", "Sonuç"
            }
        ));
        jScrollPane1.setViewportView(tbl_ogrenci);

        pn_dashboard_ogrenci.addTab("Notlarım", jScrollPane1);

        tbl_devamsizlik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Öğrenci No", "Öğrenci", "Devamsızlık"
            }
        ));
        jScrollPane2.setViewportView(tbl_devamsizlik);

        javax.swing.GroupLayout pn_devamsizlikLayout = new javax.swing.GroupLayout(pn_devamsizlik);
        pn_devamsizlik.setLayout(pn_devamsizlikLayout);
        pn_devamsizlikLayout.setHorizontalGroup(
            pn_devamsizlikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_devamsizlikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_devamsizlikLayout.setVerticalGroup(
            pn_devamsizlikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_devamsizlikLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
        );

        pn_dashboard_ogrenci.addTab("Devamsızlık", pn_devamsizlik);

        getContentPane().add(pn_dashboard_ogrenci, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, -1, 354));

        pnp_background.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnp_backgroundLayout = new javax.swing.GroupLayout(pnp_background);
        pnp_background.setLayout(pnp_backgroundLayout);
        pnp_backgroundLayout.setHorizontalGroup(
            pnp_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        pnp_backgroundLayout.setVerticalGroup(
            pnp_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        getContentPane().add(pnp_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents


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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hosgeldiniz;
    private javax.swing.JTabbedPane pn_dashboard_ogrenci;
    private javax.swing.JPanel pn_devamsizlik;
    private javax.swing.JPanel pnp_background;
    private javax.swing.JTable tbl_devamsizlik;
    private javax.swing.JTable tbl_ogrenci;
    // End of variables declaration//GEN-END:variables
}
