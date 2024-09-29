-- Insertion des données de test
INSERT INTO UnitOeuvre (name) VALUES 
('KG'),
('L');

INSERT INTO Nature (name) VALUES 
('Variable'),
('Fixe');

INSERT INTO TypeCharge (name) VALUES 
('Non Incorporable'),
('Incorporable'),
('Suppletive');

INSERT INTO Type_Centre (name) VALUES 
('Operationnel'),
('Structurel');

INSERT INTO Produit (name) VALUES 
('Product X'),
('Product Y');

INSERT INTO Production (date_production, quantite, Id_Produit) VALUES 
('2024-01-01', 100.00, 1),
('2024-01-02', 150.50, 2);

INSERT INTO Type_Centre DEFAULT VALUES; -- Insertion d'une valeur par défaut pour un SERIAL
INSERT INTO Type_Centre DEFAULT VALUES;

INSERT INTO TypeCentreProduction (designation) VALUES 
('Manufacturing'),
('Assembly'),
('Packaging');

INSERT INTO Rubrique (Name, Id_TypeCharge, id_nature, id_unit_oeuvre) VALUES 
('Rubrique A', 1, 1, 1), -- En supposant que id_unit_oeuvre 1 existe
('Rubrique B', 2, 2, 1), -- En supposant que id_unit_oeuvre 1 existe
('Rubrique C', 3, 2, 1); -- En supposant que id_unit_oeuvre 1 existe

INSERT INTO Centre (name, id_type_centre, id_unit_oeuvre) VALUES 
('Centre A', 1, 1), -- En supposant que id_type_centre 1 existe et id_unit_oeuvre 1 existe
('Centre B', 2, 1); -- En supposant que id_type_centre 2 existe et id_unit_oeuvre 1 existe

INSERT INTO Charge (total_montant, date_charge, id_rubrique) VALUES 
(500.00, '2024-02-01', 1), -- En supposant que id_rubrique 1 existe
(750.25, '2024-02-02', 2), -- En supposant que id_rubrique 2 existe
(1000.75, '2024-02-03', 3); -- En supposant que id_rubrique 3 existe

INSERT INTO Detail_charge (id_nature, id_centre, id_charge, montant, cles_repartition) VALUES 
(1, 1, 1, 300.00, 'Key 1'), -- En supposant que id_nature 1 existe, id_centre 1 existe, id_charge 1 existe
(2, 2, 2, 450.50, 'Key 2'); -- En supposant que id_nature 2 existe, id_centre 2 existe, id_charge 2 existe

INSERT INTO CentreProduction (id_type_centre_production, Id_Produit, id_centre) VALUES 
(1, 1, 1), -- En supposant que id_type_centre_production 1 existe, Id_Produit 1 existe, id_centre 1 existe
(1, 2, 2); -- En supposant que id_type_centre_production 1 existe, Id_Produit 2 existe, id_centre 2 existe

INSERT INTO Repartition_charge_centre (id_centre, id_rubrique, pourcentage) VALUES 
(1, 1, 50.00), -- En supposant que id_centre 1 existe, id_rubrique 1 existe
(2, 2, 75.25); -- En supposant que id_centre 2 existe, id_rubrique 2 existe

