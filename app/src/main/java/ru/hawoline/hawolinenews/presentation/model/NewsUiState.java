package ru.hawoline.hawolinenews.presentation.model;

import java.util.ArrayList;
import java.util.List;

public final class NewsUiState {
  private final boolean isSignedIn;
  private final boolean isPremium;
  private final List<NewsItemUiState> newsItems;
  private final List<Message> userMessages;

  public NewsUiState(List<NewsItemUiState> newsItems, List<Message> userMessages) {
    this(false, false, newsItems, userMessages);
  }

  public NewsUiState(boolean isSignedIn, boolean isPremium, List<NewsItemUiState> newsItems,
      List<Message> userMessages) {
    this.isSignedIn = isSignedIn;
    this.isPremium = isPremium;
    this.newsItems = new ArrayList<>(newsItems);
    this.userMessages = new ArrayList<>(userMessages);
  }

  public boolean isSignedIn() {
    return isSignedIn;
  }

  public boolean isPremium() {
    return isPremium;
  }

  public List<NewsItemUiState> getNewsItems() {
    return new ArrayList<>(newsItems);
  }

  public List<Message> getUserMessages() {
    return new ArrayList<>(userMessages);
  }
}
