package sports2u.com.sportou.fragments.instructor_list;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import sports2u.com.sportou.Coach;
import sports2u.com.sportou.CoachListAdapter;
import sports2u.com.sportou.DataController;
import sports2u.com.sportou.R;
import sports2u.com.sportou.fragments.CoachFragment;
import sports2u.com.sportou.fragments.InstructorListFragment;

public class DistanceListFragment extends Fragment implements CoachListAdapter.FilterCriteria {

    private OnFragmentInteractionListener mListener;
    private String type;
    private String location;

    public DistanceListFragment() {
        // Required empty public constructor
    }

    public static DistanceListFragment newInstance(String type, String location) {
        Bundle bundle = new Bundle();
        bundle.putString(InstructorListFragment.TYPE, type);
        bundle.putString(InstructorListFragment.LOCATION, location);
        DistanceListFragment fragment = new DistanceListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getString(InstructorListFragment.TYPE);
        location = getArguments().getString(InstructorListFragment.LOCATION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_distance_list, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new CoachListAdapter(
                DataController.getInstance().getFilteredCoaches("distance", type, location),
                this.getContext(), this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Coach coach = (Coach) listView.getItemAtPosition(i);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_holder, CoachFragment.newInstance(coach))
                        .commit();
            }
        });
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

    @Override
    public String getFilterCriteria(Coach coach) {
        return "3.5km";
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
