<template>
  <div class="pagetitle">
    <h1>Charge</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
        <li class="breadcrumb-item">Insertion</li>
        <li class="breadcrumb-item active">Charge</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-8 offset-2 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center mb-4">Ajouter une Charge</h5>

            <!-- General Form Elements -->
            <form @submit.prevent="submitForm">
              <div class="row mb-3">
                <label for="totalMontant" class="col-sm-2 col-form-label">Montant Total</label>
                <div class="col-sm-10">
                  <input type="number" v-model="charge.totalMontant" placeholder="Insérer le montant total" class="form-control" required>
                </div>
              </div>

              <div class="row mb-3">
                <label for="dateCharge" class="col-sm-2 col-form-label">Date de Charge</label>
                <div class="col-sm-10">
                  <input type="date" v-model="charge.dateCharge" class="form-control" required>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Rubrique</label>
                <div class="col-sm-10">
                  <select v-model="charge.rubriqueId" class="form-select" required>
                    <option value="" disabled selected>Choisir une rubrique</option>
                    <option v-for="rubrique in rubriques" :key="rubrique.id_charge" :value="rubrique.id_charge">{{ rubrique.name }}</option>
                  </select>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label"></label>
                <button type="submit" class="btn btn-primary col-4 offset-2">Valider</button>
              </div>
            </form><!-- End General Form Elements -->
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Modal Bootstrap pour les Messages -->
  <div class="modal fade" id="modalMessage" tabindex="-1" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="modalLabel">{{ modalTitle }}</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          {{ modalMessage }}
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
          <button type="button" class="btn btn-primary" @click="closeModal">OK</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      charge: {
        totalMontant: null,
        dateCharge: '',
        rubriqueId: null,
      },
      modalTitle: '',
      modalMessage: '',
      rubriques: [] // To store rubrique data
    };
  },
  methods: {
    async fetchRubriques() {
      try {
        const response = await fetch('http://localhost:8080/api/rubrique/list');
        if (!response.ok) {
          throw new Error('Failed to fetch rubriques');
        }
        this.rubriques = await response.json();
      } catch (error) {
        console.error('Error fetching rubriques:', error);
      }
    },
    
    async submitForm() {
      try {
        const response = await fetch('http://localhost:8080/api/charge/insert', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.charge) // Send the charge object
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Erreur lors de l\'insertion');
        }

        this.modalTitle = 'Succès';
        this.modalMessage = 'Charge ajoutée avec succès';
        this.showModal();
        this.resetForm(); // Call resetForm to clear the input fields
      } catch (error) {
        this.modalTitle = 'Erreur';
        this.modalMessage = `Erreur lors de l'insertion : ${error.message}`;
        this.showModal();
        console.error('Détails de l\'erreur :', error);
      }
    },

    resetForm() {
      this.charge.totalMontant = null;
      this.charge.dateCharge = '';
      this.charge.rubriqueId = null;
    },

    showModal() {
      const modalElement = new bootstrap.Modal(document.getElementById('modalMessage'));
      modalElement.show();
    },

    closeModal() {
      const modalElement = bootstrap.Modal.getInstance(document.getElementById('modalMessage'));
      modalElement.hide();
    },
  },
  
  async mounted() {
    await this.fetchRubriques(); // Load rubriques on component mount
  }
};
</script>

<style scoped>
/* Add any additional styles here if needed */
</style>
