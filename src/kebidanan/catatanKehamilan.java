/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kebidanan;

 /*
 * @author ASUS
 */
public class catatanKehamilan {
    String id, ortuId, hamilKe, riwayatPenyakit, riwayatAlergi;
    
    //constructor
    public catatanKehamilan(String id, String ortuId, String hamilKe, String riwayatPenyakit, String riwayatAlergi){
        this.id = id;
        this.ortuId = ortuId;
        this.hamilKe = hamilKe;
        this.riwayatPenyakit = riwayatPenyakit;
        this.riwayatAlergi = riwayatAlergi;
    }
    
    //setter
    public void setId(String id){
        this.id = id;
    }
    
    public void setOrtuId(String ortuId){
        this.ortuId = ortuId;
    }
    
    public void setHamilKe(String hamilKe){
        this.hamilKe = hamilKe;
    }
    
    public void setRiwayatPenyakit(String riwayatPenyakit){
        this.riwayatPenyakit = riwayatPenyakit;
    }
    
    public void setRiwayatAlergi(String riwayatAlergi){
        this.riwayatAlergi = riwayatAlergi;
    }
    
    //getter
    public String getId(){
        return this.id;
    }
    
    public String getOrtuId(){
        return this.ortuId;
    }
    
    public String getHamilKe(){
        return this.hamilKe;
    }
    
    public String getRiwayatPenyakit(){
        return this.riwayatPenyakit;
    }
    
    public String getRiwayatAlergi(){
        return this.riwayatAlergi;
    }
              
}

