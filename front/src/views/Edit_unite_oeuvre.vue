<template>
  <div class="pagetitle">
    <h1> Unité d'oeuvre </h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
        <li class="breadcrumb-item">Modification</li>
        <li class="breadcrumb-item active">Unité d'oeuvre</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-8 offset-2 mt-5">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title text-center mb-4"> Modifier une Unité d'Oeuvre </h5>
            <div class="col-10 offset-1">
              <form @submit.prevent="submitForm">
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                  <div class="col-sm-10">
                    <input type="text" v-model="unitOeuvre.name" placeholder="modifier le nom" class="form-control" required>
                  </div>
                </div>

                <div class="row mb-3 ">
                  <label class="col-sm-2 col-form-label"></label>
                  <button type="submit" class="btn btn-primary col-4 offset-2">valider</button>
                </div>
              </form><!-- End General Form Elements -->
            </div>
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
      unitOeuvre: {
        name: '' // Assurez-vous d'utiliser 'nom' ici
      },
      modalTitle: '',
      modalMessage: ''
    };
  },
  methods: {
    async submitForm() {
      if (!this.unitOeuvre.name) {
        this.modalTitle = 'Erreur';
        this.modalMessage = "Le nom ne peut pas être vide";
        this.showModal();
        return; // Prevent form submission
      }

      const id = this.$route.params.id_unit_oeuvre; // Récupérer l'ID depuis les paramètres de route

      try {
        const response = await fetch(`http://localhost:8080/api/unitoeuvre/update/${id}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({ name: this.unitOeuvre.name }) // Utiliser 'nom' pour la requête
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Erreur lors de la mise à jour');
        }

        const data = await response.json();
        this.modalTitle = 'Succès';
        this.modalMessage = 'Unité d\'oeuvre mise à jour avec succès';
        this.showModal();
        // Clear the form or redirect as needed
      } catch (error) {
        this.modalTitle = 'Erreur';
        this.modalMessage = `Erreur lors de la mise à jour : ${error.message}`;
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
  },
  mounted() {
    const id = this.$route.params.id_unite_oeuvre; // Récupérer l'ID depuis les paramètres de route
    // Appel pour charger les données de l'unité d'œuvre peut être ajouté ici si nécessaire
  }
};
</script>

<style scoped>
/* Add any additional styles here if needed */
</style>
