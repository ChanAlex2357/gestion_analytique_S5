<script>

//exemple de donnée azo
export default {
    data() {
      return {
        rubrique :[
        {Id_rubrique:1, name:'ram', nature:{Id_nature:1 , name:'variable'}, unite_oeuvre:{Id_unite_oeuvre:1 , name:'GB'}},
        {Id_rubrique:1, name:'ram', nature:{Id_nature:1 , name:'variable'}, unite_oeuvre:{Id_unite_oeuvre:1 , name:'GB'}},
        {Id_rubrique:1, name:'rom', nature:{Id_nature:1 , name:'fix'}, unite_oeuvre:{Id_unite_oeuvre:1 , name:'GB'}}
        ]

      }
    }
}
</script>

<template>
    <div>
      <h1>List rubrique</h1>
    </div>

    <div class="pagetitle">
      <h1> Rubrique </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
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
              <!-- Table with hoverable rows //////////////////////////////////////////////////////////-->
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
                  <tr v-for="(Rubrique,index) in rubrique" :key="index" value="{{Rubrique.Id_rubrique}}" ><!-- //////////////////////////////////////////////////////////////////////-->

                   
                    <th scope="row">*</th>
                    <td>{{ Rubrique.name }}</td>
                    <td>  {{ Rubrique.nature.name }}</td>
                    <td> {{ Rubrique.unite_oeuvre.name }} </td>
                    <!--//-->
                    <td> 
                      <!-- <router-link to="{path:'/Home', query: { id: 12  }}"> <button type="button" class="btn btn-primary">edit</button></router-link> -->
                      <router-link :to="{ name: 'Edit_rubrique', params: { id: 12 } }">
                        <button type="button" class="btn btn-primary " ><i class="bi bi-pencil-fill"></i></button>
                      </router-link>

                      <router-link to="/"><button type="button" class="btn btn-danger offset-1"><div class="icon"> <i class="bi bi-x-lg"></i></div></button> </router-link>
                                 
                    </td>
                    <!--//-->
                    
                  </tr>
                  <tr><!-- //////////-->
                    <th scope="row">*</th>
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
