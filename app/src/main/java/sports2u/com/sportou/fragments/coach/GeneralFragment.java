package sports2u.com.sportou.fragments.coach;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sports2u.com.sportou.R;

public class GeneralFragment extends Fragment {

    private static final String DESCRIPTION = "longDescription";
    private static final String LOCATION = "location";

    private OnFragmentInteractionListener mListener;
    private String longDesc;
    private String location;

    public GeneralFragment() {
        // Required empty public constructor
    }

    public static GeneralFragment newInstance(String longDesc, String location) {
        Bundle bundle = new Bundle();
        bundle.putString(DESCRIPTION, longDesc);
        bundle.putString(LOCATION, location);
        GeneralFragment fragment = new GeneralFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        longDesc = getArguments().getString(DESCRIPTION);
        location = getArguments().getString(LOCATION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general, container, false);
        ((TextView) view.findViewById(R.id.long_desc)).setText(longDesc);
        ((TextView) view.findViewById(R.id.location)).setText(location);
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
