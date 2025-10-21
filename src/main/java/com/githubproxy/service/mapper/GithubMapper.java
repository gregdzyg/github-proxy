package com.githubproxy.service.mapper;

import com.githubproxy.client.dto.GithubBranch;
import com.githubproxy.controller.dto.Branch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GithubMapper {

    public List<Branch> mapGithubBranchesToResponseBranches(List<GithubBranch> githubBranches) {
        List<Branch> repoBranches = new ArrayList<>();
        githubBranches.forEach(githubBranch -> repoBranches.add(
                new Branch(githubBranch.name(), githubBranch.commit().sha())
        ));
        return repoBranches;
    }
}
