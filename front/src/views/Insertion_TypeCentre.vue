<template>
  <div class="pagetitle">
    <h1> Ajouter un Type de Centre </h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a> </li>
        <li class="breadcrumb-item">Insertion</li>
        <li class="breadcrumb-item active">
          <router-link to="/TypeCentreList" style="text-decoration: none;">Types de Centre</router-link>
        </li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-6 offset-3 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center mb-3">Insertion du Type de Centre</h5>

            <form @submit.prevent="submitForm">
              <div class="mb-3">
                <label for="name" class="form-label">Nom</label>
                <input type="text" placeholder="Saisissez le nom du type de centre" class="form-control" id="name" v-model="typeCentre.name" required>
              </div>
              <div class="row mb-3">
                <label class="col-sm-2 col-form-label"></label>
                <button type="submit" class="btn btn-primary col-4 offset-2">Valider</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Modale Bootstrap pour les Messages -->
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
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" @click="closeModal">Fermer</button>
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
      typeCentre: { name: '' },
      modalTitle: '',
      modalMessage: ''
    };
  },
  methods: {
    async submitForm() {
      try {
        const response = await fetch('http://localhost:8080/api/typecentre/insert', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.typeCentre)
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Erreur lors de l\'ajout du type de centre');
        }

        this.modalTitle = 'Succès';
        this.modalMessage = 'Type de centre ajouté avec succès';
        this.showModal();
      } catch (error) {
        this.modalTitle = 'Erreur';
        this.modalMessage = `Erreur lors de l'insertion : ${error.message}`;
        this.showModal();
        console.error('Détails de l\'erreur :', error);
      }
    },
    showModal() {
      const modalElement = new bootstrap.Modal(document.getElementById('modalMessage'));
      modalElement.show();
    },
    closeModal() {
      const modalElement = bootstrap.Modal.getInstance(document.getElementById('modalMessage'));
      modalElement.hide();
    }
  }
};
</script>

<style scoped>
/* Ajoutez ici des styles supplémentaires si nécessaire */
</style>
