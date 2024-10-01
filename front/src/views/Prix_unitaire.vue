<template>
    <div class="pagetitle">
      <h1> Centre </h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html" style="text-decoration: none;">Home</a></li>
          <li class="breadcrumb-item">Insertion</li>
          <li class="breadcrumb-item active">Prix Prix_unitaire</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
  
    <section class="section">
      <div class="row">
        <div class="col-lg-8 offset-2 mt-5">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title text-center mb-4">Prix_unitaire</h5>
              <div class="col-10 offset-1">
                <form @submit.prevent="submitForm">
                  <div class="row mb-3">
                    <label for="centreName" class="col-sm-2 col-form-label">Prix_unitaire</label>
                    <div class="col-sm-10">
                      <input type="number" v-model="centre.name" id="centreName" placeholder="Ar" class="form-control" required >
                    </div>
                  </div>
  
                  <div class="row mb-3">
                    <label for="typeCentre" class="col-sm-2 col-form-label">Type de Centre</label>
                    <div class="col-sm-10">
                      <select v-model="centre.typeCentre" id="typeCentre" class="form-select" required>
                        <option v-for="type in typeCentres" :key="type.id_type_centre" :value="type">{{ type.name }}</option>
                      </select>
                    </div>
                  </div>
  
                  <div class="row mb-3">
                    <label for="unitOeuvre" class="col-sm-2 col-form-label">Unité d'Oeuvre</label>
                    <div class="col-sm-10">
                      <select v-model="centre.unitOeuvre" id="unitOeuvre" class="form-select" required>
                        <option v-for="unit in unitsOeuvre" :key="unit.id_unit_oeuvre" :value="unit">{{ unit.name }}</option>
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
        centre: {
          name: '',
          typeCentre: null, // Will store the selected TypeCentre ID
          unitOeuvre: null, // Will store the selected UnitOeuvre ID
        },
        typeCentres: [], // Array to hold TypeCentre options
        unitsOeuvre: [], // Array to hold UnitOeuvre options
        modalTitle: '',
        modalMessage: '',
      };
    },
    created() {
      this.loadTypeCentres();
      this.loadUnitsOeuvre();
    },
    methods: {
      async loadTypeCentres() {
        try {
          const response = await fetch('http://localhost:8080/api/typecentre/list'); // Adjust the endpoint
          this.typeCentres = await response.json();
        } catch (error) {
          console.error('Error loading TypeCentres:', error);
        }
      },
      async loadUnitsOeuvre() {
        try {
          const response = await fetch('http://localhost:8080/api/unitoeuvre/list'); // Adjust the endpoint
          this.unitsOeuvre = await response.json();
        } catch (error) {
          console.error('Error loading UnitOeuvre:', error);
        }
      },
      async submitForm() {
        try {
          const response = await fetch('http://localhost:8080/api/centre/insert', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify( {name : this.centre.name ,typeCentre : this.centre.typeCentre , unitOeuvre : this.centre.unitOeuvre }), // Send entire centre object
          });
  
          if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Erreur lors de l\'insertion');
          }
  
          const data = await response.json();
          this.modalTitle = 'Succès';
          this.modalMessage = 'Centre ajouté avec succès';
          this.showModal();
          // Clear the form or redirect as needed
          this.resetForm();
        } catch (error) {
          this.modalTitle = 'Erreur';
          this.modalMessage = `Erreur lors de l'insertion : ${error.message}`;
          this.showModal();
          console.error('Détails de l\'erreur :', error);
        }
      },
      resetForm() {
        this.centre.name = '';
        this.centre.typeCentre = null;
        this.centre.unitOeuvre = null;
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
  /* Add any additional styles here if needed */
  </style>
  