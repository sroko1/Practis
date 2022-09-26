package pl.example.juniorhomework.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.juniorhomework.dto.UserBranch;
import pl.example.juniorhomework.service.GithubService;

import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;


    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @RequestMapping("/repos/{login}")
    List<UserBranch> getUserReposWithBranchesSha(@PathVariable("login") String owner) {
        return githubService.readUserReposWithBranchesSha(owner);

    }

}



