package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BranchAndCommits(
        @JsonProperty("name") String name,
        @JsonProperty("lastCommitSha") String lastCommitSha
) {
}
