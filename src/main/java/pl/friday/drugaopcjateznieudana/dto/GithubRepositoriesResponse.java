package pl.friday.drugaopcjateznieudana.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GithubRepositoriesResponse extends GithubResponse<GithubRepoDto> {
}
