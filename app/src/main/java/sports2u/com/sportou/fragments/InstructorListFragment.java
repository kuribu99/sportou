package sports2u.com.sportou.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sports2u.com.sportou.R;
import sports2u.com.sportou.fragments.instructor_list.DistanceListFragment;
import sports2u.com.sportou.fragments.instructor_list.PriceListFragment;
import sports2u.com.sportou.fragments.instructor_list.RatingListFragment;

public class InstructorListFragment extends Fragment {

    public static final String TYPE = "type";
    public static final String LOCATION = "location";

    private String type;
    private String location;

    private OnFragmentInteractionListener mListener;

    public InstructorListFragment() {
        // Required empty public constructor
    }

    public static InstructorListFragment newInstance(String type, String location) {
        Bundle bundle = new Bundle();
        bundle.putString(TYPE, type);
        bundle.putString(LOCATION, location);
        InstructorListFragment fragment = new InstructorListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString(TYPE);
        location = getArguments().getString(LOCATION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null)
            return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_instructor_list, container, false);

        ((TextView) view.findViewById(R.id.tbx_search)).setText(String.format(
                "Searching for %s coaches from %s",
                type.isEmpty() || type.equals("Any sports")? "any": type,
                location.isEmpty() || location.equals("Any locations")? "any places": location));

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(RatingListFragment.newInstance(type, location), "Rating");
        adapter.addFragment(DistanceListFragment.newInstance(type, location), "Distance");
        adapter.addFragment(PriceListFragment.newInstance(type, location), "Price");

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
