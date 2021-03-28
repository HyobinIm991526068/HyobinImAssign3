/**
 *  Assignment 3
 *  Hyobin Im
 *  991526068
 *  Class: 1211_34780
 */
package hyobin.im.s991526068;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "Im";
    private PageViewModel pageViewModel;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 777;
    private View view;
    ImageView imageView;
    AnimationDrawable mframeAnimation = null;
    private int speed;
    private int duration = 250;
    private Spinner spinner;


    public ImFragment() {
        // Required empty public constructor
    }


    public static ImFragment newInstance() {
        return new ImFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_im, container, false);
        imageView = (ImageView) view.findViewById(R.id.hyobin_imageView);

        spinner = (Spinner) view.findViewById(R.id.hyobin_speed_spinner);

        final Button callButton = (Button) view.findViewById(R.id.hyobin_call_button);
        callButton.setOnClickListener((View.OnClickListener) this);

        final Button startButton = (Button) view.findViewById(R.id.hyobin_start_button);
        startButton.setOnClickListener((View.OnClickListener) this);

        final Button stopButton = (Button) view.findViewById(R.id.hyobin_stop_button);
        stopButton.setOnClickListener((View.OnClickListener) this);

        final Button speedButton = (Button) view.findViewById(R.id.hyobin_speed_button);
        speedButton.setOnClickListener((View.OnClickListener) this);

        return view;
    }

    @Override
    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.hyobin_call_button:
                if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CODE_ASK_PERMISSIONS);
                }else{
                    call();
                }
                break;
            case R.id.hyobin_start_button:
                startAnimation();
                break;
            case R.id.hyobin_stop_button:
                stopAnimation();
                break;
            case R.id.hyobin_speed_button:
                setSpeed();
                break;
        }
    }

    public void call()
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: 1234567890"));
        getActivity().startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void startAnimation()
    {
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.run1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.run2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.run3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.run4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.run5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.run6);

        // Get the background, which has been compiled to an AnimationDrawable object.
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, duration);
        mframeAnimation.addFrame(frame2, duration);
        mframeAnimation.addFrame(frame3, duration);
        mframeAnimation.addFrame(frame4, duration);
        mframeAnimation.addFrame(frame5, duration);
        mframeAnimation.addFrame(frame6, duration);

        imageView.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);
    }

    private void setSpeed()
    {
        TextView selected = (TextView)spinner.getSelectedView();
        speed = Integer.valueOf(selected.getText().toString());
        duration = speed;
    }
}
