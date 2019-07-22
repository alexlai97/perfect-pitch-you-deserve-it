package com.example.pitchperfectlyaccuratelypractice.ModeFragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.pitchperfectlyaccuratelypractice.ModeFragments.GeneralFragment;
import com.example.pitchperfectlyaccuratelypractice.R;
import com.example.pitchperfectlyaccuratelypractice.activities.MainActivity;
import com.example.pitchperfectlyaccuratelypractice.model.Model;
import com.example.pitchperfectlyaccuratelypractice.music.Song;
import com.example.pitchperfectlyaccuratelypractice.question.SongQuestion;
import com.example.pitchperfectlyaccuratelypractice.tools.MidiSongPlayer;

public class SongGeneralFragment extends GeneralFragment {
    private static String TAG = "SongGeneralFragment";

    //private TextView prevNoteText;
    //private TextView currentNoteText;
    //private TextView nextNoteText;

    private ConstraintLayout prevNoteLayout;
    private ConstraintLayout currentNoteLayout;
    private ConstraintLayout nextNoteLayout;

    private TextView currentLyricsText;
    protected TextView songTitleText;

    protected Spinner librarySpinner;

    protected MidiSongPlayer midiSongPlayer;
    protected Model model;

    @Override
    void setupAdditionalView() {
        prevNoteLayout = constraintLayout.findViewById(R.id.previous_note_include);
        currentNoteLayout = constraintLayout.findViewById(R.id.current_note_include);
        nextNoteLayout = constraintLayout.findViewById(R.id.next_note_include);
        currentLyricsText = constraintLayout.findViewById(R.id.lyricsTextView);
        librarySpinner = constraintLayout.findViewById(R.id.librarySpinner);
        model = ((MainActivity)(getActivity())).getModel();
        songTitleText = constraintLayout.findViewById(R.id.songTitleTextView);

        ArrayAdapter<String> all_songs_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, model.getSongList().getSongTitles());
        librarySpinner.setAdapter(all_songs_adapter);


        setupSongAdditionalView();
    }

    // FIXME
    @Override
    public void listenerSetUp() {

    }

    void setupSongAdditionalView() {

    }

    @Override
    public void updateQuestionTexts(String [] texts){
        if(!onCreated) return;
        if (texts.length != 3) { throw new AssertionError("expecting texts' length is 3"); }
        char[] charArray = texts[0].toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (i == 0) {
                ((TextView) prevNoteLayout.findViewById(R.id.NoteTextView)).setText("" + charArray[i]);
            } else if (i == 1) {
                ((TextView) prevNoteLayout.findViewById(R.id.NoteScaleTextView)).setText("" + charArray[i]);
            } else if (i == 2) {
                ((TextView) prevNoteLayout.findViewById(R.id.NoteSigView)).setText("" + charArray[i]);
            }
        }
        char[] charArray1 = texts[1].toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (i == 0) {
                ((TextView) currentNoteLayout.findViewById(R.id.NoteTextView)).setText("" + charArray1[i]);
            } else if (i == 1) {
                ((TextView) currentNoteLayout.findViewById(R.id.NoteScaleTextView)).setText("" + charArray1[i]);
            } else if (i == 2) {
                ((TextView) currentNoteLayout.findViewById(R.id.NoteSigView)).setText("" + charArray1[i]);
            }
        }
        char[] charArray2 = texts[2].toCharArray();
        for (int i = 0; i < charArray.length; ++i) {
            if (i == 0) {
                ((TextView) nextNoteLayout.findViewById(R.id.NoteTextView)).setText("" + charArray2[i]);
            } else if (i == 1) {
                ((TextView) nextNoteLayout.findViewById(R.id.NoteScaleTextView)).setText("" + charArray2[i]);
            } else if (i == 2) {
                ((TextView) nextNoteLayout.findViewById(R.id.NoteSigView)).setText("" + charArray2[i]);
            }
        }
    }

    public void updateLyricsView(String str) {
        if (str == null) throw new AssertionError("str is null when updating lyrics");
        currentLyricsText.setText(str);
    }
}