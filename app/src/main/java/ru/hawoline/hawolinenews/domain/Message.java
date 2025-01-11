package ru.hawoline.hawolinenews.domain;

public final class Message {
  private final String message;

  public Message(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
