package com.example.kodakanatsumi.words;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.net.NetworkInfo;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by kodakanatsumi on 2017/06/20.
 */

public class CardAdapter extends ArrayAdapter<Card> {

    List<Card> mCard;

    public CardAdapter(Context context, int layoutResourceId, List<Card> objects) {
        super(context, layoutResourceId, objects);

        mCard = objects;
    }

    @Override
    public int getCount() {
        return mCard.size();
    }

    @Override
    public Card getItem(int position) {
        return mCard.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final ViewHoler viewHoler;

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card, null);
            viewHoler = new ViewHoler(convertView);
            convertView.setTag(viewHoler);
        }else {
            viewHoler = (ViewHoler) convertView.getTag();
        }

        final Card item = getItem(position);

        if (item != null){

            viewHoler.iconImageView.setBackgroundResource(item.imageId);
            viewHoler.titleTextView.setText(item.title);
            viewHoler.contentTectView.setText(item.content);
            viewHoler.likeButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    item.likeNum++;
                    viewHoler.likeTextView.setText(item.likeNum + "Likes");

                    if (!item.isChecked){
                        viewHoler.likeButton.setImageResource(R.drawable.ic_done_all_black_24dp);
                        item.isChecked = true;

                    }else {
                        viewHoler.likeButton.setImageResource(R.drawable.ic_done_black_24dp);
                        item.isChecked = false;
                    }

                    Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.like_touch);
                    viewHoler.likeButton.startAnimation(animation);


                }
            });
            viewHoler.iconImageView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Toast.makeText(getContext(), item.meaning, Toast.LENGTH_SHORT).show();
                }
            });

        }

        return convertView;
    }


    private class ViewHoler {
        ImageView iconImageView;
        TextView titleTextView;
        TextView likeTextView;
        TextView contentTectView;
        ImageView likeButton;


        public ViewHoler(View view) {
            iconImageView = (ImageView) view.findViewById(R.id.icon);
            titleTextView = (TextView) view.findViewById(R.id.title_textview);
            likeTextView = (TextView) view.findViewById(R.id.like_textview);
            contentTectView = (TextView) view.findViewById(R.id.content);
            likeButton = (ImageView) view.findViewById(R.id.like_button);
        }
    }

}

