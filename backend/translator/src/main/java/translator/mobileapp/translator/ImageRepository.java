package translator.mobileapp.translator;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findIdAndUserId(Long imageId, Long userId); 
}
