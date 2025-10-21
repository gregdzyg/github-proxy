# 🔗 GitHub Proxy API

A lightweight **Spring Boot** application acting as a proxy for the [GitHub REST API v3](https://developer.github.com/v3).  
Fetches all **non-fork repositories** for a given user, including each repository’s **branches and latest commit SHA**.

---

## 🚀 Features
- Get all user repositories (excluding forks)
- List all branches with latest commit SHA
- Proper error handling (`404`, `406`)
- Built with **Spring Boot**, **OpenFeign**, **Java 17**

---

## 🧠 Endpoint

GET /repos/{username}
Accept: application/json

### ✅ Example Response
```json
{
    "repositories": [
        {
            "repositoryName": "EasyTaskManager",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "c75f1451cf35264693123856bb14968d1467208b"
                }
            ]
        },
        {
            "repositoryName": "github-proxy",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "5da61709ccddcef05842270de1c548547eaa77e4"
                }
            ]
        },
        {
            "repositoryName": "Lash-Brow-Atelier",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "4c3882fb3ba48860e7bb6bc6c76f2de8a84ccedf"
                }
            ]
        },
        {
            "repositoryName": "miniGames",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "6e0fd572eb451850743a47d018dd8280637f9e9a"
                }
            ]
        },
        {
            "repositoryName": "songify",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "f63eb53f932d15233d3334b87787cf62f2a5d8d8"
                }
            ]
        },
        {
            "repositoryName": "songify-feign-client",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "32b90ff9cfa549402fb9f02dc7baebf37e42b167"
                }
            ]
        },
        {
            "repositoryName": "soulmedic-ui",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "7b5144ac9581bae659b60aecaf587cccced0ef68"
                }
            ]
        },
        {
            "repositoryName": "warcaby-java",
            "ownerLogin": "gregdzyg",
            "branches": [
                {
                    "name": "main",
                    "sha": "b4ecdace2046b4991102e0c84fd1b079d825c37f"
                }
            ]
        }
    ]
}
❌ Example Error
{
  "status": 404,
  "message": "GitHub user not found or does not exist"
}
🧩 Tech Stack
Java 17
Spring Boot 3
Spring Cloud OpenFeign
Maven
📌 Author: Grzegorz Dżyg