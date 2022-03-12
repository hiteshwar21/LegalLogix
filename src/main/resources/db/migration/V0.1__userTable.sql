CREATE TABLE advocate(
    id INTEGER PRIMARY KEY,
    user_name VARCHAR(50),
    name VARCHAR(50),
    password VARCHAR(30),
    email VARCHAR(255),
    phone_number INTEGER,
    address VARCHAR(512),
    date_created DATE DEFAULT now(),
    date_modified DATE DEFAULT now()
);

CREATE SEQUENCE advocate_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE clients(
    id INTEGER PRIMARY KEY,
    adv_id INTEGER,
    client_name VARCHAR(50),
    Address VARCHAR(255),
    Phone_number INTEGER,
    Date_created DATE DEFAULT now(),
    Date_modified DATE DEFAULT now(),
    Email VARCHAR(256),
    active BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_adv_id FOREIGN KEY (adv_id) REFERENCES advocate (id)
);

CREATE SEQUENCE clients_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE court_hearing(
    id INTEGER PRIMARY KEY,
    client_id INTEGER,
    charged_section INTEGER,
    Hearing_date DATE DEFAULT now(),
    Hours_spent TIME,
    active BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE SEQUENCE court_hearing_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE document_request(
    id INTEGER PRIMARY KEY,
    client_id INTEGER,
    adv_id INTEGER,
    original_path VARCHAR(512),
    key VARCHAR(512),
    processed_path VARCHAR(512),
    name VARCHAR(256),
    extension VARCHAR(128),
    total_pages INTEGER,
    date_created DATE DEFAULT now(),
    date_modified DATE DEFAULT now(),
    deleted BOOLEAN DEFAULT FALSE,
    active BOOLEAN DEFAULT TRUE,
    status INTEGER,
    doc_type INTEGER,
    CONSTRAINT fk_client_id FOREIGN KEY (client_id) REFERENCES clients (id),
    CONSTRAINT fk_adv_id FOREIGN KEY (adv_id) REFERENCES advocate (id)
);

CREATE SEQUENCE document_request_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE ipc_section(
    id INTEGER PRIMARY KEY,
    name VARCHAR(500),
    description TEXT,
    punishment_range INTEGER,
    fine_range INTEGER
);

CREATE SEQUENCE ipc_section_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;