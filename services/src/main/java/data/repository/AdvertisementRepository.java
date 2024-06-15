package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import data.domain.Advertisement;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    Object findBytitle(String gettitle);

    @SuppressWarnings({ "null", "unchecked" })
    Advertisement save(Advertisement advertisement);

}