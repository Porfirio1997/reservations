-- =========================
-- CLIENT
-- =========================
CREATE TABLE client (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(20),
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- CPF deve ser único
CREATE UNIQUE INDEX uk_client_cpf ON client (cpf);

-- =========================
-- LOCATION
-- =========================
CREATE TABLE location (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255),
    tipo VARCHAR(100),
    descricao TEXT,
    valor_hora NUMERIC(10,2),
    tempo_minimo TIMESTAMP,
    tempo_maximo TIMESTAMP,
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

-- =========================
-- RESERVATION
-- =========================
CREATE TABLE reservation (
    id BIGSERIAL PRIMARY KEY,
    location_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    data_inicio TIMESTAMP WITH TIME ZONE NOT NULL,
    data_fim TIMESTAMP WITH TIME ZONE NOT NULL,
    valor_final NUMERIC(10,2),
    situacao VARCHAR(50),
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_reservation_location
        FOREIGN KEY (location_id)
        REFERENCES location (id),

    CONSTRAINT fk_reservation_client
        FOREIGN KEY (client_id)
        REFERENCES client (id),

    CONSTRAINT chk_reservation_data
        CHECK (data_fim > data_inicio)
);

-- =========================
-- INDEXES
-- =========================
CREATE INDEX idx_reservation_location_id ON reservation (location_id);
CREATE INDEX idx_reservation_client_id ON reservation (client_id);
CREATE INDEX idx_reservation_data_inicio ON reservation (data_inicio);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);