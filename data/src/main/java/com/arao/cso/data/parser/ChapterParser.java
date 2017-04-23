package com.arao.cso.data.parser;

import android.content.Context;
import android.util.SparseArray;

import com.arao.cso.data.story.NodeOption;
import com.arao.cso.data.story.StoryNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChapterParser {

    private Context context;

    public ChapterParser(Context context) {
        this.context = context;
    }

    public SparseArray<StoryNode> parseChapter(int chapter) {
        SparseArray<StoryNode> storyNodes = new SparseArray<>();
        InputStream fis = null;
        try {
            fis = context.getAssets().open(String.format("chapter%d.txt", chapter));

            if (fis != null) {
                InputStreamReader chapterReader = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(chapterReader);

                String line = bufferedReader.readLine();
                while (line != null) {
                    String separator = "/";
                    String[] tokens = line.split(separator);
                    List<NodeOption> nodeOptions = null;
                    if (tokens.length > 3) {
                        nodeOptions = new ArrayList<>();
                        for (int i = 0; i < tokens.length - 3; i++) {
                            String[] s = tokens[i + 3].split("\\$");
                            nodeOptions.add(new NodeOption(s[0], Integer.parseInt(s[1])));
                        }
                    }
                    StoryNode storyNode = new StoryNode(Integer.parseInt(tokens[0]), tokens[1], tokens[2], nodeOptions);
                    storyNodes.put(storyNode.getId(), storyNode);
                    line = bufferedReader.readLine();
                }

            }
        } catch (Exception e) {
            // print stack trace.
        } finally {
            // close the file.
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return storyNodes;
    }

}
