package com.githubproxy.controller.dto;

import java.util.List;

public record GithubProxyResponseDto(List<GithubProxyRepositoryDto> repositories) {
}
