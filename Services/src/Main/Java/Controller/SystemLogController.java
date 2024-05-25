import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SystemLogService {

    @PersistenceContext
    private EntityManager entityManager;

    public SystemLog createSystemLog(SystemLog systemLog) {
        entityManager.persist(systemLog);
        return systemLog;
    }

    public SystemLog getSystemLogById(int logID) {
        return entityManager.find(SystemLog.class, logID);
    }

    public List<SystemLog> getAllSystemLogs() {
        return entityManager.createQuery("SELECT sl FROM SystemLog sl", SystemLog.class)
                .getResultList();
    }

    public SystemLog updateSystemLog(SystemLog systemLog) {
        return entityManager.merge(systemLog);
    }

    public void deleteSystemLog(int logID) {
        SystemLog systemLog = entityManager.find(SystemLog.class, logID);
        if (systemLog != null) {
            entityManager.remove(systemLog);
        }
    }
}
