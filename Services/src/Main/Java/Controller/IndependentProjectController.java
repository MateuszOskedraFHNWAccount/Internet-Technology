import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class IndependentProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public IndependentProject createIndependentProject(IndependentProject independentProject) {
        entityManager.persist(independentProject);
        return independentProject;
    }

    public IndependentProject getIndependentProjectById(int projectId) {
        return entityManager.find(IndependentProject.class, projectId);
    }

    public List<IndependentProject> getAllIndependentProjects() {
        return entityManager.createQuery("SELECT ip FROM IndependentProject ip", IndependentProject.class)
                .getResultList();
    }

    public IndependentProject updateIndependentProject(IndependentProject independentProject) {
        return entityManager.merge(independentProject);
    }

    public void deleteIndependentProject(int projectId) {
        IndependentProject independentProject = entityManager.find(IndependentProject.class, projectId);
        if (independentProject != null) {
            entityManager.remove(independentProject);
        }
    }
}