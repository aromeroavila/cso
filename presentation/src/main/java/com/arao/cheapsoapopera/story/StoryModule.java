package com.arao.cheapsoapopera.story;

import com.arao.cso.data.story.StoryRepository;
import com.arao.cso.domain.story.StoryDataSource;
import com.arao.cso.domain.story.StoryUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class StoryModule {

    @Provides
    StoryPresenter storyPresenter(StoryUseCase storyUseCase) {
        return new StoryPresenter(storyUseCase);
    }

    @Provides
    StoryUseCase storyUseCase(StoryDataSource storyDataSource) {
        return new StoryUseCase(storyDataSource);
    }

    @Provides
    StoryDataSource storyRepository(StoryRepository storyRepository) {
        return storyRepository;
    }

}
