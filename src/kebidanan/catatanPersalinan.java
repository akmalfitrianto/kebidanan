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
public class catatanPersalinan{
    private String databaseName = "2210010546";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
//    private String id;
//    private String catatanKehamilan_id;
//    private LocalDate tglPersalinan;
//    private String umurKehamilan;
//    private PenolongPersalinan penolongPersalinan;
//    private CaraPersalinan caraPersalinan;
//    private KeadaanIbu keadaanIbu;
//    private KondisiLahir kondisiLahir;
    
      public catatanPersalinan(){
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
//    public enum PenolongPersalinan {
//        DOKTER,
//        BIDAN
//    }
//
//    public enum CaraPersalinan {
//        NORMAL,
//        TINDAKAN
//    }
//
//    public enum KeadaanIbu {
//        SEHAT,
//        SAKIT
//    }
//
//    public enum KondisiLahir {
//        NORMAL,
//        CACAT
//    }
//
//    public catatanPersalinan(String id, String catatanKehamilan_id, LocalDate tglPersalinan, String umurKehamilan,
//                             PenolongPersalinan penolongPersalinan, CaraPersalinan caraPersalinan,
//                             KeadaanIbu keadaanIbu, KondisiLahir kondisiLahir) {
//        super(0, 0, 0, null, null, "", ""); 
//        this.id = id;
//        this.catatanKehamilan_id = catatanKehamilan_id;
//        this.tglPersalinan = tglPersalinan;
//        this.umurKehamilan = umurKehamilan;
//        this.penolongPersalinan = penolongPersalinan;
//        this.caraPersalinan = caraPersalinan;
//        this.keadaanIbu = keadaanIbu;
//        this.kondisiLahir = kondisiLahir;
      
      public void simpanCP(String id, String catatankehamilan_id, String penolong_persalinan, String cara_persalinan, String keadaan_ibu, String kondisi_lahir){
          try {
              String sql = "insert into catatanPersalinan (id, catatankehamilan_id,penolong_persalinan, cara_persalinan, keadaan_ibu, kondisi_lahir) value (?, ?, ?, ?, ?, ?)";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, catatankehamilan_id);
              perintah.setString(3, penolong_persalinan);
              perintah.setString(4, cara_persalinan);
              perintah.setString(5, keadaan_ibu);
              perintah.setString(6, kondisi_lahir);
              perintah.executeUpdate();
              
              System.out.println("data berhasil ditambah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahCP(String id, String catatankehamilan_id, String penolong_persalinan, String cara_persalinan, String keadaan_ibu, String kondisi_lahir){
          try {
              String sql = "update catatanpersalinan set catatankehamilan_id = ?, penolong_persalinan = ?, cara_persalinan = ?, keadaan_ibu, kondisi_lahir = ? where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, catatankehamilan_id);
              perintah.setString(2, penolong_persalinan);
              perintah.setString(3, cara_persalinan);
              perintah.setString(4, keadaan_ibu);
              perintah.setString(5, kondisi_lahir);
              perintah.setString(6, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void hapusCP(String id){
          try {
              String sql = "delete from catatanpersalinan where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              
              perintah.executeUpdate();
              System.out.println("data berhasil dihapus");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void cariCP(String id){
          try {
              String sql = "select * from catatanpersalinan where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID : "+data.getString("id"));
                  System.out.println("CK ID : "+data.getString("catatankehamilan_id"));
                  System.out.println("PENOLONG PERSALINAN : "+data.getString("penolong_persalinan"));
                  System.out.println("CARA PERSALINAN : "+data.getString("cara_persalinan"));
                  System.out.println("KEADAAN IBU : "+data.getString("keadaan_ibu"));
                  System.out.println("KONDISI LAHIR : "+data.getString("kondisi_lahir"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataCP(String id){
          try {
              Statement stmt = koneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("select * from catatanpersalinan order by id asc");
              while(baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("catatankehamilan_id")+" | "+
                          baris.getString("penolong_persalinan")+" | "+
                          baris.getString("cara_persalinan")+" | "+
                          baris.getString("keadaan_ibu")+" | "+
                          baris.getString("kondisi_lahir"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
//    }
//    public int getId() {
//        return Integer.parseInt(id);
//    }
//
//    public String getCatatanKehamilan_id() {
//        return catatanKehamilan_id;
//    }
//
//    public LocalDate getTglPersalinan() {
//        return tglPersalinan;
//    }
//
//    public String getUmurKehamilan() {
//        return umurKehamilan;
//    }
//
//    public PenolongPersalinan getPenolongPersalinan() {
//        return penolongPersalinan;
//    }
//
//    public CaraPersalinan getCaraPersalinan() {
//        return caraPersalinan;
//    }
//
//    public KeadaanIbu getKeadaanIbu() {
//        return keadaanIbu;
//    }
//
//    public KondisiLahir getKondisiLahir() {
//        return kondisiLahir;
//    }
}


