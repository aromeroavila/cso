package com.arao.cso.data.story;

import android.util.SparseArray;

import com.arao.cso.data.parser.ChapterParser;
import com.arao.cso.domain.story.StoryDataSource;
import com.arao.cso.domain.story.StoryLine;
import com.arao.cso.domain.story.StoryUseCase;

import java.util.List;

import javax.inject.Inject;

public class StoryRepository implements StoryDataSource {

    private SparseArray<StoryNode> storyNodes;
    private int currentNodeId;
    private ChapterParser chapterParser;
    private StoryNodeMapper storyNodeMapper;

    @Inject
    public StoryRepository(ChapterParser chapterParser, StoryNodeMapper storyNodeMapper) {
        this.chapterParser = chapterParser;
        this.storyNodeMapper = storyNodeMapper;
    }

    @Override
    public StoryLine getLastStoryLine() {
        if (storyNodes == null) {
            storyNodes = chapterParser.parseChapter(1);
            currentNodeId = 1;
        }
        return storyNodeMapper.storyLineFrom(getCurrentStoryNode());
    }

    @Override
    public StoryLine updateCurrentStoryLine(int option) {
        StoryNode currentStoryNode = getCurrentStoryNode();
        StoryNode newStoryNode;
        List<NodeOption> nodeOptions = getCurrentStoryNode().getNodeOptions();

        if (option == StoryUseCase.DEFAULT_OPTION) {
            newStoryNode = storyNodes.get(currentStoryNode.getId() + 1);
        } else {
            NodeOption selectedNodeOption = nodeOptions.get(option);
            newStoryNode = storyNodes.get(selectedNodeOption.getNextStoryNode());
        }

        currentNodeId = newStoryNode.getId();
        return storyNodeMapper.storyLineFrom(newStoryNode);
    }

    private StoryNode getCurrentStoryNode() {
        return storyNodes.get(currentNodeId);
    }

}
