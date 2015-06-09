package com.carbonstr.spring.service;

import com.carbonstr.spring.model.News;

import java.util.Date;
import java.util.List;

public interface NewsService {

    public void addNews(News n);
    public List<News> getNewsList(int startAt, int count);
    public List<News> getNewsByDate(Date startDate, Date endDate);
    public News getNews(int id);

}
