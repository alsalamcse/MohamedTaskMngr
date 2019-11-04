package com.example.mohamedtaskmngr.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mohamedtaskmngr.R;

import java.util.zip.Inflater;

public class TasksAdapter extends ArrayAdapter<MyTask>
{

    public TasksAdapter(@NonNull Context context) {
        super(context, R.layout.taskitem);
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //6) building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,true);
//7
        TextView tvTitlle=vitem.findViewById(R.id.itmTvTittle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPriority);
        CheckBox cbIsCompleted=vitem.findViewById(R.id.itmChbxisCompleted);
        ImageView ivInfo=vitem.findViewById(R.id.itmImgInfo);
       //getting data source
        MyTask myTask=getItem(position);

    //connect item to data source
        tvTitlle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSubject());
        rbPrio.setRating(myTask.getImportant());
        cbIsCompleted.setChecked(false);
        return vitem;











    }
}
