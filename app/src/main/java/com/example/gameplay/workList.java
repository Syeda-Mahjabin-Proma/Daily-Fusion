package com.example.gameplay;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class workList extends Activity {

    private LinearLayout allTask;
    private TextView taskCount, deletedTaskCount, taskCompleteCount, remainingTaskCount;
    private Button addTask, deleteAll;
    private int totalTasks = 0, deletedTasks = 0, completedTasks = 0, completedCheckedTasks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worklist);
        findViews();
        addNewTask();
        deleteAllTask();
    }

    private void deleteAllTask() {
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allTask.removeAllViews();
                totalTasks = 0;
                deletedTasks = 0;
                completedTasks = 0;
                completedCheckedTasks = 0;
                updateTaskCounts();
            }
        });
    }

    private void addNewTask() {
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalTasks++;
                updateTaskCounts();

                LinearLayout taskLayout = new LinearLayout(workList.this);
                taskLayout.setOrientation(LinearLayout.HORIZONTAL);
                taskLayout.setPadding(10, 10, 10, 10);
                taskLayout.setBackgroundColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(0, 10, 0, 10);
                taskLayout.setLayoutParams(params);

                CheckBox checkBox = new CheckBox(workList.this);
                LinearLayout.LayoutParams checkBoxParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                checkBoxParams.gravity = Gravity.CENTER_VERTICAL;
                checkBox.setLayoutParams(checkBoxParams);
                checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                    if (isChecked) {
                        completedTasks++;
                    } else {
                        completedTasks--;
                    }
                    updateTaskCounts();
                });

                TextView taskText = new TextView(workList.this);
                taskText.setText("Task " + totalTasks);
                taskText.setTextColor(Color.parseColor("#FFFFFF"));
                taskText.setPadding(20, 0, 20, 0);
                LinearLayout.LayoutParams taskTextParams = new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1f
                );
                taskTextParams.gravity = Gravity.CENTER_VERTICAL;
                taskText.setLayoutParams(taskTextParams);

                Button editButton = new Button(workList.this);
                editButton.setText("Edit");
                editButton.setTextSize(15);
                LinearLayout.LayoutParams editButtonParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                editButtonParams.gravity = Gravity.CENTER_VERTICAL;
                editButton.setLayoutParams(editButtonParams);
                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTask(taskText);
                    }
                });

                Button deleteButton = new Button(workList.this);
                deleteButton.setText("Delete");
                deleteButton.setTextSize(15);
                LinearLayout.LayoutParams deleteButtonParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                deleteButtonParams.gravity = Gravity.CENTER_VERTICAL;
                deleteButton.setLayoutParams(deleteButtonParams);
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkBox.isChecked()) {
                            completedCheckedTasks++;
                        }
                        allTask.removeView(taskLayout);
                        deletedTasks++;
                        updateTaskCounts();
                    }
                });

                taskLayout.addView(checkBox);
                taskLayout.addView(taskText);
                taskLayout.addView(editButton);
                taskLayout.addView(deleteButton);

                allTask.addView(taskLayout);
            }
        });
    }

    private void editTask(TextView taskText) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(workList.this);
        builder.setTitle("Edit Task");

        final EditText input = new EditText(workList.this);
        input.setText(taskText.getText());
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            taskText.setText(input.getText().toString());
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }


    private void updateTaskCounts() {
        taskCount.setText(String.valueOf(totalTasks));
        deletedTaskCount.setText(String.valueOf(deletedTasks));
        taskCompleteCount.setText(String.valueOf(completedTasks));
        remainingTaskCount.setText(String.valueOf(totalTasks - completedTasks - deletedTasks + completedCheckedTasks));
    }

    private void findViews() {
        allTask = findViewById(R.id.allTask);
        taskCount = findViewById(R.id.taskCount);
        deletedTaskCount = findViewById(R.id.deletedTaskCount);
        taskCompleteCount = findViewById(R.id.taskCompleteCount);
        remainingTaskCount = findViewById(R.id.remainingTaskCount);
        addTask = findViewById(R.id.addTask);
        deleteAll = findViewById(R.id.deleteAll);
    }
}
