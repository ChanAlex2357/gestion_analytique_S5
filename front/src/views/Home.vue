<script>
export default {
  data() {
    return {
      centre: [],     // Stockera les informations des centres
      charge: []      // Stockera les charges ou autres informations nécessaires
    };
  },
  mounted() {
    // Requête pour récupérer les données de l'API
    fetch('http://localhost:8080/coutcentre')
      .then(response => response.json())
      .then(data => {
        this.centre = data.allCoutCentres;   // Récupérer les centres depuis la réponse
      })
      .catch(error => {
        console.error('Erreur lors de la récupération des données:', error);
      });
  }
};
</script>

<template>
  <div>
    <h1>Home</h1>
  </div>
  <div class="pagetitle">
    <h1>DashBoard</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item">DashBoard</li>
        <li class="breadcrumb-item active">Analytique</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-12">
        <div class="card-body">
          <h5 class="card-title">Analytique</h5>
          <p>Cours : Ar (ariary)</p>

          <!-- Table with hoverable rows -->
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Rubrique</th>
                <th scope="col">Unité-Oeuvre</th>
                <th scope="col">Nature</th>
                <th v-for="(Centre, index) in centre" :key="index" colspan="3">{{ Centre.centre.name }}</th>
              </tr>
              <tr>
                <th></th>
                <th></th>
                <th></th>
                <template v-for="(Centre, index) in centre" :key="index">
                  <th>%</th>
                  <th>Fixe</th>
                  <th>Variable</th>
                </template>
              </tr>
            </thead>
            <tbody>
              <!-- Exemple de ligne de charge, à adapter selon tes données -->
              <tr v-for="(Charge, index) in charge" :key="index">
                <th scope="row">{{ Charge.nom }}</th>
                <td>{{ Charge.rubrique.unite_oeuvre.name }}</td>
                <td>{{ Charge.nature.nom }}</td>
                <!-- Générer les cellules pour chaque centre -->
                <template v-for="(Centre, index) in centre" :key="index">
                  <td>{{ Centre.coutTotal }}</td>
                  <td>{{ Centre.coutDirectTotal }}</td>
                  <td>{{ Centre.cles }}</td>
                </template>
              </tr>

              <!-- Ligne de total, exemple simple -->
              <tr>
                <th colspan="3">Total</th>
                <template v-for="(Centre, index) in centre" :key="index">
                  <td>{{ Centre.coutTotal }}</td>
                  <td>{{ Centre.coutDirectTotal }}</td>
                  <td>{{ Centre.cles }}</td>
                </template>
              </tr>
            </tbody>
          </table>

          <h5 class="card-title">Repartition</h5>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Repartition</th>
                <th scope="col">Cout Direct</th>
                <th scope="col">Cles</th>
                <th scope="col">Centre Structurelle</th>
                <th scope="col">Cout total</th>
              </tr>
            </thead>
            <tbody>
              <!-- Exemple de ligne de répartition -->
              <tr v-for="(Centre, index) in centre" :key="index">
                <th scope="row">{{ Centre.centre.name }}</th>
                <td>{{ Centre.coutDirectTotal }}</td>
                <td>{{ Centre.cles }}</td>
                <td>{{ Centre.centre.typeCentre.name }}</td>
                <td>{{ Centre.coutTotal }}</td>
              </tr>
              <tr>
                <th>Total General</th>
                <td>{{ sommeCoutDirect }}</td>
                <td>{{ sommeCles }}</td>
                <td>{{ sommeStructurelle }}</td>
                <td>{{ sommeCoutTotal }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </section>
</template>
