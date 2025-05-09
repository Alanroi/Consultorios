INSERT INTO doctors (nombre, apellido_paterno, apellido_materno, especialidad) VALUES ('jose', 'Doe', 'Cluff', 'general');
INSERT INTO doctors (nombre, apellido_paterno, apellido_materno, especialidad) VALUES ('Ana', 'Lopez', 'Ramirez', 'general');
INSERT INTO doctors (nombre, apellido_paterno, apellido_materno, especialidad) VALUES ('Alan', 'Roi', 'Rodriguez', 'general');

INSERT INTO consultorios (numero, piso) VALUES (10,1);
INSERT INTO consultorios (numero, piso) VALUES (11,2);
INSERT INTO consultorios (numero, piso) VALUES (1,2);

INSERT INTO citas (nombre, horario, doctor_id, consultorio_id) VALUES ('pedro','2025-06-01 14:00:00', 3, 2);