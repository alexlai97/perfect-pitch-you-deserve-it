package com.example.pitchperfectlyaccuratelypractice.fragments;

import android.graphics.Color;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.TextView;

import com.example.pitchperfectlyaccuratelypractice.R;

/**
 * a children of general fragment
 * it has questionNoteText view, questionIntervalText view
 */
public class IntervalFragment extends GeneralFragment {
    private static String TAG = "IntervalFragment";

    /**
     * question note on top of question interval
     */
    private TextView questionNoteText;
    /**
     * question interval on botton of question note
     */
    private TextView questionIntervalText;

    private TextView arrowText;

    /**
     * constructor of IntervalFragment
     * setup resource (see parent onCreateView for use)
     */
    public IntervalFragment() {
        resource = R.layout.fragment_interval;
        background_color = Color.parseColor("#BDE8D8");
    }

    /**
     * set up views of questionNoteText and questionIntervalText
     */
    @Override
    void setupAdditionalView() {
        Log.d(TAG, "setupAdditionalView: ");
        questionNoteText = constraintLayout.findViewById(R.id.questionNoteTextView);
        if (questionNoteText == null) {
            throw new AssertionError("questionNoteText is null");
        }
        questionIntervalText = constraintLayout.findViewById(R.id.questionIntervalTextView);
        if (questionIntervalText == null) { throw new AssertionError("questionIntervalText is null"); }
        arrowText = constraintLayout.findViewById(R.id.arrowTextView);
    }
    /**
     * update questions, question text + interval text
     *
     * @param texts
     */
    @Override
    public void updateQuestionTexts(String [] texts){
        if(!onCreated) return;
        if (texts.length != 2) { throw new AssertionError("expecting texts' length is 2"); }
        questionNoteText.setText(texts[0]);
        questionIntervalText.setText(texts[1]);
    }

    /**
     * update arrow text views
     * @param arrowTexts
     */
    @Override
    public void updateArrowTexts(String[] arrowTexts){
        if(!onCreated) return;
        arrowText.setText(arrowTexts[0]);
    }

    @Override
    public void updateArrowAnimation(Animation myAnimation){
        if(!onCreated) return;
        arrowText.setAnimation(myAnimation);
    }

    @Override
    public String getPopupText() {
        return "This is the interval mode, the note displayed is called the base note. \n\n" +
                "The text below it is the 'interval', where it tells you how much you are supposed to sing above or below the bass note. \n\n" +
                "Example. ...";
    }
}
