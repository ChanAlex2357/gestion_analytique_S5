<template>
    <div class="pagetitle">
      <h1> Rubrique </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
          <li class="breadcrumb-item">Modification</li>
          <li class="breadcrumb-item active">Rubrique</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="offset-2 mt-5 col-lg-7">

          <div class="card"><!--//////////-->
            <div class="card-body"> <!-- ///////////////  -->
              <h5 class="card-title"> Modifier rubrique </h5> <!--////////////////////////////////Creat or Eddit////////////////////////////////////////////////////-->

              <!-- General Form Elements -->
              <form>
                <div class="row mb-3 mt-4">
                  <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control">  <!--id="name"-->
                  </div>
                </div>
                
              
                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">unité d'oeuvre</label>
                  <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example"><!--id="id_UnitOeuvre"-->
                   <!-- //////////////////////////////   for   /////////////////////////////////////////// boucle for-->
                      <!-- --><option value="1"> <!-- --> One</option><!-- -->
                      <!-- --><option value="2"><!-- -->Two</option><!-- -->
                      <!-- --><option value="3"><!-- -->Three</option><!-- -->
                    </select>
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label">nature</label>
                  <div class="col-sm-10">
                    <select class="form-select" aria-label="Default select example"><!--id="id_Nature"-->
                   <!-- //////////////////////////////   for   /////////////////////////////////////////// boucle for-->
                      <!-- --><option value="1"> <!-- --> One</option><!-- -->
                      <!-- --><option value="2"><!-- -->Two</option><!-- -->
                      <!-- --><option value="3"><!-- -->Three</option><!-- -->
                    </select>
                  </div>
                </div>

                
                <div class="row mb-3 mt-5">
                  <label class="col-sm-2 col-form-label"></label>
                    <button type="submit" class="btn btn-primary col-5 offset-1 ">valider</button>
                </div>

              </form><!-- End General Form Elements -->

            </div>
          </div>

        </div>

        
      </div>
    </section>
  </template>
