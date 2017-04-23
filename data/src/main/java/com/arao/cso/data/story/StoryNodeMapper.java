package com.arao.cso.data.story;

import com.arao.cso.domain.story.StoryLine;

import java.util.ArrayList;
import java.util.List;

public class StoryNodeMapper {

    public StoryLine storyLineFrom(StoryNode storyNode) {
        List<String> options = null;
        List<NodeOption> nodeOptions = storyNode.getNodeOptions();
        if (nodeOptions != null) {
            int optionsSize = nodeOptions.size();
            options = new ArrayList<>(optionsSize);

            for (int i = 0; i < optionsSize; i++) {
                options.add(i, nodeOptions.get(i).getText());
            }
        }

        return new StoryLine(storyNode.getText(), null, options);
    }

}
