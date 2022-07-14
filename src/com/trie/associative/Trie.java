package com.trie.associative;

public class Trie {

    private Node root;
    Trie(){
        this.root = new Node("");
    }

    public void insert(String key, int value){
        Node temp = this.root;
        for(int i=0; i<key.length(); i++){
            Character ch = key.charAt(i);
            int asciiIdx = ch - 'a';
            if(temp.getChild(asciiIdx) == null){
                Node node = new Node(String.valueOf(ch));
                temp.setChild(asciiIdx, node);
                temp = node;
            } else { //the node with the given letter is already a child
                temp = temp.getChild(asciiIdx);
            }
        }
        temp.setLeaf(true);
        temp.setValue(value);
    }

    public int search(String key){
        Node temp = this.root;
        for(int i=0; i<key.length(); i++) {
            Character ch = key.charAt(i);
            int asciiIdx = ch - 'a';
            if(temp.getChild(asciiIdx) == null) {
                return -1;
            } else {
                temp = temp.getChild(asciiIdx);
            }
        }
        if(!temp.isLeaf()) return -1;
        return temp.getValue();
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String a = "apir";
        String b = "apple";
        String c = "approve";
        String d = "apee";
        t.insert(a, 10);
        t.insert(b, 6);
        t.insert(c, 4);
        t.insert(d, 20);

        System.out.println(t.search("puja"));
        System.out.println(t.search("apple"));
    }
}
