
package TeacherScreen;

import User.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DataAccess.Kurs;
import User.Teacher;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TeacherHelper {

    
    
    public TeacherHelper() {}
    
    
    private String URL = "jdbc:ucanaccess://C:/Users/yigitcan.alkac/Desktop/insurance.accdb";
    Connection connect = null;
    
    
    public List<Student> checkStudent (int teacherOgrNo) {
        List<Student> students = new ArrayList<>();
        
        String Query = "SELECT ogrenciler.stdNo, ogrenciler.Kullanıcı, ogrenciler.Sınıf, ogrenciler.Kurs " +
                    "FROM ogrenciler " +
                    "INNER JOIN ogretmenler ON ogrenciler.ogrNO = ogretmenler.ogrNo " +
                    "WHERE ogretmenler.ogrNo = ?" ;
        
        try {
            connect = DriverManager.getConnection(URL);
            PreparedStatement pst = connect.prepareStatement(Query);
            pst.setInt(1, teacherOgrNo);
            ResultSet rs = pst.executeQuery();
            
            
            
            while (rs.next()) {
                String kullanici = rs.getString("Kullanıcı");
                Integer sinif = rs.getInt("Sınıf");
                String kurs = rs.getString("Kurs");
                Integer stdNo = rs.getInt("stdNo");
                
                students.add(new Student(kullanici,sinif,kurs,stdNo));
                
            }
            
            connect.close();
            pst.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }

    
    // Not Load
    
    
     public List<Kurs> notLoad (int ogrNo) {
        List<Kurs> notLoad = new ArrayList<>();

 String SQL = "SELECT Dersler.stdNo, Dersler.Ders, Dersler.vizeNot, Dersler.finalNot, Dersler.Sonuc, ogrenciler.Kullanıcı " +
             "FROM ogrenciler " +
             "INNER JOIN Dersler ON ogrenciler.stdNo = Dersler.stdNo " +
             "WHERE ogrenciler.ogrNo = ?";
        
        try {
            connect = DriverManager.getConnection(URL);
            PreparedStatement pst = connect.prepareStatement(SQL);
            pst.setInt(1, ogrNo);
            ResultSet rs = pst.executeQuery();
            
            
            
            while (rs.next()) {
                int stdNo = rs.getInt("stdNo");
                String Ders = rs.getString("Ders");
                int vizeNot = rs.getInt("vizeNot");
                int finalNot = rs.getInt("finalNot");
                String sonuc = rs.getString("Sonuc");
                String ogrenciAdi = rs.getString("Kullanıcı");
                
                
                notLoad.add(new Kurs(stdNo,ogrenciAdi,Ders,vizeNot,finalNot,sonuc));

            }
            
            connect.close();
            pst.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notLoad;
    } 
     
     //Table öğrenci ekleme alanı
     
     public void tbl_ogrenciler_ekle_button (int stdNo, String Ders, int vizeNot, int finalNot, String Sonuc) {
         
         String query = "UPDATE Dersler SET Ders = ?, vizeNot = ?, finalNot = ?, Sonuc = ? WHERE stdNo = ?";
         PreparedStatement psmt = null;
         
        try {
            this.connect = DriverManager.getConnection(URL);
             psmt = connect.prepareStatement(query);
            
            //1. sorgu
          psmt.setString(1, Ders);
          psmt.setInt(2, vizeNot);
          psmt.setInt(3, finalNot);
          psmt.setString(4, Sonuc);
          psmt.setInt(5, stdNo);
          

         int rowsAffected = psmt.executeUpdate();
         if (rowsAffected > 0) {
         JOptionPane.showMessageDialog(null, "Öğrenci ve ders bilgileri başarıyla eklendi."); 
         } else {
            JOptionPane.showMessageDialog(null, "Veritabanına ekleme işlemi başarısız.");
        }
         
         connect.close();
         psmt.close();
         
        } catch (SQLException ex) {
            Logger.getLogger(TeacherHelper.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
        }
         
        
     }
     
     //table öğrenci ekleme alanı bitiş
     
     //tbl_notlar not güncelleme alanı
     // kaydet butonu başlangıç 
     // notlar kısmı
     
     
public void kaydetButton(int stdNo, String Ders, int Not, String vizeTip) {
    String SQL;
    
    if (vizeTip.equals("Vize")) {
        SQL = "UPDATE Dersler SET Ders = ?, vizeNot = ?, Sonuc = ? WHERE stdNo = ?";
    } else {
        SQL = "UPDATE Dersler SET Ders = ?, finalNot = ?, Sonuc = ? WHERE stdNo = ?";
    }

    try {
        this.connect = DriverManager.getConnection(URL);
        PreparedStatement psmt = connect.prepareStatement(SQL);

        // Ders adı ayarla
        psmt.setString(1, Ders);
        psmt.setInt(2, Not); 

        // Sonuç hesaplama 
        String selectSQL = "SELECT vizeNot, finalNot FROM Dersler WHERE stdNo = ?";
        PreparedStatement selectStmt = connect.prepareStatement(selectSQL);
        selectStmt.setInt(1, stdNo);
        ResultSet rs = selectStmt.executeQuery();
        
        int vizeNot = 0;
        int finalNot = 0;

        if (rs.next()) {
            vizeNot = rs.getInt("vizeNot");
            finalNot = rs.getInt("finalNot");
        }

        // Güncelleme sonrası notu ayarla
        if (vizeTip.equals("Vize")) {
            vizeNot = Not; 
        } else {
            finalNot = Not; 
        }
        
        // Sonucu hesaplama
        int ortalama = (vizeNot + finalNot) / 2;
        String sonuc = (ortalama >= 50) ? "Geçti" : "Kaldı";
        psmt.setString(3, sonuc); 
        
        psmt.setInt(4, stdNo); 

        int rowsAffected = psmt.executeUpdate();
        
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Öğrenci ve ders bilgileri başarıyla güncellendi."); 
        } else {
            JOptionPane.showMessageDialog(null, "Veritabanına güncelleme işlemi başarısız.");
        }
        
        psmt.close();
        selectStmt.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(TeacherHelper.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Hata: " + ex.getMessage());
    }
}
     
     
     // kaydet butonu bitiş
     
     // Devamsızlık Tablosu Başlangıç


     public void devamsizlikLoad (int ogrNo, DefaultTableModel defaultTableModel) {
         
         String SQL = "SELECT * FROM ogrenciler where ogrNo = ?";
         
         try {
             this.connect = DriverManager.getConnection(this.URL);
             PreparedStatement pst = connect.prepareStatement(SQL);
             pst.setInt(1, ogrNo);
             ResultSet rs = pst.executeQuery();
             
              while (rs.next()) {
             int devamsizlik = rs.getInt("Devamsızlık");
             String kurs = rs.getString("Kurs");
             String ogrenciAdi = rs.getString("Kullanıcı");
             int studentNo = rs.getInt("stdNo");
             
             defaultTableModel.addRow(new Object[]{
                 studentNo,
                 ogrenciAdi,
                 kurs,
                 devamsizlik
             });

              }
             
             
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     // Devamsızlık Tablosu Bitiş
}

