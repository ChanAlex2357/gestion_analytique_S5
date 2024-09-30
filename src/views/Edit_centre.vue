<script>

//exemple de donnée azo
  export default {
    data() {
      return {
        centre :[
        {Id_centre:1, nom:'assemblage'},
        {Id_centre:2  , nom:'reparation'},
        {Id_centre:3  , nom:'Admin/Distr'} 
        ]

      }
    }
}
</script>

<template>




    <div class="pagetitle">
      <h1> Centre </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">centre</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-6">

          <div class="card"><!--//////////-->
            <div class="card-body"> <!-- ///////////////  -->
              <h5 class="card-title">  modifier un centre</h5> <!--////////////////////////////////Creat or Eddit////////////////////////////////////////////////////-->

              <!-- General Form Elements -->
              <form>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" > <!--id="Name"-->
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">Type Centre</label>
                  <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example" > <!--id="id_TypeCentre"-->
                   <!-- //////////////////////////////   for   /////////////////////////////////////////// boucle for-->
                      <!-- --><option   v-for="(centre,index) in centre" :key="index" value="{{centre.Id_centre}}" > <!-- --> {{ centre.nom }} </option><!-- -->
                      <!-- --><option value="2"><!-- -->Two</option><!-- -->
                      <!-- --><option value="3"><!-- -->Three</option><!-- -->
                    </select>
                  </div>
                </div>

                
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">valider</button>
                  </div>
                </div>

              </form><!-- End General Form Elements -->

            </div>
          </div>

        </div>

        <div class="col-lg-6">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Centre</h5>
              <p> ... </p>
            </div>
          </div>

        </div>
      </div>
    </section>






  </template>