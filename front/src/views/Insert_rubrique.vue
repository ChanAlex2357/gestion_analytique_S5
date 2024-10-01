<template>
  <div class="pagetitle">
    <h1>Rubrique</h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
        <li class="breadcrumb-item">Insertion</li>
        <li class="breadcrumb-item active">Rubrique</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-8 offset-2 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center mb-4">Ajouter une Rubrique</h5>

            <!-- General Form Elements -->
            <form @submit.prevent="submitForm">
              <div class="row mb-3">
                <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                <div class="col-sm-10">
                  <input type="text" v-model="rubrique.name" placeholder="Insérer le nom" class="form-control" required>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Unité d'œuvre</label>
                <div class="col-sm-10">
                  <select v-model="rubrique.unitOeuvre" class="form-select" required>
                    <option value="" disabled selected>Choisir une unité d'œuvre</option>
                    <option v-for="unit in unitsOeuvre" :key="unit.id" :value="unit">{{ unit.name }}</option>
                  </select>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Nature</label>
                <div class="col-sm-10">
                  <select v-model="rubrique.nature" class="form-select" required>
                    <option value="" disabled selected>Choisir une nature</option>
                    <option v-for="nature in natures" :key="nature.id" :value="nature">{{ nature.name }}</option>
                  </select>
                </div>
              </div>

              <div class="row mb-3">
                <label class="col-sm-2 col-form-label">Type de charge</label>
                <div class="col-sm-10">
                  <select v-model="rubrique.type_charge" class="form-select" required>
                    <option value="" disabled selected>Choisir le type de charge</option>
                    <option v-for="typecharge in typecharges" :key="typecharge.id_typecharge" :value="typecharge">{{ typecharge.name }}</option>
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
      rubrique: {
        name: '',
        unitOeuvre: null,
        nature: null,
        type_charge: null // Ensure this matches the data property correctly
      },
      modalTitle: '',
      modalMessage: '',
      unitsOeuvre: [], // To store unit d'œuvre data
      natures: [], // To store nature data
      typecharges: [] // Correctly define this to hold type charges
    };
  },
  methods: {
    async fetchUnitsOeuvre() {
      try {
        const response = await fetch('http://localhost:8080/api/unitoeuvre/list');
        if (!response.ok) {
          throw new Error('Failed to fetch units d\'œuvre');
        }
        this.unitsOeuvre = await response.json();
      } catch (error) {
        console.error('Error fetching units d\'œuvre:', error);
      }
    },
    
    async fetchNatures() {
      try {
        const response = await fetch('http://localhost:8080/api/nature/list');
        if (!response.ok) {
          throw new Error('Failed to fetch natures');
        }
        this.natures = await response.json();
      } catch (error) {
        console.error('Error fetching natures:', error);
      }
    },

    async fetchTypeCharges() { // Correct the method name
      try {
        const response = await fetch('http://localhost:8080/api/typecharge/list');
        if (!response.ok) {
          throw new Error('Erreur lors de la récupération des types de charge');
        }
        this.typecharges = await response.json(); // Use this.typecharges here
      } catch (error) {
        console.error('Détails de l\'erreur :', error);
      }
    },
    
    async submitForm() {
      try {
        const response = await fetch('http://localhost:8080/api/rubrique/insert', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({name : this.rubrique.name , unitOeuvre : this.rubrique.unitOeuvre , nature : this.rubrique.nature, type_charge : this.rubrique.type_charge}) // Send the rubrique object
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Erreur lors de l\'insertion');
        }

        this.modalTitle = 'Succès';
        this.modalMessage = 'Rubrique ajoutée avec succès';
        this.showModal();
        // Reset the form or redirect if necessary
        this.resetForm(); // Call resetForm to clear the input fields
      } catch (error) {
        this.modalTitle = 'Erreur';
        this.modalMessage = `Erreur lors de l'insertion : ${error.message}`;
        this.showModal();
        console.error('Détails de l\'erreur :', error);
      }
    },

    resetForm() {
      this.rubrique.name = '';
      this.rubrique.unitOeuvre = null; // Use the correct property name
      this.rubrique.nature = null; // Use the correct property name
      this.rubrique.type_charge = null; // Reset type_charge as well
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
    await Promise.all([this.fetchUnitsOeuvre(), this.fetchNatures(), this.fetchTypeCharges()]); // Load all data on mount
  }
};
</script>


<style scoped>
/* Add any additional styles here if needed */
</style>
