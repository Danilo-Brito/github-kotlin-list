package com.danilobrito.mainlist.domain.usecase

import com.danilobrito.mainlist.data.repository.GithubRepository

class StarUseCase(
    private val repository: GithubRepository
) {
    suspend operator fun invoke() = repository.repositoryByStar()
}