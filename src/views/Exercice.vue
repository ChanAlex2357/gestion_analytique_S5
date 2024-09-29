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
              <h5 class="card-title"> ajouter ou modifier </h5> <!--////////////////////////////////Creat or Eddit////////////////////////////////////////////////////-->

              <!-- General Form Elements -->
              <form>
                
                

                <div class="row mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">Date debut</label>
                  <div class="col-sm-10">
                    <input type="date" class="form-control" id="date_debut">
                  </div>
                </div>

                <div class="row mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">Date fin</label>
                  <div class="col-sm-10">
                    <input type="date" class="form-control" id="date_fin">
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
              <h5 class="card-title">Exercice</h5>
              <p> ... </p>
            </div>
          </div>

        </div>
      </div>
    </section>
  </template>