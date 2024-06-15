package services.src.main.java.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.data.domain.Advertisement;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    Object findBytitle(String gettitle);

    Advertisement save(Advertisement advertisement);

}