package com.ucen.vetclinicjavafx.vetclinicjavafx.app.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class AbstractService {

    public Pageable createPageableRequest(Integer pageNumber, Integer pageSize, Sort.Direction direction,
                                          String... properties) {
        PageRequest pageRequest =
                PageRequest.of(pageNumber == null ? 0 : pageNumber, pageSize == null ? 1000000 : pageSize);

        if (direction != null && properties != null) {
            pageRequest = pageRequest.withSort(direction, properties);
        }
        return pageRequest;
    }
}
