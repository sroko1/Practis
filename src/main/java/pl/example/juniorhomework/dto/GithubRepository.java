package pl.example.juniorhomework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubRepository(
        @JsonProperty("name") String repoName,
        @JsonProperty ("branches_url") String branchesUrl,
        @JsonProperty ("fork") boolean fork,
        @JsonProperty ("git_commit_url")String gitCommitsUrl,
        RepoOwner owner) {
}
