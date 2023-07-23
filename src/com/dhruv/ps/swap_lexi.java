package com.dhruv.ps;

public class swap_lexi {
    public static void main(String[] args) {
//        String str = "bbcacad" ;
//        String str = "tsraa" ;
        String str = "cpqadp" ;
        char [] ch = str.toCharArray() ;
        String res = "" ;
        char findSmallest = smallest(ch) ;
//        System.out.println(findSmallest);
        int times = findTime(ch,findSmallest) ;
        for( int i = 0 ; i<times ; i++ ){
            res = smallestStr(ch,ch.length) ;
        }
        System.out.println(res);
    }
    static char smallest(char[]ch){
        char smst = ch[0] ;
        for( int i = 1 ; i<ch.length ; i++ ){
            if( ch[i] < smst ){
                smst = ch[i] ;
            }
        }
        return smst ;
    }
    static int findTime(char[]str,char smst){
        int n = str.length ;
        // To store the first index of
        // every character of str
        int []chk = new int[MAX];
        for (int i = 0; i < MAX; i++)
            chk[i] = -1;

        // Store the first occurring
        // index every character
        for (int i = 0; i < n; i++)
        {

            // If current character is appearing
            // for the first time in str
            if (chk[str[i] - 'a'] == -1)
                chk[str[i] - 'a'] = i;
        }
        int fstOccOfSmst = chk[smst-'a'] ;
        int cnt = 0 ;
        for( int i = 0 ; i< chk.length ; i++ ){
            if( chk[i] != -1 && chk[i] < fstOccOfSmst ){
                cnt++ ;
            }
        }
        System.out.println(cnt);
        return cnt ;

    }
    static int MAX = 26 ;
    static String smallestStr(char []str, int n)
    {
        int i, j = 0;

        // To store the first index of
        // every character of str
        int []chk = new int[MAX];
        for (i = 0; i < MAX; i++)
            chk[i] = -1;

        // Store the first occurring
        // index every character
        for (i = 0; i < n; i++)
        {

            // If current character is appearing
            // for the first time in str
            if (chk[str[i] - 'a'] == -1)
                chk[str[i] - 'a'] = i;
        }

        // Starting from the leftmost character
        for (i = 0; i < n; i++)
        {
            boolean flag = false;

            // For every character smaller than str[i]
            for (j = 0; j < str[i] - 'a'; j++)
            {

                // If there is a character in str which is
                // smaller than str[i] and appears after it
                if (chk[j] > chk[str[i] - 'a'])
                {
                    flag = true;
                    break;
                }
            }

            // If the required character pair is found
            if (flag)
                break;
        }

        // If swapping is possible
        if (i < n-1)
        {

            // Characters to be swapped
            char ch1 = str[i];
            char ch2 = (char) (j + 'a');

            // For every character
            for (i = 0; i < n; i++)
            {

                // Replace every ch1 with ch2
                // and every ch2 with ch1
                if (str[i] == ch1)
                    str[i] = ch2;

                else if (str[i] == ch2)
                    str[i] = ch1;
            }
        }

        return String.valueOf(str);
    }
}
