import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

                try {
                    // Singleton bağlantısını oluştur
                    DatabaseConnection db = (DatabaseConnection) DatabaseConnection.getInstance();
                    Connection connection = db.getConnection();

                    System.out.println("--- Otomasyon Sistemi Başladı ---");

                    // Kullanıcıları Testleme
                    System.out.println("Yeni Kullanıcı Ekleme İşlemi...");
                    createUser(connection, "Ali Updated", "aliupdate@gmail.com", "password123", "Driver");

                    System.out.println("\nAraç Ekleme Testi...");
                    Vehicle vehicle = VehicleFactory.getVehicle("car");
                    vehicle.createVehicle();

                    System.out.println("\nPark Yeri Ekleme Testi...");
                    createParkingSlot(connection, 1, "AVAILABLE");

                    System.out.println("\nPark Kayıtlarını Testleme...");
                    createParkingRecord(connection, 1, 1);

                    System.out.println("\nObserver Testleme...");
                    Admin adminObserver = new Admin();
                    adminObserver.update("Park doluluğu güncellendi!");

                } catch (SQLException e) {
                    System.out.println("Veritabanı bağlantısında sorun: " + e.getMessage());
                }
            }

            // Kullanıcı eklemek için CRUD metodu
            public static void createUser(Connection connection, String name, String email, String password, String role) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Users (name, email, password, role_id) VALUES (?, ?, ?, 1)");
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);

                pstmt.executeUpdate();
                System.out.println("Kullanıcı " + name + " sisteme eklendi.");
            }

            // Park Yeri oluşturma metodu
            public static void createParkingSlot(Connection connection, int slotNumber, String status) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ParkingSlots (slot_number, status) VALUES (?, ?)");
                pstmt.setInt(1, slotNumber);
                pstmt.setString(2, status);

                pstmt.executeUpdate();
                System.out.println(slotNumber + " numaralı park yeri oluşturuldu.");
            }

            // Park Kayıtlarını oluşturma metodu
            public static void createParkingRecord(Connection connection, int vehicle_id, int slot_id) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ParkingRecords (vehicle_id, slot_id, start_time) VALUES (?, ?, NOW())");
                pstmt.setInt(1, vehicle_id);
                pstmt.setInt(2, slot_id);

                pstmt.executeUpdate();
                System.out.println("Araç park işlemi oluşturuldu.");
            }
        }

