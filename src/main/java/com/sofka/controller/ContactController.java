package com.sofka.controller;


import com.sofka.domain.Contact;
import com.sofka.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Clase para establecer los controladores.
 *
 * @version 1.0.0 2022-06-26
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.0
 *
 */
@Slf4j
@RestController
public class ContactController {
    /**
     * Inyección del servicio para tratar la tabla contactos.
     */
    @Autowired
    private ContactService contactService;

    /**
     * API POST que permite crear un contacto.
     * @param contact
     * @return
     */
    @PostMapping(path = "/contact")
    public ResponseEntity<Contact> toCreate(Contact contact) {
        log.info(String.valueOf(contact));
        contactService.save(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    /**
     * API GET para obtener la lista de contactos guardados.
     * @return
     */
    @GetMapping(path = "/contacts")
    public List<Contact> list() {

        return contactService.list();
    }

    /**
     * API GET para obtener un contacto por el id.
     * @param id
     * @return
     */
    @GetMapping(path = "/contact/{id}")
    public Optional<Contact> toFind( @PathVariable("id") Long id) {
      return contactService.findUser(id);
    }

    /**
     * API PUT para actualizar el contacto en todos sus campos.
     * @param contact
     * @param id
     * @return
     */
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> toUpdate(Contact contact, @PathVariable("id") Long id) {
        contactService.update(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * API PATCH para actualizar el nombre del contacto.
     * @param contact
     * @param id
     * @return
     */
    @PatchMapping(path = "/contact/name/{id}")
    public ResponseEntity<Contact> toUpdateName(Contact contact, @PathVariable("id") Long id) {
        contactService.updateName(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar el número del contacto.
     * @param contact
     * @param id
     * @return
     */
    @PatchMapping(path = "/contact/number/{id}")
    public ResponseEntity<Contact> toUpdateNumber(Contact contact, @PathVariable("id") Long id) {
        contactService.updateNumber(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar el correo electrónico del contacto.
     * @param contact
     * @param id
     * @return
     */
    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> toUpdateEmail(Contact contact, @PathVariable("id") Long id) {
        contactService.updateEmail(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar la fecha de nacimiento del contacto.
     * @param contact
     * @param id
     * @return
     */
    @PatchMapping(path = "/contact/birthday/{id}")
    public ResponseEntity<Contact> toUpdateBirthday(Contact contact, @PathVariable("id") Long id) {
        contactService.updateBirthday(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para hacer el borrado lógico del contacto.
     * @param contact
     * @param id
     * @return
     */
    @PatchMapping(path = "/contact/deleted/{id}")
    public ResponseEntity<Contact> toUpdateDeleted(Contact contact, @PathVariable("id") Long id) {
        contactService.updateDeleted(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    /**
     * API DELETE para eliminar un contacto por el id.
     * @param contact
     * @return
     */
    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> toDelete(Contact contact) {
        contactService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
