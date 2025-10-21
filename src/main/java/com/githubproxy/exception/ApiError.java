package com.githubproxy.exception;

public record ApiError(int status, String message) {
}
