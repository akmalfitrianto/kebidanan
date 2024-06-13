/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class koneksi {
    private String databaseName = "2210010546";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
    
    public koneksi(){
        try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    //DATA UJI
    public void simpanUji(String nik,String nama,String telp,String alamat){
        try {
            String sql = "insert into uji (nik, nama, telp, alamat) value(?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            perintah.executeUpdate();
            
            System.out.println("data berhasil tersimpan"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahUji(String nik,String nama,String telp,String alamat){
        try {
            String sql = "update uji set nama = ?, telp = ?, alamat = ? where nik = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            perintah.executeUpdate();
            
            System.out.println("data berhasil terubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
    public void hapusUji(String nik){
        try {
            String sql = "delete from uji where nik = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    //DATA CATATAN KEHAMILAN
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
      
      // DATA CATATAN PERSALINAN
      
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
      
      // DATA TABEL ANAK
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
     
    // DATA TABEL ORTU
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
