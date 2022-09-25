package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record UserBranch(
        @JsonProperty("repo_name") String repoName,
        @JsonProperty("owner") String owner,
        List<BranchAndCommits> branches
) {
}
