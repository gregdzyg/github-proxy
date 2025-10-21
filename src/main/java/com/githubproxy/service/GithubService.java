package com.githubproxy.service;

import com.githubproxy.client.GithubFeignClient;
import com.githubproxy.client.dto.GithubBranch;
import com.githubproxy.client.dto.GithubRepository;
import com.githubproxy.controller.dto.Branch;
import com.githubproxy.controller.dto.GithubProxyRepositoryDto;
import com.githubproxy.service.mapper.GithubMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GithubService {
    private final GithubMapper githubMapper;
    private final GithubFeignClient githubFeignClient;

    GithubService(GithubFeignClient githubFeignClient, GithubMapper githubMapper) {
        this.githubFeignClient = githubFeignClient;
        this.githubMapper = githubMapper;
    }

    private List<GithubRepository> fetchUserRepos(String username) {
        return githubFeignClient.fetchAllUserRepos(username).stream()
                .filter(githubRepository -> !githubRepository.fork()).toList();
    }

    private List<GithubBranch> fetchRepoBranches(String owner, String repo) {
        return githubFeignClient.fetchAllRepoBranches(owner, repo);
    }


    public List<GithubProxyRepositoryDto> getUserReposWithBranches(String username) {
        List<GithubRepository> repos = fetchUserRepos(username);
        List<GithubProxyRepositoryDto> userRepositories = new ArrayList<>();

        for (GithubRepository repo : repos) {
            String owner = repo.owner().login();
            List<GithubBranch> branches = fetchRepoBranches(owner, repo.name());
            List<Branch> mappedBranches = githubMapper.mapGithubBranchesToResponseBranches(branches);

            userRepositories.add(new GithubProxyRepositoryDto(
                    repo.name(), owner, mappedBranches
            ));
        }
        return userRepositories;
    }


}
