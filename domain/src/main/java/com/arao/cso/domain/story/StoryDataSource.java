package com.arao.cso.domain.story;

public interface StoryDataSource {

    StoryLine getLastStoryLine();

    StoryLine updateCurrentStoryLine(int option);

}
