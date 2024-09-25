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
  - [ ] Class ViewCoutCentre()
    - [ ] Attributs
      - [ ] Centre
      - [ ] NatureCharge
      - [ ] Montant

  - [ ] Class View CoutCentre()
    - [ ] Attributs
      - [ ] Centre
      - [ ] <Nature,Montant> , Montant par nature de charge
      - [ ] Exercice
      - [ ] coutTotal
      - [ ] coutDirectTotal
    - [ ] setCoutDirectTotal
    -> Somme de chaque montant de chaque nature

  - [ ] Class AdminCoutCentre ( Exercice )
    -> Recupere la liste des details charges dans l'exercice
    -> Grouper par idCentre et le type charge
    -> Sommer les montants de chaque groupe , on obtient le montant par nature de chaque centre pour une ligne de donnee
    -> Instancier ViewCoutCentre
    -> Etablir la liste des CoutCentre en mettant la somme de chaque nature dans la map <Nature,Montant>
    -> Une fois la liste CoutCentre[] etablie , separer les Operationnelles et structurelles

    - [ ] Attributs
      - [ ] Exercice
      - [ ] CoutCentre[]
      - [ ] SommeOperationnelle
      - [ ] SommeStructurelle
      - [ ] SommeCoutTotal

    - [ ] Fonctions - Faire les calculs a partir de la liste des couts centres
      - [ ] getCentreOperationnelle()

      - [ ] getCoutDirectTotal( Centre )
      -> return CoutCentre.getCoutDirectTotal tels que CoutCentre.Centre == Centre

      - [ ] getCoutCentre(Centre)
      -> return CoutCentre tels que CoutCentre.Centre == Cnetre

      - [ ] getSommeOperationnelle( ) -> Si l'attribut SommeOperationnelle n'est pas on retourne directement
        -> Somme des coup direct de tous les centres de type operationnelle
        -> Stocker le resultat dans SommeOperationnelle

      - [ ] getSommeStructurelle() -> Si l'attribut SommeStucturelle n'est pas on retourne directement
        -> Somme des coup direct de tous les centres de type Stucturelle
        -> Stocker le resultat dans SommeStucturelle

      - [ ] getClesCentreOperationnelle(Centre[])
      ->  pour chaque centre de centre => getClesCentreOperationnelle(Centre)

      - [ ] getClesCentreOperationnelle(Centre)
      -> Cles = getCoutDirectTotal(Centre) / getSommeOperationnelle()
      -> La cle de repartition du structurelle pour le centre operationnelle

      - [ ] getCoutTotalCentreOperationnelle(Centre)
      -> coutcentre = getCoutCentre(Centre)
      ->  return coutCentre.getCoutTotal Si la valeur est != 0
      -> Sinon coutTotal = getCoutDirectTotal(Centre) + ( getClesCentreOperationnelle(Centre) * getSommeStructurelle() )
      -> coucentre.setCoutTotal(coutTotal)

      - [ ] getSommeCoutTotal()
      -> Si SommeCoutTotal return it
      -> Pour chaque centre de getCentreOperationnelle()
      -> getCoutTotalCentreOperationnelle(centre)
      -> setSommeCoutTotal

  - [ ] Class AdminCharge (Exercice)
  -> getCharges(Exercice) -> Mettre la liste dans l'attribut

    - [ ] Attribut
      - [ ] Charges []
    - [ ] Fonctions
      - [ ] getCharges( Exercice )
      - [ ] getCharges()
      -> Recuperer les charges dans l'intervalle de l'exercice
  - [ ] Class Compta( Exercice )
    - [ ] Attributs
      - [ ] AdminCoutCentre (Exercice)
      - [ ] AdminCharge (Exercice)
    - [ ] Fonctions
      - [ ] getCoutGenerale()
      -> adminCharge.getCharges() , faire la somme des montants
      - [ ] getCout
