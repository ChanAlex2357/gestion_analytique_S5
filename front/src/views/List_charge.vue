<template>
  <div class="pagetitle">
    <h1>Liste des Charges</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
        <li class="breadcrumb-item active">Liste des Charges</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-10 offset-1 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Liste des Charges</h5>

            <!-- Table with hoverable rows -->
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th>Montant Total</th>
                  <th>Date de Charge</th>
                  <th>Rubrique</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(charge, index) in charges" :key="charge.id_charge">
                  <th scope="row">{{ index + 1 }}</th>
                  <td>{{ charge.total_montant }}</td>
                  <td>{{ charge.date_charge }}</td>
                  <td>{{ charge.rubrique.name }}</td>
                  <td>
                    <router-link :to="`/EditCharge/${charge.id_charge}`">
                      <button type="button" class="btn btn-primary">
                        <i class="bi bi-pencil-fill"></i>
                      </button>
                    </router-link>
                    <button type="button" class="btn btn-danger offset-2" @click="openDeleteModal(charge.id_charge)">
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
          Êtes-vous sûr de vouloir supprimer cette charge ?
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
      charges: [], // Liste des charges
      chargeIdToDelete: null // ID de la charge à supprimer
    };
  },
  mounted() {
    this.fetchCharges(); // Charger la liste au montage
  },
  methods: {
    // Fonction pour récupérer la liste des charges
    async fetchCharges() {
      try {
        const response = await fetch('http://localhost:8080/api/charge/list');
        if (!response.ok) {
          throw new Error('Erreur lors de la récupération des charges');
        }
        this.charges = await response.json();
      } catch (error) {
        console.error('Détails de l\'erreur :', error);
      }
    },

    // Ouvrir la modal de suppression
    openDeleteModal(id) {
      this.chargeIdToDelete = id; // Stocker l'ID de la charge à supprimer
      const modalElement = new bootstrap.Modal(document.getElementById('deleteModal'));
      modalElement.show(); // Afficher la modal de confirmation
    },

    // Confirmer la suppression
    async confirmDelete() {
      try {
        const response = await fetch(`http://localhost:8080/api/charge/delete/${this.chargeIdToDelete}`, {
          method: 'DELETE'
        });

        if (!response.ok) {
          throw new Error('Erreur lors de la suppression de la charge');
        }

        this.fetchCharges(); // Mettre à jour la liste après la suppression
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
