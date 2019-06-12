package fr.leroymerlin.demodevfest.mvc.controllers;

import fr.leroymerlin.demodevfest.mvc.controllers.exceptions.ResourceNotFoundException;
import fr.leroymerlin.demodevfest.mvc.service.TvShowService;
import fr.leroymerlin.demodevfest.mvc.model.TvShow;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TvShowController {

	private TvShowService tvShowService;

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

	@GetMapping(value = "/tvShows")
	public List<TvShow> getTvShows(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
								   @RequestParam(value = "size", required = false, defaultValue = "100") Integer size) {

		return tvShowService.findAll(page, size);
	}

	@GetMapping(value = "/tvShows/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TvShow getTvShowById(@PathVariable String id) {
		return tvShowService.findById(id)
							.orElseThrow(ResourceNotFoundException::new);
	}
}
