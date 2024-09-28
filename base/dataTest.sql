-- Insertion dans la table UnitOeuvre
INSERT INTO UnitOeuvre (id_unit_oeuvre, name) VALUES 
('KG'),
('L')

-- Insertion dans la table Nature
INSERT INTO Nature (id_nature, name) VALUES 
('Variable'),
('Fixe');

-- Insertion dans la table TypeCharge
INSERT INTO TypeCharge (name) VALUES 
('Non Incorporable'),
('Incorporable'),
('Suppletive');

-- Insertion dans la table Produit
INSERT INTO Produit (name) VALUES 
('Product X'),
('Product Y');

-- Insertion dans la table Production
INSERT INTO Production (date_production, quantite, Id_Produit) VALUES 
('2024-01-01', 100.00, 1),
('2024-01-02', 150.50, 2);

-- Insertion dans la table Type_Centre
INSERT INTO Type_Centre (id_type_centre) VALUES 
('Operationnal'),
('Structural');

-- Insertion dans la table TypeCentreProduction
INSERT INTO TypeCentreProduction (designation) VALUES 
('Manufacturing'),
('Assembly'),
('Packaging');

-- Insertion dans la table Rubrique
INSERT INTO Rubrique (Name, Id_TypeCharge, id_nature, id_unit_oeuvre) VALUES 
('Rubrique A', 1, 1, 20),
('Rubrique B', 2, 2, 30),
('Rubrique C', 3, 3, 40);

-- Insertion dans la table Centre
INSERT INTO Centre (name, id_type_centre, id_unit_oeuvre) VALUES 
('Centre A', 1, 1.0),
('Centre B', 2, 2.0);

-- Insertion dans la table Charge
INSERT INTO Charge (total_montant, date_charge, id_rubrique) VALUES 
( 500.00, '2024-02-01', 1),
( 750.25, '2024-02-02', 2),
( 1000.75, '2024-02-03', 3);

-- Insertion dans la table Detail_charge
INSERT INTO Detail_charge (id_nature, id_centre, id_charge, id_charge_detail, montant, cles_repartition) VALUES 
(1, 1, 1, 1, 300.00, 'Key 1'),
(2, 2, 2, 2, 450.50, 'Key 2');

-- Insertion dans la table CentreProduction
INSERT INTO CentreProduction ( Id_Produit, id_centre) VALUES 
( 1, 1),
( 3, 3);

-- Insertion dans la table Repartition_charge_centre
INSERT INTO Repartition_charge_centre (id_centre, id_rubrique, pourcentage) VALUES 
(1, 1, 50.00),
(2, 2, 75.25),
(3, 3, 25.75);

-- Affichage de la vue v_cout_centre pour valider les données
SELECT * FROM v_cout_centre;
