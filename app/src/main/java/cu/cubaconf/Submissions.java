package cu.cubaconf;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cu.cubaconf.adapter.SubmissionAdapter;
import cu.cubaconf.model.Submission;

public class Submissions extends AppCompatActivity {

    public EditText search;
    public ListView submissionsListView;
    private Reader reader;
    private Submission[] submissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submissions);

        ActionBar bar = getSupportActionBar();
        bar.setTitle(getString(R.string.proposals));
        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_TITLE);
        bar.setHomeButtonEnabled(true);

        submissionsListView = (ListView) findViewById(R.id.submissionsList);

        Gson GSON = new Gson();

        try {
            reader = new InputStreamReader(getAssets().open("data/submissions.json"));
            submissions = GSON.fromJson(reader, Submission[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        search = (EditText) findViewById(R.id.EditTextSearch);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<Submission> newsubs = new ArrayList<Submission>();

                for (Submission submission : submissions) {
                    if (submission.getSummary().toLowerCase().contains(String.valueOf(s).toLowerCase())
                            || submission.getName().toLowerCase().contains(String.valueOf(s).toLowerCase())
                            || submission.getTitle().toLowerCase().contains(String.valueOf(s).toLowerCase())) {
                        newsubs.add(submission);
                    }
                }

                submissionsListView.setAdapter(new SubmissionAdapter(getBaseContext(), newsubs.toArray(new Submission[newsubs.size()])));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Collections.shuffle(Arrays.asList(submissions));

        submissionsListView.setAdapter(new SubmissionAdapter(this, submissions));

        hideKeyboard();
    }

    public void hideKeyboard() {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
