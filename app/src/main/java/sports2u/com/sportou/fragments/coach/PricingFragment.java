package sports2u.com.sportou.fragments.coach;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sports2u.com.sportou.R;

public class PricingFragment extends Fragment {

    private static final String COACH_ONE = "one";
    private static final String COACH_GROUP = "group";

    private OnFragmentInteractionListener mListener;
    private String coachOne;
    private String coachGroup;

    public PricingFragment() {
        // Required empty public constructor
    }

    public static PricingFragment newInstance(String coachOne, String coachGroup) {
        Bundle bundle = new Bundle();
        bundle.putString(COACH_ONE, coachOne);
        bundle.putString(COACH_GROUP, coachGroup);
        PricingFragment fragment = new PricingFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coachOne = getArguments().getString(COACH_ONE);
        coachGroup = getArguments().getString(COACH_GROUP);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pricing, container, false);
        ((TextView) view.findViewById(R.id.price_one)).setText(coachOne);
        ((TextView) view.findViewById(R.id.price_group)).setText(coachGroup);
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
