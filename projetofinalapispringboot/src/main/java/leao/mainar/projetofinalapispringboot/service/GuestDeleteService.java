package leao.mainar.projetofinalapispringboot.service;

import leao.mainar.projetofinalapispringboot.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestDeleteService {

    @Autowired
    private GuestRepository guestRepository;

    public void delete(long id) {
        this.guestRepository.deleteById(id);
    }
}
