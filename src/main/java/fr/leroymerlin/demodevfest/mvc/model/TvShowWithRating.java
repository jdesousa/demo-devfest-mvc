package fr.leroymerlin.demodevfest.mvc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TvShowWithRating {
	private TvShow tvShow;
	private TvShowRating tvShowRating;
}
