FROM postgres:9.6

COPY ./images/postgres/data/tables.sql /docker-entrypoint-initdb.d/tables.sql

COPY ./images/postgres/data/insertions.sql /docker-entrypoint-initdb.d/insertions.sql