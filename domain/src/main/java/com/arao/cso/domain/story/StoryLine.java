package com.arao.cso.domain.story;

import java.util.List;

public class StoryLine {

    private String text;
    private Character character;
    private List<String> options;

    public StoryLine(String text, Character character, List<String> options) {
        this.text = text;
        this.character = character;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public Character getCharacter() {
        return character;
    }

    public List<String> getOptions() {
        return options;
    }

}
