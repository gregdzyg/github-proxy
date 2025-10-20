package com.githubproxy.service;

import com.githubproxy.client.GithubFeignClient;
import com.githubproxy.client.dto.GithubBranch;
import com.githubproxy.client.dto.GithubRepository;
import com.githubproxy.controller.dto.Branch;
import com.githubproxy.controller.dto.GithubProxyRepositoryDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class GithubService {

    private final GithubFeignClient githubFeignClient;

    GithubService(GithubFeignClient githubFeignClient) {
        this.githubFeignClient = githubFeignClient;
    }

    public List<GithubRepository> makeGetAllReposRequest(String username) {
        List<GithubRepository> repos = githubFeignClient.fetchAllUserRepos(username);
        System.out.println(repos);
        return repos;
    }

    public List<GithubBranch> makeGetAllRepoBranchesRequest(String owner, String repo) {
        List<GithubBranch> branches = githubFeignClient.fetchAllRepoBranches(owner, repo);
        System.out.println(branches);
        return branches;
    }

    public List<Branch> mapGithubBranchesToResponseBranches(List<GithubBranch> githubBranches) {
        List<Branch> repoBranches = new ArrayList<>();
        githubBranches.forEach(githubBranch -> repoBranches.add(
                new Branch(githubBranch.name(), githubBranch.commit().sha())
        ));
        return repoBranches;
    }

    public List<GithubProxyRepositoryDto> makeServerResponse(String username) {
        List<String> reposNames = makeGetAllReposRequest(username).stream()
                .map(GithubRepository::name).toList();
        List<GithubProxyRepositoryDto> userRepositories = new ArrayList<>();

        for (String repoName : reposNames) {
            userRepositories.add(new GithubProxyRepositoryDto(repoName, username,
                    mapGithubBranchesToResponseBranches(makeGetAllRepoBranchesRequest(username, repoName)
            )));
        }
        return userRepositories;
    }


}
