package pl.friday.drugaopcjateznieudana.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubUserDto {

    private Long id;
    private String login;
}
