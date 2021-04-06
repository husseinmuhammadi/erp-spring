#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER firmco WITH PASSWORD '123456';
    CREATE DATABASE firmco;
    GRANT ALL PRIVILEGES ON DATABASE firmco TO firmco;
EOSQL

psql -v ON_ERROR_STOP=1 --username "firmco" --dbname "firmco" <<-EOSQL
    CREATE SCHEMA master;
EOSQL