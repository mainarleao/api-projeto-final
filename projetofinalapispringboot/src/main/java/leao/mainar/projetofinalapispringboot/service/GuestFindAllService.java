package leao.mainar.projetofinalapispringboot.service;

import leao.mainar.projetofinalapispringboot.model.GuestEntity;
import leao.mainar.projetofinalapispringboot.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestFindAllService {

    @Autowired
    private GuestRepository guestRepository;

        public List<GuestEntity> FindAll() {
            return (List<GuestEntity>) this.guestRepository.findAll();
    }
}
