/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kebidanan;

/**
 *
 * @author ASUS
 */
public class tabelAnak {
   String id, ortuId, nama, jk, beratLahir, panjangLahir, lingkarKepala;
   
   //constructor
   public tabelAnak(String id, String ortuId, String nama, String jk, String beratLahir, String panjangLahir, String lingkarKepala){
       this.id = id;
       this.ortuId = ortuId;
       this.nama = nama;
       this.jk = jk;
       this.beratLahir = beratLahir;
       this.panjangLahir = panjangLahir;
       this.lingkarKepala = lingkarKepala;
   }
   
   //setter
   public void setId(String id){
       this.id = id;
   } 
   
   public void setOrtuId(String ortuId){
       this.ortuId = ortuId;
   }
   
   public void setNama(String nama){
       this.nama = nama;
   }
   
   public void setJk(String jk){
       this.jk = jk;
   }
   
   public void setBeratLahir(String beratLahir){
       this.beratLahir = beratLahir;
   }
   
   public void setPanjangLahir(String panjangLahir){
       this.panjangLahir = panjangLahir;
   }
   
   public void setLingkarKepala(String lingkarKepala){
       this.lingkarKepala = lingkarKepala;
   }
   
   //getter
   public String getId(){
       return this.id;
   }
   
   public String getOrtuId(){
       return this.ortuId;
   }
   
   public String getNama(){
       return this.nama;
   }
   
   public String getJk(){
       return this.jk;
   }
   
   public String getBeratLahir(){
       return this.beratLahir;
   }
   
   public String getPanjangLahir(){
       return this.panjangLahir;
   }
   
   public String getLingkarKepala(){
       return this.lingkarKepala;
   }
           
}


