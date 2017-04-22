package com.arao.cheapsoapopera.injection.component;

import com.arao.cheapsoapopera.injection.scope.PerActivity;
import com.arao.cheapsoapopera.story.StoryModule;
import com.arao.cheapsoapopera.story.StoryActivity;

import dagger.Component;

@PerActivity
@Component (dependencies = {ApplicationComponent.class}, modules = {StoryModule.class})
public interface StoryComponent {

    void inject(StoryActivity storyActivity);

}
