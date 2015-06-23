package com.example.tree_view;

import java.util.List;

import com.example.tree.bean.Node;
import com.example.tree.bean.TreeListViewAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

 

public class SimpleTreeAdapter<T> extends TreeListViewAdapter<T> {

	public SimpleTreeAdapter(ListView mTree, Context context, List<T> datas,
			int defaultExpandLevel) throws IllegalArgumentException,
			IllegalAccessException {
		super(mTree, context, datas, defaultExpandLevel);
	}

	@Override
	public View getConvertView(Node node, int position, View convertView,
			ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.id_treenode_icon);
			viewHolder.label = (TextView) convertView
					.findViewById(R.id.id_treenode_label);
			viewHolder.line_Top = (View) convertView
					.findViewById(R.id.line_top);
			viewHolder.line_Bottom = (View) convertView
					.findViewById(R.id.line_bottom);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		if (node.getIcon() == -1) {
			viewHolder.line_Top.setVisibility(View.INVISIBLE);
			viewHolder.line_Bottom.setVisibility(View.INVISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		} else {
			viewHolder.icon.setVisibility(View.VISIBLE);
//			viewHolder.line_Top.setVisibility(View.INVISIBLE);
//			viewHolder.line_Bottom.setVisibility(View.INVISIBLE);
			viewHolder.icon.setImageResource(node.getIcon());
		}

		viewHolder.label.setText(node.getName());

		return convertView;
	}

	private final class ViewHolder {
		ImageView icon;
		TextView label;
		View line_Top;
		View line_Bottom;
	}

}