package ru.hawoline.hawolinenews.domain;

public final class NewsItemUiState {
  private final String title;
  private final String body;
  private final boolean bookmarked;

  public NewsItemUiState(String title, String body) {
    this(title, body, false);
  }

  public NewsItemUiState(String title, String body, boolean bookmarked) {
    this.title = title;
    this.body = body;
    this.bookmarked = bookmarked;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public boolean isBookmarked() {
    return bookmarked;
  }
}
