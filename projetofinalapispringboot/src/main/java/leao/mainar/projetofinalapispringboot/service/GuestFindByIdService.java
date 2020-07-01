package leao.mainar.projetofinalapispringboot.service;

import leao.mainar.projetofinalapispringboot.model.GuestEntity;
import leao.mainar.projetofinalapispringboot.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestFindByIdService {

    @Autowired
    private GuestRepository guestRepository;

    public GuestEntity findById(long id) {
        return this.guestRepository.findById(id).get();
    }
}
