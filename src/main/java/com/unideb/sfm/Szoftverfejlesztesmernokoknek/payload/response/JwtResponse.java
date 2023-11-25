package com.unideb.sfm.Szoftverfejlesztesmernokoknek.payload.response;

import java.util.Base64;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Integer id;
  private String fullName;
  private String username;
  private String email;
  private String profileImageBase64;
  private List<String> roles;

  public JwtResponse(String accessToken, Integer id, String fullName, String username, String email, List<String> roles, byte[] profileImage) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.fullName = fullName;
    this.email = email;
    this.roles = roles;
    this.profileImageBase64 = Base64.getEncoder().encodeToString(profileImage);
  }

    public String getProfileImage() {
        return profileImageBase64;
    }

    public void setProfileImage(String profileImage) {
        this.profileImageBase64 = profileImage;
    }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

    public String getFullName() {
    return fullName;
  }

    public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }
}
