/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugaspbo;
import kebidanan.*;
import java.time.LocalDate;
import java.util.Scanner;
import crud.database;

/**
 *
 * @author ASUS
 */
public class Tugaspbo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        tOrtu cihuy = new tOrtu();
//        cihuy.simpanOrtu("","","","","","");
//        cihuy.ubahOrtu("","","","","","");
//        cihuy.hapusOrtu("");
//        cihuy.cariOrtu("");
//        cihuy.dataOrtu();

//        tAnak alamak = new tAnak();
//        alamak.simpanAnak("1","1","aldy","laki-laki","3kg","50cm","37cm");
//        alamak.ubahAnak("","","","","","","");
//        alamak.hapusAnak("");
//        alamak.cariAnak("");
//        alamak.dataAnak();
        
        catatanKehamilan icikiwir = new catatanKehamilan();
//        icikiwir.simpanCK("2","2","1","asam urat","dermatitis");
//        icikiwir.ubahCK("","","","","");
//        icikiwir.hapus("");
        icikiwir.cariCK("1");
        icikiwir.dataCK();

//        catatanPersalinan aduhai = new catatanPersalinan();
//        aduhai.simpanCP("","","","","","");
//        aduhai.ubahCP("","","","","","");
//        aduhai.hapusCP("");
//        aduhai.cariCP("");
//        aduhai.dataCP();
        
        
//        Scanner input = new Scanner(System.in);
//
//        
//        System.out.println("Masukkan ID Kehamilan:");
//        int idKehamilan = input.nextInt();
//        input.nextLine(); // Membersihkan \n
//        System.out.println("Masukkan ID Ortu:");
//        int idOrtu = input.nextInt();
//        input.nextLine(); // Membersihkan \n
//        System.out.println("Masukkan Hamil ke:");
//        int hamilKe = input.nextInt();
//        input.nextLine(); // Membersihkan \n
//        System.out.println("Masukkan HPHT (YYYY-MM-DD):");
//        String hphtString = input.nextLine();
//        LocalDate hpht = LocalDate.parse(hphtString);
//        System.out.println("Masukkan HPT (YYYY-MM-DD):");
//        String hptString = input.nextLine();
//        LocalDate hpt = LocalDate.parse(hptString);
//        System.out.println("Masukkan Riwayat Penyakit:");
//        String riwayatPenyakit = input.nextLine();
//        System.out.println("Masukkan Riwayat Alergi:");
//        String riwayatAlergi = input.nextLine();
//
//        catatanKehamilan kehamilan = new catatanKehamilan(idKehamilan, idOrtu, hamilKe, hpht, hpt, riwayatPenyakit, riwayatAlergi);
//
//        
//        System.out.println("Masukkan ID Persalinan:");
//        String idPersalinan = input.nextLine();
//        System.out.println("Masukkan ID Kehamilan:");
//        String idKehamilanPersalinan = input.nextLine();
//        System.out.println("Masukkan Tanggal Persalinan (YYYY-MM-DD):");
//        String tglPersalinanString = input.nextLine();
//        LocalDate tglPersalinan = LocalDate.parse(tglPersalinanString);
//        System.out.println("Masukkan Umur Kehamilan:");
//        String umurKehamilan = input.nextLine();
//        System.out.println("Masukkan Penolong Persalinan (DOKTER/BIDAN):");
//        String penolongString = input.nextLine();
//        catatanPersalinan.PenolongPersalinan penolongPersalinan = catatanPersalinan.PenolongPersalinan.valueOf(penolongString);
//        System.out.println("Masukkan Cara Persalinan (NORMAL/TINDAKAN):");
//        String caraString = input.nextLine();
//        catatanPersalinan.CaraPersalinan caraPersalinan = catatanPersalinan.CaraPersalinan.valueOf(caraString);
//        System.out.println("Masukkan Keadaan Ibu (SEHAT/SAKIT):");
//        String keadaanIbuString = input.nextLine();
//        catatanPersalinan.KeadaanIbu keadaanIbu = catatanPersalinan.KeadaanIbu.valueOf(keadaanIbuString);
//        System.out.println("Masukkan Kondisi Lahir (NORMAL/CACAT):");
//        String kondisiLahirString = input.nextLine();
//        catatanPersalinan.KondisiLahir kondisiLahir = catatanPersalinan.KondisiLahir.valueOf(kondisiLahirString);
//
//        catatanPersalinan persalinan = new catatanPersalinan(idPersalinan, idKehamilanPersalinan, tglPersalinan, umurKehamilan,
//                penolongPersalinan, caraPersalinan, keadaanIbu, kondisiLahir);
//
//        
//        System.out.println("Informasi Catatan Kehamilan:");
//        System.out.println("ID Kehamilan: " + kehamilan.getId());
//        System.out.println("ID Ortu: " + kehamilan.getOrtu_id());
//        System.out.println("Hamil ke: " + kehamilan.getHamil_ke());
//        System.out.println("HPHT: " + kehamilan.getHpht());
//        System.out.println("HPT: " + kehamilan.getHpt());
//        System.out.println("Riwayat Penyakit: " + kehamilan.getRiwayat_penyakit());
//        System.out.println("Riwayat Alergi: " + kehamilan.getRiwayat_alergi());
//
//        System.out.println("\nInformasi Catatan Persalinan:");
//        System.out.println("ID Persalinan: " + persalinan.getId());
//        System.out.println("ID Kehamilan: " + persalinan.getCatatanKehamilan_id());
//        System.out.println("Tanggal Persalinan: " + persalinan.getTglPersalinan());
//        System.out.println("Umur Kehamilan: " + persalinan.getUmurKehamilan());
//        System.out.println("Penolong Persalinan: " + persalinan.getPenolongPersalinan());
//        System.out.println("Cara Persalinan: " + persalinan.getCaraPersalinan());
//        System.out.println("Keadaan Ibu: " + persalinan.getKeadaanIbu());
//        System.out.println("Kondisi Lahir: " + persalinan.getKondisiLahir());
//
//        // Menutup Scanner
//        input.close();
    }
            
}
