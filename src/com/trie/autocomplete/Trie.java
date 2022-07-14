package com.trie.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;
    private int lcpIndex;
    Trie(){
        this.root = new Node("");
    }

    public String longestCommonPrefix(){
        Node node = this.root;
        String lcp ="";
        //keep considering the child while the node has single child
        while(numOfChildren(node)==1 && !node.isLeaf()){
            node = node.getChild(lcpIndex);
            //we get the char out of ascii value
            lcp = lcp + (char) (lcpIndex + 'a');
        }
        return lcp;
    }
//is to consider all the children which is not null
    //count the number of non null children
    private int numOfChildren(Node node) {
        int numChildren = 0;
        for(int i=0; i<node.getChildren().length; i++){
            if(node.getChild(i)!=null){
                numChildren++;
                lcpIndex= i;
            }
        }
        return numChildren;
    }

    public List<String> autocomplete(String prefix){
        Node temp = root;
        List<String> autocompleteList = new ArrayList<>();
        for(int i = 0; i< prefix.length(); i++){
            Character ch = prefix.charAt(i);
            int asciiIdx = ch - 'a';
            if(temp.getChild(asciiIdx) == null) return autocompleteList;
            temp = temp.getChild(asciiIdx);
        }
        //this is the inorder traversal (DFS)
        collect(temp, prefix, autocompleteList);
        return  autocompleteList;
    }

    private void collect(Node node, String prefix, List<String> list) {

        //base- case
        if(node == null) return;
        //when we hit the leaf node
        if(node.isLeaf())
            list.add(prefix);

        //all the child of actual node
      for(Node childNode : node.getChildren()){
            if(childNode==null) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix+childCharacter, list);
        }
    }

    public void insert(String key){
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
    }

    public boolean search(String key){
        Node temp = this.root;
        for(int i=0; i<key.length(); i++) {
            Character ch = key.charAt(i);
            int asciiIdx = ch - 'a';
            if(temp.getChild(asciiIdx) == null) {
                return false;
            } else {
                temp = temp.getChild(asciiIdx);
            }
        }
        if(!temp.isLeaf()) return false;
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String a = "apir";
        String b = "apple";
        String c = "approve";
        String d = "apee";
        t.insert(a);
        t.insert(b);
        t.insert(c);
        t.insert(d);

        //System.out.println(t.autocomplete("app"));
        System.out.println(t.longestCommonPrefix());
    }
}
