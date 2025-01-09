package ru.hawoline.hawolinenews.presentation.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsUiStateTest {
  private NewsUiState newsUiState;
  private final List<NewsItemUiState> newsItems = new ArrayList<>();
  private final List<Message> userMessages = new ArrayList<>();

  @Before
  public void setUp() {
    NewsItemUiState newsItemUiState0 = new NewsItemUiState("C++", "C++ becomes popular");
    NewsItemUiState newsItemUiState1 = new NewsItemUiState("Python", "Python becomes popular");
    NewsItemUiState newsItemUiState2 =
        new NewsItemUiState("Assembler", "Assembler becomes popular");
    NewsItemUiState newsItemUiState3 = new NewsItemUiState("Scala", "Scala becomes popular");
    NewsItemUiState newsItemUiState4 = new NewsItemUiState("Kotlin", "Kotlin becomes popular");
    NewsItemUiState newsItemUiState5 = new NewsItemUiState("Java", "Java becomes popular");

    newsItems.add(newsItemUiState0);
    newsItems.add(newsItemUiState1);
    newsItems.add(newsItemUiState2);
    newsItems.add(newsItemUiState3);
    newsItems.add(newsItemUiState4);
    newsItems.add(newsItemUiState5);

    for (int i = 0; i < 10; i++) {
      userMessages.add(new Message("Message: " + i));
    }

    newsUiState = new NewsUiState(newsItems, userMessages);
  }

  @Test
  public void testImmutability() {
    //Test that size of sourceList does not change if copyOfSourceList adds or removes items
    final List<NewsItemUiState> copyOfNewsItemUiStates = newsUiState.getNewsItems();
    copyOfNewsItemUiStates.add(new NewsItemUiState("Bad language", "Bad language becomes popular"));
    assertEquals(newsItems.size(), copyOfNewsItemUiStates.size() - 1);

    //Adds copyOfSourceList to newsItems then copyOfSourceList adds new element
    final List<NewsItemUiState> testNewsItems = new ArrayList<>();
    testNewsItems.add(new NewsItemUiState("Language0", "Language0 becomes popular"));
    testNewsItems.add(new NewsItemUiState("Language1", "Language1 becomes popular"));
    testNewsItems.add(new NewsItemUiState("Language2", "Language2 becomes popular"));
    newsUiState = new NewsUiState(testNewsItems, userMessages);
    testNewsItems.add(new NewsItemUiState("Bad language", "Bad language becomes popular"));
    assertEquals(newsUiState.getNewsItems().size(), testNewsItems.size() - 1);
  }

  @After
  public void tearDown() {
    newsItems.clear();
    userMessages.clear();
  }
}