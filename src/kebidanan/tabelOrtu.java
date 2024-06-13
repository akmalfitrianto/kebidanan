/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kebidanan;

/**
 *
 * @author ASUS
 */
public class tabelOrtu {
    String id, namaIbu, pekerjaanIbu, namaAyah, pekerjaanAyah, alamat;
    
    //constructor
    public tabelOrtu(String id, String namaIbu, String pekerjaanIbu, String namaAyah, String pekerjaanAyah, String alamat){
        this.id = id;
        this.namaIbu = namaIbu;
        this.pekerjaanIbu = pekerjaanIbu;
        this.namaAyah = namaAyah;
        this.pekerjaanAyah = pekerjaanAyah;
        this.alamat = alamat;
    }
    
    //setter
    public void setId(String id){
        this.id = id;
    }
    
    public void setNamaIbu(String namaIbu){
        this.namaIbu = namaIbu;
    }
    
    public void setPekerjaanIbu(String PekerjaanIbu){
        this.pekerjaanIbu = pekerjaanIbu;
    }
    
    public void setNamaAyah(String namaAyah){
        this.namaAyah = namaAyah;
    }
    
    public void setPekerjaanAyah(String pekerjaanAyah){
        this.pekerjaanAyah = pekerjaanAyah;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    //getter
    public String getId(){
        return this.id;
    }
    
    public String getNamaibu(){
        return this.namaIbu;
    }
    
    public String getPekerjaanIbu(){
        return this.pekerjaanIbu;
    }
    
    public String getNamaAyah(){
        return this.namaAyah;
    }
    
    public String getPekerjaanAyah(){
        return this.pekerjaanAyah;
    }
    
    public String getAlamat(){
        return this.alamat;
    }
}   
