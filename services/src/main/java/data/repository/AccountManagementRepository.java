package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.AccountManagement;
import data.domain.AccountManagement.Actiontype;
import data.repository.AccountManagementRepository;

@Repository
public interface AccountManagementRepository extends JpaRepository<AccountManagement, Long> {

    Object findByActionType(Actiontype actionType);
    // You can add custom query methods here if needed

    @SuppressWarnings({ "unchecked", "null" })
    AccountManagement save(AccountManagement existingAccount);

    boolean existsById(long managementID);

    void deleteById(long managementID);
}