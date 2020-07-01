package leao.mainar.projetofinalapispringboot.repository;

import leao.mainar.projetofinalapispringboot.model.GuestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<GuestEntity, Long> {
}
