# Sistem Manajemen Produksi Roti dan KUE

## 1. Deskripsi Program
Program Sistem Manajemen Produksi Roti dan Kue merupakan aplikasi berbasis Java yang digunakan untuk mengelola data produk dan data produksi pada usaha roti dan kue. Program ini menyediakan beberapa fitur utama, yaitu menambahkan data produk, menampilkan data produk, mengubah data produk, dan menghapus data produk. Program membedakan produk menjadi dua kategori, yaitu Roti dan Kue. Setiap kategori memiliki atribut khusus masing-masing. Produk Roti memiliki atribut rasa dan ukuranRoti, sedangkan produk Kue memiliki atribut jenisKue dan ukuranKue.
Program dibuat menggunakan konsep Object-Oriented Programming (OOP) seperti encapsulation, inheritance, polymorphism, access modifier, ArrayList, constructor, getter dan setter. Program juga menerapkan pola Model-View-Controller (MVC) untuk memisahkan bagian data, tampilan dan input pengguna, serta logika pengolahan data.


## 2. Penerapan MVC (Model View Controller) dan Penggunaan Setiap Class.
Program menggunakan pola Model-View-Controller (MVC) untuk memisahkan tanggung jawab setiap bagian program.

<img width="294" height="223" alt="image" src="https://github.com/user-attachments/assets/ad453dcd-965a-483f-95bb-b90a41bbe52f" />

Ini adalah Contoh Struktur Pemisahan Masing-Masing Package dan kelasnya saat di aplikasi netbeans yang di gunakan pada program ini.

**Package Model**
Package model berfungsi untuk menyimpan struktur dan data objek dalam program. Misalnya menyimpan data untuk Class Produk berperan sebagai superclass yang menyimpan atribut umum produk, lalu Class Roti merupakan subclass dari Produk yang menyimpan atribut khusus produk roti dan Class Kue merupakan subclass dari Produk yang menyimpan atribut khusus produk kue.Jadi Package ini tujuannya emang untuk meyimpan struktur data dan sebuah konsepnya.

**Package View**
Package view ini berisi class yang namanya View, yang dimana class View ini bertanggung jawab terhadap seluruh interaksi dengan user dengan program atau yang menjadi tampilan program nya saat user menggunakan program ini seperti:
- Menampilkan menu.
- Mengambil input menggunakan Scanner.
- Melakukan validasi dasar input.
- Melakukan looping menu utama.
- Menampilkan informasi dan pesan kepada pengguna.
Dengan demikian, View berfokus pada interaksi antara pengguna dengan program.

**Package Controller**
Package controller berisi class ManajemenSistem yang dimana class ManajemenSistem ini bertanggung jawab terhadap logika pengolahan data atau sistem CRUD nya seperti:
- Menambahkan data.
- Menampilkan data.
- Mengubah data.
- Menghapus data.
- Menyimpan data ke dalam ArrayList.
- Mencari data berdasarkan ID.
- Mengecek apakah ID sudah digunakan.
Dengan demikian, Controller berfokus pada proses CRUD dan logika bisnis program apabila ingin mencari sebuah ID dari sebuah produk itu sudah ada atau belum.

**Class Main**
Class Main merupakan titik awal program. Class ini membuat objek View dan ManajemenSistem, kemudian menjalankan menu utama.

```
java
public class Main {

    public static void main(String[] args) {

        View view = new View();
        ManajemenSistem controller = new ManajemenSistem(view);

        view.jalankanMenu(controller);

        view.tutupScanner();
    }
}
```

Dari kode di atas pada class Main saya hanya perlu membuat objek view dan controller yang sudah di kaitkan dari class package View dan Controller untuk saya panggil method nya dan juga program akan lansung berjalan sesuai dengan logika yang sudah di buat pada masing masing package class.

Dengan Demikian Penerapan MVC ini juga saya terapkan demi reusabilitas kode pada setiap class agar tidak sangat panjang dan susah buat di pahamin strukturnya.


## 3. Penerapan Validasi Input
Validasi input digunakan untuk memastikan data yang dimasukkan pengguna sesuai dengan aturan dasar program. Validasi input diterapkan pada class View karena View bertanggung jawab terhadap interaksi langsung dengan pengguna.

Validasi angka dilakukan menggunakan hasNextInt() dan hasNextDouble(). Contohnya pada input ID:


```
java
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
                .......

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

```

Jika pengguna memasukkan data yang bukan angka, program akan memberikan pesan kesalahan dan meminta pengguna memasukkan data kembali. Program juga menggunakan while (true) agar proses input terus dilakukan sampai pengguna memberikan input yang benar. Selain validasi tipe data, program juga melakukan validasi terhadap nilai. Contohnya ID harus lebih dari 0 dan harga harus lebih dari 0, dan pilihan menu harus berada pada angka 1 sampai 5.

Untuk input String, program memeriksa apakah input kosong menggunakan:

```
java
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

```

Jika saat menginput itu kita lansung enter atau mengisi dengan input kosong maka program akan berulang karena program tersebut tidak boleh terisi kosong.

Selain validasi dasar di View, Controller juga memiliki validasi bisnis, misalnya melakukan pengecekan apakah ID produk sudah digunakan sebelum data baru ditambahkan.

```
java
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

```

## 4. Penerapan Encasulaption 
Konsep encapsulation diterapkan dengan menyembunyikan atribut yang terdapat pada class menggunakan access modifier private. Atribut pada class Produk, Roti, dan Kue tidak dapat diakses secara langsung dari class lain

Contohnya pada class Produk:
```
java
private int idProduk;
private String namaProduk;
private int stok;
private double hargaProduk;
```
Karena atribut menggunakan private, class lain tidak dapat mengubah nilai atribut secara langsung. Untuk mengambil nilai atribut digunakan method getter, sedangkan untuk mengubah nilai atribut digunakan method setter.
```
java
public int getStok() {
    return stok;
}

public void setStok(int stok) {
    this.stok = stok;
}
```
Penerapan encapsulation membuat data pada objek lebih terkontrol karena akses terhadap atribut dilakukan melalui method yang telah disediakan oleh class. Pada class Roti, atribut khusus seperti rasa dan ukuranRoti juga menggunakan private. Sedangkan pada class Kue, atribut jenisKue dan ukuranKue juga dibuat private dan diakses menggunakan getter dan setter.

## 5. Penerapan Inheritence
Konsep inheritance diterapkan dengan membuat class Produk sebagai superclass, kemudian class Roti dan Kue sebagai subclass. Kemudian class Roti dan Kue beserta masing masing atributnya mewarisi atribut dan method dari class Produk menggunakan:
```
java
public class Roti extends Produk
private String rasa;
private String ukuranRoti;

public class Kue extends Produk
private String jenisKue;
private String ukuranKue;
```
Dengan inheritance, atribut dan method yang bersifat umum tidak perlu ditulis ulang pada class Roti dan Kue. Kedua class tersebut cukup mewarisinya dari class Produk.

## 6. Penerapan Polymorpishm Overriding
Konsep polymorphism dengan overriding dapat diterapkan ketika subclass memiliki method dengan nama dan parameter yang sama seperti superclass, tetapi memberikan implementasi yang berbeda.
Pada program ini, polymorphism dapat diterapkan pada method dari class Produk yang merupakan superclass:
```
java
public void tampilkanProduk() {
}
```

Lalu kita override untuk kita panggil method nya ke class roti dan kue seperti ini:
```
java
@Override
    public void tampilkanProduk() {
    super.tampilkanProduk();
        System.out.println("Jenis Produk : Roti");
        System.out.println("Rasa         : " + rasa);
        System.out.println("Ukuran       : " + ukuranRoti);
    }    ...

@Override
    public void tampilkanProduk() {
    super.tampilkanProduk();
        System.out.println("Jenis           : Kue");
        System.out.println("Jenis Kue       : " + jenisKue);
        System.out.println("Ukuran          : " + ukuranKue);
    }
```

Dengan overriding tersebut, method yang memiliki nama sama dapat memberikan perilaku berbeda sesuai dengan objek yang digunakan. Contohnya, objek Roti akan menampilkan informasi khusus seperti rasa dan ukuranRoti, sedangkan objek Kue akan menampilkan jenisKue dan ukuranKue.


## 7. Alur Dokumentasi Program 
**Tampilan Menu Utama**

<img width="332" height="171" alt="image" src="https://github.com/user-attachments/assets/b0f8486d-e779-4e01-b0f7-dc9896379377" />

Ini merupakan Tampilan Menu Utama saat pertama kali program di jalankan.

<img width="362" height="237" alt="image" src="https://github.com/user-attachments/assets/7bf7fd86-c150-4085-82bd-51473a1cc4fc" />

Di saat Kita salah menginput pilihan pada menu utama maka program akan berulang balik ke menu utama dan di atas dapat di lihat validasinya apabila kita salah menginput di luar dari tipe data atau di luar batas nilai piliha 1-5.

**Menu 1 Tambah Produk**

<img width="291" height="141" alt="image" src="https://github.com/user-attachments/assets/30c7873d-d827-4a87-a52e-c7b49a2562e2" />

Pertama kita akan cek Validasi bisnisnya apabila ID produk tersebut sudah ada maka program akan mengulang memberikan input idProduk baru untuk kita lakukan tambah produk dan apabila kita juga salah dalam menginput seperti menginput huruf atau kata pada inputan yang harusnya String maka program juga akan mengulang untuk memberikan inputan ulang idProduk sampai benar. Dan ini juga akan berlaku pada inputan tipe data int dan double lainnya.

<img width="281" height="108" alt="image" src="https://github.com/user-attachments/assets/41ac347d-5efe-44a7-8da6-628f610ee907" />

Setelah itu kitaa akan memasukan id baru nyaa yaitu 75 sebagai id produk baru yang ingin kita tambah kan, lalu lanjut menginput nama produk, saat menginput nama produk tidak boleh inpu kosong harus ada isi nya jika kosong maka program input nama produk akan berulang sampai benar karena inputnya tidak boleh kosong. Dan ini juga berlaku pada inputan lain yang memiliki tipe data String.

<img width="279" height="393" alt="image" src="https://github.com/user-attachments/assets/46cb4742-c29b-4835-91fc-f2515361883c" />

Setelah kita menginput produk, kita akan di arahkan ke pilihan jenis produk agar kita bisa mengkategorikan produk baru yang ingin kita tambahkan ini kategori nya roti atau kue. Pada implementasi ini saya memilih kue dan langsung lanjut untuk menambahkan data produksi nya terlebih dahulu agar kitaa bisa mengetahui batch dari proses produksi nya itu apa saja, setelah nya baru lansung lanjut ke input atribut dari kue tersebut yaitu "jenis kue" Dan "ukuran kue" Untuk menentukan aneka kue nya nanti seperti apa.

**Menu 2 Tampilkan Produk**

<img width="271" height="586" alt="image" src="https://github.com/user-attachments/assets/53428f78-059e-4472-a0b8-57e13f1d7e40" />

Ini adalah output Menu kedua yaitu tampilkanProduk() , yang dimana method ini tampilannya juga mengambil dari data dummy dan data yang baru saja kita tambahkan saat berada di method tambahProduk() sebelumnya dan dapat di lihat produk yang baru saja kita tambahkan sudah tertera pada output program.

**Menu 3 Ubah Data Produk**

<img width="229" height="88" alt="image" src="https://github.com/user-attachments/assets/342aac81-0ee6-4d07-9e17-688d3bea86c8" />

<img width="245" height="75" alt="image" src="https://github.com/user-attachments/assets/38e8d780-e21c-44ae-8755-7d01d0d19e4d" />

Pada Menu ketiga yaitu menu Update saat ingin menginput id produk atau mencari id produk roti atau kue itu dapat di lihat bahwa id dari masing-masing produk di temukan karena mengambil atau menggunakan getidProduk yang dalamnya sudah terdaftar data data produk lain. Jika id Produk roti yang di input maka data produk roti di temukan dan sebaliknya pada kue pun begitu

<img width="305" height="225" alt="image" src="https://github.com/user-attachments/assets/8aa57350-9b56-4c33-8b81-3aaf1a6e07b9" />

Nahh selanjutnya proses update nyaa, disini saya ingin melakukan update pada produk dengan id 75 atau Brownies Coklat, yang dimana saya mengubah stoknya, harga produk, jumlah produksi, tanggal produksi, status produksi dan ukuran kue. Kenapa saya hanya mengubah atribut itu saja karena isi nya itu secara real time bisa berubah bisa berkurang , bisa bertambah ataupun berubah ketentuannya seperti contoh status produksi yang awalnya "Sedang Proses" Bisa berubah nanti menjadi "Berhasil"

**Menu 4 Hapus Data Produk**

<img width="321" height="362" alt="image" src="https://github.com/user-attachments/assets/c7e5e2d1-00d2-4faa-871f-1aec5e582b63" />

Selanjutnya masuk ke menu keempat yaitu hapus Produk yang dimana untuk menghapus sebuah produk kita harus input id dari produk tersebut tidak jauh berbeda juga dengan menu update sebelum nya dalam konteks mencari id produk untuk kita lakukan CRUD yang dimana pada menu hapus inipun dia akan menghapus sesuai dengan id produk yang terdaftar di masing-masing kategori dan dari output gambar di atas dapat di lihat saya menghapus produk dengan id 75 dan ituadalah data produk dari kue.

**Menu 5 Keluar**

<img width="482" height="268" alt="image" src="https://github.com/user-attachments/assets/948ea264-09cb-4530-9d74-6c1a7efa29f1" />

Menu kelima keluar program dan program pun selesai. Terimakasih🙏🏻













