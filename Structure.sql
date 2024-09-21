CREATE TABLE unit_oeuvre(
   id_unit_oeuvre DOUBLE PRECISION,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_unit_oeuvre)
);

CREATE TABLE Nature(
   id_nature INTEGER,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_nature)
);

CREATE TABLE Rubrique(
   id_rubrique INTEGER,
   Name VARCHAR(50) ,
   id_unit_oeuvre INTEGER,
   id_nature INTEGER,
   PRIMARY KEY(id_rubrique)
);

CREATE TABLE CoutCentre(
   id_centre INTEGER,
   total_cout_fixe NUMERIC(15,2)   NOT NULL,
   total_cout_variable NUMERIC(15,2)  ,
   total_cout_centre NUMERIC(15,2)  ,
   PRIMARY KEY(id_centre)
);

CREATE TABLE Centre(
   id_centre INTEGER,
   id_type_centre INTEGER NOT NULL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_centre)
);

CREATE TABLE Charge_finale(
   id_charge_finale INTEGER,
   id_rubrique INTEGER,
   total_montant NUMERIC(15,2)  ,
   PRIMARY KEY(id_charge_finale)
);

CREATE TABLE Detail_charge(
   id_charge_detail INTEGER,
   id_rubrique INTEGER,
   id_centre INTEGER,
   id_nature INTEGER,
   montant NUMERIC(15,2)  ,
   PRIMARY KEY(id_charge_detail)
);
