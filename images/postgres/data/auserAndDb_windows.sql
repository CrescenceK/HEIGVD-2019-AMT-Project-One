DROP DATABASE IF EXISTS "GestionDesCours";
DROP USER IF EXISTS amtprojet1;

--User: amtprojet1
CREATE USER amtprojet1 WITH ENCRYPTED PASSWORD 'pswrd' 
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;

--Database: Gestion des cours
CREATE DATABASE "GestionDesCours"
    WITH
    OWNER = amtprojet1
    ENCODING = 'UTF-8'
    LC_COLLATE = 'French_Switzerland.1252'
    LC_CTYPE = 'French_Switzerland.1252'
    CONNECTION LIMIT = -1
    TEMPLATE template0;
