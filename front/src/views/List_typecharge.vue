<template>
    <div class="pagetitle">
      <h1> Type de Charge </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
          <li class="breadcrumb-item">Liste</li>
          <li class="breadcrumb-item active">Type de Charge</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  
    <section class="section">
      <div class="row">
        <div class="col-lg-10 offset-1 mt-5">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Liste des Types de Charge</h5>
  
              <!-- Table with hoverable rows -->
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th>Nom</th>
                    <th scope="col">Action</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(typeCharge, index) in typeCharges" :key="typeCharge.id_type_charge">
                    <th scope="row">{{ index + 1 }}</th>
                    <td>{{ typeCharge.name }}</td>
                    <td>
                      <router-link :to="`/Edit_type_charge/${typeCharge.id_type_charge}`">
                        <button type="button" class="btn btn-primary">
                          <i class="bi bi-pencil-fill"></i>
                        </button>
                      </router-link>
                      <a href="#" class="offset-2">
                        <button type="button" class="btn btn-danger" @click="openDeleteModal(typeCharge.id_type_charge)">
                          <i class="bi bi-x-lg">  </i>
                        </button>
                      </a>
                    </td>
                  </tr>
                </tbody>
              </table>
              <!-- End Table with hoverable rows -->
  
            </div>
          </div>
        </div>
      </div>
    </section>
  
    <!-- Modal Bootstrap pour confirmation de suppression -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="deleteModalLabel">Confirmation de Suppression</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            Êtes-vous sûr de vouloir supprimer ce type de charge ?
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
            <button type="button" class="btn btn-danger" @click="confirmDelete">Supprimer</button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        typeCharges: [],  // Liste des types de charge
        typeChargeIdToDelete: null // ID du type de charge à supprimer
      };
    },
    mounted() {
      this.fetchTypeCharges();  // Charger la liste au montage
    },
    methods: {
      // Fonction pour récupérer la liste des types de charge
      async fetchTypeCharges() {
        try {
          const response = await fetch('http://localhost:8080/api/typecharge/list');
          if (!response.ok) {
            throw new Error('Erreur lors de la récupération des types de charge');
          }
          this.typeCharges = await response.json();
        } catch (error) {
          console.error('Détails de l\'erreur :', error);
        }
      },
  
      // Ouvrir la modal de suppression
      openDeleteModal(id) {
        console.log(`ID du type de charge à supprimer : ${id}`);  // Message de débogage
        this.typeChargeIdToDelete = id; // Stocker l'ID du type de charge à supprimer
        const modalElement = new bootstrap.Modal(document.getElementById('deleteModal'));
        modalElement.show(); // Afficher la modal de confirmation
      },
  
      // Confirmer la suppression
      async confirmDelete() {
        try {
          // Vérification que l'ID est valide
          if (this.typeChargeIdToDelete === null || this.typeChargeIdToDelete === undefined) {
            console.error('L\'ID du type de charge à supprimer est invalide');
            throw new Error('L\'ID du type de charge à supprimer est invalide');
          }
  
          console.log(`Suppression du type de charge avec l'ID : ${this.typeChargeIdToDelete}`);  // Message de débogage
  
          const response = await fetch(`http://localhost:8080/api/typecharge/delete/${this.typeChargeIdToDelete}`, {
            method: 'DELETE'
          });
  
          if (!response.ok) {
            throw new Error('Erreur lors de la suppression du type de charge');
          }
  
          this.fetchTypeCharges(); // Mettre à jour la liste après la suppression
          const modalElement = bootstrap.Modal.getInstance(document.getElementById('deleteModal'));
          modalElement.hide(); // Cacher la modal après suppression
        } catch (error) {
          console.error('Détails de l\'erreur :', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  /* Ajoutez ici des styles supplémentaires si nécessaire */
  </style>
  
  <!-- CSS de Bootstrap -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- JS de Bootstrap (inclut jQuery et Popper.js) -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  