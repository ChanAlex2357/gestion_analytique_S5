<template>
    <div>
      <h1>List centre</h1>
    </div>

    <div class="pagetitle">
      <h1> Unité d'oeuvre </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">Blank</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-6">

          <div class="card">
              <div class="card-body">
                <h5 class="card-title">liste des Unités d'oeuvre</h5>
                <p>...</p>
                <!-- Table with hoverable rows -->
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th scope="col">#</th>
                      <th scope="col">unités d'oeuvre</th>
                    
                      <th> nom :unite-oeuvre</th>
                      <th scope="col">action</th>
        
                    </tr>
                  </thead>
                  <tbody>
                    <tr><!-- //////////-->
                      <th scope="row">1</th>
                      <td>ex: gb</td>
                      <td>  gigaByte</td>

                      <!--//-->
                      <td><a href="#"> <button type="button" class="btn btn-primary">edit</button> </a>
                                        <button type="button" class="btn btn-danger"><div class="icon"> <i class="bi bi-x-lg"></i></div></button>
                      </td>
                    </tr>
                      <!--//-->
                      
                    
                    
                  
                  </tbody>
                </table>
                <!-- End Table with hoverable rows -->

              </div>
          </div>

        </div>
      

        <div class="col-lg-6">
          <div class="card"> <!--  -->
              <div class="card-body">
                <h5 class="card-title">(^ ^)</h5>
                <p>... </p>
              </div>
          </div>
        </div>

      </div>

    </section>
  </template>



