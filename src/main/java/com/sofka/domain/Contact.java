package com.sofka.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

/**
 * Clase refernciar una tabla SQL a objetos.
 *
 * @version 1.0.0 2022-06-26
 *
 * @author DANIEL PEREZ VITOLA - dapevi97@gmail.com
 *
 * @since 1.0.0
 *
 */
@Data
@Entity
@Table(name = "contact")
public class Contact implements Serializable {
    /**
     * Configurar el id de las filas.
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Referencia del id de la tabla.
     */
    @Column(name = "con_id")
    private Long id;
    /**
     * Referencia del campo con_name de la tabla.
     */
    @Column(name = "con_name")
    private String name;
    /**
     * Referencia del campo con_number de la tabla.
     */
    @Column(name = "con_number")
    private String number;
    /**
     * Referencia del campo con_email de la tabla.
     */
    @Column(name = "con_email")
    private String email;
    /**
     * Referencia del campo con_birthday de la tabla.
     */
    @Column(name = "con_birthday")
    private String birthday;
    /**
     * Referencia del campo deleted de la tabla.
     */
    @Column(name = "deleted")
    private String deleted;
}
