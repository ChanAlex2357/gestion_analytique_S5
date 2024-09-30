package gestion.analytique.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.analytique.pc.model.Dashboard;
import gestion.analytique.pc.service.DashboardService; // Assuming you have a service for dashboard operations
import lombok.Data;

@RestController
@Data
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    // Endpoint to get general statistics for the dashboard
    @GetMapping
    public Dashboard getDashboard() {
        return getDashboardService().getDashboard();
    }


    // Add more endpoints as needed...
}
