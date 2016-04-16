package localhost.mmangold.plusminus;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class FriendListViewAdapter extends BaseAdapter{

    // Variables
    Context context;
    String[] nameList;
    int[] deptList;
    private static LayoutInflater inflater = null;

    // Constructor
    public FriendListViewAdapter(MainActivity mainActivity, String[] _NameList, int[] _DeptList) {
        context = mainActivity;
        nameList = _NameList;
        deptList = _DeptList;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Class which holds sub-views
    public class ViewHolder {
        TextView tv1;
        TextView tv2;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Instancize views, reuse if possible
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.item_listview_friend, parent,false);
            ViewHolder holder = new ViewHolder();// Populate internal views
            holder.tv1=(TextView) rowView.findViewById(R.id.friend_name);
            holder.tv2=(TextView) rowView.findViewById(R.id.dept_amount);
            rowView.setTag(holder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tv1.setText(nameList[position]);
        holder.tv2.setText(String.valueOf(deptList[position]));
        if (deptList[position]<0)
            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.dept_neg));
        else if (deptList[position]==0)
            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        else
            holder.tv2.setTextColor(ContextCompat.getColor(context, R.color.dept_pos));
        /*
        // New click listener (pass from before? to be able to turn off?)
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Clicked " + nameList[position], Toast.LENGTH_LONG).show();
            }
        });
        */
        return rowView;
    }

    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }
}
