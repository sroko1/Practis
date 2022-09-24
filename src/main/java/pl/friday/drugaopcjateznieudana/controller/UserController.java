package pl.friday.drugaopcjateznieudana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.friday.drugaopcjateznieudana.dto.GithubUserDto;
import pl.friday.drugaopcjateznieudana.dto.GithubUsersResponse;

import java.util.List;

@RestController
public record UserController(RestTemplate restTemplate) {

    @RequestMapping("/api/users")
    public List<GithubUserDto> search(@RequestParam(name = "q", required = false) String query) {
        ResponseEntity<GithubUsersResponse> forEntity =
                restTemplate.getForEntity(String.format("https://api.github.com/search/users?q=%s", query), GithubUsersResponse.class);
        return forEntity.getBody().getItems();
    }

    @RequestMapping("/api/users/{login}")
    public GithubUserDto get(@PathVariable("login") String login) {
        ResponseEntity<GithubUserDto> forEntity = restTemplate.getForEntity(String.format("https://api.github.com/users/%s", login), GithubUserDto.class);
        return forEntity.getBody();
    }
}