package pl.friday.drugaopcjateznieudana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.friday.drugaopcjateznieudana.dto.GithubRepoDto;

import java.util.List;

@Repository
public interface GithubRepository extends JpaRepository <GithubRepoDto, Long> {

    List<GithubRepoDto> findGithubReposDtoByGithubUserName(String name);
}
