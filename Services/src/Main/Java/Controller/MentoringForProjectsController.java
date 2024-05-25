import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class MentoringForProjectsService {

    @PersistenceContext
    private EntityManager entityManager;

    public MentoringForProjects createMentoringForProjects(MentoringForProjects mentoringForProjects) {
        entityManager.persist(mentoringForProjects);
        return mentoringForProjects;
    }

    public MentoringForProjects getMentoringForProjectsById(int projectID) {
        return entityManager.find(MentoringForProjects.class, projectID);
    }

    public List<MentoringForProjects> getAllMentoringForProjects() {
        return entityManager.createQuery("SELECT mfp FROM MentoringForProjects mfp", MentoringForProjects.class)
                .getResultList();
    }

    public MentoringForProjects updateMentoringForProjects(MentoringForProjects mentoringForProjects) {
        return entityManager.merge(mentoringForProjects);
    }

    public void deleteMentoringForProjects(int projectID) {
        MentoringForProjects mentoringForProjects = entityManager.find(MentoringForProjects.class, projectID);
        if (mentoringForProjects != null) {
            entityManager.remove(mentoringForProjects);
        }
    }
}