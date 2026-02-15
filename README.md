# 🏁 Championship Management System

This project is a Spring Boot backend application developed as part of a class project.
It manages a motorsport championship environment (Formula 1 / MotoGP) and demonstrates
database design, entity relationships, and business logic implementation.

---

## 📌 Project Overview

The system allows management of:

- Championships  
- Teams (Equipes)  
- Drivers (Pilotes)  
- Sponsors  
- Contracts  
- Races & Positions  

---

## 🗄️ Main Entities

### Championship
- year  
- category (FORMULA1 / MOTOGP)  
- details  

### Team (Equipe)
- name  
- total points  
- ranking  

### Driver (Pilote)
- name  
- team  
- total points  
- ranking  

### Race (Course)
- date  
- location  

### Position
- race result per driver  
- points earned  

### Sponsor
- name  
- country  
- annual budget  
- contract status  

### Contract
- sponsor–team partnership  
- amount  
- year  

---

## ⚙️ Business Logic

### Sponsor Management

Add Sponsor
- dateCreation is automatically set to the system date.
- archived is initialized to false.
- bloquerContrat is initialized to false.

Add Multiple Sponsors
- Sponsors are processed one by one to ensure initialization rules are applied.

Modify Sponsor
- dateDerniereModification is automatically updated.

Archive Sponsor
- Sets archived to true instead of deleting the record.

Delete Sponsor
- Removes a sponsor by ID.

---

## 🛠️ Technologies Used

- Java  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MariaDB / MySQL  
- Maven  

---

## 📚 Learning Objectives

This project demonstrates:

- CRUD operations  
- Entity relationships with JPA  
- Service layer design  
- Business rule implementation  
- Database modeling  
- Clean architecture principles  

---

Made with ❤️ by Farah
