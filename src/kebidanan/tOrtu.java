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
public class tOrtu {
    private String databaseName = "2210010546";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
    
    public tOrtu(){
        try {
            String location = "jdbc:mysql://localhost/"+ databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanOrtu(String id, String namaibu, String pekerjaanibu, String namaayah, String pekerjaanayah, String alamat){
        try {
            String sql = "insert into t_ortu (id, namaibu, pekerjaanibu, namaayah, pekerjaanayah, alamat) value (?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.setString(2, namaibu);
            perintah.setString(3, pekerjaanibu);
            perintah.setString(4, namaayah);
            perintah.setString(5, pekerjaanayah);
            perintah.setString(6, alamat);
            perintah.executeUpdate();
            
            System.out.println("data berhasil disimpan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahOrtu(String id, String namaibu, String pekerjaanibu, String namaayah, String pekerjaanayah, String alamat){
        try {
            String sql = "update t_ortu set nama_ibu = ?, pekerjaanibu = ?, namaayah = ?, pekerjaanayah = ?, alamat = ? where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, namaibu);
            perintah.setString(2, pekerjaanibu);
            perintah.setString(3, namaayah);
            perintah.setString(4, pekerjaanayah);
            perintah.setString(5, alamat);
            perintah.setString(6, id);
            perintah.executeUpdate();
            
            System.out.println("data berhasil diubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusOrtu(String id){
        try {
            String sql = "delete from t_ortu where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            perintah.executeUpdate();
            
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cariOrtu(String id){
        try {
            String sql = "select * from t_ortu where id = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, id);
            ResultSet data = perintah.executeQuery();
            while(data.next()){
                System.out.println("ID : "+data.getString("id"));
                System.out.println("NAMA IBU : "+data.getString("namaibu"));
                System.out.println("PEKERJAAN IBU : "+data.getString("pekerjaanibu"));
                System.out.println("NAMA AYAH : "+data.getString("namaayah"));
                System.out.println("PEKERJAAN AYAH : "+data.getString("pekerjaanayah"));
                System.out.println("ALAMAT : "+data.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void dataOrtu(String id){
        try {
            Statement stmt = koneksiDB.createStatement();
            ResultSet baris = stmt.executeQuery("select * from t_ortu order by id asc");
            while(baris.next()){
                System.out.println(baris.getString("id")+" | "+
                        baris.getString("namaibu")+" | "+
                        baris.getString("pekerjaanibu")+" | "+
                        baris.getString("namaayah")+" | "+
                        baris.getString("pekerjaanayah")+" | "+
                        baris.getString("alamat"));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}   
