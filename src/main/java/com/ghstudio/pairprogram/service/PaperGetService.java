package com.ghstudio.pairprogram.service;

import com.ghstudio.pairprogram.service.entity.PaperResponseBody;

public interface PaperGetService {
    PaperResponseBody getPaper(Integer count, Integer role);
}
