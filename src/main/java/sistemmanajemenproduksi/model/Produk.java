/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemmanajemenproduksi.model;

/**
 *
 * @author Ahmad Ahdasuki
 */

public class Produk {

    private int idProduk;
    private String namaProduk;
    private int stok;
    private double hargaProduk;
    private int jumlahProduksi;
    private String tanggalProduksi;
    private String statusProduksi;

    public Produk(int idProduk, String namaProduk, int stok,
                  double hargaProduk, int jumlahProduksi, String tanggalProduksi, String statusProduksi) {

        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.stok = stok;
        this.hargaProduk = hargaProduk;
        this.jumlahProduksi = jumlahProduksi;
        this.tanggalProduksi = tanggalProduksi;
        this.statusProduksi = statusProduksi;
    }

    // Getter

    public int getIdProduk() {
        return idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public int getStok() {
        return stok;
    }

    public double getHargaProduk() {
        return hargaProduk;
    }

    public int getJumlahProduksi() {
        return jumlahProduksi;
    }

    public String getTanggalProduksi() {
        return tanggalProduksi;
    }

    public String getStatusProduksi() {
        return statusProduksi;
    }


    // Setter
    public void setIdProduk(int idProduk) {
        if (idProduk > 0) {
            this.idProduk = idProduk;
        }
    }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk != null && !namaProduk.trim().isEmpty()) {
            this.namaProduk = namaProduk;
        }
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public void setHargaProduk(double hargaProduk) {
        if (hargaProduk >= 0) {
            this.hargaProduk = hargaProduk;
        }
    }

    public void setJumlahProduksi(int jumlahProduksi) {
        if (jumlahProduksi >= 0) {
            this.jumlahProduksi = jumlahProduksi;
        }else {
            System.out.println("Jumlah Produksi Tidak Boleh di Bawah 0!");
        }
    }
    
    public void setTanggalProduksi(String tanggalProduksi){
        if (tanggalProduksi != null && !tanggalProduksi.trim(). isEmpty()){
        this.tanggalProduksi = tanggalProduksi;
    } else {
            System.out.println("Tanggal Produksi Tidak Boleh Kosong");
            }
    }
    
    public void setStatusProduksi (String statusProduksi){
        if(statusProduksi != null && !statusProduksi.trim().isEmpty()){
            this.statusProduksi = statusProduksi;
        }else{
            System.out.println("Status Produksi Tidak Boleh Kosong");
        }
    }

    // Method untuk polymorphism
    public void tampilkanProduk() {

        System.out.println("ID Produk       : " + idProduk);
        System.out.println("Nama Produk     : " + namaProduk);
        System.out.println("Stok            : " + stok);
        System.out.println("Harga           : Rp" + hargaProduk);
        System.out.println("Jumlah Produksi : " + jumlahProduksi);
        System.out.println("Tanggal Produksi : " + tanggalProduksi);
        System.out.println("Status Produksi : " + statusProduksi);
    }
}
