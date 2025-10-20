package com.githubproxy.client;

import com.githubproxy.client.dto.GithubBranch;
import com.githubproxy.client.dto.GithubRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github", url = "${github.base-url}")
@Component
public interface GithubFeignClient {

    @GetMapping("/users/{username}/repos")
    List<GithubRepository> fetchAllUserRepos(@PathVariable String username);

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<GithubBranch> fetchAllRepoBranches(@PathVariable String owner, @PathVariable String repo);



}