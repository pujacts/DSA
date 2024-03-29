package com.trie.associative;

import com.trie.Constants;

public class Node {

    private String character;
    private Node[] children;
    private boolean leaf;
    private boolean visited;
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node(String character) {
        this.character = character;
        this.children = new Node[Constants.ALPHABET_SIZE];

    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Node[] getChildren() {
        return children;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node getChild(int index){
        return children[index];
    }

    @Override
    public String toString() {
        return character;
    }

    public void setChild(int asciiIdx, Node node) {
        children[asciiIdx] = node;
    }
}
