# TO-DO LIST

## Insertion de Centre

- [ ] Front
  - [ ] Formulaire Centre
    - [ ] Liste type Centre - select
    - [ ] Liste Unit Oeuvre
- [ ] Back
  - [ ] Class UnitOeuvre
  - [ ] Class TypeCentre
  - [ ] Class Centre

## Insertion Rubrique

- [ ] Front
  - [ ] Formulaire Rubrique
    - [ ] Liste Unite Oeuvre - select
    - [ ] Liste nature - select
    - [ ] Liste TypeCharge - Radio Button Choix type charge
      - [ ] Liste des centres actueles
      - [ ] si Non Incorporable
        - [ ] Cles des centres = 0%
      - [ ] sinon Incorporable
        - [ ] Cles par centre - decimal
- [ ] Back
  - [ ] Class TypeCharge ( nom )
  - [ ] Class Nature ( nom )
  - [ ] Class Rubrique ( nom , Nature , TypeCharge )
  - [ ] Class RepartiChargeCentre

## Insertion Charge

- [ ] Front
  - [ ] Formulaire Charge
    - [ ] Liste des rubrique - select
    - [ ] Montant - numeric
    - [ ] Date Charge - date
- [ ] Back
  - [ ] Class DetailCharge ( Charge , TypeCharge , Centre , Cles , Montant , DateCharge)
  - [ ] Class Charge ( Rubrique , montant , date_charge )
    - [ ] setDateCharge ( String ) - Validation du format de date
    - [ ] setMontant ( String ) - Montant > 0
  - [ ] Class Cles ( pourcentage )
  - [ ] Class RepartionCharge ( Charge , Centre , Cles )
    - [ ] fonction get_montant_par_cles() => Charge.montant * Cles.pourcentage
  - [ ] Class AdminRepartionCharge
    - [ ] fonction get_repartition_charge_par_centre( Charge ) => RepartitionCharge []
        -> Donne la rerpartition de la charge sur tout les centres actuels
- Integration
  - [ ] La liste des rubriques - Rubrique.getAll
  - [ ] fonction Charge.save_charge( idRubrique , montant , date_charge ) throws exception
    -> Validation des donnees ave new Charge(idRubrique , montant , date_charge)
    -> get_repartition_charge_par_centre ( Charge )
    -> Pour chaque repartition insertion base dans detail_charge avec RepartitionCharge.get_montant_par_cles()
    -> Insertion base Charge ( idRubrique , montant , date_charge)

## Calcul de cout

- [ ] Back
  - [ ] Class utilitaire Exercice( date_debut , date_fin)
  - [ ] Class View CoutCentre()
    - [ ] Attributs
      - [ ] Centre
      - [ ] TypeCharge
      - [ ] Exercice
      - [ ] Montant
  - [ ] Class AdminCoutCentre ( Exercice )
    -> Recupere la liste des details charges dans l'exercice
    -> Grouper par idCentre et le type charge
    -> Sommer les montants de chaque groupe

    - [ ] Attributs
      - [ ] Exercice
      - [ ] CoutCentre[]
    - [ ] Fonctions - Faire les calculs a partir de la liste des couts centres
      - [ ] getCoutDirectTotal( Centre )
        - [ ] getSommeCoutFixe( Centre )
        - [ ] getSommeCoutVariable( Centre )
      - [ ] getSommeOperationnelle( )
        -> Somme des coup direct de tous les centres de type operationnelle
      - [ ] getSommeStructurelle()
        -> Somme des coup direct de tous les centres de type Structurelle
