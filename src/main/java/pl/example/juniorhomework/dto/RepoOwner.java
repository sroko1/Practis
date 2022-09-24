package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepoOwner(
       @JsonProperty String login,
        Long id) {
}
