package jain.ankit.balconyview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView mVideoView;
    MediaController mediaController;

    String url= "rtsp://tplinkcam1:tplinkcam1@192.168.1.2/stream1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaController = new MediaController(this);
        mVideoView = findViewById(R.id.mVideoView);

        mediaController.setAnchorView(mVideoView);

        mVideoView.setVideoURI(Uri.parse(url));
        mVideoView.setMediaController(mediaController);
        mVideoView.start();

        ProgressDialog progressDialog= ProgressDialog.show(this, "Loading", "Please wait...", true);

        mVideoView.setOnPreparedListener(mediaPlayer -> progressDialog.dismiss());

        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(getApplicationContext(), "Oops An Error Occurred While Playing Video...!!!", Toast.LENGTH_LONG).show(); // display a toast when an error is occured while playing an video
                return false;
            }
        });
    }
}