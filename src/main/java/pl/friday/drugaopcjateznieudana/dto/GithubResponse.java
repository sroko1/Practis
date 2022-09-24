package pl.friday.drugaopcjateznieudana.dto;

import lombok.Data;

import java.util.List;

@Data
class GithubResponse<T> {

    private List<T> items;
}
