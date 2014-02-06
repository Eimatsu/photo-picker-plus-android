package com.chute.android.photopickerplus.callback;

import com.dg.libs.rest.authentication.AuthenticationProvider;
import com.dg.libs.rest.client.BaseRestClient;

public final class CustomAuthenticationProvider implements
    AuthenticationProvider {

  private String token;

  public CustomAuthenticationProvider(String token) {
    this.token = token;
  }

  @Override
  public void authenticateRequest(BaseRestClient client) {
    client.addHeader("Authorization", "Bearer " + token);
  }

}
