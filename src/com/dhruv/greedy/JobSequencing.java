package com.dhruv.greedy;

import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
//        char val = 1+'0' ;
//        System.out.println(val);
        int n = 4 ;
        Job j1 = new Job(1,4,20) ;
        Job j2 = new Job(2,1,10);
        Job j3 = new Job(3,1,40) ;
        Job j4 = new Job(4,1,30) ;
        Job[] jobs = {j1,j2,j3,j4} ;
        int[] ans = JobScheduling(jobs,n) ;
        System.out.println(Arrays.toString(ans));
    }
    static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)-> b.profit-a.profit);
        int lastDeadlineDay = 0 ;
        for( int i = 0 ; i<arr.length ; i++ ){
            lastDeadlineDay = Math.max(lastDeadlineDay,arr[i].deadline) ;
        }
        int[] deadlineDayArray = new int[lastDeadlineDay+1] ;
        int profit = 0 ;
        int jobs = 0 ;
        for( int i = 0 ;i<arr.length ; i++ ){
            Job j = arr[i] ;
            int deadline = j.deadline ;
            for( int k = deadline ;k>0 ; k-- ){
                if( deadlineDayArray[k] == 0 ){
                    deadlineDayArray[k] = j.id ;
                    profit += j.profit ;
                    jobs++ ;
                    break;
                }
            }
        }
        int[] res = new int[2] ;
        res[0] = profit ;
        res[1] = jobs ;
        return res ;
    }
}
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
