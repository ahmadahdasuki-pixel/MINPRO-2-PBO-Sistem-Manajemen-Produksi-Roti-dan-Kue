/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemmanajemenproduksi.model;

public class Roti extends Produk {
    private String rasa;
    private String ukuranRoti;

    public Roti(int idProduk, String namaProduk, int stok, double hargaProduk, int jumlahProduksi, String tanggalProduksi, String statusProduksi, String rasa, String ukuranRoti) {
        super(idProduk, namaProduk, stok, hargaProduk, jumlahProduksi, tanggalProduksi, statusProduksi);
        this.rasa = rasa;
        this.ukuranRoti = ukuranRoti;
    }


    public String getRasa() {
        return rasa;
    }

    public String getUkuranRoti() {
        return ukuranRoti;
    }

    public void setRasa(String rasa) {
        if(rasa.isEmpty()){
            System.out.println("Rasa Roti Tidak Boleh Kosong !");
        }
        this.rasa = rasa;
    }

    public void setUkuranRoti(String ukuranRoti) {
        if(ukuranRoti.isEmpty()){
            System.out.println("Ukuran Roti Tidak Boleh Kosong !");
        }
        this.ukuranRoti = ukuranRoti;
    }
    
    @Override
    public void tampilkanProduk() {
    super.tampilkanProduk();
        System.out.println("Jenis Produk : Roti");
        System.out.println("Rasa         : " + rasa);
        System.out.println("Ukuran       : " + ukuranRoti);
    }    
}
