# Otopark Sistemi
Otobark Yönetim Sistemi
Bu proje, otopark yönetimi için kapsamlı bir yazılım çözümü sunar. Araç yönetimi, kullanıcı rolleri, park türleri ve ödeme sistemleri gibi özellikleri içerir. Proje, Java dili ve MySQL veritabanı kullanılarak geliştirilmiştir.

Özellikler Araç Yönetimi: Araç ekleme, düzenleme, silme ve ödeme işleme. Kullanıcı Rolleri: Admin ve sürücü rolleri. Tasarım Desenleri: Singleton, Factory, Abstract Factory, Observer, State, Builder ve Decorator desenleri. Veritabanı Yönetimi: MySQL kullanılarak CRUD işlemleri. Swing UI: Kullanıcı dostu arayüz tasarımı. Veritabanı Yapısı Tablolar Arac: plaka, marka, model, durum, giriş_tarihi, çıkış_tarihi, kullanıcı_id Kullanici: id, ad, soyad, email, şifre, yetki ParkTürü: tur_id, tür_adı (standart, park, VIP, motor) ParkYeri: park_id, yer_no, durum, arac_id Kurulum Proje Dosyalarını İndirin:

Kodu kopyala:

git clone https://github.com/Gulbaharelik/otoparkSistemi.git

Veritabanını Kurun:

otoparkproje_db.sql dosyasını MySQL kullanarak içe aktarın. Bağımlılıkları Yükleyin:

Proje, Java'nın standart kütüphanelerini kullanır. Ekstra bir bağımlılık gerekmez. Projeyi Çalıştırın:

Java IDE'nizde Main.java dosyasını çalıştırın. Kullanım Admin Girişi:

Admin hesabıyla oturum açarak araç ve kullanıcı yönetimi işlemlerini gerçekleştirebilirsiniz. Araç Ekleme ve Silme:

Araç silindiğinde, çıkış tarihi güncellenir. Park yeri ve türü, ödeme işlemi tamamlandıktan sonra güncellenir. Ödeme İşleme:

Ödeme sonrası park yeri ve park türü bilgileri güncellenir.

Projeyi birlikte yaptığım grup arkadaşım : https://github.com/asumangenc
