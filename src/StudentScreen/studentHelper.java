
package StudentScreen;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import StudentScreen.StudentDashboard;
import java.util.logging.Level;
import java.util.logging.Logger;


public class studentHelper {
    Connection connect;
    private String URL = "jdbc:ucanaccess://C:/Users/yigitcan.alkac/Desktop/insurance.accdb";
    
    public studentHelper () {
        
    }
    
    
    public void load_tbl_notlar (int stdNo, DefaultTableModel defaultTableModel) {
        
        try {
            String SQL = "SELECT * FROM Dersler WHERE stdNo = ?";
            connect = DriverManager.getConnection(URL);
            PreparedStatement psmt = connect.prepareStatement(SQL);
            psmt.setInt(1, stdNo);
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) {
                
                String dersler = rs.getString("Ders");
                int vizenot = rs.getInt("vizeNot");
                int finalNot = rs.getInt("finalNot");
                String Sonuc = rs.getString("Sonuc");
                
                defaultTableModel.addRow(new Object[]{
                    dersler,
                    vizenot,
                    finalNot,
                    Sonuc
                }); 
                
            }
            connect.close();
            psmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(studentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
        public void load_tbl_devamsizlik (int stdNo, DefaultTableModel defaultTableModel) {
        
        try {
            String SQL = "SELECT * FROM ogrenciler WHERE stdNo = ?";
            connect = DriverManager.getConnection(URL);
            PreparedStatement psmt = connect.prepareStatement(SQL);
            psmt.setInt(1, stdNo);
            ResultSet rs = psmt.executeQuery();
            
            while (rs.next()) {
                
                int ogrenciNo = rs.getInt("ogrNo");
                String ogrenciAdi = rs.getString("Kullanıcı");
                int devamsizlik = rs.getInt("Devamsızlık");
                
                
                defaultTableModel.addRow(new Object[]{
                    ogrenciNo,
                    ogrenciAdi,
                    devamsizlik
                }); 
                
            }
            
            connect.close();
            psmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(studentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
}
