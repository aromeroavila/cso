package com.arao.cso.data.story;

public class NodeOption {

    private String text;
    private int nextStoryNode;

    public NodeOption(String text, int nextStoryNode) {
        this.text = text;
        this.nextStoryNode = nextStoryNode;
    }

    public String getText() {
        return text;
    }

    public int getNextStoryNode() {
        return nextStoryNode;
    }

}
