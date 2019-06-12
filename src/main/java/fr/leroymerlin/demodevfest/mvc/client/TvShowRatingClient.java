package fr.leroymerlin.demodevfest.mvc.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.leroymerlin.demodevfest.mvc.model.TvShowIds;
import fr.leroymerlin.demodevfest.mvc.model.TvShowRating;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TvShowRatingClient {

	public static final String URL_TV_SHOW_BY_IDS = "http://127.0.0.1:7070/tvShowRatingByIds";
	public static final String URL_TV_SHOW = "http://127.0.0.1:7070/tvShowRating/";

	@Value("${tv-show-rating-api.retry-max:3}")
	private String tvshowRatingHost;

	private ObjectMapper objectMapper;
	private RestTemplate restTemplate;

	public TvShowRatingClient(ObjectMapper objectMapper, RestTemplate restTemplate) {
		this.objectMapper = objectMapper;
		this.restTemplate = restTemplate;
	}

	public List<TvShowRating> postTvShowRating(TvShowIds tvShowIds) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		HttpEntity<TvShowIds> entity = new HttpEntity<TvShowIds>(tvShowIds, headers);

		return restTemplate.exchange(
			URL_TV_SHOW_BY_IDS,
			HttpMethod.POST,
			entity,
			new ParameterizedTypeReference<List<TvShowRating>>() {
			})
						   .getBody();
	}

	public List<TvShowRating> getTvShowRatingByIds(TvShowIds tvShowIds) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		HttpEntity<TvShowIds> entity = new HttpEntity<TvShowIds>(tvShowIds, headers);

		String url = URL_TV_SHOW_BY_IDS + "?ids=" + String.join(",", tvShowIds.getIds());

		return restTemplate.exchange(
			url,
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<TvShowRating>>() {
			})
						   .getBody();
	}

	public TvShowRating getTvShowRating(String tvShowId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

		String url = URL_TV_SHOW + "/" + tvShowId;

		return restTemplate.exchange(
			url,
			HttpMethod.GET,
			null,
			TvShowRating.class)
						   .getBody();
	}

}
