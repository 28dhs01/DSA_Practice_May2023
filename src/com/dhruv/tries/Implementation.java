package com.dhruv.tries;

import java.util.Stack;

public class Implementation {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        Trie trie = new Trie();
        trie.insert("apple");
        boolean present = trie.search("apple") ;
        System.out.println(present);
    }
}
class Trie {
    TrieNode root ;
    public Trie() {
        this.root = new TrieNode() ;
    }

    public void insert(String word) {
        TrieNode dmy = root ;
        for( int i = 0 ; i<word.length() ;i++ ){
            char ch = word.charAt(i) ;
            boolean refNode = dmy.refPres(ch) ;
            if( refNode ){
                dmy = dmy.getRef(ch) ;
            }else{
                dmy.makeRef(ch) ;
                dmy = dmy.getRef(ch) ;
            }
        }
        dmy.flag = true ;
    }

    public boolean search(String word) {
        TrieNode dmy = root ;
        for( int i = 0 ; i<word.length() ;i++ ){
            char ch = word.charAt(i) ;
            if( !dmy.refPres(ch) ){
                return false ;
            }
            dmy = dmy.getRef(ch) ;
        }
        if( dmy.flag == true ){
            return true ;
        }
        return false ;
    }

    public boolean startsWith(String prefix) {
        TrieNode dmy = root ;
        for( int i = 0 ; i<prefix.length() ;i++ ){
            char ch = prefix.charAt(i) ;
            if( !dmy.refPres(ch) ){
                return false ;
            }
            dmy = dmy.getRef(ch) ;
        }
        return true ;
    }

    class TrieNode {
        TrieNode [] ar  ;
        boolean flag ;
        TrieNode(){
            this.ar = new TrieNode[26];
            this.flag = false ;
        }
        boolean refPres(char ch){
            return ar[ch-'a'] != null ;
        }
        TrieNode getRef(char ch){
            return ar[ch-'a'] ;
        }
        void makeRef(char ch){
            ar[ch-'a'] = new TrieNode() ;
        }
    }
}

