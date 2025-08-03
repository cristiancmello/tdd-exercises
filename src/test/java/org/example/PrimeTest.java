package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Exercicios:
 *   1. Monte um teste de números primos (método de teste canBePrime)
 *   2. Depois de implementado e feito passar no teste, limpe o código (Clean Code)
 */

public class PrimeTest {
    @Test
    void canBePrime() {
        Assertions.assertFalse(Prime.isPrime(0)); // verifique se 1 não é primo
        Assertions.assertFalse(Prime.isPrime(1)); // verifique se 1 não é primo
        Assertions.assertTrue(Prime.isPrime(2));  // verifique se 2 é primo
        Assertions.assertTrue(Prime.isPrime(3));
        Assertions.assertFalse(Prime.isPrime(4));
        Assertions.assertTrue(Prime.isPrime(5));
        Assertions.assertFalse(Prime.isPrime(6));
        Assertions.assertTrue(Prime.isPrime(7));
        Assertions.assertFalse(Prime.isPrime(8));
        Assertions.assertFalse(Prime.isPrime(9));
        Assertions.assertFalse(Prime.isPrime(1244));
        Assertions.assertTrue(Prime.isPrime(1237));
    }

    @Test
    void canGenerateNextPrimeFromIndex() {
        // Imagine o seguinte. Um array de números: [0, 1, 2, 3, 4, 5, ...] e índices
        // Índices:     0   1   2   3   4   5
        // Valores:    [0,  1,  2,  3,  4,  5]
        // Do índice (index) 0, obtemos o número 0. Do próximo índice (0 + 1 = 1), obtemos o número 1.
        // Isto é, tanto o índice quanto o seu valor associado são idênticos.
        // Os testes abaixo julgam se o valor associado do próximo índice é o número primo esperado ou não.
        // Obs.: podemos reutilizar na implementação parte da estrutura usada na implementação testada por canBePrime.
        Assertions.assertEquals(-1, Prime.next(0)); // próximo ao índice 0 é o 1 e o valor de 1 não é primo. Retorne -1 quando não for primo.
        Assertions.assertEquals(2, Prime.next(1)); // próximo ao índice 1 é o 2 e o valor de 2 é primo. Retorne o próprio quando for primo.
        Assertions.assertEquals(3, Prime.next(2)); // e assim por diante.
        Assertions.assertEquals(-1, Prime.next(3));
        Assertions.assertEquals(5, Prime.next(4));
        Assertions.assertEquals(-1, Prime.next(5));
        Assertions.assertEquals(7, Prime.next(6));
        Assertions.assertEquals(-1, Prime.next(7));
    }

    @Test
    void canBeGeneratePrimeNumbersAsList() {
        // Gere um array de números inteiros, respeitando-se o intervalo: (0, 10]
        // Ou seja, excluindo o valor do índice 0 (aberto) e incluindo o valor do índice 10 (fechado).
        // Este array de números inteiros precisam conter a sequência de números primos contida dentro do intervalo.
        int[] primeNumbers = Prime.generate(0, 1); // sequência de índices gerada: 1 (porque: (0, 1] é a sequência contendo 1)
        Assertions.assertArrayEquals(new int[] {}, primeNumbers); // intervalo (0, 1] não tem números primos. Retorne array vazio.

        primeNumbers = Prime.generate(0, 2); // sequência de índices gerada: 1, 2 (porque: (0, 2] é a sequência contendo 1 e 2)
        Assertions.assertArrayEquals(new int[] {2}, primeNumbers); // intervalo (0, 2] tem números primos. Retorne um array contendo 2

        primeNumbers = Prime.generate(0, 3);
        Assertions.assertArrayEquals(new int[] {2, 3}, primeNumbers);

        primeNumbers = Prime.generate(0, 4);
        Assertions.assertArrayEquals(new int[] {2, 3}, primeNumbers);

        primeNumbers = Prime.generate(0, 5);
        Assertions.assertArrayEquals(new int[] {2, 3, 5}, primeNumbers);

        primeNumbers = Prime.generate(1, 2);
        Assertions.assertArrayEquals(new int[] {2}, primeNumbers);

        primeNumbers = Prime.generate(1, 3);
        Assertions.assertArrayEquals(new int[] {2, 3}, primeNumbers);

        primeNumbers = Prime.generate(4, 10);
        Assertions.assertArrayEquals(new int[] {5, 7}, primeNumbers);
    }
}
