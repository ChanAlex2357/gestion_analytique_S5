
<script>
export default {
  props: ['id'], // Les params sont accessibles comme des props
  mounted() {
    console.log('ID from params:', this.id); // Vous pouvez aussi accéder à l'id ici
  }
}
</script>

<template>
    <div>
      <h1>Edit  _charges</h1>
    </div>



    <div class="pagetitle">
      <h1 > Charge  {{ id }} </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">charge</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-6">

          <div class="card"><!--//////////-->
            <div class="card-body"> <!-- ///////////////  -->
              <h5 class="card-title"> modifier </h5> <!--////////////////////////////////Creat or Eddit////////////////////////////////////////////////////-->

              <!-- General Form Elements -->
              <form>
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control"><!--id="name"-->
                  </div>
                </div>
                
                

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">Rubrique</label>
                  <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example" > <!--  id=""id_Rubrique-->
                   <!-- //////////////////////////////   for   /////////////////////////////////////////// boucle for-->
                      <!-- --><option value="1"> <!-- --> One</option><!-- -->
                      <!-- --><option value="2"><!-- -->Two</option><!-- -->
                      <!-- --><option value="3"><!-- -->Three</option><!-- -->
                    </select>
                  </div>
                  
                 
                </div>

                <div class="row mb-3">
                          <label for="inputNumber" class="col-sm-2 col-form-label"> (Ar) </label> <!--when we need to get the value ex: if center 1 not checked( id = 0) wee don't need the value of Montant1-->

                          <div class="col-sm-10">
                            <input type="number" class="form-control" min="0">   <!-- ex:     id="Montant2--"-->
                        </div>
                    

                  </div>

                  <div class="row mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">Date</label>
                  <div class="col-sm-10">
                    <input type="date" class="form-control">
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

        
      </div>
    </section>
  </template>