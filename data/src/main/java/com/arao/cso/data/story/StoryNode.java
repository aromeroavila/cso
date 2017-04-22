package com.arao.cso.data.story;

import java.util.List;

class StoryNode {

    private long id;
    private String text;
    private List<StoryNode> nextStoryNodes;

    public StoryNode(long id, String text, List<StoryNode> nextStoryNodes) {
        this.id = id;
        this.text = text;
        this.nextStoryNodes = nextStoryNodes;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<StoryNode> getNextStoryNodes() {
        return nextStoryNodes;
    }
}
