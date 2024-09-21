

CREATE TABLE charge_details (
    id_chargedetail INT,
    id_rubrique INT REFERENCES rubriques(id_rubrique),
    id_centre INT REFERENCES centres(id_centre),
    nature,
    montant
);

CREATE TABLE charge_finales (
    id_charge INT PRIMARY KEY,
    id_rubrique INT REFERENCES rubriques(id_rubrique);
    montant_total,
    nature,
);


CREATE TABLE rubriques (
    id_rubrique INT PRIMARY KEY,
    nom VARCHAR(50),
    unit_price VARCHAR(50),
    nature CHAR(1)
);

CREATE TABLE centres (
    id_centre INT PRIMARY KEY,
    nom VARCHAR(50)
);