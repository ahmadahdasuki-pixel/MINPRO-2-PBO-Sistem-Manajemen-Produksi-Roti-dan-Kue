package sistemmanajemenproduksi.controller;

import sistemmanajemenproduksi.model.Kue;
import sistemmanajemenproduksi.model.Produk;
import sistemmanajemenproduksi.model.Roti;
import sistemmanajemenproduksi.view.View;
import java.util.ArrayList;

public class ManajemenSistem {

    private ArrayList<Roti> daftarProdukRoti;
    private ArrayList<Kue> daftarProdukKue;
    private View view;

    public ManajemenSistem(View view) {

        this.view = view;
        daftarProdukRoti = new ArrayList<>();
        daftarProdukKue = new ArrayList<>();
        
        tambahDataAwal();
    }
    
    // DATA DUMMY
    private void tambahDataAwal() {
        Roti roti = new Roti(101,"Roti Keju", 80, 15000, 50, "20-09-2026", "Berhasil","Keju","Medium");
        daftarProdukRoti.add(roti);
        Kue kue = new Kue(103, "Brownies Coklat", 50, 25000, 75, "19-08-2026", "Sedang Proses", "Brownies","Sedang");
        daftarProdukKue.add(kue);
    }
 
//    TAMBAH PRODUK
    public void tambahProduk() {
        System.out.println();
        System.out.println("===== TAMBAH DATA PRODUK =====");

        int idProduk;
        while (true) {
            idProduk = view.inputId();
            boolean idSudahAda = false;
            for (Roti roti : daftarProdukRoti) {
                if (roti.getIdProduk() == idProduk) {
                    idSudahAda = true;
                    break;
                }
            }
            for (Kue kue : daftarProdukKue) {
                if (kue.getIdProduk() == idProduk) {
                    idSudahAda = true;
                    break;
                }
            }
            if (!idSudahAda) {
                break;
            }
            System.out.println("ID Produk Tersebut Sudah Di gunakan");
        }

        String namaProduk = view.inputNamaProduk(); 
        int stok = view.inputStok();
        double hargaProduk = view.inputHarga();
        int jenisProduk = view.inputJenisProduk();
        
        System.out.println();
        System.out.println("Tambah Data Produksi");
        int jumlahProduksi = view.inputJumlahProduksi();
        String tanggalProduksi = view.inputTanggalProduksi();
        String statusProduksi = view.inputStatusProduksi();
        
        // TAMBAH DATA ROTI
        System.out.println();
        System.out.println("Tambah Data Roti");
        if (jenisProduk == 1) {
            String rasa = view.inputRasa();
            String ukuranRoti = view.inputUkuranRoti();

            Roti rotiBaru = new Roti(
                    idProduk,
                    namaProduk,
                    stok,
                    hargaProduk,
                    jumlahProduksi,
                    tanggalProduksi,
                    statusProduksi,
                    rasa,
                    ukuranRoti
            );
            daftarProdukRoti.add(rotiBaru);
            System.out.println("Data Produk Roti Berhasil Di Tambahkan");
        }

        // TAMBAH DATA KUE
        else {
            System.out.println();
            System.out.println("Tambah DataKue");
            String jenisKue = view.inputJenisKue();
            String ukuranKue = view.inputUkuranKue();
            Kue kueBaru = new Kue(
                    idProduk,
                    namaProduk,
                    stok,
                    hargaProduk,
                    jumlahProduksi,
                    tanggalProduksi,
                    statusProduksi,
                    jenisKue,
                    ukuranKue
            );
            daftarProdukKue.add(kueBaru);
            System.out.println("Data Produk Kue Berhasil Di Tambahkan");
        }
    }
    
//    TAMPILKAN PRODUK
    public void tampilkanProduk() {
        System.out.println();
        System.out.println("===== DATA PRODUK =====");

        if (daftarProdukRoti.isEmpty()
                && daftarProdukKue.isEmpty()) {
            System.out.println("Belum ada data produk.");
            return;
        }
        System.out.println();
        System.out.println("=== DATA ROTI ===");
        if (daftarProdukRoti.isEmpty()) {
            System.out.println("Belum ada data roti.");
        } else {
            for (Roti roti : daftarProdukRoti) {
                System.out.println();
                roti.tampilkanProduk();
                System.out.println("----------------------");
            }
        }

        System.out.println();
        System.out.println("=== DATA KUE ===");
        if (daftarProdukKue.isEmpty()) {
            System.out.println("Belum ada data kue.");
        } else {
            for (Kue kue : daftarProdukKue) {
                System.out.println();
                kue.tampilkanProduk();
                System.out.println("----------------------");
            }
        }
    }
    
//    UBAH DATA PRODUK
    public void updateProduk() {
        System.out.println();
        System.out.println("===== UPDATE DATA PRODUK =====");

        int idProduk = view.inputId();
        
        // CARI ID ROTI
        for (Roti roti : daftarProdukRoti) {
            if (roti.getIdProduk() == idProduk) {
                System.out.println("Data ID Produk Roti Ditemukan.");
                roti.setStok(view.inputStok());
                roti.setHargaProduk(view.inputHarga());
                System.out.println();
                System.out.println("=== Update Data Produksi ===");
                roti.setJumlahProduksi(view.inputJumlahProduksi());
                roti.setTanggalProduksi(view.inputTanggalProduksi());
                roti.setStatusProduksi(view.inputStatusProduksi());
                System.out.println();
                System.out.println("=== Update Data Roti ===");
                roti.setRasa(view.inputRasa());
                roti.setUkuranRoti(view.inputUkuranRoti());
                
                System.out.println("Data Roti Berhasil Di Update");
                return;
            }
        }

        // CARI ID KUE
        for (Kue kue : daftarProdukKue) {
            if (kue.getIdProduk() == idProduk) {
                System.out.println();
                System.out.println("Data Produk Kue Ditemukan.");
                kue.setStok(view.inputStok());
                kue.setHargaProduk(view.inputHarga());
                System.out.println();
                System.out.println("=== Update Data Produksi ===");
                kue.setJumlahProduksi(view.inputJumlahProduksi());
                kue.setTanggalProduksi(view.inputTanggalProduksi());
                kue.setStatusProduksi(view.inputStatusProduksi());
                System.out.println();
                System.out.println("=== Update Data Kue ===");
                kue.setUkuranKue(view.inputUkuranKue());

                System.out.println("Data Kue Berhasil Di Berhasil Di Update");
                return;
            }
        }
        System.out.println("Produk Dengan ID Tersebut Tidak Di Temukan");
    }

    // HAPUS DATA PRODUK
    public void hapusProduk() {
        System.out.println();
        System.out.println("===== HAPUS DATA PRODUK =====");
        int idProduk = view.inputId();

        // HAPUS DATA ROTI
        for (int i = 0; i < daftarProdukRoti.size(); i++) {
            if (daftarProdukRoti.get(i).getIdProduk() == idProduk) {
                daftarProdukRoti.remove(i);
                System.out.println("Data Roti Berhasil Di Hapus");
                return;
            }
        }
        // HAPUS DATA KUE
        for (int i = 0; i < daftarProdukKue.size(); i++) {
            if (daftarProdukKue.get(i).getIdProduk() == idProduk) {
                daftarProdukKue.remove(i);
                System.out.println("Data Kue Berhasil Di Hapus");
                return;
            }
        }
        System.out.println("Produk Dengan ID Tersebut Tidak Di Temukan");
    }
  }
    
    

