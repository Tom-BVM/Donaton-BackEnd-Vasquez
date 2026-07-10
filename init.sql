CREATE DATABASE IF NOT EXISTS donaciones_db;
CREATE DATABASE IF NOT EXISTS logistica_db;
CREATE DATABASE IF NOT EXISTS necesidades_db;
CREATE DATABASE IF NOT EXISTS usuario_db;

CREATE USER IF NOT EXISTS 'donaciones'@'%' IDENTIFIED BY 'donaciones123';
GRANT ALL PRIVILEGES ON donaciones_db.* TO 'donaciones'@'%';

CREATE USER IF NOT EXISTS 'logistica'@'%' IDENTIFIED BY 'logistica123';
GRANT ALL PRIVILEGES ON logistica_db.* TO 'logistica'@'%';

CREATE USER IF NOT EXISTS 'necesidades'@'%' IDENTIFIED BY 'necesidades123';
GRANT ALL PRIVILEGES ON necesidades_db.* TO 'necesidades'@'%';

CREATE USER IF NOT EXISTS 'usuario'@'%' IDENTIFIED BY 'usuario123';
GRANT ALL PRIVILEGES ON usuario_db.* TO 'usuario'@'%';

FLUSH PRIVILEGES;
