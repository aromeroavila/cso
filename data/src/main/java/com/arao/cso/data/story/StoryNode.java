package com.arao.cso.data.story;

import java.util.List;

public class StoryNode {

    private int id;
    private String character;
    private String text;
    private List<NodeOption> nodeOptions;

    public StoryNode(int id, String character, String text, List<NodeOption> nodeOptions) {
        this.id = id;
        this.character = character;
        this.text = text;
        this.nodeOptions = nodeOptions;
    }

    public int getId() {
        return id;
    }

    public String getCharacter() {
        return character;
    }

    public String getText() {
        return text;
    }

    public List<NodeOption> getNodeOptions() {
        return nodeOptions;
    }

}
