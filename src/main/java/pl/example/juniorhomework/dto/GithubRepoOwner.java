package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubRepoOwner(
        @JsonProperty("login") String login) {
}
