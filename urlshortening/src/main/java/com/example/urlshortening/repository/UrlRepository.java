package com.example.urlshortening.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.urlshortening.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

	Url findByShortUrl(String shortUrl);

	Url findByLongUrl(String longUrl);
}
