package leao.mainar.projetofinalapispringboot.service;

import leao.mainar.projetofinalapispringboot.model.GuestEntity;
import leao.mainar.projetofinalapispringboot.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestUpdateService {

    @Autowired
    private GuestRepository guestRepository;

    public GuestEntity update(GuestEntity guestEntity) {
        return this.guestRepository.save(guestEntity);
    }
}
