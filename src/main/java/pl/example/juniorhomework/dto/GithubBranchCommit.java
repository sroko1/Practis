package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubBranchCommit(
        @JsonProperty String sha) {
}
