CREATE TABLE UnitOeuvre(
   id_unit_oeuvre DOUBLE PRECISION,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_unit_oeuvre)
);

CREATE TABLE Nature(
   id_nature INTEGER,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_nature)
);

CREATE TABLE TypeCharge(
   Id_TypeCharge SERIAL,
   name VARCHAR(50) ,
   PRIMARY KEY(Id_TypeCharge)
);

CREATE TABLE Produit(
   Id_Produit SERIAL,
   name VARCHAR(50)  NOT NULL,
   PRIMARY KEY(Id_Produit)
);

CREATE TABLE Production(
   Id_Production SERIAL,
   date_production DATE NOT NULL,
   quantite NUMERIC(15,2)   NOT NULL,
   Id_Produit INTEGER NOT NULL,
   PRIMARY KEY(Id_Production),
   FOREIGN KEY(Id_Produit) REFERENCES Produit(Id_Produit)
);

CREATE TABLE Type_Centre(
   id_type_centre SERIAL,
   PRIMARY KEY(id_type_centre)
);

CREATE TABLE TypeCentreProduction(
   id_type_centre_production SERIAL,
   designation VARCHAR(50)  NOT NULL,
   PRIMARY KEY(id_type_centre_production)
);

CREATE TABLE Rubrique(
   id_rubrique INTEGER,
   Name VARCHAR(50) ,
   Id_TypeCharge INTEGER NOT NULL,
   id_nature INTEGER NOT NULL,
   id_unit_oeuvre DOUBLE PRECISION NOT NULL,
   PRIMARY KEY(id_rubrique),
   FOREIGN KEY(Id_TypeCharge) REFERENCES TypeCharge(Id_TypeCharge),
   FOREIGN KEY(id_nature) REFERENCES Nature(id_nature),
   FOREIGN KEY(id_unit_oeuvre) REFERENCES UnitOeuvre(id_unit_oeuvre)
);

CREATE TABLE Centre(
   id_centre INTEGER,
   name VARCHAR(50)  NOT NULL,
   id_type_centre INTEGER NOT NULL,
   id_unit_oeuvre DOUBLE PRECISION NOT NULL,
   PRIMARY KEY(id_centre),
   FOREIGN KEY(id_type_centre) REFERENCES Type_Centre(id_type_centre),
   FOREIGN KEY(id_unit_oeuvre) REFERENCES UnitOeuvre(id_unit_oeuvre)
);

CREATE TABLE Charge(
   id_charge INTEGER,
   total_montant NUMERIC(15,2)  ,
   date_charge DATE NOT NULL,
   id_rubrique INTEGER NOT NULL,
   PRIMARY KEY(id_charge),
   FOREIGN KEY(id_rubrique) REFERENCES Rubrique(id_rubrique)
);

CREATE TABLE Detail_charge(
   id_nature INTEGER,
   id_centre INTEGER,
   id_charge INTEGER,
   id_charge_detail INTEGER,
   montant NUMERIC(15,2)  ,
   cles_repartition VARCHAR(50) ,
   PRIMARY KEY(id_nature, id_centre, id_charge, id_charge_detail),
   FOREIGN KEY(id_nature) REFERENCES Nature(id_nature),
   FOREIGN KEY(id_centre) REFERENCES Centre(id_centre),
   FOREIGN KEY(id_charge) REFERENCES Charge(id_charge)
);

CREATE TABLE CentreProduction(
   id_type_centre_production INTEGER,
   Id_Produit INTEGER,
   id_centre INTEGER,
   id_centre_production SERIAL,
   PRIMARY KEY(id_type_centre_production, Id_Produit, id_centre, id_centre_production),
   FOREIGN KEY(id_type_centre_production) REFERENCES TypeCentreProduction(id_type_centre_production),
   FOREIGN KEY(Id_Produit) REFERENCES Produit(Id_Produit),
   FOREIGN KEY(id_centre) REFERENCES Centre(id_centre)
);

CREATE TABLE Repartition_charge_centre(
   id_centre INTEGER,
   id_rubrique INTEGER,
   id_repartition_charge_centre SERIAL,
   pourcentage NUMERIC(15,2)  ,
   PRIMARY KEY(id_centre, id_rubrique, id_repartition_charge_centre),
   FOREIGN KEY(id_centre) REFERENCES Centre(id_centre),
   FOREIGN KEY(id_rubrique) REFERENCES Rubrique(id_rubrique)
);
