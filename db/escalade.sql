--
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "idVoie";
ALTER TABLE ONLY public."Longueur" DROP CONSTRAINT "idVoie";
ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "idTopo";
ALTER TABLE ONLY public."Pret" DROP CONSTRAINT "idTopo";
ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "idSite";
ALTER TABLE ONLY public."Secteur" DROP CONSTRAINT "idSite";
ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "idSecteur";
ALTER TABLE ONLY public."Voie" DROP CONSTRAINT "idSecteur";
ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "idLongueur";
ALTER TABLE ONLY public."Voie" DROP CONSTRAINT "Voie_pkey";
ALTER TABLE ONLY public."Topo" DROP CONSTRAINT "Topo_pkey";
ALTER TABLE ONLY public."Site" DROP CONSTRAINT "Site_pkey";
ALTER TABLE ONLY public."Secteur" DROP CONSTRAINT "Secteur_pkey";
ALTER TABLE ONLY public."Pret" DROP CONSTRAINT "Pret_pkey";
ALTER TABLE ONLY public."Longueur" DROP CONSTRAINT "Longueur_pkey";
ALTER TABLE ONLY public."Commentaire" DROP CONSTRAINT "Commentaire_pkey";
DROP TABLE public."Voie";
DROP TABLE public."Topo";
DROP TABLE public."Site";
DROP TABLE public."Secteur";
DROP TABLE public."Pret";
DROP TABLE public."Longueur";
DROP TABLE public."Commentaire";
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


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
-- Name: Commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Commentaire" (
    "idCommentaire" integer NOT NULL,
    "datePublication" date NOT NULL,
    "nomUtilisateur" "char"[] NOT NULL,
    contenu "char"[] NOT NULL,
    "idSite" integer NOT NULL,
    "idSecteur" integer NOT NULL,
    "idVoie" integer NOT NULL,
    "idLongueur" integer NOT NULL,
    "idTopo" integer NOT NULL
);


ALTER TABLE "Commentaire" OWNER TO postgres;

--
-- Name: Longueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Longueur" (
    "idLongueur" integer NOT NULL,
    cotation "char"[] NOT NULL,
    "nomRelais" "char"[] NOT NULL,
    hauteur integer NOT NULL,
    "idVoie" integer NOT NULL
);


ALTER TABLE "Longueur" OWNER TO postgres;

--
-- Name: Pret; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Pret" (
    "idPret" integer NOT NULL,
    "dateDebut" date NOT NULL,
    "dateFin" date NOT NULL,
    "nomEmprunteur" "char"[] NOT NULL,
    "emailEmprunteur" "char"[] NOT NULL,
    "nomDemandeur" "char"[] NOT NULL,
    "emailDemandeur" "char"[] NOT NULL,
    "idTopo" integer NOT NULL
);


ALTER TABLE "Pret" OWNER TO postgres;

--
-- Name: Secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Secteur" (
    "idSecteur" integer NOT NULL,
    hauteur integer NOT NULL,
    nom "char"[] NOT NULL,
    "idSite" integer
);


ALTER TABLE "Secteur" OWNER TO postgres;

--
-- Name: Site; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Site" (
    "idSite" integer NOT NULL,
    nom "char"[] NOT NULL,
    "emplacementGeo" "char"[] NOT NULL,
    hauteur integer NOT NULL,
    type "char"[] NOT NULL
);


ALTER TABLE "Site" OWNER TO postgres;

--
-- Name: Topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Topo" (
    "idTopo" integer NOT NULL,
    nom "char"[] NOT NULL,
    "nomAuteur" "char"[] NOT NULL,
    "dateSortie" date NOT NULL
);


ALTER TABLE "Topo" OWNER TO postgres;

--
-- Name: Voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Voie" (
    "idVoie" integer NOT NULL,
    nom "char"[] NOT NULL,
    "nomHauteurVoie" "char"[] NOT NULL,
    hauteur integer NOT NULL,
    "nbPoints" integer NOT NULL,
    etat "char"[] NOT NULL,
    "idSecteur" integer NOT NULL
);


ALTER TABLE "Voie" OWNER TO postgres;

--
-- Data for Name: Commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Commentaire" ("idCommentaire", "datePublication", "nomUtilisateur", contenu, "idSite", "idSecteur", "idVoie", "idLongueur", "idTopo") FROM stdin;
\.
COPY "Commentaire" ("idCommentaire", "datePublication", "nomUtilisateur", contenu, "idSite", "idSecteur", "idVoie", "idLongueur", "idTopo") FROM '$$PATH$$/2844.dat';

--
-- Data for Name: Longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Longueur" ("idLongueur", cotation, "nomRelais", hauteur, "idVoie") FROM stdin;
\.
COPY "Longueur" ("idLongueur", cotation, "nomRelais", hauteur, "idVoie") FROM '$$PATH$$/2845.dat';

--
-- Data for Name: Pret; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Pret" ("idPret", "dateDebut", "dateFin", "nomEmprunteur", "emailEmprunteur", "nomDemandeur", "emailDemandeur", "idTopo") FROM stdin;
\.
COPY "Pret" ("idPret", "dateDebut", "dateFin", "nomEmprunteur", "emailEmprunteur", "nomDemandeur", "emailDemandeur", "idTopo") FROM '$$PATH$$/2849.dat';

--
-- Data for Name: Secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Secteur" ("idSecteur", hauteur, nom, "idSite") FROM stdin;
\.
COPY "Secteur" ("idSecteur", hauteur, nom, "idSite") FROM '$$PATH$$/2846.dat';

--
-- Data for Name: Site; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Site" ("idSite", nom, "emplacementGeo", hauteur, type) FROM stdin;
\.
COPY "Site" ("idSite", nom, "emplacementGeo", hauteur, type) FROM '$$PATH$$/2843.dat';

--
-- Data for Name: Topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Topo" ("idTopo", nom, "nomAuteur", "dateSortie") FROM stdin;
\.
COPY "Topo" ("idTopo", nom, "nomAuteur", "dateSortie") FROM '$$PATH$$/2847.dat';

--
-- Data for Name: Voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Voie" ("idVoie", nom, "nomHauteurVoie", hauteur, "nbPoints", etat, "idSecteur") FROM stdin;
\.
COPY "Voie" ("idVoie", nom, "nomHauteurVoie", hauteur, "nbPoints", etat, "idSecteur") FROM '$$PATH$$/2848.dat';

--
-- Name: Commentaire Commentaire_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "Commentaire_pkey" PRIMARY KEY ("idCommentaire");


--
-- Name: Longueur Longueur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Longueur"
    ADD CONSTRAINT "Longueur_pkey" PRIMARY KEY ("idLongueur");


--
-- Name: Pret Pret_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Pret"
    ADD CONSTRAINT "Pret_pkey" PRIMARY KEY ("idPret");


--
-- Name: Secteur Secteur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Secteur"
    ADD CONSTRAINT "Secteur_pkey" PRIMARY KEY ("idSecteur");


--
-- Name: Site Site_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Site"
    ADD CONSTRAINT "Site_pkey" PRIMARY KEY ("idSite");


--
-- Name: Topo Topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Topo"
    ADD CONSTRAINT "Topo_pkey" PRIMARY KEY ("idTopo");


--
-- Name: Voie Voie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Voie"
    ADD CONSTRAINT "Voie_pkey" PRIMARY KEY ("idVoie");


--
-- Name: Commentaire idLongueur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "idLongueur" FOREIGN KEY ("idLongueur") REFERENCES "Longueur"("idLongueur");


--
-- Name: Voie idSecteur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Voie"
    ADD CONSTRAINT "idSecteur" FOREIGN KEY ("idSecteur") REFERENCES "Secteur"("idSecteur");


--
-- Name: Commentaire idSecteur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "idSecteur" FOREIGN KEY ("idSecteur") REFERENCES "Secteur"("idSecteur");


--
-- Name: Secteur idSite; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Secteur"
    ADD CONSTRAINT "idSite" FOREIGN KEY ("idSite") REFERENCES "Site"("idSite");


--
-- Name: Commentaire idSite; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "idSite" FOREIGN KEY ("idSite") REFERENCES "Site"("idSite");


--
-- Name: Pret idTopo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Pret"
    ADD CONSTRAINT "idTopo" FOREIGN KEY ("idTopo") REFERENCES "Topo"("idTopo");


--
-- Name: Commentaire idTopo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "idTopo" FOREIGN KEY ("idTopo") REFERENCES "Topo"("idTopo");


--
-- Name: Longueur idVoie; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Longueur"
    ADD CONSTRAINT "idVoie" FOREIGN KEY ("idVoie") REFERENCES "Voie"("idVoie");


--
-- Name: Commentaire idVoie; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Commentaire"
    ADD CONSTRAINT "idVoie" FOREIGN KEY ("idVoie") REFERENCES "Voie"("idVoie");


--
-- PostgreSQL database dump complete
--

