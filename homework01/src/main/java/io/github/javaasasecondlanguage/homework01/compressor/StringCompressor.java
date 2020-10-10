package io.github.javaasasecondlanguage.homework01.compressor;

public class StringCompressor {
    /**
     * Given an array of characters, compress it using the following algorithm:
     *
     * Begin with an empty string s.
     * For each group of consecutive repeating characters in chars:
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * Return a compressed string.
     * </p>
     * Follow up:
     * Could you solve it using only O(1) extra space?
     * </p>
     * Examples:
     * a -> a
     * aa -> a2
     * aaa -> a3
     * aaabb -> a3b2
     * "" -> ""
     * null -> Illegal argument
     * 234 sdf -> Illegal argument
     *
     * @param str nullable array of chars to compress
     *            str may contain illegal characters
     * @return a compressed array
     * @throws IllegalArgumentException if str is null
     * @throws IllegalArgumentException if any char is not in range 'a'..'z'
     */
    public char[] compress(char[] str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        var builder = new StringBuilder();
        for (int start = 0; start < str.length; ) {
            if (!Character.isAlphabetic(str[start])) {
                throw new IllegalArgumentException();
            }
            builder.append(str[start]);
            int end = start + 1;
            for (; end < str.length && str[end] == str[start]; ++end) {
            }
            if (end - start > 1) {
                builder.append(end - start);
            }
            start = end;
        }
        return builder.toString().toCharArray();
    }
}
