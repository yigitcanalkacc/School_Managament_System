
package TeacherScreen;

import User.Teacher;
import javax.swing.table.DefaultTableModel;
import User.Student;
import java.util.List;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import DataAccess.Kurs;
import TeacherScreen.TeacherHelper;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class TeacherDashboard extends javax.swing.JFrame {

    
    Teacher teacherStats;
    Student student;
    
    
    public TeacherDashboard(Teacher teacherStats) {
        this.teacherStats = teacherStats;
        initComponents();
        setLocationRelativeTo(null);
        lbl_hosgeldiniz.setText("Hoşgeldiniz " + teacherStats.getName());
        studentsLoad();
        notLoad();
        cmb_kurs1.addItem(teacherStats.getKurs());
        cmb_ders_sec.addItem(teacherStats.getKurs());
        init();
        selectedRow_ogr1();
        selectedRow_stNo();
        devamsizlikTable_Load();
    }
    

    
    
    public void studentsLoad () {
        TeacherHelper teacherHelper = new TeacherHelper();
        List<Student> students = teacherHelper.checkStudent(teacherStats.getId());
        
        DefaultTableModel model =  (DefaultTableModel) tbl_ogrenciler.getModel();
        model.setRowCount(0);
        
        for(Student student : students) {
            model.addRow(new Object[]{
                student.getName(),
                student.getStdNo(),
                student.getGrade(),
                student.getCourse()
            });
        }
    }
    
    public void notLoad () {
        TeacherHelper teacherHelper = new TeacherHelper();
        List<Kurs> kurslar = teacherHelper.notLoad(teacherStats.getId());
        
        DefaultTableModel model = (DefaultTableModel) tbl_notlar.getModel();
        model.setRowCount(0);
        
        for (Kurs kurs : kurslar) {
            model.addRow(new Object[]{
                kurs.getStdNo(),
                kurs.getOgrenci(),
                kurs.getDers(),
                kurs.getVizenot(),
                kurs.getFinalnot(),
                kurs.getSonuc()
                
            });
        }

        
        System.out.println("Dönen kayıt sayısı: " + kurslar.size());

        
    }
    
  
    
    public void init() {
    // MouseListener tbl_ogrenciler
    tbl_ogrenciler.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            selectedRow_ogr1();
            selectedRow_stNo();
            
        }
    });
    
        // MouseListener tbl_notlar
    tbl_notlar.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
           selectedRow_fldOgrenci();
        }
    });
    
    
}
              
public void selectedRow_ogr1() {
    int selectedRow = tbl_ogrenciler.getSelectedRow();
    if (selectedRow != -1) {
        // 1. sütundaki değeri al
        String studentName = (String) tbl_ogrenciler.getValueAt(selectedRow, 0);
        // fld_ogrekle1 alanına yazdır
        fld_ogrekle1.setText(studentName);
    }
}

public void selectedRow_stNo() {
    int selectedRow = tbl_ogrenciler.getSelectedRow();
    if (selectedRow != -1) {
        // 1. sütundaki değeri al
        int studentNo = (Integer) tbl_ogrenciler.getValueAt(selectedRow, 1);
        // fld_ogrekle1 alanına yazdır
        fld_student_no.setText(String.valueOf(studentNo));
    }
}


public void selectedRow_fldOgrenci() {
    int selectedRow = tbl_notlar.getSelectedRow();
    if (selectedRow != -1) {
        // 1. sütundaki değeri al
        String studentNo = (String) tbl_notlar.getValueAt(selectedRow, 1);
        // fld_ogrekle1 alanına yazdır
        fld_ogrenci.setText(studentNo);
    }
}


 public void devamsizlikTable_Load () {
      TeacherHelper teacherHelper = new TeacherHelper();
      DefaultTableModel devamsizlik = (DefaultTableModel) tbl_devamsızlık.getModel();
      devamsizlik.setRowCount(0);
      tbl_devamsızlık.setBackground(Color.WHITE);
      teacherHelper.devamsizlikLoad(teacherStats.getId(), devamsizlik);
 }

    

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pnl_teacher = new javax.swing.JPanel();
        pnl_ogretmen = new javax.swing.JTabbedPane();
        pnl_ogrenciler = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ogrenciler = new javax.swing.JTable();
        btn_ara = new javax.swing.JButton();
        fld_ara = new javax.swing.JTextField();
        lbl_ara = new javax.swing.JLabel();
        btn_ekle1 = new javax.swing.JButton();
        fld_ogrekle1 = new javax.swing.JTextField();
        lbl_ogr_ekle1 = new javax.swing.JLabel();
        lbl_sinif1 = new javax.swing.JLabel();
        fld_sinif1 = new javax.swing.JTextField();
        lbl_kurs1 = new javax.swing.JLabel();
        cmb_kurs1 = new javax.swing.JComboBox<>();
        lbl_final_not = new javax.swing.JLabel();
        fld_final_not = new javax.swing.JTextField();
        lbl_ogrenci_no = new javax.swing.JLabel();
        fld_student_no = new javax.swing.JTextField();
        pnl_notlar = new javax.swing.JPanel();
        pn_notlar = new javax.swing.JScrollPane();
        tbl_notlar = new javax.swing.JTable();
        lbl_not_guncelle = new javax.swing.JLabel();
        fld_ogrenci = new javax.swing.JTextField();
        lbl_ogrenci = new javax.swing.JLabel();
        lbl_ders_sec = new javax.swing.JLabel();
        cmb_ders_sec = new javax.swing.JComboBox<>();
        lbl_not_tipi = new javax.swing.JLabel();
        cmb_not_tipi = new javax.swing.JComboBox<>();
        lbl_not = new javax.swing.JLabel();
        fld_not = new javax.swing.JTextField();
        btn_kaydet = new javax.swing.JButton();
        pnp_devamsızlık = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_devamsızlık = new javax.swing.JTable();
        lbl_devamsizlik = new javax.swing.JLabel();
        lbl_hosgeldiniz = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Öğretmen Ekranı");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnl_teacher.setBackground(new java.awt.Color(255, 255, 255));

        pnl_ogretmen.setBackground(new java.awt.Color(255, 255, 255));

        pnl_ogrenciler.setBackground(new java.awt.Color(255, 255, 255));

        tbl_ogrenciler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Adı", "Öğrenci No", "Sınıf", "Ders"
            }
        ));
        tbl_ogrenciler.setOpaque(false);
        jScrollPane1.setViewportView(tbl_ogrenciler);

        btn_ara.setText("Ara");

        lbl_ara.setText("Öğrenci Ara");

        btn_ekle1.setText("Güncelle");
        btn_ekle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ekle1MouseClicked(evt);
            }
        });

        fld_ogrekle1.setEditable(false);
        fld_ogrekle1.setEnabled(false);

        lbl_ogr_ekle1.setText("Öğrenci Adı");

        lbl_sinif1.setText("Vize Notu");

        lbl_kurs1.setText("Ders");

        lbl_final_not.setText("Final Notu");

        lbl_ogrenci_no.setText("Öğrenci No");

        fld_student_no.setEditable(false);
        fld_student_no.setEnabled(false);

        javax.swing.GroupLayout pnl_ogrencilerLayout = new javax.swing.GroupLayout(pnl_ogrenciler);
        pnl_ogrenciler.setLayout(pnl_ogrencilerLayout);
        pnl_ogrencilerLayout.setHorizontalGroup(
            pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ogrencilerLayout.createSequentialGroup()
                .addGroup(pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_ogrencilerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(fld_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_kurs1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_final_not, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fld_ogrekle1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(lbl_ogr_ekle1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sinif1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fld_sinif1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btn_ekle1)
                    .addComponent(lbl_final_not, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_kurs1, 0, 115, Short.MAX_VALUE)
                    .addComponent(lbl_ogrenci_no, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_student_no))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnl_ogrencilerLayout.setVerticalGroup(
            pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ogrencilerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_ogrencilerLayout.createSequentialGroup()
                        .addComponent(lbl_ogr_ekle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fld_ogrekle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_ogrenci_no)
                        .addGap(5, 5, 5)
                        .addComponent(fld_student_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_sinif1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fld_sinif1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_final_not)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fld_final_not, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_kurs1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_kurs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ekle1))
                    .addGroup(pnl_ogrencilerLayout.createSequentialGroup()
                        .addGroup(pnl_ogrencilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_ara)
                            .addComponent(fld_ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_ara))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pnl_ogretmen.addTab("Öğrencilerim", pnl_ogrenciler);

        pnl_notlar.setBackground(new java.awt.Color(255, 255, 255));

        tbl_notlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Öğrenci No", "Öğrenci", "Ders", "Vize Not", "Final Not", "Durum"
            }
        ));
        tbl_notlar.setOpaque(false);
        pn_notlar.setViewportView(tbl_notlar);

        lbl_not_guncelle.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        lbl_not_guncelle.setText("Not Güncelleme Ekranı");

        fld_ogrenci.setEditable(false);
        fld_ogrenci.setEnabled(false);

        lbl_ogrenci.setText("Öğrenci");

        lbl_ders_sec.setText("Ders Seç");

        lbl_not_tipi.setText("Not Tipi");

        cmb_not_tipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vize", "Final" }));

        lbl_not.setText("Not");

        btn_kaydet.setText("Kaydet");
        btn_kaydet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kaydetMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnl_notlarLayout = new javax.swing.GroupLayout(pnl_notlar);
        pnl_notlar.setLayout(pnl_notlarLayout);
        pnl_notlarLayout.setHorizontalGroup(
            pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_notlar, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
            .addGroup(pnl_notlarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ogrenci, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_ogrenci, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ders_sec, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_ders_sec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb_not_tipi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_not_tipi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_not, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_notlarLayout.createSequentialGroup()
                        .addComponent(fld_not, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_kaydet)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_notlarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_not_guncelle)
                .addGap(244, 244, 244))
        );
        pnl_notlarLayout.setVerticalGroup(
            pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_notlarLayout.createSequentialGroup()
                .addComponent(pn_notlar, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_not_guncelle)
                .addGap(18, 18, 18)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ogrenci)
                    .addComponent(lbl_ders_sec)
                    .addComponent(lbl_not_tipi)
                    .addComponent(lbl_not))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_notlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fld_ogrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_ders_sec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_not_tipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fld_not, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kaydet))
                .addGap(25, 25, 25))
        );

        pnl_ogretmen.addTab("Notlar", pnl_notlar);

        pnp_devamsızlık.setBackground(new java.awt.Color(255, 255, 255));

        tbl_devamsızlık.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Öğrenci No", "Öğrenci Adı", "Sınıf", "Devamsızlık"
            }
        ));
        tbl_devamsızlık.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_devamsızlık.setShowHorizontalLines(true);
        jScrollPane2.setViewportView(tbl_devamsızlık);

        lbl_devamsizlik.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lbl_devamsizlik.setText("Devamsızlığı bulunan öğrencilerin devamsızlık kayıtları aşağıda yer almaktadır.");

        javax.swing.GroupLayout pnp_devamsızlıkLayout = new javax.swing.GroupLayout(pnp_devamsızlık);
        pnp_devamsızlık.setLayout(pnp_devamsızlıkLayout);
        pnp_devamsızlıkLayout.setHorizontalGroup(
            pnp_devamsızlıkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnp_devamsızlıkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnp_devamsızlıkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnp_devamsızlıkLayout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addComponent(lbl_devamsizlik)
                        .addGap(38, 38, 38)))
                .addContainerGap())
        );
        pnp_devamsızlıkLayout.setVerticalGroup(
            pnp_devamsızlıkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnp_devamsızlıkLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lbl_devamsizlik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pnl_ogretmen.addTab("Devamsızlık", pnp_devamsızlık);

        lbl_hosgeldiniz.setText("Hoşgeldiniz");

        javax.swing.GroupLayout pnl_teacherLayout = new javax.swing.GroupLayout(pnl_teacher);
        pnl_teacher.setLayout(pnl_teacherLayout);
        pnl_teacherLayout.setHorizontalGroup(
            pnl_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_ogretmen)
            .addGroup(pnl_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_hosgeldiniz, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_teacherLayout.setVerticalGroup(
            pnl_teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_teacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_hosgeldiniz)
                .addGap(18, 18, 18)
                .addComponent(pnl_ogretmen))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_teacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kaydetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kaydetMouseClicked
        TeacherHelper teacherHelper = new TeacherHelper();
        int selectedRow = tbl_notlar.getSelectedRow();

        if (selectedRow != -1) {
            String Ders = cmb_ders_sec.getSelectedItem().toString();
            int stdNo = Integer.parseInt(tbl_notlar.getValueAt(selectedRow, 0).toString());
            String vizeTip = cmb_not_tipi.getSelectedItem().toString();
            int not = Integer.parseInt(fld_not.getText());

            teacherHelper.kaydetButton(stdNo, Ders, not, vizeTip);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen bir satır seçin.");
        }

        notLoad();
    }//GEN-LAST:event_btn_kaydetMouseClicked

    private void btn_ekle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ekle1MouseClicked

        TeacherHelper teacherHelper = new TeacherHelper();

        int stdNo = Integer.parseInt(fld_student_no.getText());
        String Ders = cmb_kurs1.getSelectedItem().toString();
        int vizeNot = Integer.parseInt(fld_sinif1.getText());
        int finalNot = Integer.parseInt(fld_final_not.getText());
        String sonuc;
        int ortalama = (vizeNot + finalNot) / 2;

        if (ortalama >= 50) {
            sonuc = "Geçti";
        } else {
            sonuc = "Kaldı";
        }

        teacherHelper.tbl_ogrenciler_ekle_button(stdNo, Ders, vizeNot, finalNot, sonuc);

        notLoad();

    }//GEN-LAST:event_btn_ekle1MouseClicked

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
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_ekle1;
    private javax.swing.JButton btn_kaydet;
    private javax.swing.JComboBox<String> cmb_ders_sec;
    private javax.swing.JComboBox<String> cmb_kurs1;
    private javax.swing.JComboBox<String> cmb_not_tipi;
    private javax.swing.JTextField fld_ara;
    private javax.swing.JTextField fld_final_not;
    private javax.swing.JTextField fld_not;
    private javax.swing.JTextField fld_ogrekle1;
    private javax.swing.JTextField fld_ogrenci;
    private javax.swing.JTextField fld_sinif1;
    private javax.swing.JTextField fld_student_no;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lbl_ara;
    private javax.swing.JLabel lbl_ders_sec;
    private javax.swing.JLabel lbl_devamsizlik;
    private javax.swing.JLabel lbl_final_not;
    private javax.swing.JLabel lbl_hosgeldiniz;
    private javax.swing.JLabel lbl_kurs1;
    private javax.swing.JLabel lbl_not;
    private javax.swing.JLabel lbl_not_guncelle;
    private javax.swing.JLabel lbl_not_tipi;
    private javax.swing.JLabel lbl_ogr_ekle1;
    private javax.swing.JLabel lbl_ogrenci;
    private javax.swing.JLabel lbl_ogrenci_no;
    private javax.swing.JLabel lbl_sinif1;
    private javax.swing.JScrollPane pn_notlar;
    private javax.swing.JPanel pnl_notlar;
    private javax.swing.JPanel pnl_ogrenciler;
    private javax.swing.JTabbedPane pnl_ogretmen;
    private javax.swing.JPanel pnl_teacher;
    private javax.swing.JPanel pnp_devamsızlık;
    private javax.swing.JTable tbl_devamsızlık;
    private javax.swing.JTable tbl_notlar;
    private javax.swing.JTable tbl_ogrenciler;
    // End of variables declaration//GEN-END:variables
}
