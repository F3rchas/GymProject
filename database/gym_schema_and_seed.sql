-- =====================================================
-- Gym Backend - PostgreSQL Schema & Initial Seed Data
-- Database: gym_db
-- =====================================================

CREATE TABLE IF NOT EXISTS miembros (
    id_miembro VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    celular BIGINT,
    correo_electronico VARCHAR(150) UNIQUE,
    password VARCHAR(255) NOT NULL,
    estado BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS planes (
    id_plan SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE PRECISION NOT NULL,
    duracion_dias INTEGER NOT NULL,
    estado BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS membresias (
    id_membresia SERIAL PRIMARY KEY,
    id_miembro VARCHAR(50) NOT NULL,
    fecha_inicio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    medio_pago VARCHAR(50),
    comentario VARCHAR(255),
    estado VARCHAR(30) DEFAULT 'ACTIVA',
    CONSTRAINT fk_membresias_miembro
        FOREIGN KEY (id_miembro) REFERENCES miembros (id_miembro)
);

CREATE TABLE IF NOT EXISTS membresias_planes (
    id_membresia INTEGER NOT NULL,
    id_plan INTEGER NOT NULL,
    cantidad INTEGER NOT NULL DEFAULT 1,
    total DOUBLE PRECISION NOT NULL,
    estado BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id_membresia, id_plan),
    CONSTRAINT fk_mp_membresia
        FOREIGN KEY (id_membresia) REFERENCES membresias (id_membresia) ON DELETE CASCADE,
    CONSTRAINT fk_mp_plan
        FOREIGN KEY (id_plan) REFERENCES planes (id_plan)
);

-- =====================================================
-- Initial Plans (Catalog Seed)
-- =====================================================
INSERT INTO planes (nombre, precio, duracion_dias, estado)
VALUES
    ('Plan Mensual Full', 650.00, 30, TRUE),
    ('Plan Trimestral', 1750.00, 90, TRUE),
    ('Entrenador Personal (4 sesiones)', 500.00, 30, TRUE),
    ('Renta de Locker', 150.00, 30, TRUE)
ON CONFLICT DO NOTHING;
