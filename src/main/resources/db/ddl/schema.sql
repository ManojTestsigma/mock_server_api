CREATE TABLE configuration
(
    id            BIGINT auto_increment PRIMARY KEY,
    tenant_id     BIGINT,
    uri_path      TEXT NOT NULL,
    method   VARCHAR(16) NOT NULL,
    request_body  TEXT,
    delay         BIGINT,
    response_body TEXT,
    status_code   INT NOT NULL
);