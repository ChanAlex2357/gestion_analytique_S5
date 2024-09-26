package gestion.analytique.pc.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Exercice {

    private LocalDate date_debut;

    private LocalDate date_fin;

    @Builder
    public Exercice(LocalDate date_debut, LocalDate date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    // Helper methods
    // public long getDurationDays() {
    //     return java.time.Duration.between(date_debut, date_fin).toTotalSeconds() / 86400;
    // }

    // public boolean isActiveDate(LocalDate date) {
    //     return date.isAfter(date_debut) && date.isBefore(date_fin);
    // }

    // public boolean containsDate(LocalDate date) {
    //     return date.isAfter(date_debut) || date.isBefore(date_fin);
    //}
}