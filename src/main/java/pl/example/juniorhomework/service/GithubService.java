package pl.example.juniorhomework.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.example.juniorhomework.dto.GithubRepository;
import pl.example.juniorhomework.dto.RepoOwner;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class GithubService implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final String githubUrl;
    private final String userNameGithubUrl;

    public GithubService(RestTemplate restTemplate,
                         @Value("${github.repository.url}") String githubUrl,
                         @Value("${userNameGithubUrl.repository.url}") String userNameGithubUrl) {
        this.restTemplate = restTemplate;
        this.githubUrl = githubUrl;
        this.userNameGithubUrl = userNameGithubUrl;

        log.info("github url: [{}]", githubUrl);
    }

    public List<GithubRepository> readGitHubRepos() {
        var responseFromServer = restTemplate.getForObject(githubUrl, GithubRepository[].class);
        var result = Arrays.asList(responseFromServer);
        log.info("result: {}", result);

        return result;
    }


    // TODO:
    public List<GithubRepository> readGitHubReposV3() {
        var responseFromServer =
                restTemplate.exchange(githubUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<GithubRepository>>() {
                        });
        return responseFromServer.getBody();
    }


    public RepoOwner findReposByUsername(String name) {
        return restTemplate.getForObject(userNameGithubUrl,RepoOwner.class, name);
    }

//    public List<GithubRepoDto> findReposByUsername(String name) {
//        var response = restTemplate.getForObject(githubUrl,GithubRepoDto[].class, name);
//        var result = Arrays.asList(response);
//        log.info("trying to find objects by name: [{}], result: [{}]", name, result);
//        return result;
//    }




    @Override
    public void run(String... args) throws Exception {
        findReposByUsername("sroko1");
        readGitHubRepos();

        log.info("->" + readGitHubReposV3());
    }
}
