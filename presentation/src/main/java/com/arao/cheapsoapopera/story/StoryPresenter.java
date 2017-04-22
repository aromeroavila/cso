package com.arao.cheapsoapopera.story;

import com.arao.cso.domain.story.StoryLine;
import com.arao.cso.domain.story.StoryUseCase;

import javax.inject.Inject;

class StoryPresenter {

    private StoryUseCase storyUseCase;

    private StoryView storyView;

    @Inject
    StoryPresenter(StoryUseCase storyUseCase) {
        this.storyUseCase = storyUseCase;
    }

    void initialise(StoryView storyView) {
        this.storyView = storyView;
        StoryLine storyLine = storyUseCase.resumeStory();
        storyView.renderStoryLine(storyLine);
    }

    void onContinueStoryPressed() {
        StoryLine storyLine = storyUseCase.continueStory();
        storyView.renderStoryLine(storyLine);
    }

    void onStoryOptionSelected(int option) {
        StoryLine storyLine = storyUseCase.chooseOption(option);
        storyView.renderStoryLine(storyLine);
    }

}
