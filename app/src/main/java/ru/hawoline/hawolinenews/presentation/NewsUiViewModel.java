package ru.hawoline.hawolinenews.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ru.hawoline.hawolinenews.domain.Message;
import ru.hawoline.hawolinenews.domain.NewsItemUiState;
import ru.hawoline.hawolinenews.domain.NewsUiState;

public class NewsUiViewModel extends ViewModel {

  private final MutableLiveData<NewsUiState> someUiState =
      new MutableLiveData<>(new NewsUiState(new ArrayList<>(), new ArrayList<>()));

  public LiveData<NewsUiState> getSomeUiState() {
    return someUiState;
  }

  public void postRandomNews() {
    Random random = new Random();
    List<NewsItemUiState> newsItemUiStates = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      newsItemUiStates.add(
          new NewsItemUiState(String.valueOf(random.nextInt()), "Body: " + random.nextInt()));
    }
    List<Message> messages = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      messages.add(new Message("Message: " + random.nextInt()));
    }
    someUiState.setValue(new NewsUiState(newsItemUiStates, messages));
  }
}
