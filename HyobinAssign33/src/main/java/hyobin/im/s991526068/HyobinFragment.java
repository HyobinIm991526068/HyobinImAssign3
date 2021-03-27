
package hyobin.im.s991526068;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HyobinFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HyobinFragment extends Fragment {

    private static final String TAG = "Hyobin";
    private PageViewModel pageViewModel;
    private CanvasView customCanvas;

    public HyobinFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_hyobin, container, false);
        customCanvas =(CanvasView) root.findViewById(R.id.hyobin_canvas);
        Button clearCanvas = (Button)root.findViewById(R.id.hyobinBtn);
        clearCanvas.setOnClickListener((View.OnClickListener) this);
        return root;
    }
}