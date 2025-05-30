package Old;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepositoryOld extends JpaRepository<MenuOld, Long> {
    List<MenuOld> findByParentIsNullOrderByOrderIndex();
}
