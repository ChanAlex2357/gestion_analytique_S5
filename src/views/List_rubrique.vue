<template>
    <div>
      <h1>List rubrique</h1>
    </div>

    <div class="pagetitle">
      <h1> Rubrique </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">Rubrique</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-8">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">liste des rubrique</h5>
              <p>...</p>
              <!-- Table with hoverable rows -->
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">rubrique</th>
                    <th> nature</th>
                    <th> unite-oeuvre</th>
                    <th scope="col">action</th>
      
                  </tr>
                </thead>
                <tbody>
                  <tr><!-- //////////-->
                    <th scope="row">1</th>
                    <td>ex: ram</td>
                    <td>  variable</td>
                    <td> gb </td>
                    <!--//-->
                    <td><a href="#"> <button type="button" class="btn btn-primary">edit</button> </a>
                                      <button type="button" class="btn btn-danger"><div class="icon"> <i class="bi bi-x-lg"></i></div></button>
                    </td>
                    <!--//-->
                    
                  </tr>
                  <tr><!-- //////////-->
                    <th scope="row">1</th>
                    <td>ex: ram</td>
                    <td>  variable</td>
                    <td> gb </td>
                    <!--//-->
                    <td><a href="#"> <button type="button" class="btn btn-primary">edit</button> </a>
                                      <button type="button" class="btn btn-danger"><div class="icon"> <i class="bi bi-x-lg"></i></div></button>
                    </td>
                    <!--//-->
                    
                  </tr>
                  
                
                </tbody>
              </table>
              <!-- End Table with hoverable rows -->

            </div>
          </div>

        </div>

        <div class="col-lg-4">

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
