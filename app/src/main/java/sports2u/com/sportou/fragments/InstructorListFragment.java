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

import sports2u.com.sportou.R;
import sports2u.com.sportou.fragments.instructor_list.DistanceListFragment;
import sports2u.com.sportou.fragments.instructor_list.PriceListFragment;
import sports2u.com.sportou.fragments.instructor_list.RankingListFragment;

public class InstructorListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public InstructorListFragment() {
        // Required empty public constructor
    }

    public static InstructorListFragment newInstance() {
        return new InstructorListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(savedInstanceState != null)
            return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_instructor_list, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager.setOffscreenPageLimit(3);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(RankingListFragment.newInstance(), "Rating");
        adapter.addFragment(DistanceListFragment.newInstance(), "Distance");
        adapter.addFragment(PriceListFragment.newInstance(), "Price");

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
