package pl.friday.drugaopcjateznieudana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubRepoDto {

    private String name;
    private String branchesUrl;
    private boolean fork;
    private String gitCommitsUrl;
}
