
package Connect;


import TeacherScreen.TeacherDashboard;
import User.Teacher;
import java.sql.*;
import javax.swing.JTabbedPane;


public class TeacherLogin {
    
private String URL = "jdbc:ucanaccess://C:/Users/yigitcan.alkac/Desktop/insurance.accdb";
private Connection connect = null;
Teacher teacherStats;
    
    public TeacherLogin() {
    }

    

    public void TeacherLogin(String username, String password) {
        
        try {
            this.connect = DriverManager.getConnection(URL);
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ogretmenler" );
            boolean loginSuccessful = false;
            
            while(rs.next()){
                String user = rs.getString("ID");
                int ogrNo = rs.getInt("ogrNo");
                String name = rs.getString("Kullanıcı");
                String pass = rs.getString("Password");
                String kurs = rs.getString("Yetki");
                
                        
                    if (username.equals(user) && password.equals(pass) ) {
                        System.out.println("Giriş Başarılı");
                        teacherStats = new Teacher(ogrNo, name, kurs);
                        
                        TeacherDashboard teacherDashboard = new TeacherDashboard(teacherStats);
                         teacherDashboard.setVisible(true);
                        
                        loginSuccessful = true;
                        break;
                    } 
                    
              
                    }
            
              if (!loginSuccessful) {
            System.out.println("Kullanıcı Adı veya Şifre Hatalı");
                            }
            connect.close();
            stmt.close();
            rs.close();  
            } 
        catch (SQLException e) {
            e.printStackTrace();
        } 

    }
            
            
  
      
        
        
        
    }


    

