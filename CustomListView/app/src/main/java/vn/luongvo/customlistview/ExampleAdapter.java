package vn.luongvo.customlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author LuongV
 */
public class ExampleAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private int mResource;

    public ExampleAdapter(Context context, int resource, List<String> strings) {
        super(context, resource, strings);
        mContext = context;
        mResource = resource;
    }

    public class ViewHolder {
        public TextView tvTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, null);

            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(getItem(position));

        return convertView;
    }
}
