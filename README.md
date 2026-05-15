# 🛡️ IdentityGuard API

IdentityGuard, modern backend mimarisi (**8-Layer Architecture**) prensipleriyle geliştirilmiş, yüksek güvenlikli bir Kimlik Doğrulama (Authentication) ve Yetkilendirme (Authorization) servisidir. Proje, ölçeklenebilir ve sürdürülebilir bir altyapı sağlamak amacıyla Spring Boot ve JWT teknolojileri üzerine inşa edilmiştir.

## 🚀 Teknolojiler
* **Java 21** & **Spring Boot 3.x**
* **Spring Security 6** & **JWT (JSON Web Token)**
* **PostgreSQL**
* **Docker** & **Docker Compose**
* **Lombok**
* **Maven**

## 🏗️ Mimari Yapı (8-Layer Architecture)
Proje, kodun okunabilirliğini ve test edilebilirliğini artırmak için şu 8 ana katmandan oluşmaktadır:

1.  **Model:** Veritabanı tablolarını temsil eden POJO sınıfları.
2.  **Repository:** Veri erişim katmanı (Spring Data JPA).
3.  **Service:** İş mantığının (Business Logic) yürütüldüğü katman.
4.  **DTO (Data Transfer Object):** Katmanlar arası veri transferini sağlayan objeler.
5.  **Controller:** API uç noktalarını (Endpoints) yöneten katman.
6.  **Config:** Uygulama yapılandırmaları ve Bean tanımları.
7.  **Exception:** Global hata yönetimi ve merkezi hata yakalama sistemi.
8.  **Security:** JWT yönetimi, filtreleme ve güvenlik yapılandırmaları.

## 🔒 Temel Özellikler
* **Role Based Access Control (RBAC):** Kullanıcılara özel roller (USER, ADMIN) ve yetkilendirme sistemi.
* **Global Exception Handling:** Tüm hataların standart ve anlamlı bir JSON formatında kullanıcıya dönülmesi.
* **Duplicate Validation:** Aynı kullanıcı adı veya e-posta ile mükerrer kayıtların engellenmesi.
* **Environment Configuration:** Hassas verilerin `.env` dosyası üzerinden güvenli yönetimi.
* **Database Migration:** Otomatik şema yönetimi (Hibernate DDL-Auto).

## 🛠️ Kurulum ve Çalıştırma

### 1. Ön Gereksinimler
* Bilgisayarınızda **Docker** ve **Docker Compose** kurulu olmalıdır.

### 2. Ortam Değişkenlerini Ayarlayın
Proje ana dizininde bir `.env` dosyası oluşturun (bu dosya `.gitignore` tarafından korunmaktadır) ve aşağıdaki **örnek** yapılandırmayı kendinize göre doldurun:

```env
# Database
DB_USERNAME=your_db_user
DB_PASSWORD=your_db_password
DB_URL=jdbc:postgresql://identity-db:5432/identity_db

# Security
JWT_SECRET_KEY=your_32_character_long_secure_secret_key_here
JWT_EXPIRATION=86400000

# Server
SERVER_PORT=8081

# Spring
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_APPLICATION_NAME=identity-guard-api