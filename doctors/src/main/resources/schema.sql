CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido_paterno VARCHAR(255),
    apellido_materno VARCHAR(255),
    especialidad VARCHAR(255)
);

CREATE TABLE consultorios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero INT,
    piso INT
);

CREATE TABLE citas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    horario DATETIME,
    doctor_id BIGINT,
    consultorio_id INT,
    CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    CONSTRAINT fk_consultorio FOREIGN KEY (consultorio_id) REFERENCES consultorios(id)
);