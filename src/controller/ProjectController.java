package controller;

import model.Project;
import model.ProjectDAO;

public class ProjectController {
    public void saveProject(Project p) {
        ProjectDAO.insert(p); // Übergibt das Projekt an die DAO zur Speicherung
    }
}
