package cu.cubaconf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.joanzapata.iconify.widget.IconTextView;

import cu.cubaconf.model.Submission;

public class SubmissionDetail extends AppCompatActivity {

    Submission submission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission_detail);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP | ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_TITLE);
        bar.setHomeButtonEnabled(true);

        submission = (Submission) getIntent().getSerializableExtra("submission");

        bar.setTitle(submission.getTitle());

        TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        TextView textViewAuthorName = (TextView) findViewById(R.id.textViewAuthorName);
        TextView textViewTwitter = (TextView) findViewById(R.id.textViewTwitter);
        TextView textViewOrganization = (TextView) findViewById(R.id.textViewOrganization);
        TextView textViewBio = (TextView) findViewById(R.id.textViewBio);


        textViewTitle.setText(submission.getTitle());
        textViewDescription.setText(submission.getDescription());
        textViewAuthorName.setText(submission.getName());

        if (!submission.getTwitter().equals("")) {
            textViewTwitter.setText("@" + submission.getTwitter());
        } else {
            textViewTwitter.setVisibility(View.GONE);
            IconTextView icon = (IconTextView) findViewById(R.id.iconTwitter);
            icon.setVisibility(View.GONE);
        }

        if (!submission.getOrganization().equals("")) {
            textViewOrganization.setText(submission.getOrganization());
        } else {
            textViewOrganization.setVisibility(View.GONE);
            IconTextView icon = (IconTextView) findViewById(R.id.iconOrg);
            icon.setVisibility(View.GONE);
        }
        textViewBio.setText(submission.getBio());
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

    public void openURI(String uri) {
        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(Uri.parse(uri));
        startActivity(callIntent);
    }

    public void clickTwitterUser(View view) {
        openURI("https://twitter.com/" + submission.getTwitter());
    }

}
