package com.githubproxy.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GithubBranch(String name, Commit commit) {
}
