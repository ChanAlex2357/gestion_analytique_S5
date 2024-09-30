<script>
export default {
  data() {
    return {
      dateDebut: '',  // Liaison avec l'input de la date de début
      dateFin: ''     // Liaison avec l'input de la date de fin
    };
  },
  methods: {
    // Méthode pour sauvegarder les dates dans sessionStorage
    saveDatesToSessionStorage() {
      // Vérification basique si les champs sont remplis
      if (this.dateDebut && this.dateFin) {
        // Sauvegarder dans sessionStorage
        sessionStorage.setItem('date_debut', this.dateDebut);
        sessionStorage.setItem('date_fin', this.dateFin);
        alert('Les dates ont été sauvegardées dans la session !');
      } else {
        alert('Veuillez remplir les deux champs de date.');
      }
    }
  }
};
</script>
<template>
    <div>
      <h1>Exercice</h1>
    </div>



    <div class="pagetitle">
      <h1> Exercice</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">Exercice</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-6">

          <div class="card"><!--//////////-->
            <div class="card-body"> <!-- ///////////////  -->
              <h5 class="card-title"> Exercice </h5> <!--////////////////////////////////Creat or Eddit////////////////////////////////////////////////////-->

              <form @submit.prevent="saveDatesToSessionStorage">
      <div class="row mb-3">
        <label for="inputDate" class="col-sm-2 col-form-label">Date début</label>
        <div class="col-sm-10">
          <input type="date" class="form-control" id="date_debut" v-model="dateDebut">
        </div>
      </div>

      <div class="row mb-3">
        <label for="inputDate" class="col-sm-2 col-form-label">Date fin</label>
        <div class="col-sm-10">
          <input type="date" class="form-control" id="date_fin" v-model="dateFin">
        </div>
      </div>

      <div class="row mb-3">
        <div class="col-sm-10 offset-sm-2">
          <button type="submit" class="btn btn-primary">Valider</button>
        </div>
      </div>
    </form>

            </div>
          </div>

        </div>

        <div class="col-lg-6">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Exercice</h5>
              <p> ... </p>
            </div>
          </div>

        </div>
      </div>
    </section>
  </template>