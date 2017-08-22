package cu.cubaconf;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
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


        Collections.shuffle(Arrays.asList(submissions));

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            submissionsListView.setAdapter(new SubmissionAdapter(getBaseContext(), search(query)));
        } else {
            submissionsListView.setAdapter(new SubmissionAdapter(this, submissions));
        }

        hideKeyboard();
    }

    public Submission[] search(String s) {
        ArrayList<Submission> newsubs = new ArrayList<Submission>();

        for (Submission submission : submissions) {
            if (submission.getSummary().toLowerCase().contains(String.valueOf(s).toLowerCase())
                    || submission.getName().toLowerCase().contains(String.valueOf(s).toLowerCase())
                    || submission.getTitle().toLowerCase().contains(String.valueOf(s).toLowerCase())) {
                newsubs.add(submission);
            }
        }

        return newsubs.toArray(new Submission[newsubs.size()]);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the options menu from XML
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
//        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
