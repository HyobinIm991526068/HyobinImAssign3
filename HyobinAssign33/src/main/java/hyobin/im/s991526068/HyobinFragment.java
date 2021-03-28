
package hyobin.im.s991526068;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HyobinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HyobinFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "Hyobin";
    private PageViewModel pageViewModel;
    private CanvasView customCanvas;
    private Spinner colorSpinner;
    private Spinner thicknessSpinner;
    //String selectedColor;
    //String selectedThickness;

    public HyobinFragment() {
        // Required empty public constructor
    }

    public static HyobinFragment newInstance() {
        return new HyobinFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hyobin, container, false);
        customCanvas =(CanvasView) view.findViewById(R.id.hyobin_canvas);

        colorSpinner = (Spinner) view.findViewById(R.id.hyobin_color_spinner);
        thicknessSpinner = (Spinner) view.findViewById(R.id.hyobin_thickness_spinner);

        Button clearCanvas = (Button)view.findViewById(R.id.hyobinBtn);
        clearCanvas.setOnClickListener((View.OnClickListener) this);

        Button changeBrush = (Button)view.findViewById(R.id.hyobin_changebrush_button);
        changeBrush.setOnClickListener((View.OnClickListener) this);
        return view;
    }

    @Override
    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.hyobinBtn:
                customCanvas.wipeCanvas();
                break;
            case R.id.hyobin_changebrush_button:
                TextView selectedColor = ((TextView)colorSpinner.getSelectedView());
                TextView selectedThickness = ((TextView)thicknessSpinner.getSelectedView());
                String c = selectedColor.getText().toString();
                String t = selectedThickness.getText().toString();
                setBrush(c, t);
                break;
        }
    }

    public void setBrush(String color, String thickness)
    {
        if (color.equals("BLUE")){
            customCanvas.setBlue();
        } else if (color.equals("BLACK")){
            customCanvas.setBlack();
        } else if (color.equals("RED")){
            customCanvas.setRed();
        }

        if (thickness.equals("Thin")){
            customCanvas.setThin();
        } else if (thickness.equals("Medium")){
            customCanvas.setMedium();
        } else if (thickness.equals("Thick")){
            customCanvas.setThick();
        }
    }
}