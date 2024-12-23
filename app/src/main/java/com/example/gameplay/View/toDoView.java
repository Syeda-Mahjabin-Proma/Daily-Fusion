package com.example.gameplay.View;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gameplay.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class toDoView extends Activity {

    private LinearLayout allTask;
    private TextView taskCount, deletedTaskCount, taskCompleteCount, remainingTaskCount;
    private Button addTask, deleteAll;
    private int totalTasks = 0, deletedTasks = 0, completedTasks = 0, completedCheckedTasks = 0;

    private SharedPreferences sharedPreferences;
    private static final String TASKS_KEY = "tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo);
        findViews();
        sharedPreferences = getSharedPreferences("ToDoApp", MODE_PRIVATE);
        loadTasks();
        addNewTask();
        deleteAllTask();
    }

    private void deleteAllTask() {
        deleteAll.setOnClickListener(v -> {
            allTask.removeAllViews();
            totalTasks = 0;
            deletedTasks = 0;
            completedTasks = 0;
            completedCheckedTasks = 0;
            saveTasks();
            updateTaskCounts();
        });
    }

    private void addNewTask() {
        addTask.setOnClickListener(v -> {
            totalTasks++;
            updateTaskCounts();

            LinearLayout taskLayout = createTaskLayout("Task " + totalTasks, false);
            allTask.addView(taskLayout);

            saveTasks();
        });
    }

    private LinearLayout createTaskLayout(String taskName, boolean isChecked) {
        LinearLayout taskLayout = new LinearLayout(toDoView.this);
        taskLayout.setOrientation(LinearLayout.HORIZONTAL);
        taskLayout.setPadding(10, 10, 10, 10);
        taskLayout.setBackgroundColor(Color.parseColor("#000000"));

        LinearLayout.LayoutParams taskParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        taskParams.setMargins(0, 10, 0, 10);
        taskLayout.setLayoutParams(taskParams);
        taskLayout.setGravity(Gravity.CENTER_VERTICAL);

        CheckBox checkBox = new CheckBox(toDoView.this);
        checkBox.setChecked(isChecked);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked1) -> {
            if (isChecked1) {
                completedTasks++;
            } else {
                completedTasks--;
            }
            saveTasks();
            updateTaskCounts();
        });

        TextView taskText = new TextView(toDoView.this);
        taskText.setText(taskName);
        taskText.setTextColor(Color.parseColor("#FFFFFF"));
        taskText.setPadding(20, 0, 20, 0);
        taskText.setMaxWidth(600);
        taskText.setLayoutParams(new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));

        Button editButton = new Button(toDoView.this);
        editButton.setText("Edit");
        editButton.setOnClickListener(v -> editTask(taskText));

        Button deleteButton = new Button(toDoView.this);
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                completedCheckedTasks++;
            }
            allTask.removeView(taskLayout);
            deletedTasks++;
            saveTasks();
            updateTaskCounts();
        });

        LinearLayout buttonLayout = new LinearLayout(toDoView.this);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setGravity(Gravity.END);
        buttonLayout.addView(editButton);
        buttonLayout.addView(deleteButton);

        taskLayout.addView(checkBox);
        taskLayout.addView(taskText);
        taskLayout.addView(buttonLayout);

        return taskLayout;
    }

    private void editTask(TextView taskText) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(toDoView.this);
        builder.setTitle("Edit Task");

        final EditText input = new EditText(toDoView.this);
        input.setText(taskText.getText());
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            taskText.setText(input.getText().toString());
            saveTasks();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void saveTasks() {
        JSONArray taskArray = new JSONArray();
        for (int i = 0; i < allTask.getChildCount(); i++) {
            LinearLayout taskLayout = (LinearLayout) allTask.getChildAt(i);
            CheckBox checkBox = (CheckBox) taskLayout.getChildAt(0);
            TextView taskText = (TextView) taskLayout.getChildAt(1);

            JSONObject taskObject = new JSONObject();
            try {
                taskObject.put("taskName", taskText.getText().toString());
                taskObject.put("isChecked", checkBox.isChecked());
                taskArray.put(taskObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        sharedPreferences.edit().putString(TASKS_KEY, taskArray.toString()).apply();
    }

    private void loadTasks() {
        String tasks = sharedPreferences.getString(TASKS_KEY, "[]");
        try {
            JSONArray taskArray = new JSONArray(tasks);
            for (int i = 0; i < taskArray.length(); i++) {
                JSONObject taskObject = taskArray.getJSONObject(i);
                String taskName = taskObject.getString("taskName");
                boolean isChecked = taskObject.getBoolean("isChecked");
                LinearLayout taskLayout = createTaskLayout(taskName, isChecked);
                allTask.addView(taskLayout);
                if (isChecked) completedTasks++;
                totalTasks++;
            }
            updateTaskCounts();
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
