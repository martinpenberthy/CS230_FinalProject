package com.example.finalproject.activity;

import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.adapter.CustomAdapter;
import com.example.finalproject.R;
import com.example.finalproject.model.RetroPhoto;
import com.example.finalproject.network.GetDataService;
import com.example.finalproject.network.RetrofitClientInstance;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    private SoundPool soundPool;
    private int sound1_kick, sound2_snare, sound3_hat, sound4_vox, sound5_glitch, sound6_beatbox;

    //Implement a View onClickListener
    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Step 4 of 4: Finally call getTag() on the view.
            // This viewHolder will have all required values.
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            // viewHolder.getItemId();
            // viewHolder.getItemViewType();
            // viewHolder.itemView;
            //TestItem thisItem = mTestItemList.get(position);
            //Toast.makeText(MainActivity.this, "You Clicked: " + thisItem.getTitle(), Toast.LENGTH_SHORT).show();

            Log.d("Debug", "CLICKED");
            Log.d("Debug", String.valueOf(position));

            playSound(position);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        // Create a reference for the RetrofitInstance interface
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        //Get photos
        Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        }else
        {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        //Load sounds
        sound1_kick = soundPool.load(this, R.raw.sound1_kick, 1);
        sound2_snare = soundPool.load(this, R.raw.sound2_snare, 1);
        sound3_hat = soundPool.load(this, R.raw.sound3_hat, 1);
        sound4_vox = soundPool.load(this, R.raw.sound4_vox, 1);
        sound5_glitch = soundPool.load(this, R.raw.sound5_glitch, 1);
        sound6_beatbox = soundPool.load(this, R.raw.sound6_beatbox, 1);

    }

    private void generateDataList(List<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);

        adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //Create and set OnItemClickListener
        adapter.setOnItemClickListener(onItemClickListener);
    }

    //Handle sound events
    public void playSound(int position)
    {
        switch(position)
        {
            case 0:

                soundPool.play(sound1_kick, 1.0f, 1.0f, 0, 0, 1);
                break;

            case 1:
                soundPool.play(sound2_snare, 1.0f, 1.0f, 0, 0, 1);
                break;

            case 2:
                soundPool.play(sound3_hat, 1.0f, 1.0f, 0, 0, 1);
                break;

            case 3:
                soundPool.play(sound4_vox, 1.0f, 1.0f, 0, 0, 1);
                break;

            case 4:
                soundPool.play(sound5_glitch, 1.0f, 1.0f, 0, 0, 1);
                break;

            case 5:
                soundPool.play(sound6_beatbox, 1.0f, 1.0f, 0, 0, 1);
                break;
            default:
                Random rand = new Random();
                int randValue = rand.nextInt(6);
                Log.d("Debug", "RandValue");
                Log.d("Debug", String.valueOf(randValue));
                switch(randValue) {
                    case 0:

                        soundPool.play(sound1_kick, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    case 1:
                        soundPool.play(sound2_snare, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    case 2:
                        soundPool.play(sound3_hat, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    case 3:
                        soundPool.play(sound4_vox, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    case 4:
                        soundPool.play(sound5_glitch, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    case 5:
                        soundPool.play(sound6_beatbox, 1.0f, 1.0f, 0, 0, 1);
                        break;

                    default:
                        break;
                }

                break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }



}