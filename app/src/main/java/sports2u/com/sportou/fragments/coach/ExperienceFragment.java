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

public class ExperienceFragment extends Fragment {

    private static final String SPORT = "sport";
    private static final String COACH = "coach";
    private static final String STUDENT = "student";

    private String sportExperience;
    private String coachExperience;
    private String studentExperience;

    private OnFragmentInteractionListener mListener;

    public ExperienceFragment() {
        // Required empty public constructor
    }

    public static ExperienceFragment newInstance(String sportExperience, String coachExperience, String studentExperience) {
        Bundle bundle = new Bundle();
        bundle.putString(SPORT, sportExperience);
        bundle.putString(COACH, coachExperience);
        bundle.putString(STUDENT, studentExperience);
        ExperienceFragment fragment = new ExperienceFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportExperience = getArguments().getString(SPORT);
        coachExperience = getArguments().getString(COACH);
        studentExperience = getArguments().getString(STUDENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_experience, container, false);
        ((TextView) view.findViewById(R.id.exp_sport)).setText(sportExperience);
        ((TextView) view.findViewById(R.id.exp_coach)).setText(coachExperience);
        ((TextView) view.findViewById(R.id.exp_student)).setText(studentExperience);
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
