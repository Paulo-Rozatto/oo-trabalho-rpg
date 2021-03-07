/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.main;

/**
 *
 * @author mathe
 */
public class AçãoInvalida extends Exception {

    /**
     * Creates a new instance of <code>AçãoInvalida</code> without detail
     * message.
     */
    public AçãoInvalida() {
    }

    /**
     * Constructs an instance of <code>AçãoInvalida</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AçãoInvalida(String msg) {
        super(msg);
    }
}
