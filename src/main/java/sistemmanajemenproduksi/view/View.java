/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemmanajemenproduksi.view;

import java.util.Scanner;
import sistemmanajemenproduksi.controller.ManajemenSistem;
import sistemmanajemenproduksi.model.Kue;
import sistemmanajemenproduksi.model.Roti;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    // MENU UTAMA
    public void tampilkanMenu() {
    System.out.println();
    System.out.println("======================================");
    System.out.println(" SISTEM MANAJEMEN PRODUKSI ROTI & KUE");
    System.out.println("======================================");
    System.out.println("1. Tambah Data Produk");
    System.out.println("2. Tampilkan Data Produk");
    System.out.println("3. Update Data Produk");
    System.out.println("4. Hapus Data Produk");
    System.out.println("5. Keluar");
    System.out.println("======================================");
}
    public void jalankanMenu(ManajemenSistem controller) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = inputMenu();
            switch (pilihan) {
                case 1:
                    controller.tambahProduk();
                    break;
                case 2:
                    controller.tampilkanProduk();
                    break;
                case 3:
                    controller.updateProduk();
                    break;
                case 4:
                    controller.hapusProduk();
                    break;
                case 5:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
            }
        } while (pilihan != 5);
    }

    // VALIDASI MENU
    public int inputMenu() {
        while (true) {
            System.out.print("Pilih menu : ");
            if (scanner.hasNextInt()) {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan >= 1 && pilihan <= 5) {
                    return pilihan;
                }System.out.println("Pilihan Menu Hanya 1 Sampai 5 !!!");
                
            }   else {
                System.out.println("Input Harus Berupa Angka");
                scanner.nextLine();
            }
        }
    }

    // INPUT ID
    public int inputId() {
        while (true) {
            System.out.print("ID Produk : ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                if (id > 0) {
                    return id;
                }System.out.println("Input Harus Di atas dari 0!");
            } else {
                System.out.println("ID harus berupa angka");
                scanner.nextLine();
            }
        }
    }

    // INPUT NAMA
    public String inputNamaProduk() {
        while (true) {
            System.out.print("Nama Produk : ");
            String nama = scanner.nextLine();
            if (!nama.trim().isEmpty()) {
                return nama;
            }
            System.out.println(
                    "Nama produk tidak boleh kosong!"
            );
        }
    }

    // INPUT STOK
    public int inputStok() {
        while (true) {
            System.out.print("Stok : ");
            if (scanner.hasNextInt()) {
                int stok = scanner.nextInt();
                scanner.nextLine();
                if (stok >= 0) {
                    return stok;
                }System.out.println("Stok Harus di atas 0!!!");
            } else {
                System.out.println(
               "Stok harus berupa angka");
                scanner.nextLine();
            }
        }
    }
    
    // INPUT HARGA
    public double inputHarga() {
        while (true) {
            System.out.print("Harga Produk : ");
            if (scanner.hasNextDouble()) {
                double harga = scanner.nextDouble();
                scanner.nextLine();
                if (harga > 0) {
                    return harga;
                }System.out.println("Harga Harus Di Atas 0!!!");
            } else {
                System.out.println(
                "Harga harus berupa angka");
                scanner.nextLine();
            }
        }
    }

    // INPUT JENIS PRODUK
    public int inputJenisProduk() {
        while (true) {
            System.out.println();
            System.out.println("=========================");
            System.out.println("     PILIH JENIS PRODUK");
            System.out.println("=========================");
            System.out.println("1. Roti");
            System.out.println("2. Kue");
            System.out.print("Pilih jenis produk : ");
            if (scanner.hasNextInt()) {
                int jenis = scanner.nextInt();
                scanner.nextLine();
                if (jenis == 1 || jenis == 2) {
                    return jenis;
                }System.out.println("Pilihan Hanya 1 dan 2!!!");
            } else {
                System.out.println(
                "Input Pilihan Harus Berupa Angka!");
                scanner.nextLine();
            }
        }
    }

    // INPUT DATA ROTI
    public String inputRasa() {
        while (true) {
            System.out.print("Rasa : ");
            String rasa = scanner.nextLine();
            if (!rasa.trim().isEmpty()) {
                return rasa;
            }
            System.out.println(
                    "Rasa tidak boleh kosong!"
            );
        }
    }

    public String inputUkuranRoti() {
        while (true) {
            System.out.print("Ukuran Roti : ");
            String ukuran = scanner.nextLine();
            if (!ukuran.trim().isEmpty()) {
                return ukuran;
            }
            System.out.println(
                    "Ukuran roti tidak boleh kosong!"
            );
        }
    }

    // INPUT DATA KUE
    public String inputJenisKue() {
        while (true) {
            System.out.print("Jenis Kue : ");
            String jenisKue = scanner.nextLine();
            if (!jenisKue.trim().isEmpty()) {
                return jenisKue;
            }
            System.out.println(
                    "Jenis kue tidak boleh kosong!"
            );
        }
    }

    public String inputUkuranKue() {
        while (true) {
            System.out.print("Ukuran Kue : ");
            String ukuran = scanner.nextLine();
            if (!ukuran.trim().isEmpty()) {
                return ukuran;
            }
            System.out.println(
                    "Ukuran kue tidak boleh kosong!"
            );
        }
    }

    // INPUT DATA PRODUKSI
    public int inputJumlahProduksi() {
        while (true) {
            System.out.print("Jumlah Produksi : ");
            if (scanner.hasNextInt()) {
                int jumlah = scanner.nextInt();
                scanner.nextLine();
                if (jumlah > 0) {
                    return jumlah;
                }System.out.println("Jumlah Produksi Harus Di atas 0!!!");
            } else {
                System.out.println(
                "Jumlah produksi harus berupa angka !");
                scanner.nextLine();
            }
        }
    }

    public String inputTanggalProduksi() {
        while (true) {
            System.out.print("Tanggal Produksi : ");
            String tanggal = scanner.nextLine();
            if (!tanggal.trim().isEmpty()) {
                return tanggal;
            }
            System.out.println(
                    "Tanggal produksi tidak boleh kosong!"
            );
        }
    }

    public String inputStatusProduksi() {
        while (true) {
            System.out.print("Status Produksi : ");
            String status = scanner.nextLine();
            if (!status.trim().isEmpty()) {
                return status;
            }
            System.out.println(
                    "Status produksi tidak boleh kosong!"
            );
        }
    }
    
    public void tutupScanner() {
        scanner.close();
    }
}