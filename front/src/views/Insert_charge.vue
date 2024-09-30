<template>
  <div class="pagetitle">
    <h1> Insert_charges </h1>
    <nav>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
        <li class="breadcrumb-item">prototype</li>
        <li class="breadcrumb-item active">charge</li>
      </ol>
    </nav>
  </div><!-- End Page Title -->

  <section class="section">
    <div class="row">
      <div class="col-lg-8 offset-2 mt-5">
        <div class="card"><!--//////////-->
          <div class="card-body"> <!-- ///////////////  -->
            <h5 class="card-title text-center mb-4"> Ajouter ou modifier une Charge </h5>
            <div class="col-10 offset-1">
              <form @submit.prevent="submitForm">
                <div class="row mb-3">
                  <label for="inputText" class="col-sm-2 col-form-label">Nom</label>
                  <div class="col-sm-10">
                    <input type="text" v-model="charge.name" placeholder="Insérer le nom" class="form-control" required>
                  </div>
                </div>

                
                <div class="row mb-3 ">
                  <label class="col-sm-2 col-form-label">Rubrique</label>
                  <div class="col-sm-10">
                    <select class="form-select" v-model="charge.rubrique" required>
                      <option value="">Sélectionnez une rubrique</option>
                      <option v-for="(rubrique, index) in rubriquesList" :key="index" :value="rubrique.id">{{ rubrique.name }}</option>
                    </select>
                  </div>
                </div>

                <div class="row mb-3">
                  <label for="inputNumber" class="col-sm-2 col-form-label">Montant (Ar)</label> <!--when we need to get the value ex: if center 1 not checked( id = 0) wee don't need the value of Montant1-->
                  <div class="col-sm-10">
                    <input type="number" v-model="charge.montant" min="0" class="form-control" required>
                  </div>
                </div>

                <div class="row mb-3">
                  <label for="inputDate" class="col-sm-2 col-form-label">Date</label>
                  <div class="col-sm-10">
                    <input type="date" v-model="charge.date" class="form-control" required>
                  </div>
                </div>

                <div class="row mb-3">
                  <label class="col-sm-2 col-form-label"></label>
                  <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary col-4 offset-2">valider</button>
                  </div>
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
      charge: {
        name: '',
        rubrique: '',
        montant: '',
        date: ''
      },
      modalTitle: '',
      modalMessage: '',
      rubriquesList: []
    };
  },

  methods: {
    async fetchRubriques() {
      const response = await fetch('http://localhost:8080/api/rubrique/list');
      const data = await response.json();
      this.rubriquesList = data;
    },
    async submitForm() {
      if (!this.charge.name || !this.charge.rubrique || !this.charge.montant || !this.charge.date) {
        this.modalTitle = 'Erreur';
        this.modalMessage = "Veuillez remplir tous les champs";
        this.showModal();
        return;
      }

      try {
        const response = await fetch('http://localhost:8080/api/charge/insert', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(this.charge)
        });

        if (!response.ok) {
          const errorData = await response.json();
          throw new Error(errorData.message || 'Erreur lors de l\'insertion');
        }

        const data = await response.json();
        this.modalTitle = 'Succès';
        this.modalMessage = 'Charge ajoutée avec succès';
        this.showModal();
        // Clear the form or redirect as needed
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
    },
    mounted() {
    this.fetchRubriques();
  }
  }
};
</script>