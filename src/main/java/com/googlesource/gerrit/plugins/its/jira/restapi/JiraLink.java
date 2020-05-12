// Copyright (C) 2017 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.its.jira.restapi;

import java.net.URI;
import java.net.URISyntaxException;

public class JiraLink {

  private final String globalId;
  private final JiraLinkObject object;

  public JiraLink(String url, String title) {
    this.globalId = url;
    this.object = new JiraLinkObject(url, title);
  }

  public String getGlobalId() {
    return globalId;
  }

  public JiraLinkObject getObject() {
    return object;
  }

  public static class JiraLinkObject {
    private final String url;
    private final String title;
    private JiraLinkIcon icon;

    public JiraLinkObject(String url, String title) {
      this.url = url;
      this.title = title;
      try {
        this.icon = new JiraLinkIcon(new URI(url).resolve("/favicon.ico").toString());
      } catch (URISyntaxException e) {
        // no icon
      }
    }

    public String getUrl() {
      return url;
    }

    public String getTitle() {
      return title;
    }

    public JiraLinkIcon getIcon() {
      return icon;
    }
  }

  public static class JiraLinkIcon {
    private final String url16x16;

    public JiraLinkIcon(String url) {
      this.url16x16 = url;
    }

    public String getUrl16x16() {
      return url16x16;
    }
  }
}
