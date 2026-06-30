CREATE DATABASE usuario_db;
CREATE DATABASE donaciones_db;
CREATE DATABASE logistica_db;
CREATE DATABASE necesidades_db;

CREATE USER 'usuario'@'%' IDENTIFIED BY 'usuario123';
GRANT ALL PRIVILEGES ON usuario_db.* TO 'usuario'@'%';

CREATE USER 'donaciones'@'%' IDENTIFIED BY 'donaciones123';
GRANT ALL PRIVILEGES ON donaciones_db.* TO 'donaciones'@'%';

CREATE USER 'logistica'@'%' IDENTIFIED BY 'logistica123';
GRANT ALL PRIVILEGES ON logistica_db.* TO 'logistica'@'%';

CREATE USER 'necesidades'@'%' IDENTIFIED BY 'necesidades123';
GRANT ALL PRIVILEGES ON necesidades_db.* TO 'necesidades'@'%';