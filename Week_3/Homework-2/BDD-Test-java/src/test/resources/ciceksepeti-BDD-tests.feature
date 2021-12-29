Feature: ciceksepeti.com Test Senaryoları

  Scenario: Kategorileden Ürün Seçme
    Given Çiçeksepeti.com Sitesine Giriş Yap
    Given Kategorilerden Çiçek Seç
    When  Listelenenlerin Arasından `Doğal Ahşap Kütükte Renkli Papatya Aranjmanı` ürününü seç
    Then  Ürün Detay Sayfasına Yönlen

  Scenario: Seçilen Üründen Breadcrumb İle Anasayfaya Yönlenme
    Given Çiçeksepeti.com Sitesine Giriş Yap
    Given Kategorilerden Çiçek Seç
    Given Listelenenlerin Arasından `Doğal Ahşap Kütükte Renkli Papatya Aranjmanı` ürününü seç
    Given Ürün Detay Sayfasına Yönlen
    When  Breadcrumb'dan Sırasıyla Çiçek ve Anasayfa Adımına Tıkla
    Then  Sırasıyla Çiçek Kategorisine ve Anasayfaya Yönlen

  Scenario: Sepete Ürün Ekleme
    Given Çiçeksepeti.com Sitesine Giriş Yap
    Given Arama Çubuğuna Tıkla
    Given Arama Çubuğuna "lavanta kokulu Mum" yaz
    Given Enter Butonunu Tıkla
    Given Listelenenlerin Arasından Luxery Candle Lavanta Kokulu Mor Cam Mum Ürününe Tıkla
    When  Sepete Ekle
    Then  "Luxery Candle Lavanta Kokulu Mor Cam Mum " Ürününü Sapette gör
