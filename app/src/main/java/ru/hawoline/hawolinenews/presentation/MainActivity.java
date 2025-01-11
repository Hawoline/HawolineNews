package ru.hawoline.hawolinenews.presentation;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import ru.hawoline.hawolinenews.R;
import ru.hawoline.hawolinenews.domain.NewsItemUiState;

public class MainActivity extends AppCompatActivity {
  private TextView hahaTextView;
  private Button postNewsButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    hahaTextView = findViewById(R.id.text_view_haha);
    postNewsButton = findViewById(R.id.button_post_news);

    NewsUiViewModel model = new ViewModelProvider(this).get(NewsUiViewModel.class);
    model.getSomeUiState().observe(this, uiState -> {
      StringBuilder stringBuilder = new StringBuilder();
      for (NewsItemUiState newsItem : uiState.getNewsItems()) {
        stringBuilder.append(newsItem.getBody()).append("\n");
      }
      hahaTextView.setText(stringBuilder.toString());
    });

    postNewsButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        model.postRandomNews();
      }
    });
  }
}