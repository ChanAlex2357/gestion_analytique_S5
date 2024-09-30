 <script>
  export default{
    data(){
      return{
        centre:[
          {Id_centre:1,  nom:'assemblage', type:'optionnel'},
          {Id_centre:2,nom:'reparation',type:'optionnel'},
          {Id_centre:2,nom:'reparation',type:'optionnel'}
          

        ]
      }
    }
  }
</script> 
<template>
    <div>
      <h1>List centre</h1>


      <div class="pagetitle">
      <h1> Centre </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">Centre</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-6">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">title</h5>
              <p>...</p>
              <!-- Table with hoverable rows -->
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">centre</th>
                    <th scope="col">type</th>
                    <th scope="col">action</th>
      
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(Centre,index) in centre" :key="index" ><!-- //////////-->
                    <th scope="row">*</th>
                    <td>{{ Centre.nom }}</td>
                    <td>{{ Centre.type }}</td>
                    <td>
                      <router-link :to="{ name: 'Edit_centre', params: { id: 12 } }">
                        <button type="button" class="btn btn-primary " ><i class="bi bi-pencil-fill"></i></button>
                      </router-link>
                      <router-link to="/"><button type="button" class="btn btn-danger offset-1"><div class="icon"> <i class="bi bi-x-lg"></i></div></button> </router-link>
                    </td>
                    
                  </tr>
                  <tr><!-- //////////-->
                    <th scope="row">1</th>
                    <td>ex: assemblage</td>
                    <td></td>
                    <td><a href="#">    </a> </td>
                    <td></td>
                    
                  </tr>
                
                </tbody>
              </table>
              <!-- End Table with hoverable rows -->

            </div>
          </div>

        </div>

        <div class="col-lg-6">

          <div class="card"> <!--  -->
            <div class="card-body">
              <h5 class="card-title"> </h5>
              <p>... </p>
            </div>
          </div>

        </div>
      </div>
    </section>
    </div>
  </template>



