<template>
  <div class="pagetitle">
    <h1>Liste des Centres</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
        <li class="breadcrumb-item active">Liste des Centres</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-10 offset-1 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Liste des Centres</h5>

            <!-- Table with hoverable rows -->
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th>Nom</th>
                  <th>Type de Centre</th>
                  <th>Unité d'Œuvre</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(centre, index) in centres" :key="centre.id_centre">
                  <th scope="row">{{ index + 1 }}</th>
                  <td>{{ centre.name }}</td>
                  <td>{{ centre.typeCentre.name }}</td>
                  <td>{{ centre.unitOeuvre.nom }}</td>
                  <td>
                    <router-link :to="`/EditCentre/${centre.id_centre}`">
                      <button type="button" class="btn btn-primary">
                        <i class="bi bi-pencil-fill"></i>
                      </button>
                    </router-link>
                    <button type="button" class="btn btn-danger offset-2" @click="openDeleteModal(centre.id_centre)">
                      <i class="bi bi-x-lg"></i>
                    </button>
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
          Êtes-vous sûr de vouloir supprimer ce centre ?
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
      centres: [],  // Liste des centres
      centreIdToDelete: null // ID du centre à supprimer
    };
  },
  mounted() {
    this.fetchCentres();  // Charger la liste au montage
  },
  methods: {
    // Fonction pour récupérer la liste des centres
    async fetchCentres() {
      try {
        const response = await fetch('http://localhost:8080/api/centre/list');
        if (!response.ok) {
          throw new Error('Erreur lors de la récupération des centres');
        }
        this.centres = await response.json();
      } catch (error) {
        console.error('Détails de l\'erreur :', error);
      }
    },

    // Ouvrir la modal de suppression
    openDeleteModal(id) {
      this.centreIdToDelete = id; // Stocker l'ID du centre à supprimer
      const modalElement = new bootstrap.Modal(document.getElementById('deleteModal'));
      modalElement.show(); // Afficher la modal de confirmation
    },

    // Confirmer la suppression
    async confirmDelete() {
      try {
        const response = await fetch(`http://localhost:8080/api/centre/delete/${this.centreIdToDelete}`, {
          method: 'DELETE'
        });

        if (!response.ok) {
          throw new Error('Erreur lors de la suppression du centre');
        }

        this.fetchCentres(); // Mettre à jour la liste après la suppression
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
