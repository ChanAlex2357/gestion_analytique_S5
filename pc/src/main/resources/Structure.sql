-- creation of the database 
CREATE DATABASE business_management ;
\c business_management ;

--creation of the tables
CREATE TABLE unit_oeuvre(
   id_unit_oeuvre SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_unit_oeuvre)
);

CREATE TABLE Nature(
   id_nature SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_nature)
);

CREATE TABLE Rubrique(
   id_rubrique SERIAL,
   Name VARCHAR(50) ,
   id_unit_oeuvre INTEGER,
   id_nature INTEGER,
   PRIMARY KEY(id_rubrique),
   FOREIGN KEY (id_unit_oeuvre) REFERENCES unit_oeuvre(id_unit_oeuvre),
   FOREIGN KEY (id_nature) REFERENCES nature(id_nature)
);

CREATE TABLE CoutCentre(
   id_centre SERIAL,
   total_cout_fixe NUMERIC(15,2) ,
   total_cout_variable NUMERIC(15,2) ,
   total_cout_centre NUMERIC(15,2)  ,
   PRIMARY KEY(id_centre)
);

CREATE TABLE type_centre(
   id_type_centre SERIAL PRIMARY KEY,
   name VARCHAR(25)
);

CREATE TABLE Centre(
   id_centre SERIAL,
   id_type_centre INTEGER NOT NULL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_centre),
   FOREIGN KEY (id_type_centre) REFERENCES type_centre(id_type_centre) 
);

CREATE TABLE Charge_finale(
   id_charge_finale SERIAL,
   id_rubrique INTEGER,
   total_montant NUMERIC(15,2)  ,
   PRIMARY KEY(id_charge_finale),
   FOREIGN KEY (id_rubrique) REFERENCES rubrique(id_rubrique)
);

CREATE TABLE Detail_charge(
   id_charge_detail SERIAL,
   id_rubrique INTEGER,
   id_centre INTEGER,
   montant NUMERIC(15,2)  ,
   PRIMARY KEY(id_charge_detail),
   FOREIGN KEY (id_rubrique) REFERENCES rubrique(id_rubrique),
   FOREIGN KEY (id_centre) REFERENCES centre(id_centre),
   FOREIGN KEY (id_nature) REFERENCES nature(id_nature)
);
