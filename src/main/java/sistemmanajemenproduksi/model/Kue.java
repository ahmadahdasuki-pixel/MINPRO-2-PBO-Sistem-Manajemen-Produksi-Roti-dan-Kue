/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemmanajemenproduksi.model;

public class Kue extends Produk {

    private String jenisKue;
    private String ukuranKue;

    public Kue(int idProduk, String namaProduk, int stok, double hargaProduk, int jumlahProduksi, String tanggalProduksi, String statusProduksi,String jenisKue, String ukuranKue) {
        super(idProduk, namaProduk, stok, hargaProduk, jumlahProduksi, tanggalProduksi, statusProduksi);
        this.jenisKue = jenisKue;
        this.ukuranKue = ukuranKue;
    }

    // Getter
    public String getJenisKue() {
        return jenisKue;
    }

    public String getUkuranKue() {
        return ukuranKue;
    }

    // Setter
    public void setJenisKue(String jenisKue) {
        if (jenisKue != null && !jenisKue.trim().isEmpty()) {
            this.jenisKue = jenisKue;
        }
    }

    public void setUkuranKue(String ukuranKue) {
        if (ukuranKue != null && !ukuranKue.trim().isEmpty()) {
            this.ukuranKue = ukuranKue;
        }
    }

    // Override
    @Override
    public void tampilkanProduk() {
    super.tampilkanProduk();
        System.out.println("Jenis           : Kue");
        System.out.println("Jenis Kue       : " + jenisKue);
        System.out.println("Ukuran          : " + ukuranKue);
    }
}
