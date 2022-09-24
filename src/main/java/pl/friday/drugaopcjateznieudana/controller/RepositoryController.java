package pl.friday.drugaopcjateznieudana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.friday.drugaopcjateznieudana.dto.GithubRepoDto;
import pl.friday.drugaopcjateznieudana.dto.GithubRepositoriesResponse;

import java.util.List;

@RestController
public record RepositoryController(RestTemplate restTemplate) {

    @RequestMapping("/api/repositories")
    public List<GithubRepoDto> repositoryList(@RequestParam(name = "q", required = false) String query) {
        ResponseEntity<GithubRepositoriesResponse> forEntity =
                restTemplate.getForEntity(String.format("https://api.github.com/search/repositories?q=%s", query), GithubRepositoriesResponse.class);
        return forEntity.getBody().getItems();

    }
}
