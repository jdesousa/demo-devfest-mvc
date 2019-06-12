package fr.leroymerlin.demodevfest.mvc.service;

import fr.leroymerlin.demodevfest.mvc.client.TvShowRatingClient;
import fr.leroymerlin.demodevfest.mvc.model.TvShow;
import fr.leroymerlin.demodevfest.mvc.model.TvShowRating;
import fr.leroymerlin.demodevfest.mvc.repository.TvShowRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TvShowService {
	private TvShowRepository tvShowRepository;
	private TvShowRatingClient tvShowRatingClient;

	public Optional<TvShow> findById(String id) {
		return tvShowRepository.findById(id)
							   .map(tvShow -> collectTvShowRating(id, tvShow));
	}

	private TvShow collectTvShowRating(String id, TvShow tvShow) {
		TvShowRating tvShowRating = tvShowRatingClient.getTvShowRating(id);

		if (tvShowRating != null) {
			return tvShow.setAverageRating(tvShowRating.getAverageRating())
						 .setNumVotes(tvShowRating.getNumVotes());
		}

		return tvShow;
	}

	public List<TvShow> findAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<TvShow> all = tvShowRepository.findAll(pageable);
		return all.getContent();
	}
}
