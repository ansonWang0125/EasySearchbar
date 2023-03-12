package sdm.hw2.com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan({"sdm.hw2.com.example.demo","sdm.hw2.com.example.model","sdm.hw2.com.example.controller","sdm.hw2.com.example.service","sdm.hw2.com.example.repository"})
@EntityScan({"sdm.hw2.com.example.demo","sdm.hw2.com.example.model","sdm.hw2.com.example.controller","sdm.hw2.com.example.service","sdm.hw2.com.example.repository"})
public class Hw2Application {
	private static final Logger logger = LoggerFactory.getLogger(Hw2Application.class);
	public static void main(String[] args) {
		logger.info("doing something...");
		SpringApplication.run(Hw2Application.class, args);
		Connection conn = null;
        Statement stmt = null;
    	try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            String url = "jdbc:mysql://localhost:3306/order_application";
            String user = "root";
            String password = "secure1234";
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Create a new table
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Enrollments (SID VARCHAR(255) PRIMARY KEY, NAME VARCHAR(255))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");
            String sql1 = "CREATE TABLE IF NOT EXISTS Courses (id BIGINT AUTO_INCREMENT PRIMARY KEY, SID VARCHAR(255), Course VARCHAR(255), FOREIGN KEY (SID) REFERENCES Enrollments(SID))";
            stmt.executeUpdate(sql1);
            System.out.println("Table created successfully!");
            String sql2 = "CREATE TABLE IF NOT EXISTS Semesters (id BIGINT AUTO_INCREMENT PRIMARY KEY, SID VARCHAR(255), Semester VARCHAR(255), FOREIGN KEY (SID) REFERENCES Enrollments(SID))";
            stmt.executeUpdate(sql2);
            System.out.println("Table created successfully!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
