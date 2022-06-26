package com.sofka.service;

import com.sofka.domain.Contact;

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
public interface IContactService {
    /**
     * Método para listar los contactos guardados.
     * @return
     */
    List<Contact> list();

    /**
     * Método para guardar un contacto.
     * @param contact
     * @return
     */
    Contact save(Contact contact);

    /**
     * Método para actualizar un contacto.
     * @param id
     * @param contact
     * @return
     */
    Contact update(Long id, Contact contact);

    /**
     * Método para eliminar un contacto.
     * @param contact
     */
    void delete(Contact contact);

    /**
     * Método para encontrar un contacto.
     * @param id
     * @return
     */
    Optional<Contact> findUser(Long id);
}
