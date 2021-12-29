

https://user-images.githubusercontent.com/94717318/147693152-50d6452b-4ce4-4524-8ff0-4e2e675d58e3.mp4

# Senaryolar

## Feature: ciceksepeti.com Test Senaryoları

  ### Scenario: Kategorileden Ürün Seçme
  - Çiçeksepeti.com Sitesine Giriş Yap
  - Kategorilerden Çiçek Seç
  - Listelenenlerin Arasından `Doğal Ahşap Kütükte Renkli Papatya Aranjmanı` ürününü seç
  - Ürün Detay Sayfasına Yönlen

  ### Scenario: Seçilen Üründen Breadcrumb İle Anasayfaya Yönlenme
  - Çiçeksepeti.com Sitesine Giriş Yap
  - Kategorilerden Çiçek Seç
  - Listelenenlerin Arasından `Doğal Ahşap Kütükte Renkli Papatya Aranjmanı` ürününü seç
  - Ürün Detay Sayfasına Yönlen
  - Breadcrumb'dan Sırasıyla Çiçek ve Anasayfa Adımına Tıkla
  - Sırasıyla Çiçek Kategorisine ve Anasayfaya Yönlen

  ### Scenario: Sepete Ürün Ekleme
  - Çiçeksepeti.com Sitesine Giriş Yap
  - Arama Çubuğuna Tıkla
  - Arama Çubuğuna "lavanta kokulu Mum" yaz
  - Enter Butonunu Tıkla
  - Listelenenlerin Arasından Luxery Candle Lavanta Kokulu Mor Cam Mum Ürününe Tıkla
  - Sepete Ekle
  - "Luxery Candle Lavanta Kokulu Mor Cam Mum " Ürününü Sapette gör
