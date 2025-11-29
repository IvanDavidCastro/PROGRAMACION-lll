# Tecnar SpringBoot (web rewrite of the desktop app)

This project is a Spring Boot REST API that reproduces the functionality of the uploaded Java desktop application (Clientes / Usuarios).
It provides three persistence backends selectable with Spring profiles:
- **supabase**: Postgres via Spring Data JPA (use your Supabase DB URL/credentials)
- **mongodb**: MongoDB via Spring Data MongoDB
- **firebase**: Google Firestore via Firebase Admin SDK (requires service account JSON)

How to run locally
------------------
1. Build with Maven:
   ```bash
   mvn -B package -DskipTests
   ```
2. Run with profile (example supabase):
   ```bash
   # supabase: set JDBC_DATABASE_URL, DB_USER, DB_PASS or use application.yml defaults
   java -jar target/tecnar-springboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=supabase
   ```
3. For MongoDB:
   ```bash
   java -jar target/tecnar-springboot-0.0.1-SNAPSHOT.jar --spring.profiles.active=mongodb
   ```
4. For Firebase (Firestore):
   - Set `GOOGLE_APPLICATION_CREDENTIALS` env var pointing to your service account JSON.
   - Activate profile `firebase` when running.

APIs
----
- `GET /api/clientes` - list
- `GET /api/clientes/{id}` - get
- `POST /api/clientes` - create
- `PUT /api/clientes/{id}` - update
- `DELETE /api/clientes/{id}` - delete

Deploy to Fly.io
----------------
1. Create fly app: `flyctl apps create your-app-name`
2. Build image and push or use `fly deploy` (it will use Dockerfile).
3. Set environment variables on Fly: DB connection string, or `GOOGLE_APPLICATION_CREDENTIALS` (securely) and the service account file via secrets or a storage solution.
4. Use `flyctl secrets set JDBC_DATABASE_URL=... DB_USER=... DB_PASS=...` or `MONGODB_URI=...`

Notes and TODOs
- Firebase: the project includes a Firestore-based service implementation but you must provide credentials.
- Authentication & Users: this skeleton focuses on Clientes endpoints. You can expand with Usuarios similarly.
- Provide CORS or frontend as needed.
