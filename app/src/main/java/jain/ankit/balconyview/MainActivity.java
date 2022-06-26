package jain.ankit.balconyview;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class MainActivity extends AppCompatActivity {
    StyledPlayerView exoPlayerView;

    String url= "rtsp://tplinkcam1:tplinkcam1@192.168.1.2/stream1";
// credits: https://exoplayer.dev/hello-world.html
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exoPlayerView = findViewById(R.id.exoPlayerView);

        ExoPlayer exoPlayer = new ExoPlayer.Builder(this).build();
        exoPlayerView.setPlayer(exoPlayer);
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(url));
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.play();
    }
}