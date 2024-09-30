<script>
  export default {
    data(){
      return{
        charge:[
          {Id_charge:1, nom:'ramImpor',montant:100000, nature:{Id_nature:2 , nom:'variable'} , rubrique:{Id_rubrique:1, name:'ram'}, centre:{Id_centre:1 , nom:'centre1'}},
          {Id_charge:1, nom:'ramImpor',montant:100000, nature:{Id_nature:2 , nom:'variable'} , rubrique:{Id_rubrique:1, name:'ram'}, centre:{Id_centre:1 , nom:'centre1'}},
          {Id_charge:1, nom:'ramImpor',montant:100000, nature:{Id_nature:2 , nom:'variable'} , rubrique:{Id_rubrique:1, name:'ram'}, centre:{Id_centre:1 , nom:'centre1'}}
        ]
      }
    }
  }

</script>

<template>
    <div>
      <h1>List charge </h1>
    </div>

    <div class="pagetitle">
      <h1> liste des charges </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item">prototype</li>
          <li class="breadcrumb-item active">Charge (coût) </li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">liste des charges</h5>
              <p>...</p>
              <!-- Table with hoverable rows -->
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">charge</th>
                    <!-- araka ny isan ilay centre///////:::::::::::::::::::::::::::::::-->
                    <th> centre</th>
                    <!-- araka ny isan ilay centre ny montant//////////::::::::::::::::::::::::::::::::-->
                    <th>montant1</th>
                    <!-- araka ny isan ilay centre///:::::::::::::::::::::::::::::::-->
                    
                    

                    <th> nature</th>
                    <th> unite-oeuvre</th>
                    <th scope="col">action</th>
      
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(Charge,index) in charge" :key="index" value="{{Charge.Id_charge}}" ><!-- //////////-->
                    <th scope="row">*</th>
                    <td> {{ Charge.nom }}</td>
                    <td> {{  Charge.centre.nom }} </td>
                    <td>300 000  ar</td> <!--////-->
               
                    <td>var</td>
                    <td>gb</td>
                    <!--//-->
                    <td> 
                      <!-- <router-link to="{path:'/Home', query: { id: 12  }}"> <button type="button" class="btn btn-primary">edit</button></router-link> -->
                      <router-link :to="{ name: 'Edit_charge', params: { id: 12 } }">
                        <button type="button" class="btn btn-primary " ><i class="bi bi-pencil-fill"></i></button>
                      </router-link>

                      <router-link to="/"><button type="button" class="btn btn-danger offset-1"><div class="icon"> <i class="bi bi-x-lg"></i></div></button> </router-link>
                                 
                    </td>
                    <!--//-->

                  </tr>
                  
                
                </tbody>
              </table>
              <!-- End Table with hoverable rows -->

            </div>
          </div>

        </div>

        
      </div>
    </section>
    
  </template>