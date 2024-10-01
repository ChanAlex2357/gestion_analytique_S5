<template>
  <div>
    <h1>Home</h1>
    <div class="pagetitle">
      <h1>DashBoard</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
          <li class="breadcrumb-item">DashBoard</li>
          <li class="breadcrumb-item active">Analytique</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-8 offset-2 mt-2">
          <div v-for="(coutProduction, index) in adminCoutProduction.coutProductions" :key="index" class="card mt-4">
            <div class="card-body">
              <h5 class="card-title">Production pour {{ coutProduction.production.produit.name }}</h5>
              <form @submit.prevent="handleSubmit(index)">
                <div class="row mb-2 mt-5">
                  <label for="prixUnitaire" class="col-sm-3 col-form-label">Prix Unitaire</label>
                  <div class="col-sm-8">
                    <input type="number" v-model="coutProduction.prx" id="prixUnitaire" placeholder="Insérer le prix unitaire" class="form-control" required>
                  </div>
                </div>
                <div class="row mb-4">
                  <label for="quantite" class="col-sm-3 col-form-label">Quantité</label>
                  <div class="col-sm-8">
                    <input type="number" v-model="coutProduction.qtt" id="quantite" placeholder="Insérer la quantité" class="form-control" required>
                  </div>
                </div>
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <button type="submit" class="btn btn-primary col-4 offset-2">Valider</button>
                </div>
              </form>

              <!-- Display the calculation details after submission -->
              <div v-if="coutProduction.ca !== undefined">
                <p><strong>Chiffre d'Affaires (CA):</strong> {{ coutProduction.ca }} Ar</p>
                <p><strong>Marge sur Coût Variable (MCV):</strong> {{ coutProduction.mcv }} Ar</p>
                <p><strong>Seuil de rentabilité:</strong> {{ coutProduction.seuilRentabilite }} Ar</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="section">
      <div class="row">
        <div class="col-lg-12">
          <div class="card-body">
            <div>
    <h1>Détails des Charges</h1>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>ID Charge Détail</th>
          <th>Montant</th>
          <th>Clés de Répartition</th>
          <th>Nature</th>
          <th>Centre</th>
          <th>Type Centre</th>
          <th>Unité d'Oeuvre</th>
          <th>ID Charge</th>
          <th>Total Montant Charge</th>
          <th>Date de Charge</th>
          <th>Rubrique</th>
          <th>Type Charge</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="detail in adminDetailCharge.detailCharges" :key="detail.id_charge_detail">
          <td>{{ detail.id_charge_detail }}</td>
          <td>{{ detail.montant }}</td>
          <td>{{ detail.cles_repartition }}</td>
          <td>{{ detail.nature.name }}</td>
          <td>{{ detail.centre.name }}</td>
          <td>{{ detail.centre.typeCentre.name }}</td>
          <td>{{ detail.centre.unitOeuvre.name }}</td>
          <td>{{ detail.charge.id_charge }}</td>
          <td>{{ detail.charge.total_montant }}</td>
          <td>{{ detail.charge.date_charge }}</td>
          <td>{{ detail.charge.rubrique.name }}</td>
          <td>{{ detail.charge.rubrique.type_charge.name }}</td>
        </tr>
      </tbody>
    </table>
  </div>

            <h5 class="card-title">Répartition</h5>
            <table class="table table-striped">
              <thead>
                <tr>
                  <th scope="col">Centre</th>
                  <th scope="col">Coût Direct</th>
                  <th scope="col">Clés</th>
                  <th scope="col">Type Centre</th>
                  <th scope="col">Coût Total</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(centre, index) in adminCoutCentre.allCoutCentres" :key="index">
                  <th scope="row">{{ centre.centre.name }}</th>
                  <td>{{ centre.coutDirectTotal }}</td>
                  <td>{{ centre.cles }}</td>
                  <td>{{ centre.centre.typeCentre.name }}</td>
                  <td>{{ centre.coutTotal }}</td>
                </tr>
                <tr>
                  <th>Total Général</th>
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
  </div>
</template>

<script>
export default {
  data() {
    return {
      adminCoutCentre: {}, // To hold the CoutCentre data
      adminDetailCharge: {}, // To hold the DetailCharge data
      adminCoutProduction : {}, // To hold the Production data
      prx: 0, // Prix unitaire
      qtt: 0, // Quantité
      seuilRentabilite: 0, // Seuil de rentabilité
      sommeCoutDirect: 0,
      sommeCles: 0,
      sommeStructurelle: 0,
      sommeCoutTotal: 0,
    };
  },
  methods: {
    handleSubmit(index) {
      // Récupérer les données de production
      const coutProduction = this.adminCoutProduction.coutProductions[index];

      // Calcul du Chiffre d'Affaires (CA)
      coutProduction.ca = coutProduction.prx * coutProduction.qtt;

      // Coût Variable (CV)
      const CV = coutProduction.montantByNature.Variable;

      // Calcul de la Marge sur Coût Variable (MCV)
      coutProduction.mcv = coutProduction.ca - CV;
      // coutProduction.mcv = CV;

      // Coût Fixe (CF)
      const CF = coutProduction.montantByNature.Fixe;

      // Calcul du Seuil de rentabilité
      coutProduction.seuilRentabilite = CF * coutProduction.ca / coutProduction.mcv;
    },
  },
  mounted() {
    // Fetch data from the API
    fetch('http://localhost:8080/api/dashboard')
      .then(response => response.json())
      .then(data => {
        this.adminCoutCentre = data.adminCoutCentre;
        this.adminDetailCharge = data.adminDetailCharge;
        this.adminCoutProduction = data.adminCoutProduction;

        // Calculate totals
        this.sommeCoutDirect = this.adminCoutCentre.allCoutCentres.reduce((sum, centre) => sum + centre.coutDirectTotal, 0);
        this.sommeCles = this.adminCoutCentre.allCoutCentres.reduce((sum, centre) => sum + centre.cles, 0);
        this.sommeStructurelle = this.adminCoutCentre.sommeStructurelle || 0; // Use default if not present
        this.sommeCoutTotal = this.adminCoutCentre.sommeCoutTotal || 0; // Use default if not present
      })
      .catch(error => console.error('Error fetching data:', error));
  },
};
</script>
