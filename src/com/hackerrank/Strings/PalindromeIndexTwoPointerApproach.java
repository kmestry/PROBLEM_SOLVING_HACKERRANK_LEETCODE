package com.hackerrank.Strings;

public class PalindromeIndexTwoPointerApproach {

    // Complete the palindromeIndex function below.
    //aabccccaa
    static int palindromeIndex(String s) {

        if (isPalindrome(s)) {
            return -1;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                String subString = s.substring(i + 1, s.length() - i);
                if (isPalindrome(subString))
                    return i;
                else
                    return s.length() - 1 - i;
            }
        }
        return 0;

    }

    static boolean isPalindrome(String inputString) {
        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
                return false;
            }

        }
        return true;
    }

    /*
    * 10
wykkttfghdvbyxbxefnltpnbdkkdbnptlnfexbxybvdhgfttkkyw
iynilxchelphhsjiftgmbtaxlnbrbhsrptfxfddmhoerxaaaaxreohmddfxftprshbrbnlxatbmgtfishhplehcxlinyi
xfsxrgylhgebvagwhmctvsbnqbqwwcpuhisbrtmbawsdyulxccxluydsabmtrbsihupcwwqbqnbsvtcmhwgavbeghlygrxsfx
uaklbdlxfbvypmqselghnbmmwyywmmbnhglesqmpvbfxldblkau
xthxhvykhasivjiwmbbmwivisahkyvhxhtx
oladkyolbdmqwlkejjeklwmdbloykdalo
kbkseyyvccgpqtqterkrrkretqtqpgccvyyskbk
crwlgqeubhhvigsliydbuvvvvubdyilsgivhhbueqglwrc
slwaebreoxussybaujipwtqdwlayumpeicdiifaafiidciepmuylwdqtwpijuabyssuxoerbeawls
nujquecofwcbnfyaayfnbcwfceuqjun
    * */

    public static void main(String[] args) {
        boolean result = isPalindrome("aabccccaa");
        System.out.println("result = " + result);
        int index = palindromeIndex("aabccccaa");
        System.out.println("index = " + index);

        //   palindromeIndex("aabccccaa");
       /* int result = palindromeIndex("iynilxchelphhsjiftgmbtaxlnbrbhsrptfxfddmhoerxaaaaxreohmddfxftprshbrbnlxatbmgtfishhplehcxlinyi");
        System.out.println("result = " + result);*/

    }
}
