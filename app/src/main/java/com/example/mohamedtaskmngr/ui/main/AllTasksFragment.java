package com.example.mohamedtaskmngr.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mohamedtaskmngr.R;
import com.example.mohamedtaskmngr.data.MyTask;
import com.example.mohamedtaskmngr.data.TasksAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {
   private TasksAdapter tasksAdapter;
   private ListView lvTasks;


    public AllTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tasksAdapter=new TasksAdapter(getContext());
        View view = inflater.inflate(R.layout.fragment_all_tasks, container, false);
        // Inflate the layout for this fragment
        lvTasks=view.findViewById(R.id.lstvTasks);
        lvTasks.setAdapter(tasksAdapter);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        readTasksFromFirebase();

    }


    public void  readTasksFromFirebase()
    {
        FirebaseDatabase database=FirebaseDatabase.getInstance();//CONNECT TO DATABASE
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get curret uid
        String uid = auth.getUid();
        DatabaseReference reference = database.getReference();


        reference.child("tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)//ae
            {
                tasksAdapter.clear();

                for (DataSnapshot d:dataSnapshot.getChildren()) {
                    MyTask t=d.getValue(MyTask.class);
                    Log.d("MYTask",t.toString());
                    tasksAdapter.add(t);







                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }







}
