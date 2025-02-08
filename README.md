Task Reminder App ⏰📧
- A Task Reminder App that helps users manage tasks efficiently by sending automated email reminders before deadlines. 
- The app includes user authentication, stores data in a PostgreSQL database, and is built using Java Servlets.

Features 🚀
✅ User Authentication – Secure login and registration.
✅ Task Management – Add, update, and delete tasks.
✅ Automated Email Reminders – Sends alerts before task deadlines.
✅ PostgreSQL Integration – Stores user data and tasks in a relational database.
✅ User-Friendly Interface – Simple and easy to navigate.
✅ All Required JAR Files Provided – No need to search for dependencies.
✅ Apache Tomcat Support – Includes catalina.jar for smooth deployment.

Tech Stack 🛠
-Backend: Java Servlets
-Database: PostgreSQL
-Email Service: JavaMail API
-Frontend: HTML, CSS, JavaScript
-Server: Apache Tomcat

JAR Dependencies 📦
The following JAR files are included in the lib/ folder:

-PostgreSQL JDBC Driver (postgresql.jar)
-JavaMail API (javax.mail.jar)
-GSON (gson.jar for JSON parsing)
-Servlet API (javax.servlet.jar)
-Apache Tomcat Core (catalina.jar)
-Additional Libraries required for smooth execution

Installation & Setup 💻
1️⃣ Clone the repository
  Copy code: git clone https://github.com/Rishabanath/Task-Reminder-App.git
2️⃣ Import the project into your preferred Java IDE (IntelliJ/Eclipse).
3️⃣ Set up PostgreSQL
  Install PostgreSQL and create a new database.
  Run the provided SQL script to create tables.
  Update database connection details in config.properties.
4️⃣ Configure JavaMail API
  Set up an SMTP server (e.g., Gmail SMTP).
5️⃣ Run the application on Apache Tomcat.

How It Works ⚙️
-User registers & logs in.
-Tasks are created & stored in Postgre.
-The system checks deadlines and sends automated email reminders.
-Users can modify or delete tasks as needed.

Future Enhancements ✨
-Implement push notifications for real-time reminders.
-Add calendar integration for better task visualization.
-Introduce multi-user collaboration for shared tasks.

🔥 Feel free to contribute! If you find this useful, ⭐ star the repository! 😊

Would you like any modifications or additions? 🚀
