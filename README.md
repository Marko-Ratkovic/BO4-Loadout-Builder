This a fan-made Black Ops 4 multiplayer loadout builder website. Browse featured loadouts for every weapon in the game, with full Pick 10 breakdowns including attachments, optics, perks, gear, equipment, and wildcards. 
Important Disclaimer: This is an unofficial fan project inspired by codmunity.gg and there layout. I am not affiliated with Treyarch or Activision in anyway. Also, this website is meant to be used to store all the loadouts created or been created by YouTubes, streamers, contant creators, the community, etc. so no one has to remember their loadouts for all the weapons with attachments in the game because I know I didn't like it as the game is still populated.

Stack
  Backend: Java (Jakarta EE) · Apache Tomcat
  Frontend: JSP · JSTL · HTML/CSS
  Database: MySQL (MariaDB via XAMPP)
  IDE: Apache NetBeans

Features:
  Featured loadout cards for all 46 total weapons, including DLCs.
  Pick 10 system with dot indicator.
  Expandable cards showing full loadout details (attachments, optics, perks, gear, equipment, wildcards).
  Weapon images and attachment icons.
  Website style in the dark/orange theme of Black Ops 4.

Setup

Requirements:
  XAMPP (MySQL/MariaDB)
  Apache Tomcat 9+
  Apache NetBeans
  JDK 17+
  MySQL Connector/J JAR
  JSTL 1.2 JAR

Database
  1. Start XAMPP and make sure MySQL is running
  2. Open phpMyAdmin and create a database called bo4_loadouts
  3. Import schema.sql to create the tables
  4. Populate the tables with your own data

Project
  1. Clone the repo and open it in NetBeans as a Web Application project
  2. Add mysql-connector-j-*.jar and jstl-1.2.jar to your project Libraries
  3. In DBConnection.java, set your MySQL username and password if needed (default is root with no password)
  4. Place your weapon/attachment/perk images in web/images/
  5. Clean & Build, then Run
