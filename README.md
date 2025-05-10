# Blog Backend (Spring Boot + H2 + JPA)

Dieses Repository enthält ausschließlich den Backend-Teil eines einfachen Blog-Systems, das mit **Spring Boot**, **H2-Datenbank**, **Spring Security** und **JPA** umgesetzt wurde. Ziel ist es nun darauf aufbauend ein eigenes **Frontend mit Angular** zu entwickeln.

---

## Voraussetzungen

- Java 17 oder höher
- Git
- (Optional) IntelliJ IDEA oder eine andere Java-IDE

---

## Projekt klonen

```bash
git clone https://github.com/mbahara/blog.git
cd blog
```

---

## ▶️ Backend starten

```bash
./mvnw spring-boot:run
```

Das Backend startet standardmäßig unter:

```
http://localhost:8080
```

---

## API-Endpunkte (Beispielhaft)

- `POST /api/auth/login` → Login mit JSON `{ login, password }`
- `GET /api/articles` → Liste aller Artikel
- `POST /api/articles/{id}/comments` → Kommentar zum Artikel hinzufügen

---

## H2-Konsole (Datenbank-Web-GUI)

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- Benutzername: `sa`
- Passwort: *(leer lassen)*

---

## Ziel

1. Ein eigenes Angular-Frontend entwickeln, das über HTTP mit dem Backend kommuniziert.
2. Folgende Features abbilden:
   - Loginmaske
   - Artikelliste mit Detailansicht
   - Kommentarabgabe nach Login
   - Suchfunktion nach Artikeltitel

---

## Hinweise

- Der Code ist modular aufgebaut (DTOs, Services, Repositories).
- Die Datenbank ist **in-memory** (H2), d. h. Änderungen bleiben nur während der Laufzeit erhalten.
- Bitte einmal die SQL-Anweisungen in der `resource`-Ordner laufen lassen, damit einge Dummy Daten vorhanden sind.

---

## Lizenz

MIT License – Nutzung für Lehrzwecke erlaubt.
