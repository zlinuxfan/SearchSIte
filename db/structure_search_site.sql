--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: main; Type: TABLE; Schema: public; Owner: searh_site_user
--

CREATE TABLE main (
    id integer NOT NULL,
    name bytea NOT NULL,
    is_filled boolean DEFAULT false NOT NULL
);


ALTER TABLE main OWNER TO searh_site_user;

--
-- Name: main_id_seq; Type: SEQUENCE; Schema: public; Owner: searh_site_user
--

CREATE SEQUENCE main_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE main_id_seq OWNER TO searh_site_user;

--
-- Name: main_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: searh_site_user
--

ALTER SEQUENCE main_id_seq OWNED BY main.id;


--
-- Name: similar_results; Type: TABLE; Schema: public; Owner: searh_site_user
--

CREATE TABLE similar_results (
    id integer NOT NULL,
    name bytea NOT NULL,
    relation_request bytea NOT NULL
);


ALTER TABLE similar_results OWNER TO searh_site_user;

--
-- Name: similar_results_id_seq; Type: SEQUENCE; Schema: public; Owner: searh_site_user
--

CREATE SEQUENCE similar_results_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE similar_results_id_seq OWNER TO searh_site_user;

--
-- Name: similar_results_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: searh_site_user
--

ALTER SEQUENCE similar_results_id_seq OWNED BY similar_results.id;


--
-- Name: urls; Type: TABLE; Schema: public; Owner: searh_site_user
--

CREATE TABLE urls (
    id integer NOT NULL,
    name bytea NOT NULL,
    link character varying(255) NOT NULL,
    url character varying(255) NOT NULL,
    description character varying(255) NOT NULL
);


ALTER TABLE urls OWNER TO searh_site_user;

--
-- Name: urls_id_seq; Type: SEQUENCE; Schema: public; Owner: searh_site_user
--

CREATE SEQUENCE urls_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE urls_id_seq OWNER TO searh_site_user;

--
-- Name: urls_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: searh_site_user
--

ALTER SEQUENCE urls_id_seq OWNED BY urls.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY main ALTER COLUMN id SET DEFAULT nextval('main_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY similar_results ALTER COLUMN id SET DEFAULT nextval('similar_results_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY urls ALTER COLUMN id SET DEFAULT nextval('urls_id_seq'::regclass);


--
-- Name: main_pkey; Type: CONSTRAINT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY main
    ADD CONSTRAINT main_pkey PRIMARY KEY (name);


--
-- Name: similar_results_pkey; Type: CONSTRAINT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY similar_results
    ADD CONSTRAINT similar_results_pkey PRIMARY KEY (name);


--
-- Name: urls_pkey; Type: CONSTRAINT; Schema: public; Owner: searh_site_user
--

ALTER TABLE ONLY urls
    ADD CONSTRAINT urls_pkey PRIMARY KEY (name);


--
-- Name: main_id_uindex; Type: INDEX; Schema: public; Owner: searh_site_user
--

CREATE UNIQUE INDEX main_id_uindex ON main USING btree (id);


--
-- Name: similar_results_id_uindex; Type: INDEX; Schema: public; Owner: searh_site_user
--

CREATE UNIQUE INDEX similar_results_id_uindex ON similar_results USING btree (id);


--
-- Name: similar_results_relation_request_uindex; Type: INDEX; Schema: public; Owner: searh_site_user
--

CREATE UNIQUE INDEX similar_results_relation_request_uindex ON similar_results USING btree (relation_request);


--
-- Name: urls_id_uindex; Type: INDEX; Schema: public; Owner: searh_site_user
--

CREATE UNIQUE INDEX urls_id_uindex ON urls USING btree (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

