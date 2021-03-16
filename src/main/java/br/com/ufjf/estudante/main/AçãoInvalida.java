/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
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
