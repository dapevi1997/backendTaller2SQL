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
     * @param contact Información de un contacto contenida en el objeto.
     * @return Contacto y respuesta de creado.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping(path = "/contact")
    public ResponseEntity<Contact> toCreate(Contact contact) {
        log.info(String.valueOf(contact));
        contactService.save(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    /**
     * API GET para obtener la lista de contactos guardados.
     * @return Array de contactos.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping(path = "/contacts")
    public List<Contact> list() {

        return contactService.list();
    }

    /**
     * API GET para obtener un contacto por el id.
     * @param id Id del contacto a encontrar.
     * @return Contacto encontrado.
     */
    @GetMapping(path = "/contact/{id}")
    public Optional<Contact> toFind( @PathVariable("id") Long id) {
      return contactService.findUser(id);
    }

    /**
     * API PUT para actualizar el contacto en todos sus campos.
     * @param contact Contacto a actualizar.
     * @param id Id del contacto a actualizar.
     * @return Contacto actualizado
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> toUpdate(Contact contact, @PathVariable("id") Long id) {
        contactService.update(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    /**
     * API PATCH para actualizar el nombre del contacto.
     * @param contact Contacto al que se le va a actualizar el nombre.
     * @param id Id del contacto al que se le va a actualizar el nombre.
     * @return Contacto con el nombre actualizado.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PatchMapping(path = "/contact/name/{id}")
    public ResponseEntity<Contact> toUpdateName(Contact contact, @PathVariable("id") Long id) {
        contactService.updateName(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar el número del contacto.
     * @param contact Contacto al que se le va a actualizar el número.
     * @param id Id del contacto al que se le va a actualizar el número.
     * @return Contacto con el número actualizado.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PatchMapping(path = "/contact/number/{id}")
    public ResponseEntity<Contact> toUpdateNumber(Contact contact, @PathVariable("id") Long id) {
        contactService.updateNumber(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar el email del contacto.
     * @param contact Contacto al que se le va a actualizar el email.
     * @param id Id del contacto al que se le va a actualizar el email.
     * @return Contacto con el email actualizado.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> toUpdateEmail(Contact contact, @PathVariable("id") Long id) {
        contactService.updateEmail(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para actualizar la fechad de nacimiento del contacto.
     * @param contact Contacto al que se le va a actualizar la fecha de nacimiento.
     * @param id Id del contacto al que se le va a actualizar la fecha de nacimiento.
     * @return Contacto con la fecha de nacimiento actualizada.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @PatchMapping(path = "/contact/birthday/{id}")
    public ResponseEntity<Contact> toUpdateBirthday(Contact contact, @PathVariable("id") Long id) {
        contactService.updateBirthday(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }
    /**
     * API PATCH para hacer el borrado lógico del contacto.
     * @param contact Contacto que se va a borrar.
     * @param id Id del contacto a borrar.
     * @return Contacto borrado.
     */
    @PatchMapping(path = "/contact/deleted/{id}")
    public ResponseEntity<Contact> toUpdateDeleted(Contact contact, @PathVariable("id") Long id) {
        contactService.updateDeleted(id,contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    /**
     * API DELETE para eliminar un contacto por el id.
     * @param contact Contacto a eliminar.
     * @return Contacto eliminado.
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> toDelete(Contact contact) {
        contactService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
