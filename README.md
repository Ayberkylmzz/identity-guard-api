# IdentityGuard API - Kimlik Yönetim Sistemi

IdentityGuard, modern web uygulamaları için geliştirilmiş, güvenli ve ölçeklenebilir bir **Kimlik Yönetimi ve Yetkilendirme (Auth)** sistemidir. Spring Boot tabanlı katmanlı mimari ile geliştirilmiştir.

## 🚀 Teknolojiler
* **Java 21+**
* **Spring Boot 3.x**
* **Spring Security & JWT** (JSON Web Token)
* **Spring Data JPA**
* **MySQL / MSSQL** (Veritabanı desteği)
* **Lombok & ModelMapper** (DTO dönüşümleri için)

## 🏗️ Mimari Yapı
Proje, bağımlılıkları minimize etmek ve sürdürülebilirliği artırmak için katmanlı mimari (Layered Architecture) kullanılarak inşa edilmiştir:
- **API:** REST Controller katmanı.
- **Business:** Servis ve iş kuralları katmanı.
- **DataAccess:** Repository arayüzleri.
- **Entities:** Veritabanı modelleri.
- **Security:** JWT ve Role-based access control yapılandırmaları.

## 🛠️ Kurulum
1. Projeyi clonelayın: `git clone https://github.com/kullaniciadi/identity-guard-api.git`
2. `application.properties` dosyasındaki veritabanı ayarlarını kendinize göre düzenleyin.
3. Projeyi Maven ile build edin: `mvn clean install`
4. Uygulamayı çalıştırın.