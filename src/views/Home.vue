<script>
export default {
  data() {
    return {

      centre: [
        { Id_centre: 1, nom: 'centre1' }


      ],

      charge: [

        { Id_charge: 1, nom: 'ramImpor', montant: 100000, nature: { Id_nature: 2, nom: 'variable' }, rubrique: { Id_rubrique: 1, name: 'ram' }, centre: { Id_centre: 1, nom: 'centre1' }, rubrique: { Id_rubrique: 1, name: 'ram', nature: { Id_nature: 1, name: 'variable' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } } },
        { Id_charge: 1, nom: 'ramImpor', montant: 100000, nature: { Id_nature: 2, nom: 'variable' }, rubrique: { Id_rubrique: 1, name: 'ram' }, centre: { Id_centre: 1, nom: 'centre1' }, rubrique: { Id_rubrique: 1, name: 'ram', nature: { Id_nature: 1, name: 'variable' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } } },
        { Id_charge: 1, nom: 'ramImpor', montant: 100000, nature: { Id_nature: 2, nom: 'variable' }, rubrique: { Id_rubrique: 1, name: 'ram' }, centre: { Id_centre: 1, nom: 'centre1' }, rubrique: { Id_rubrique: 1, name: 'ram', nature: { Id_nature: 1, name: 'variable' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } } },

      ]
      ,
      rubrique: [
        { Id_rubrique: 1, name: 'ram', nature: { Id_nature: 1, name: 'variable' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } },
        { Id_rubrique: 1, name: 'ram', nature: { Id_nature: 1, name: 'variable' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } },
        { Id_rubrique: 1, name: 'rom', nature: { Id_nature: 1, name: 'fix' }, unite_oeuvre: { Id_unite_oeuvre: 1, name: 'GB' } }
      ]

    }
  }

}
</script>

<template>
  <div>
    <h1>Home</h1>
  </div>
  <div class="pagetitle">
    <h1> DashBoard </h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item">DashBoard</li>
        <li class="breadcrumb-item active"> Analytique </li>
      </ol>
    </nav>
  </div><!-- End Page Title -->
  <section class="section">
    <div class="row">
      <div class="col-lg-12">
        <div class="card-body">
          <h5 class="card-title">Analytique</h5>
          <p>cours : Ar (ariary)</p>
          <!-- Table with hoverable rows -->
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Rubrique</th>
                <th scope="col">Unité-Oeuvre</th>
                <th scope="col">Nature</th>
                <th scope="col" colspan="3" v-for="(Centre, index) in centre" :key="index">{{ Centre.nom }}</th>
              </tr>
              <tr>
                <th></th><th></th><th></th>
                <template v-for="(Centre, index) in centre">
                  <th>%</th>
                  <th>Fixe</th>
                  <th>Variable</th>
                </template>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(Charge, index) in charge" :key="index" :value="Charge.Id_charge">
                <th scope="row">{{ Charge.nom }}</th>
                <td>{{ Charge.rubrique.unite_oeuvre.name }}</td>
                <td>{{ Charge.nature.nom }}</td>
                <template v-for="(Centre, index) in centre">
                  <td> val</td>
                  <td>zavatra</td>
                  <td>ao</td>
                </template>
              </tr>
              <tr>
                <th colspan="3"></th>
                <template v-for="(Centre, index) in centre">
                  <td>test</td>
                  <td>test</td>
                  <td>test</td>
                </template>
              </tr>
              <tr>
                <th>total</th>
                <td>test</td>
                <td>test</td>
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
              <tr>
                <th scope="row">zavatra</th>
                <td>test</td>
                <td>test</td>
                <td>test</td>
                <td>test</td>
              </tr>
              <tr>
                <th>Total General</th>
                <td>test</td>
                <td>test</td>
                <td>test</td>
                <td>test</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>


    </div>
  </section>
</template>

  