# shodaqoh-muharram
Download aplikasi versi terakhir [di sini](https://github.com/thohadi223/shodaqoh-muharram/releases/latest)
## Setup server
### Prasyarat
1. MySQL
2. Apache Web Server
3. PHP

Caatan: semua aplikasi tersebut bisa sekali install menggunakan XAMPP
### Instalasi
1. Eksekusi file sql untuk membuat stuktur database awal
2. Lakukan penyesuaian pada table `tahun_aktif`
3. Lakukan penyesuaian pada table `kurs`
4. Buatkan user-user untuk pengguna aplikasi di table `users`, dengan password dienkripsi menggunakan `SHA-21`
5. Letakkan folder `view-shodaqoh` di bawah folder `htdocs` yang ada di Apache Web Server
## Setup Client Entri Shodaqoh
### Prasyarat
1. Java JRE 1.6 atau yang lebih tinggi
### Instalasi
1. Download [entri-shodaqoh.zip](https://github.com/thohadi223/shodaqoh-muharram/releases/download/v1.0.0/entri-shodaqoh-v1.zip)
2. Extract file entri-shodaqoh.zip
3. Sesuaikan isi dari file `connection.conf` agar terhubung ke database
3. Pastikan file .jar terasosiasi dengan java
3. Double click entri-shodaqoh.jar untuk menjalankan aplikasi

## Setup Client Shodaqoh Viewer
### Prasyarat
1. Web Browser
### Instalasi
1. Akses ke `http://ip-server/view-shodaqoh`
2. Tampilkan dalam mode full screen
