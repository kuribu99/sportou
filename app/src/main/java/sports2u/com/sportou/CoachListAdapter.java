package sports2u.com.sportou;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Kong My on 29/5/2016.
 */
public class CoachListAdapter implements ListAdapter {

    public interface FilterCriteria {
        String getFilterCriteria(Coach coach);
    }
    private FilterCriteria filter;
    private List<Coach> coachList;
    private final Context context;

    public CoachListAdapter(List<Coach> coachList, Context context, FilterCriteria filter) {
        this.coachList = coachList;
        this.context = context;
        this.filter = filter;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return coachList.size();
    }

    @Override
    public Object getItem(int i) {
        return coachList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item_instructor, null);

        ImageView img = (ImageView) view.findViewById(R.id.img);
        TextView data = (TextView) view.findViewById(R.id.data);
        TextView filter = (TextView) view.findViewById(R.id.filter);

        Coach coach = coachList.get(i);
        img.setImageResource(coach.getImageID());
        data.setText(coach.getName());
        filter.setText(getFilterCriteria(coach));

        return view;
    }

    private String getFilterCriteria(Coach coach) {
        return filter.getFilterCriteria(coach);
    }

    @Override
    public int getItemViewType(int i) {
        return R.layout.list_item_instructor;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return coachList.size()==0;
    }
}
