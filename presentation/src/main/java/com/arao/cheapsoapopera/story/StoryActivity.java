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
    private TextView option1;
    private TextView option2;
    private TextView option3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        resolveDependencies();
        initViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        storyPresenter.initialise(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.story_line_holder:
                storyPresenter.onContinueStoryPressed();
                break;
            case R.id.option1:
                storyPresenter.onStoryOptionSelected(0);
                break;
            case R.id.option2:
                storyPresenter.onStoryOptionSelected(1);
                break;
            case R.id.option3:
                storyPresenter.onStoryOptionSelected(2);
                break;
        }
    }

    @Override
    public void renderStoryLine(StoryLine storyLine) {
        option1.setText("");
        option2.setText("");
        option3.setText("");
        storyLineHolder.setText(storyLine.getText());
        if (storyLine.getOptions() != null) {
            for (int i = 0; i < storyLine.getOptions().size(); i++) {
                if (i == 0) {
                    option1.setText(storyLine.getOptions().get(i));
                } else if (i == 1) {
                    option2.setText(storyLine.getOptions().get(i));
                } else if (i == 2) {
                    option3.setText(storyLine.getOptions().get(i));
                }
            }
        }
    }

    private void resolveDependencies() {
        StoryComponent storyComponent = DaggerStoryComponent.builder()
                .applicationComponent(CsoApplication.get(this).getComponent())
                .storyModule(new StoryModule(this))
                .build();
        storyComponent.inject(this);
    }

    private void initViews() {
        storyLineHolder = (TextView) findViewById(R.id.story_line_holder);
        storyLineHolder.setOnClickListener(this);
        option1 = (TextView) findViewById(R.id.option1);
        option1.setOnClickListener(this);
        option2 = (TextView) findViewById(R.id.option2);
        option2.setOnClickListener(this);
        option3 = (TextView) findViewById(R.id.option3);
        option3.setOnClickListener(this);
    }
}
