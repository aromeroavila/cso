package com.arao.cheapsoapopera.story;

import android.content.Context;

import com.arao.cso.data.parser.ChapterParser;
import com.arao.cso.data.story.StoryNodeMapper;
import com.arao.cso.data.story.StoryRepository;
import com.arao.cso.domain.story.StoryDataSource;
import com.arao.cso.domain.story.StoryUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class StoryModule {

    private Context context;

    public StoryModule(Context context) {
        this.context = context;
    }

    @Provides
    StoryPresenter storyPresenter(StoryUseCase storyUseCase) {
        return new StoryPresenter(storyUseCase);
    }

    @Provides
    StoryUseCase storyUseCase(StoryDataSource storyDataSource) {
        return new StoryUseCase(storyDataSource);
    }

    @Provides
    StoryDataSource storyRepository(ChapterParser chapterParser, StoryNodeMapper storyNodeMapper) {
        return new StoryRepository(chapterParser, storyNodeMapper);
    }

    @Provides
    ChapterParser chapterParser() {
        return new ChapterParser(context);
    }

    @Provides
    StoryNodeMapper storyNodeMapper() {
        return new StoryNodeMapper();
    }

}
