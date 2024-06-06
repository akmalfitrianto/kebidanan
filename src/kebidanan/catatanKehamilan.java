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
public class catatanKehamilan {
    private String databaseName = "2210010546";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
//    private int id;
//    private int ortu_id;
//    private int hamil_ke;
//    private LocalDate hpht;
//    private LocalDate hpt;
//    private String riwayat_penyakit;
//    private String riwayat_alergi;
    
      public catatanKehamilan(){
          try {
              String location = "jdbc:mysql://localhost/" + databaseName;
              Class.forName("com.mysql.jdbc.Driver");
              koneksiDB = DriverManager.getConnection(location, username, password);
              System.out.println("database terkoneksi");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
//
//    public catatanKehamilan(int id, int ortu_id, int hamil_ke, LocalDate hpht, LocalDate hpt, String riwayat_penyakit, String riwayat_alergi) {
//        this.id = id;
//        this.ortu_id = ortu_id;
//        this.hamil_ke = hamil_ke;
//        this.hpht = hpht;
//        this.hpt = hpt;
//        this.riwayat_penyakit = riwayat_penyakit;
//        this.riwayat_alergi = riwayat_alergi;
//    }
      
      public void simpanCK(String id, String ortu_id, String hamil_ke, String riwayat_penyakit, String riwayat_alergi){
          try {
              String sql = "insert into catatankehamilan (id, ortu_id, hamil_ke, riwayat_penyakit, riwayat_alergi) value(?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, ortu_id);
              perintah.setString(3, hamil_ke);
              perintah.setString(4, riwayat_penyakit);
              perintah.setString(5, riwayat_alergi);
              perintah.executeUpdate();
              
              System.out.println("data berhasil disimpan");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahCK(String id, String ortu_id, String hamil_ke, String riwayat_penyakit, String riwayat_alergi){
          try {
              String sql = "update catatankehamilan set ortu_id = ?, hamil_ke = ?, riwayat_penyakit = ?, riwayat_alergi = ? where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, ortu_id);
              perintah.setString(2, hamil_ke);
              perintah.setString(3, riwayat_penyakit);
              perintah.setString(4, riwayat_alergi);
              perintah.setString(5, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusCK(String id){
          try {
              String sql = "delete from catatankehamilan where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil dihapus");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
       
      public void cariCK(String id){
          try {
              String sql = "select*from catatankehamilan where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID : "+data.getString("id"));
                  System.out.println("ID ORTU : "+data.getString("ortu_id"));
                  System.out.println("HAMIL KE : "+data.getString("hamil_ke"));
                  System.out.println("RIWAYAT PENYAKIT : "+data.getString("riwayat_penyakit"));
                  System.out.println("RIWAYAT ALERGI : "+data.getString("riwayat_alergi"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataCK(){
          try {
              Statement stmt = koneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("select * from catatankehamilan order by id asc");
              while(baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("ortu_id")+" | "+
                          baris.getString("hamil_ke")+" | "+
                          baris.getString("riwayat_penyakit")+" | "+
                          baris.getString("riwayat_alergi"));
                          
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
//    public int getId() {
//        return id;
//    }
//
//    public int getOrtu_id() {
//        return ortu_id;
//    }
//
//    public int getHamil_ke() {
//        return hamil_ke;
//    }
//
//    public LocalDate getHpht() {
//        return hpht;
//    }
//
//    public LocalDate getHpt() {
//        return hpt;
//    }
//
//    public String getRiwayat_penyakit() {
//        return riwayat_penyakit;
//    }
//
//    public String getRiwayat_alergi() {
//        return riwayat_alergi;
//    }
    
}

