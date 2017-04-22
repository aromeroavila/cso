package com.arao.cso.data.story;

import com.arao.cso.domain.story.StoryDataSource;
import com.arao.cso.domain.story.StoryLine;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class StoryRepository implements StoryDataSource {

    private StoryNode currentStoryNode;

    @Inject
    StoryRepository() {
    }

    @Override
    public StoryLine getLastStoryLine() {
        return storyLineEntityFrom(currentStoryNode);
    }

    @Override
    public StoryLine updateCurrentStoryLine(int option) {
        StoryNode newStoryNode = currentStoryNode.getNextStoryNodes().get(option);
        currentStoryNode = newStoryNode;
        return storyLineEntityFrom(newStoryNode);
    }

    private StoryLine storyLineEntityFrom(StoryNode storyNode) {
        List<StoryNode> nextStoryNodes = storyNode.getNextStoryNodes();
        int optionsSize = nextStoryNodes.size();
        List<String> options = new ArrayList<>(optionsSize);

        for (int i = 0; i < optionsSize; i++) {
            options.add(i, nextStoryNodes.get(i).getText());
        }

        return new StoryLine(storyNode.getText(), null, options);

    }
}
