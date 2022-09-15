--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Table: public.produto

-- DROP TABLE IF EXISTS public.produto;

CREATE TABLE IF NOT EXISTS public.produto
(
    codigo integer NOT NULL,
    nome text COLLATE pg_catalog."default",
    tipo text COLLATE pg_catalog."default",
    CONSTRAINT produto_pkey PRIMARY KEY (codigo)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.produto
    OWNER to ti2cc;