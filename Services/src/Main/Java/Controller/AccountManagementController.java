import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class AccountManagementService {

    @PersistenceContext
    private EntityManager entityManager;

    
    public ResponseEntity AccountManagement createAccountManagement(@RequestBody AccountManagement accountManagement) {
        entityManager.persist(accountManagement);
        return accountManagement;
    }
    
    public ResponseEntity AccountManagement getAccountManagementById(@PathVariable int managementId) {
        return entityManager.find(AccountManagement.class, managementId);
    }

    //public List<AccountManagement> getAllAccountManagements() {
    //    return entityManager.createQuery("SELECT am FROM AccountManagement am", AccountManagement.class)
    //            .getResultList();
    //}

    public AccountManagement updateAccountManagement(AccountManagement accountManagement) {
        return entityManager.merge(accountManagement);
    }

    public void deleteAccountManagement(int managementId) {
        AccountManagement accountManagement = entityManager.find(AccountManagement.class, managementId);
        if (accountManagement != null) {
            entityManager.remove(accountManagement);
        }
    }
}