package sports2u.com.sportou.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import sports2u.com.sportou.R;

public class MainFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        LinearLayout layoutSearch = (LinearLayout) view.findViewById(R.id.layout_search);
        ImageButton btnSearch = (ImageButton) view.findViewById(R.id.btn_search);
        TextView tbxSearch = (TextView) view.findViewById(R.id.tbx_search);
        final EditText tbxSport = (EditText) view.findViewById(R.id.tbx_sport);
        final EditText tbxLocation = (EditText) view.findViewById(R.id.tbx_location);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_holder, InstructorListFragment.newInstance(tbxSport.getText().toString(), tbxLocation.getText().toString()))
                        .commit();
            }
        };

        layoutSearch.setOnClickListener(listener);
        btnSearch.setOnClickListener(listener);
        tbxSearch.setOnClickListener(listener);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
