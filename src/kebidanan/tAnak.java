/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kebidanan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author ASUS
 */
public class tAnak {
    private String databaseName = "2210010546";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB;
    
    public tAnak(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanAnak(String id, String ortu_id, String nama, String jk, String berat_lahir, String panjang_lahir, String lingkar_kepala){
        try {
            String sql = "insert into t_anak (id, ortu_id, nama, jk, berat_lahir, panjang_lahir, lingkar_kepala) value(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, ortu_id);
            perintah.setString(3, nama);
            perintah.setString(4, jk);
            perintah.setString(5, berat_lahir);
            perintah.setString(6, panjang_lahir);
            perintah.setString(7, lingkar_kepala);
            perintah.executeUpdate();
            
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahAnak(String id, String ortu_id, String nama, String jk, String berat_lahir, String panjang_lahir, String lingkar_kepala){
        try {
            String sql = "update t_anak set ortu_id = ?, nama = ?, jk = ?, berat_lahir = ?, panjang_lahir = ?, lingkar_kepala = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, ortu_id);
            perintah.setString(2, nama);
            perintah.setString(3, jk);
            perintah.setString(4, berat_lahir);
            perintah.setString(5, panjang_lahir);
            perintah.setString(6, lingkar_kepala);
            perintah.setString(7, id);
            perintah.executeUpdate();
            
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusAnak(String id){
        try {
            String sql = "delete from t_anak where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 
    }
    
    public void cariAnak(String id){
        try {
        String sql = "select * from t_anak where id = ?";
        PreparedStatement perintah = koneksiDB.prepareStatement(sql);
        perintah.setString(1, id);
        ResultSet data = perintah.executeQuery();
        while(data.next()){
            System.out.println("ID : "+data.getString("id"));
            System.out.println("ID ORTU : "+data.getString("ortu_id"));
            System.out.println("NAMA : "+data.getString("nama"));
            System.out.println("JENIS KELAMIN : "+data.getString("jk"));
            System.out.println("BERAT LAHIR(KG) : "+data.getString("berat_lahir"));
            System.out.println("PANJANG LAHIR(CM) : "+data.getString("panjang_lahir"));
            System.out.println("LINGKAR KEPALA(CM) : "+data.getString("lingkar_kepala"));
        }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataAnak(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from t_anak order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("ortu_id")+" | "+
                        baris.getString("nama")+" | "+
                        baris.getString("jk")+" | "+
                        baris.getString("berat_lahir")+" | "+
                        baris.getString("panjang_lahir")+" | "+
                        baris.getString("lingkar_kepala"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
