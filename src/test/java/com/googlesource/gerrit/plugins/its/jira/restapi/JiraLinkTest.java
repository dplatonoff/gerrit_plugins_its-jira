package com.googlesource.gerrit.plugins.its.jira.restapi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JiraLinkTest {
  @Test
  public void faviconTest() {
    JiraLink link = new JiraLink("https://google.com/one/two", "Title");

    assertEquals("https://google.com/one/two", link.getGlobalId());
    assertNotNull(link.getObject());
    assertEquals("https://google.com/one/two", link.getObject().getUrl());
    assertEquals("Title", link.getObject().getTitle());
    assertNotNull(link.getObject().getIcon());
    assertEquals("https://google.com/favicon.ico", link.getObject().getIcon().getUrl16x16());
  }
}
