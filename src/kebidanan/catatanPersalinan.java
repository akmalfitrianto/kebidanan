/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kebidanan;


/**
 *
 * @author ASUS
 */
public class catatanPersalinan extends catatanKehamilan{
    String idPersalinan, catatanKehamilanId, penolongPersalinan, caraPersalinan,
            keadaanIbu, kondisiLahir;

    //constructor
    public catatanPersalinan(String idPersalinan, String catatanKehamilanId, String penolongPersalinan, String caraPersalinan, String keadaanIbu, String kondisiLahir,
            String id, String ortuId, String hamilKe, String riwayatPenyakit, String riwayatAlergi){
        super(id, ortuId, hamilKe, riwayatPenyakit, riwayatAlergi );
        this.idPersalinan = idPersalinan;
        this.catatanKehamilanId = catatanKehamilanId;
        this.penolongPersalinan = penolongPersalinan;
        this.caraPersalinan = caraPersalinan;
        this.keadaanIbu = keadaanIbu;
        this.kondisiLahir = kondisiLahir;
    }
    
    //setter
    public void setIdPersalinan(String idPersalinan){
        this.idPersalinan = idPersalinan;
    }
    
    public void setCatatanKehamilanId(String catatanKehamilanId){
        this.catatanKehamilanId = catatanKehamilanId;
    }
    
    public void setPenolongPersalinan(String penolongPersalinan){
        this.penolongPersalinan = penolongPersalinan;
    }
    
    public void setCaraPersalinan(String caraPersalinan){
        this.caraPersalinan = caraPersalinan;
    }
    
    public void setKeadaanIbu(String keadaanIbu){
        this.keadaanIbu = keadaanIbu;
    }
    
    public void setKondisiLahir(String kondisiLahir){
        this.kondisiLahir = kondisiLahir;
    }
    
    //getter
    public String getIdPersalinan(){
        return this.idPersalinan;
    }
    
    public String getCatatanKehamilanId(){
        return this.catatanKehamilanId;
    }
    
    public String getPenolongPersalinan(){
        return this.penolongPersalinan;
    }
    
    public String getCaraPersalinan(){
        return this.caraPersalinan;
    }
    
    public String getKeadaanIbu(){
        return this.keadaanIbu;
    }
    
    public String getKondisiLahir(){
        return this.kondisiLahir;
    }
}


