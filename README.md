# CaesarCipherEncryptor

A secured, session-based, fault-tolerant, and database-driven Java EE web application developed for the National Security Agency to facilitate secure message encryption and decryption using the Caesar Encryption Technique (CET).

## Features

### 1. Security
- Implements role-based access control with three roles:
  - **Administrator** — can create system users and store their credentials in a file realm.
    - Field Agent: `field_agent` / `123` / role: `agent`
    - Agent Manager: `agent_manager` / `123` / role: `manager`
  - **Field Agent** — can:
    - Log in
    - Enter a plaintext message
    - Encrypt it using CET
    - Send the encrypted message (ciphertext) to the server for storage in the database
    - Each stored message includes:
      - Agent's 3-digit unique ID code
      - Ciphertext
      - Timestamp
    - Log out
  - **Agent Manager** — can:
    - Log in
    - View all messages in decrypted format
    - View details of the best-performing field agent (the one who sent the most messages), including ID code and message count
    - Log out

### 2. System Robustness
- Handles:
  - Unauthenticated access attempts
  - Unauthorized access to restricted functionalities
  - Requests for non-existent resources
  - Invalid agent ID codes (non-numeric or not exactly 3 digits)
- Displays appropriate error messages

### 3. Personalization
- Addresses users by their name throughout the session
- At session start, prompts for:
  - Name
  - Unique 3-digit agent ID code
- Uses "Siri" as the system/computer name (stored in the DD file)

### 4. Session Management
- Conversational web application using HTTP sessions to maintain state between client and server

### 5. Database-Driven
- Stores and retrieves all relevant data from the database
- Database credentials:
  - **Username:** `app`
  - **Password:** `123`
  - **Database name:** `TechnoByteSolutionsDB`

## Encryption & Decryption Logic

### Caesar Encryption Technique (CET)
- Converts plaintext to lowercase
- Replaces each letter with the letter three positions ahead in the alphabet
  - Example: `hello world!` → `khoor zruog!`

### Caesar Decryption Technique (CDT)
- Replaces each letter with the letter three positions behind in the alphabet
  - Example: `khoor zruog!` → `hello world!`

## Technologies Used
- **Backend:** Java EE (EJB, Servlets, JSP)
- **Application Server:** GlassFish / Payara
- **Development Environment:** NetBeans IDE
- **Database:** JDBC for database operations
- **Frontend:** HTML, CSS
- **Security:** File Realm for authentication

## Installation & Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/MzWan1/CaesarCipherEncryptor.git
