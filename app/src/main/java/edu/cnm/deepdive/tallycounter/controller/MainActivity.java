package edu.cnm.deepdive.tallycounter.controller;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.tallycounter.Subtally;
import edu.cnm.deepdive.tallycounter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.tallycounter.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  private ActivityMainBinding binding;
  private MainViewModel viewModel;
  private ArrayAdapter<Subtally> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.d(TAG, "MainActivity::onCreate");
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    binding.subtallies.setAdapter(adapter);
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    binding.setLifecycleOwner(this);
    binding.setViewmodel(viewModel);
    viewModel
        .getSubtallies()
        .observe(this, (subtallies) -> {
          adapter.clear();
          adapter.addAll(subtallies);
        });
/*
    viewModel
        .getCounter()
        .observe(this, this::setTallyDisplay);
*/
  }

/*
  public void handleIncrement(View v) {
    viewModel.incrementCounterValue();
  }

  public void captureSubtally(View v) {
    viewModel.captureSubtally();
  }

  private void setTallyDisplay(int counter) {
    binding.tally.setText(String.valueOf(counter));
  }
*/

}