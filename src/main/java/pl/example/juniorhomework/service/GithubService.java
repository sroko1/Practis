package pl.example.juniorhomework.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.example.juniorhomework.dto.BranchAndCommits;
import pl.example.juniorhomework.dto.GithubBranch;
import pl.example.juniorhomework.dto.GithubRepository;
import pl.example.juniorhomework.dto.UserBranch;
import pl.example.juniorhomework.exception.UsernameNotFoundException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class GithubService implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final String githubUrl;
    private final String userNameGithubUrl;
    private final String branchUrl;


    public GithubService(RestTemplate restTemplate,
                         @Value("${github.repository.url}") String githubUrl,
                         @Value("${userNameGithubUrl.repository.url}") String userNameGithubUrl,
                         @Value("${githubBranchList.repository.url}") String branchUrl) {
        this.restTemplate = restTemplate;
        this.githubUrl = githubUrl;
        this.userNameGithubUrl = userNameGithubUrl;
        this.branchUrl = branchUrl;

        log.info("github url: [{}]", githubUrl);
    }

    private List<GithubRepository> readGitHubRepos(String login) {
        try {
            var forEntity =
                    restTemplate.getForEntity(MessageFormat.format(githubUrl, login), GithubRepository[].class);
            return List.of(forEntity.getBody());
        } catch (HttpClientErrorException.NotFound e) {
            throw new UsernameNotFoundException(login);
        }

    }

    private List<BranchAndCommits> readBranchesAndItsSha(String login, String repoName) {
        var result = restTemplate.getForObject(MessageFormat.format(branchUrl, login, repoName), GithubBranch[].class);
        var response = new ArrayList<BranchAndCommits>();
        for (var branch : result) {

            response.add(new BranchAndCommits(branch.name(), branch.commit().sha()));
        }
        return response;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<UserBranch> readUserReposWithBranchesSha(String login) {
        var repos = readGitHubRepos(login);
        var response = new ArrayList<UserBranch>();
        for (var repo : repos) {
            if (!repo.fork()) {
                var branches = readBranchesAndItsSha(login, repo.repoName());
                response.add((new UserBranch(repo.repoName(), repo.owner().login(), branches)));
            }
        }
        return response;
    }


    @Override
    public void run(String... args) throws Exception {


    }
}
