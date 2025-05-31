CREATE TABLE warehouse (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    count_line INT
);

CREATE TABLE line (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    warehouse_id BIGINT
);

CREATE TABLE shelf (
    id BIGSERIAL PRIMARY KEY,
    line_id BIGINT
);

CREATE TABLE floor_zone (
    id BIGSERIAL PRIMARY KEY,
    warehouse_id BIGINT
);

CREATE TABLE container (
    id BIGSERIAL PRIMARY KEY
);

CREATE TABLE storage (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    capacity INT
);

CREATE TABLE transport_container (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE cell (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    transport_container_id BIGINT,
    storage_id BIGINT
);

CREATE TABLE application (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    data TEXT,
    type_id BIGINT,
    cell_id BIGINT,
    status_id BIGINT,
    author_id BIGINT,
    approver_id BIGINT
);

CREATE TABLE type (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    terminal BOOLEAN
);

CREATE TABLE status (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    terminal BOOLEAN
);

CREATE TABLE user_table (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    login VARCHAR(255),
    password VARCHAR(255),
    role_id BIGINT
);

CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);