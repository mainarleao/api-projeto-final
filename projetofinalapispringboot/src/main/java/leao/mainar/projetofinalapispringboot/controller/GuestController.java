package leao.mainar.projetofinalapispringboot.controller;

import leao.mainar.projetofinalapispringboot.model.GuestEntity;
import leao.mainar.projetofinalapispringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private GuestFindAllService guestFindAllService;

    @Autowired
    private GuestFindByIdService guestFindByIdService;

    @Autowired
    private GuestSaveService guestSaveService;

    @Autowired
    private GuestUpdateService guestUpdateService;

    @Autowired
    private GuestDeleteService guestDeleteService;

    @GetMapping
    public ResponseEntity<List<GuestEntity>> finAll() {
        return new ResponseEntity<List<GuestEntity>>(
                this.guestFindAllService.FindAll(),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GuestEntity> findById(@PathVariable("id")long id) {
        GuestEntity guestEntity = this.guestFindByIdService.findById(id);
        if (guestEntity != null) {
            return new ResponseEntity<GuestEntity>(
                    guestEntity,
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<GuestEntity>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<GuestEntity> save(@Valid @RequestBody GuestEntity guestEntity) {
        return new ResponseEntity<GuestEntity>(
                this.guestSaveService.save(guestEntity),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<GuestEntity> update(@RequestBody GuestEntity guestEntity) {
        return new ResponseEntity<GuestEntity>(
                this.guestUpdateService.update(guestEntity),
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GuestEntity> delete(@PathVariable("id")long id) {
        this.guestDeleteService.delete(id);
        return new ResponseEntity<GuestEntity>(
                new HttpHeaders(),
                HttpStatus.OK);
    }
}
