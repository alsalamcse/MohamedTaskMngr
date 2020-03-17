package com.example.mohamedtaskmngr.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mohamedtaskmngr.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class TasksAdapter extends ArrayAdapter<MyTurn> {

    public TasksAdapter(@NonNull Context context) {
        super(context, R.layout.taskitem);
    }

    /**
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //6) building item view
        View vitem = LayoutInflater.from(getContext()).inflate(R.layout.taskitem, parent, false);
//7
        TextView tvTime = vitem.findViewById(R.id.itmTvTime);
        TextView tvDate = vitem.findViewById(R.id.itmTvDate);
        CheckBox cbIsCompleted = vitem.findViewById(R.id.itmChbxisCompleted);

        //getting data source
        final MyTurn myTurn = getItem(position);


        //todo

        cbIsCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    FirebaseUtils.getReference().child(myTurn.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                Toast.makeText(getContext(), "delete", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getContext(), "not deleted", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        //connect item to data source
        tvTime.setText(myTurn.getTitle());
        tvDate.setText(myTurn.getSubject());
        cbIsCompleted.setChecked(false);
        return vitem;


    }

}
