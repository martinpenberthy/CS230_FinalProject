package com.example.finalproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import com.example.finalproject.R;
import com.example.finalproject.model.RetroPhoto;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RetroPhoto> dataList;
    private Context context;
    private View.OnClickListener mOnItemClickListener;


    public CustomAdapter(Context context,List<RetroPhoto> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    //CustomViewHolder Class
    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);

            // Step 3 of 4: setTag() as current view holder along with
            // setOnClickListener() as your local View.OnClickListener variable.
            // You can set the same mOnItemClickListener on multiple views if required
            // and later differentiate those clicks using view's id.
            mView.setTag(this);
            mView.setOnClickListener(mOnItemClickListener);
        }
    }//END Class

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        //holder.txtTitle.setText(dataList.get(position).getTitle());

        //Set the text based on what sound will be assigned to it
        switch (position) {
            case 0:
                holder.txtTitle.setText("Kick");
                break;
            case 1:
                holder.txtTitle.setText("Snare");
                break;
            case 2:
                holder.txtTitle.setText("Hat");
                break;
            case 3:
                holder.txtTitle.setText("Vox");
                break;
            case 4:
                holder.txtTitle.setText("Glitch");
                break;
            case 5:
                holder.txtTitle.setText("Beatbox");
                break;
            default:
                holder.txtTitle.setText(dataList.get(position).getTitle());
                break;
        }
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }
/*
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        //holder.txtTitle.setText(dataList.get(position).getFileSizeBytes());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }*/

    @Override
    public int getItemCount() {
        // Log.d("Debug", "SIZE OF DATALIST");
        //Log.d("Debug", String.valueOf(dataList.size()));
        return dataList.size();
    }


    // Step 2 of 4: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }
}