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

``
java
public class Main {

    public static void main(String[] args) {

        View view = new View();
        ManajemenSistem controller = new ManajemenSistem(view);

        view.jalankanMenu(controller);

        view.tutupScanner();
    }
}
``

Dari kode di atas pada class Main saya hanya perlu membuat objek view dan controller yang sudah di kaitkan dari class package View dan Controller untuk saya panggil method nya dan juga program akan lansung berjalan sesuai dengan logika yang sudah di buat pada masing masing package class.

Dengan Demikian Penerapan MVC ini juga saya terapkan demi reusabilitas kode pada setiap class agar tidak sangat panjang dan susah buat di pahamin strukturnya.


## 3. Penerapan Validasi Input
Validasi input digunakan untuk memastikan data yang dimasukkan pengguna sesuai dengan aturan dasar program. Validasi input diterapkan pada class View karena View bertanggung jawab terhadap interaksi langsung dengan pengguna.

Validasi angka dilakukan menggunakan hasNextInt() dan hasNextDouble(). Contohnya pada input ID:
``
java
while (true) {
            System.out.print("ID Produk : ");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                scanner.nextLine();
                .......

while (true) {
            System.out.print("Harga Produk : ");
            if (scanner.hasNextDouble()) {
                double harga = scanner.nextDouble();
                scanner.nextLine();
                ......
}

``

Jika pengguna memasukkan data yang bukan angka, program akan memberikan pesan kesalahan dan meminta pengguna memasukkan data kembali. Program juga menggunakan while (true) agar proses input terus dilakukan sampai pengguna memberikan input yang benar. Selain validasi tipe data, program juga melakukan validasi terhadap nilai. Contohnya ID harus lebih dari 0, stok tidak boleh kurang dari 0, harga harus lebih dari 0, dan pilihan menu harus berada pada angka 1 sampai 5.


## 4. Penerapan Encasulaption 
## 5. Penerapan Inheritence
## 6. Penerapan Polymorpishm Overriding
## 7. Dokumentasi Alur Progam

