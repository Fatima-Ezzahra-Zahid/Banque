PGDMP     7                    y           Clients    13.1    13.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16444    Clients    DATABASE     e   CREATE DATABASE "Clients" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE "Clients";
                postgres    false            �            1259    16490    comptebanque    TABLE     �   CREATE TABLE public.comptebanque (
    id_banq integer NOT NULL,
    nom character varying(250),
    numerocompt integer,
    solde double precision,
    id_type integer
);
     DROP TABLE public.comptebanque;
       public         heap    postgres    false            �            1259    16488    comptebanque_id_seq    SEQUENCE     �   ALTER TABLE public.comptebanque ALTER COLUMN id_banq ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.comptebanque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    204            �            1259    16502    personne    TABLE     s   CREATE TABLE public.personne (
    id integer NOT NULL,
    prenom character varying(250),
    id_compt integer
);
    DROP TABLE public.personne;
       public         heap    postgres    false            �            1259    16500    personne_id_seq    SEQUENCE     �   ALTER TABLE public.personne ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.personne_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    206            �            1259    16465    table_clients_id_seq    SEQUENCE     }   CREATE SEQUENCE public.table_clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.table_clients_id_seq;
       public          postgres    false            �            1259    16457    table_type_id_seq    SEQUENCE     z   CREATE SEQUENCE public.table_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.table_type_id_seq;
       public          postgres    false            �            1259    16459 	   typecompt    TABLE     �   CREATE TABLE public.typecompt (
    id integer DEFAULT nextval('public.table_type_id_seq'::regclass) NOT NULL,
    nom_type character varying(250)
);
    DROP TABLE public.typecompt;
       public         heap    postgres    false    200            �          0    16490    comptebanque 
   TABLE DATA           Q   COPY public.comptebanque (id_banq, nom, numerocompt, solde, id_type) FROM stdin;
    public          postgres    false    204   c       �          0    16502    personne 
   TABLE DATA           8   COPY public.personne (id, prenom, id_compt) FROM stdin;
    public          postgres    false    206          �          0    16459 	   typecompt 
   TABLE DATA           1   COPY public.typecompt (id, nom_type) FROM stdin;
    public          postgres    false    201   5       �           0    0    comptebanque_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.comptebanque_id_seq', 53, true);
          public          postgres    false    203            �           0    0    personne_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.personne_id_seq', 17, true);
          public          postgres    false    205            �           0    0    table_clients_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.table_clients_id_seq', 3, true);
          public          postgres    false    202            �           0    0    table_type_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.table_type_id_seq', 4, true);
          public          postgres    false    200            4           2606    16494    comptebanque comptebanque_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.comptebanque
    ADD CONSTRAINT comptebanque_pkey PRIMARY KEY (id_banq);
 H   ALTER TABLE ONLY public.comptebanque DROP CONSTRAINT comptebanque_pkey;
       public            postgres    false    204            6           2606    16506    personne personne_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.personne DROP CONSTRAINT personne_pkey;
       public            postgres    false    206            2           2606    16464    typecompt typecompt_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.typecompt
    ADD CONSTRAINT typecompt_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.typecompt DROP CONSTRAINT typecompt_pkey;
       public            postgres    false    201            8           2606    16507    personne fk_compt    FK CONSTRAINT     �   ALTER TABLE ONLY public.personne
    ADD CONSTRAINT fk_compt FOREIGN KEY (id_compt) REFERENCES public.comptebanque(id_banq) ON DELETE CASCADE;
 ;   ALTER TABLE ONLY public.personne DROP CONSTRAINT fk_compt;
       public          postgres    false    206    2868    204            7           2606    16495    comptebanque fk_type    FK CONSTRAINT     �   ALTER TABLE ONLY public.comptebanque
    ADD CONSTRAINT fk_type FOREIGN KEY (id_type) REFERENCES public.typecompt(id) ON DELETE CASCADE;
 >   ALTER TABLE ONLY public.comptebanque DROP CONSTRAINT fk_type;
       public          postgres    false    2866    201    204            �   �   x�}�A!E��0fhA�����qӄ1�
Nb�pzGQ�����Wd��H��(� �)������������Ķ���4K�B�\aR�jcW��%u�WS7>IuI�-�m��\�Cd���_�%��7��䶹B�AF$��mR��R�b9`      �      x�34���45����� 9=      �   %   x�3�H-*���K�2�t�+)J-(�,N����� ���     