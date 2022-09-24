package pl.example.juniorhomework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.example.juniorhomework.dto.GithubRepository;
import pl.example.juniorhomework.dto.RepoOwner;
import pl.example.juniorhomework.exception.UsernameNotFoundException;
import pl.example.juniorhomework.service.GithubService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/github")
public class GithubController {

    private final GithubService githubService;

    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/repos")
    List<GithubRepository> getRepos() {
        log.info("getRepos()");

        return githubService.readGitHubRepos();
    }
//TODO - jakies testowanie
    @GetMapping("/users/{name}")
    public RepoOwner getUserByUsername(@PathVariable("name") String name) throws UsernameNotFoundException {
        log.info(" getUserByUsername: [{}]", name);
        return githubService.findReposByUsername(name);

               }
    }


