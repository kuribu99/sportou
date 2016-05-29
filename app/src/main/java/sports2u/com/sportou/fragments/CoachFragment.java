package sports2u.com.sportou.fragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import sports2u.com.sportou.Coach;
import sports2u.com.sportou.DataController;
import sports2u.com.sportou.R;
import sports2u.com.sportou.fragments.coach.ExperienceFragment;
import sports2u.com.sportou.fragments.coach.GeneralFragment;
import sports2u.com.sportou.fragments.coach.PricingFragment;

public class CoachFragment extends Fragment {
//
    private static final String COACH = "coach";
//    private static final String ARG_PARAM2 = "param2";
//
//    private String mParam1;
//    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Coach coach;

    public CoachFragment() {
        // Required empty public constructor
    }

    public static CoachFragment newInstance() {
        CoachFragment fragment = new CoachFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public static CoachFragment newInstance(Coach coach) {
        CoachFragment fragment = new CoachFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(COACH, coach.asStringArray());
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            coach = Coach.fromStringArray(getArguments().getStringArrayList(COACH));
        else
            coach = DataController.getInstance().getCoaches().get(0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coach, container, false);

        ((TextView) view.findViewById(R.id.name)).setText(coach.getName());
        ((ImageView) view.findViewById(R.id.img)).setImageResource(coach.getImageID());
        ((TextView) view.findViewById(R.id.short_desc)).setText(coach.getShortDescription());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(GeneralFragment.newInstance(coach.getLongDescription(), coach.getLocation()), "General");
        adapter.addFragment(ExperienceFragment.newInstance(coach.getSportExperience(), coach.getCoachExperience(), coach.getStudentExperience()), "Experience");
        adapter.addFragment(PricingFragment.newInstance(coach.getOneCoach(), coach.getGroupCoach()), "Pricing");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

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
