package com.sofka.service;

import com.sofka.dao.ContactDao;
import com.sofka.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Clase para configurar los servicios.
 *
 * @version 1.0.0 2022-06-26
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.0
 *
 */
@Service
public class ContactService implements IContactService{
    /**
     * Inyección de la clase ContactDao
     */
    @Autowired
    private ContactDao contactDao;

    /**
     * Servicio para listar los contactos guardados.
     * @return Lista de contactos.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        return (List<Contact>) contactDao.findAll();
    }

    /**
     * Servicio para guardar un contacto.
     * @param contact Contacto a guardar.
     * @return Contacto guardado.
     */
    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    /**
     * Servicio para actualizar completamente un contacto.
     * @param id Id del contacto.
     * @param contact Contacto.
     * @return Contacto actualizado.
     */
    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        contact.setId(id);
        return contactDao.save(contact);
    }

    /**
     * Servicio para actualizar el nombre de un contacto.
     * @param id Id del contacto.
     * @param contact Contacto con el nombre actualizado.
     */
    @Transactional
    public void updateName(Long id, Contact contact){

        contactDao.updateName(id, contact.getName());
    }

    /**
     * Servicio para actualizar el número de un contacto.
     * @param id Id del contacto.
     * @param contact Contacto con el número actualizado.
     */
    @Transactional
    public void updateNumber(Long id, Contact contact){

        contactDao.updateNumber(id, contact.getNumber());
    }

    /**
     * Servicio para actualizar el correo electrónico de un contacto.
     * @param id Id del contacto.
     * @param contact Contacto con el correo actualizado.
     */
    @Transactional
    public void updateEmail(Long id, Contact contact){

        contactDao.updateEmail(id, contact.getEmail());
    }

    /**
     * Servicio para actualizar la fecha de nacimiciento de un contacto.
     * @param id Id del contacto.
     * @param contact Contacto con la fecha de nacimiento actualizada.
     */
    @Transactional
    public void updateBirthday(Long id, Contact contact){

        contactDao.updateBirthday(id, contact.getBirthday());
    }

    /**
     * Servicio para hacer el borrado lógico de un contacto.
     * @param id Id del contacto.
     * @param contact Contacto al que se le hará el borrado lógico.
     */
    @Transactional
    public void updateDeleted(Long id, Contact contact){

        contactDao.updateDeleted(id, contact.getDeleted());
    }

    /**
     * Servicio para eliminar a un contacto.
     * @param contact Contacto a eliminar.
     */
    @Override
    @Transactional
    public void delete(Contact contact) {
        contactDao.delete(contact);

    }

    /**
     * Servicio para encontrar a un contacto por el id.
     * @param id Id del contacto.
     * @return Contacto encontrado.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findUser(Long id) {

        return contactDao.findById(id);
    }
}
