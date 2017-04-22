package com.arao.cheapsoapopera.story;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.arao.cheapsoapopera.CsoApplication;
import com.arao.cheapsoapopera.R;
import com.arao.cheapsoapopera.injection.component.DaggerStoryComponent;
import com.arao.cheapsoapopera.injection.component.StoryComponent;
import com.arao.cso.domain.story.StoryLine;

import javax.inject.Inject;

public class StoryActivity extends AppCompatActivity implements View.OnClickListener, StoryView {

    @Inject
    StoryPresenter storyPresenter;

    private TextView storyLineHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        resolveDependencies();

        initViews();

        storyPresenter.initialise(this);
    }

    private void resolveDependencies() {
        StoryComponent storyComponent = DaggerStoryComponent.builder()
                .applicationComponent(CsoApplication.get(this).getComponent())
                .storyModule(new StoryModule())
                .build();
        storyComponent.inject(this);
    }

    @Override
    public void onClick(View v) {
        storyPresenter.onContinueStoryPressed();
    }

    private void initViews() {
        storyLineHolder = (TextView) findViewById(R.id.story_line_holder);
        storyLineHolder.setOnClickListener(this);
    }

    @Override
    public void renderStoryLine(StoryLine storyLine) {
        storyLineHolder.setText(storyLine.getText());
    }
}
