package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubBranch(
        @JsonProperty String name,
        @JsonProperty GithubBranchCommit commit) {
}
