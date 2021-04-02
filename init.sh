#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER eap WITH PASSWORD '123456';
    CREATE DATABASE eap;
    GRANT ALL PRIVILEGES ON DATABASE eap TO eap;
EOSQL

psql -v ON_ERROR_STOP=1 --username "eap" --dbname "eap" <<-EOSQL
    CREATE SCHEMA eap;
EOSQL