package com.githubproxy.controller.dto;


import java.util.List;

public record GithubProxyRepositoryDto(String repositoryName, String ownerLogin, List<Branch> branches) {
}
