<template>
    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item"><!-- ////// -->
        <a class="nav-link " href="index.html">
          <i class="bi bi-grid"></i>
          <span>Dashboard</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item"> <!-- ///////   -->
        <a class="nav-link collapsed" data-bs-target="#centre-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>centre</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="centre-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <router-link to="/Insert_centre">   <i class="bi bi-circle"></i> <span>insert</span>  </router-link>
            
              
          </li>
          <li>
            <router-link to="/List_centre">   <i class="bi bi-circle"></i> <span>List</span>  </router-link>
          </li>
          <li>
            <router-link to="/d">   <i class="bi bi-circle"></i> <span> autre </span>  </router-link>
          </li>
          
        </ul>
      </li><!-- End centre Nav -->

      <li class="nav-item"> <!-- ///////   -->
        <a class="nav-link collapsed" data-bs-target="#rubrique-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>rubrique</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="rubrique-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
            <li>
                <router-link to="/Insert_rubrique">   <i class="bi bi-circle"></i> <span>insert</span>  </router-link>
            
              
            </li>
            <li>
                <router-link to="/List_rubrique">   <i class="bi bi-circle"></i> <span>List</span>  </router-link>
            </li>
            <li>
                <router-link to="/d">   <i class="bi bi-circle"></i> <span> autre </span>  </router-link>
            </li>
          
        </ul>
      </li><!-- End rubrique Nav -->

      <li class="nav-item"> <!-- ///////   -->
        <a class="nav-link collapsed" data-bs-target="#unite_oeuvre-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>unite_oeuvre</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="unite_oeuvre-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
            <li>
                <router-link to="/Insert_unite_oeuvre">   <i class="bi bi-circle"></i> <span>insert</span>  </router-link>
            
              
            </li>
            <li>
                <router-link to="/List_unite_oeuvre">   <i class="bi bi-circle"></i> <span>List</span>  </router-link>
            </li>
            <li>
                <router-link to="/d">   <i class="bi bi-circle"></i> <span> autre </span>  </router-link>
            </li>
          
        </ul>
      </li><!-- End unite_oeuvre Nav -->

      <li class="nav-item"> <!-- ///////   -->
        <a class="nav-link collapsed" data-bs-target="#nature-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>nature</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="nature-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
            <li>
                <router-link to="/Insert_">   <i class="bi bi-circle"></i> <span>... </span>  </router-link>
            
              
            </li>
            
            <li>
                <router-link to="/d">   <i class="bi bi-circle"></i> <span> autre </span>  </router-link>
            </li>
          
        </ul>
      </li><!-- End nature Nav -->

      <li class="nav-item"> <!-- ///////   -->
        <a class="nav-link collapsed" data-bs-target="#charge-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>charge</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="charge-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
            <li>
                <router-link to="/Insert_charge">   <i class="bi bi-circle"></i> <span>insert</span>  </router-link>
            
              
            </li>
            <li>
                <router-link to="/List_charge">   <i class="bi bi-circle"></i> <span>List</span>  </router-link>
            </li>
            <li>
                <router-link to="/d">   <i class="bi bi-circle"></i> <span> autre </span>  </router-link>
            </li>
          
        </ul>
      </li><!-- End charge Nav -->

        <router-link to="/Exercice"> <!--///////////////////////:-->
            <li class="nav-item"><!-- ////// -->
        <a class="nav-link " href="#">
          <i class="bi bi-grid"></i>
          <span>Exercice</span>
        </a>
      </li>
        </router-link>

      <li class="nav-item">
        
        <p class="nav-link ">
            <i class="bi bi-box-arrow-in-right"></i>
          <span>Log out</span>
            
        </p>
          
   
      </li><!-- End Login Page Nav -->


    

    </ul>
</template>