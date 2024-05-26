import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
@RestController
@RequestMapping(path = "/jobadvertisement")
public class JobAdvertisementService {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    public JobAdvertisement createJobAdvertisement(JobAdvertisement jobAdvertisement) {
        entityManager.persist(jobAdvertisement);
        return jobAdvertisement;
    }

    public JobAdvertisement getJobAdvertisementById(int jobAdId) {
        return entityManager.find(JobAdvertisement.class, jobAdId);
    }

    public List<JobAdvertisement> getAllJobAdvertisements() {
        return entityManager.createQuery("SELECT ja FROM JobAdvertisement ja", JobAdvertisement.class)
                .getResultList();
    }

    public JobAdvertisement updateJobAdvertisement(JobAdvertisement jobAdvertisement) {
        return entityManager.merge(jobAdvertisement);
    }

    public void deleteJobAdvertisement(int jobAdId) {
        JobAdvertisement jobAdvertisement = entityManager.find(JobAdvertisement.class, jobAdId);
        if (jobAdvertisement != null) {
            entityManager.remove(jobAdvertisement);
        }
    }
}