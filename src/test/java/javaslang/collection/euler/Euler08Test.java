/*     / \____  _    _  ____   ______  / \ ____  __    _ _____
 *    /  /    \/ \  / \/    \ /  /\__\/  //    \/  \  / /  _  \   Javaslang
 *  _/  /  /\  \  \/  /  /\  \\__\\  \  //  /\  \ /\\/  \__/  /   Copyright 2014-now Daniel Dietrich
 * /___/\_/  \_/\____/\_/  \_/\__\/__/___\_/  \_//  \__/_____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.collection.euler;

import javaslang.collection.List;
import javaslang.collection.Seq;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Euler08Test {

    /**
     * <strong>Problem 8: Largest product in a series</strong>
     * <p>
     * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
     * <pre>
     * <code>
     * 73167176531330624919225119674426574742355349194934
     * 96983520312774506326239578318016984801869478851843
     * 85861560789112949495459501737958331952853208805511
     * 12540698747158523863050715693290963295227443043557
     * 66896648950445244523161731856403098711121722383113
     * 62229893423380308135336276614282806444486645238749
     * 30358907296290491560440772390713810515859307960866
     * 70172427121883998797908792274921901699720888093776
     * 65727333001053367881220235421809751254540594752243
     * 52584907711670556013604839586446706324415722155397
     * 53697817977846174064955149290862569321978468622482
     * 83972241375657056057490261407972968652414535100474
     * 82166370484403199890008895243450658541227588666881
     * 16427171479924442928230863465674813919123162824586
     * 17866458359124566529476545682848912883142607690042
     * 24219022671055626321111109370544217506941658960408
     * 07198403850962455444362981230987879927244284909188
     * 84580156166097919133875499200524063689912560717606
     * 05886116467109405077541002256983155200055935729725
     * 71636269561882670428252483600823257530420752963450
     * </code>
     * </pre>
     * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product.
     * What is the value of this product?
     * <p>
     * See also <a href="https://projecteuler.net/problem=8">projecteuler.net problem 8</a>.
     */
    @Test
    public void shouldSolveProblem8() {
        assertThat(largestProductOfConsecutives(4, _1000_DIGITS_NUMBER)).isEqualTo(5_832);
        assertThat(largestProductOfConsecutives(13, _1000_DIGITS_NUMBER)).isEqualTo(2_091_059_712);
    }

    private static long largestProductOfConsecutives(int sizeOfConsecutive, String num) {
        return digits(num)
                .sliding(sizeOfConsecutive)
                .map(Seq::product)
                .max().get().longValue();
    }

    private static List<Integer> digits(String num) {
        return List.ofAll(num.split("")).map(s -> Character.digit(s.charAt(0), 10));
    }

    private static final String _1000_DIGITS_NUMBER =
            "73167176531330624919225119674426574742355349194934" +
                    "96983520312774506326239578318016984801869478851843" +
                    "85861560789112949495459501737958331952853208805511" +
                    "12540698747158523863050715693290963295227443043557" +
                    "66896648950445244523161731856403098711121722383113" +
                    "62229893423380308135336276614282806444486645238749" +
                    "30358907296290491560440772390713810515859307960866" +
                    "70172427121883998797908792274921901699720888093776" +
                    "65727333001053367881220235421809751254540594752243" +
                    "52584907711670556013604839586446706324415722155397" +
                    "53697817977846174064955149290862569321978468622482" +
                    "83972241375657056057490261407972968652414535100474" +
                    "82166370484403199890008895243450658541227588666881" +
                    "16427171479924442928230863465674813919123162824586" +
                    "17866458359124566529476545682848912883142607690042" +
                    "24219022671055626321111109370544217506941658960408" +
                    "07198403850962455444362981230987879927244284909188" +
                    "84580156166097919133875499200524063689912560717606" +
                    "05886116467109405077541002256983155200055935729725" +
                    "71636269561882670428252483600823257530420752963450";
}
