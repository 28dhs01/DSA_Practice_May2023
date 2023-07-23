package com.dhruv.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Nmeetings {
    public static void main(String[] args) {
        int N = 6 ;
        int start[] = {1,3,0,5,8,5} ;
        int end[] =  {2,4,6,7,9,9} ;
        int ans = maxMeetings(start,end,N) ;
        System.out.println(ans);
    }
    static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<MyDs> list = new ArrayList<>();
        for( int i = 0 ; i<n ; i++ ){
            MyDs entry = new MyDs(start[i],end[i]) ;
            list.add(entry) ;
        }
        Collections.sort(list, new Comparator<MyDs>() {

            @Override
            public int compare(MyDs o1, MyDs o2) {
                if( o1.et>o2.et ){
                    return 1 ;
                }else if( o1.et<o2.et ){
                    return -1 ;
                }return 0 ;
            }
        });
        for( MyDs ent: list ){
//            System.out.println(ent.st+" - "+ent.et);
        }
        int cnt = 0 ;
        int prvEt = 0 ;
        for( int i = 0 ; i<list.size() ; i++ ){
            if( list.get(i).st > prvEt ){
                cnt++ ;
                prvEt = list.get(i).et ;
            }
        }
        return cnt ;
    }
}
class MyDs{
    int st ;
    int et ;
    MyDs(int s, int e){
        this.st = s ;
        this.et = e ;
    }
}
