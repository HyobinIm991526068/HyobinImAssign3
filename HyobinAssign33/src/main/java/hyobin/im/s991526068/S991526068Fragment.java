/**
 *  Assignment 3
 *  Hyobin Im
 *  991526068
 *  Class: 1211_34780
 */
package hyobin.im.s991526068;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class S991526068Fragment extends Fragment {

    private TextView firstName;
    private TextView lastName;
    private ImageView imageView;
    private Animation rotateLeft;
    private Animation rotateRight;
    private Animation orbit;
    Context context;
    private static final String TAG = "S991526068";
    private PageViewModel pageViewModel;

    public S991526068Fragment() {
        // Required empty public constructor
    }


    public static S991526068Fragment newInstance() {
        return new S991526068Fragment();
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

        context = container.getContext();
        View view = inflater.inflate(R.layout.fragment_s991526068, container, false);
        firstName =(TextView)view.findViewById(R.id.hyobin_firstname);
        lastName = (TextView)view.findViewById(R.id.hyobin_lastname);
        imageView = (ImageView)view.findViewById(R.id.hyobin_moon);

        rotateLeft = AnimationUtils.loadAnimation(context, R.anim.rotate_left);
        rotateRight = AnimationUtils.loadAnimation(context, R.anim.rotate_right);
        orbit = AnimationUtils.loadAnimation(context, R.anim.moon_orbit);

        firstName.startAnimation(rotateLeft);
        lastName.startAnimation(rotateRight);
        imageView.startAnimation(orbit);
        return view;
    }
}