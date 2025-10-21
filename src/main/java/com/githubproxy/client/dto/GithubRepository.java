package com.githubproxy.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubRepository(String name, Owner owner, boolean fork) {
}
