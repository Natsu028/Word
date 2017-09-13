package com.example.kodakanatsumi.words;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Card> mCards;
    CardAdapter mCardAdapter;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.LsitView);
        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.study, getString(R.string.study_title), getString(R.string.study_content),
                getString(R.string.study_meaning)));

        mCards.add(new Card(R.drawable.walk, getString(R.string.walk_title), getString(R.string.walk_content),
                getString(R.string.walk_meaning)));

        mCards.add(new Card(R.drawable.surprise, getString(R.string.surprise_title), getString(R.string.surprise_content),
                getString(R.string.surprise_meaning)));

        mCards.add(new Card(R.drawable.tokyo, getString(R.string.tokyo_title), getString(R.string.tokyo_content),
                getString(R.string.tokyo_meaning)));

        mCards.add(new Card(R.drawable.apple, "apple", "I use Apple products.", "リンゴ（製品）"));

        mCardAdapter = new CardAdapter(this, R.layout.card, mCards);
        mListView.setAdapter(mCardAdapter);

    }
}
