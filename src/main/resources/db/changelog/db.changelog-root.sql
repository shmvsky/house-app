--liquibase formatted sql

--changeset shmvky:create-usrs-table dbms:postgresql
CREATE TABLE usrs
(
    id       BIGINT NOT NULL,
    name     VARCHAR(255),
    age      INTEGER,
    password VARCHAR(255),
    CONSTRAINT pk_usrs PRIMARY KEY (id)
);

CREATE SEQUENCE usrs_seq
    start 1
    increment 50;

--changeset shmvky:create-houses-table dbms:postgresql
CREATE TABLE houses
(
    id       BIGINT NOT NULL,
    address  VARCHAR(255),
    owner_id BIGINT,
    CONSTRAINT pk_houses PRIMARY KEY (id)
);

CREATE SEQUENCE houses_seq
    start 1
    increment 50;

--changeset shmvky:create-relationships dbms:postgresql
CREATE TABLE usrs_houses
(
    house_id BIGINT NOT NULL,
    user_id  BIGINT NOT NULL,
    CONSTRAINT pk_users_houses PRIMARY KEY (house_id, user_id)
);

ALTER TABLE usrs_houses
    ADD CONSTRAINT fk_usehou_on_house FOREIGN KEY (house_id) REFERENCES houses (id);

ALTER TABLE usrs_houses
    ADD CONSTRAINT fk_usehou_on_user FOREIGN KEY (user_id) REFERENCES usrs (id);

ALTER TABLE houses
    ADD CONSTRAINT FK_HOUSES_ON_OWNER FOREIGN KEY (owner_id) REFERENCES usrs (id);
