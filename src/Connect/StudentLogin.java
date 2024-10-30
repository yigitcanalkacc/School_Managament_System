package Connect;

import StudentScreen.StudentDashboard;
import User.Student;
import java.sql.*;

public class StudentLogin {
    
    private String URL = "jdbc:ucanaccess://C:/Users/yigitcan.alkac/Desktop/insurance.accdb";
    
    public StudentLogin() {
    }

    public boolean StudentLogin(String username, String password) {
        boolean isAuthenticated = false;

        String query = "SELECT * FROM ogrenciler WHERE ID = ? AND Password = ?";
        
        try (Connection connect = DriverManager.getConnection(URL);
             PreparedStatement pstmt = connect.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("Kullanıcı");
                int sinif = rs.getInt("Sınıf");
                String kurs = rs.getString("Kurs");
                int studentNo = rs.getInt("stdNo");

                System.out.println("Giriş Başarılı");
                Student student = new Student(name, sinif, kurs, studentNo);
                StudentDashboard dashboard = new StudentDashboard(student);
                dashboard.setVisible(true);
                isAuthenticated = true;
                
            } else {
                System.out.println("Kullanıcı Adı veya Şifre Hatalı");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAuthenticated;
    }
}
