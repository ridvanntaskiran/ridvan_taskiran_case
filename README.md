
Aşağıdaki README dosyası, test otomasyonu projenin amacını, gereksinimlerini ve test senaryolarını içermektedir. Bu dosya projenin anlaşılır ve sürdürülebilir olması için önemlidir. 🎯

📝 QA Automation Testing
Bu proje, Kariyer Sayfası Test Otomasyonu için Selenium WebDriver, TestNG ve Java kullanılarak geliştirilmiştir.
Test senaryoları, web sitesi üzerindeki kariyer sayfası ve iş ilanlarıyla ilgili çeşitli doğrulamaları içermektedir.

📌 Projenin Amacı
Bu test otomasyonu projesi, Insider kariyer sayfasındaki iş ilanlarının doğruluğunu test etmek ve ilgili sayfalara başarılı bir şekilde yönlendirme yapıldığını kontrol etmek için geliştirilmiştir.

⚙️ Kullanılan Teknolojiler ve Araçlar
Java - Test otomasyonu için
Selenium WebDriver - Web elementlerini test etmek için
TestNG - Test framework
Maven - Bağımlılık yönetimi
WebDriverManager - WebDriver yönetimi
POM (Page Object Model) - Modüler yapı için

🛠️ Kurulum & Çalıştırma
1️⃣ Gereksinimler
Projenin çalıştırılabilmesi için aşağıdaki yazılımların sistemde kurulu olması gerekmektedir:

Java JDK 8 veya üstü
Maven
Google Chrome & ChromeDriver

✅ Test Senaryoları
Aşağıdaki test senaryoları uygulanmaktadır:

1️⃣ Insider Anasayfa Kontrolü
[✅] WEB sayfasına gidilir.
[✅] Ana Sayfanın açıldığı doğrulanır.

2️⃣ Kariyer Sayfası & İçerik Doğrulama
[✅] Navigasyon menüsündeki Company seçilir.
[✅] Açılan menüden Careers sayfasına gidilir.
[✅] Locations, Teams ve Life at Insider bloklarının görüntülendiği doğrulanır.

3️⃣ İş İlanlarını Filtreleme
[✅] https://useinsider.com/careers/quality-assurance/ sayfasına gidilir.
[✅] "See all QA jobs" butonuna tıklanır.
[✅] Lokasyon: "Istanbul, Turkey", Departman: "Quality Assurance" olarak filtreleme yapılır.
[✅] İş ilanlarının listelendiği doğrulanır.

4️⃣ İş İlanı Detaylarının Doğrulanması
[✅] Tüm iş ilanlarının:
Pozisyon: "Quality Assurance" içerdiği doğrulanır.
Departman: "Quality Assurance" içerdiği doğrulanır.
Lokasyon: "Istanbul, Turkey" içerdiği doğrulanır.

5️⃣ "View Role" Butonu & Lever Uygulama Sayfasına Yönlendirme
[✅] "View Role" butonuna tıklanır.
[✅] Yeni açılan sekmede, yönlendirmenin Lever Application form sayfasına yapıldığı doğrulanır.
