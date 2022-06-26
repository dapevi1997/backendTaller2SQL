package com.sofka.dao;

import com.sofka.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface que permite ralizar determinadas operaciones en la tabla.
 *
 * @version 1.0.0 2022-06-26
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.0
 *
 */
public interface ContactDao extends CrudRepository<Contact,Long> {
    /**
     * Consulta para modificar el nombre del contacto.
     * @param id
     * @param name
     */
    @Modifying
    @Query("update Contact con set con.name = :name where con.id=:id")
    void updateName(@Param(value = "id") Long id, @Param(value = "name") String name);

    /**
     * Consulta para modificar el número de contacto.
     * @param id
     * @param number
     */
    @Modifying
    @Query("update Contact con set con.number = :number where con.id=:id")
    void updateNumber(@Param(value = "id") Long id, @Param(value = "number") String number);

    /**
     * Consulta para modificar el correo electrónico del contacto.
     * @param id
     * @param email
     */
    @Modifying
    @Query("update Contact con set con.email = :email where con.id=:id")
    void updateEmail(@Param(value = "id") Long id, @Param(value = "email") String email);

    /**
     * Consulta para modificar la fecha de nacimiento del contacto.
     * @param id
     * @param birthday
     */
    @Modifying
    @Query("update Contact con set con.birthday = :birthday where con.id=:id")
    void updateBirthday(@Param(value = "id") Long id, @Param(value = "birthday") String birthday);

    /**
     * Consulta para modificar el campo que indica que se hizo un borrado lógico al contacto.
     * @param id
     * @param deleted
     */
    @Modifying
    @Query("update Contact con set con.deleted = :deleted where con.id=:id")
    void updateDeleted(@Param(value = "id") Long id, @Param(value = "deleted") String deleted);
}
