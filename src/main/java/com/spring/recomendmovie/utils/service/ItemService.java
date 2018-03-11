package com.spring.recomendmovie.utils.service;

import java.util.List;

public interface ItemService<T> {
    List<T> findItemByPage(int currentPage, int pageSize);
}
