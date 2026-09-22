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


