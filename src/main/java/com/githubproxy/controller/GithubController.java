package com.githubproxy.controller;

import com.githubproxy.controller.dto.GithubProxyRepositoryDto;
import com.githubproxy.controller.dto.GithubProxyResponseDto;
import com.githubproxy.service.GithubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GithubController {

    GithubService service;
    GithubController(GithubService service) {
        this.service = service;
    }

    @GetMapping("/repos/{username}")
    ResponseEntity<GithubProxyResponseDto> getAllReposByUsername(@PathVariable String username) {
        List<GithubProxyRepositoryDto> repositoriesList = service.makeServerResponse(username);
        GithubProxyResponseDto response = new GithubProxyResponseDto(repositoriesList);
        return ResponseEntity.ok(response);
    }
}
