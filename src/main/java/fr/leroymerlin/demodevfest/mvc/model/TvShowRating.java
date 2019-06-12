package fr.leroymerlin.demodevfest.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvShowRating {
	private String tvShowId;
	private Float averageRating;
	private Integer numVotes;
}
