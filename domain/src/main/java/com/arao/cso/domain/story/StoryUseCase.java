package com.arao.cso.domain.story;

import javax.inject.Inject;

public class StoryUseCase {

    public static final int DEFAULT_OPTION = -1;

    private StoryDataSource storyDataSource;

    @Inject
    public StoryUseCase(StoryDataSource storyDataSource) {
        this.storyDataSource = storyDataSource;
    }

    public StoryLine resumeStory() {
        return storyDataSource.getLastStoryLine();
    }

    public StoryLine continueStory() {
        return storyDataSource.updateCurrentStoryLine(DEFAULT_OPTION);
    }

    public StoryLine chooseOption(int option) {
        return storyDataSource.updateCurrentStoryLine(option);
    }

}
